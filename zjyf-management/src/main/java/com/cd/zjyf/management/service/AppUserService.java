package com.cd.zjyf.management.service;

import com.cd.zjyf.management.bean.PageBean;
import com.cd.zjyf.management.bean.RylxCode;
import com.cd.zjyf.management.bean.ZgztCode;
import com.cd.zjyf.management.bean.dto.IsshDto;
import com.cd.zjyf.management.bean.dto.PasswordDto;
import com.cd.zjyf.management.bean.query.AbstarctQuery;
import com.cd.zjyf.management.bean.query.AppUserQuery;
import com.cd.zjyf.management.dao.AppUserDao;
import com.cd.zjyf.management.dao.JgdwJbxxDao;
import com.cd.zjyf.management.dao.WxDao;
import com.cd.zjyf.management.dao.YlwsJbxxDao;
import com.cd.zjyf.management.exception.InspectionException;
import com.cd.zjyf.management.exception.LogicException;
import com.cd.zjyf.management.pojo.AppUser;
import com.cd.zjyf.management.pojo.JgdwJbxx;
import com.cd.zjyf.management.pojo.Role;
import com.cd.zjyf.management.pojo.YlwsJbxx;
import com.cd.zjyf.management.util.AESUtils;
import com.cd.zjyf.management.util.MD5Utils;
import com.cd.zjyf.management.util.RequestValidationUtils;
import com.cd.zjyf.management.util.UUIDUtils;
import com.cd.zjyf.management.validation.AppUserValidation;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.*;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ma.xiaofeng on 2018/4/16.
 */
@Service
public class AppUserService {

	@Autowired
	private AppUserDao appUserDao;

	@Autowired
	AppUserValidation appUservalidation;

	@Autowired
	JgdwJbxxDao jgdwJbxxDao;

	@Autowired
	YlwsJbxxDao ylwsJbxxDao;

	@Autowired
	private WxDao wxDao;


	/**
	 * 根据id查询
	 */
	public AppUser getAppUserById(String id) {
		AppUser user = appUserDao.findOne(id);
		return user;
	}

	/**
	 * 删除用户（单个删除，真删）
	 */
	public void deleteAppUser(String id) {
		appUserDao.delete(id);
	}

	/**
	 * 根据id修改用户, 不能修改密码
	 */
	public void updateAppUser(String id, AppUser appUser) {
	    judge(appUser);
		AppUser user = appUserDao.findOne(id);
        appUser.setMm(user.getMm());
        appUser.setRyzp(user.getRyzp());
        appUser.setZgzt(user.getZgzt());
        appUser.setIssh(user.getIssh());
        appUser.setWtgyy(user.getWtgyy());
        //appUser.setYsgsid(user.getYsgsid());
		appUserDao.save(appUser);
	}

	/**
	 * 修改用户密码"
	 */
	public void updateAppUserPassoword(String id, String password) throws Exception {
		AppUser user = appUserDao.findOne(id);
        String pw = AESUtils.desEncrypt(password);
        user.setMm(MD5Utils.md5Digest(pw));
		appUserDao.save(user);
	}

	/**
	 * 修改用户审核状态"
	 */
	public void updateAppUserIssh(String id, IsshDto vo) {
		AppUser user = appUserDao.findOne(id);
		user.setIssh(vo.getIssh());
		String issh = vo.getIssh();
		if ("2".equals(issh)) {
			user.setWtgyy(vo.getWtgyy());
		}
		appUserDao.save(user);
	}



    /**
     *  根据id查询用户
     */
    public AppUser getUser(String id) throws Exception {
        // 参数id校验
		boolean empty = StringUtils.isEmpty(id);
		if (empty) {
			throw  new LogicException("查询的用户不能为空");
		}
		// 拿到当前用户，做权限校验
        AppUser loginUser = getLoginUser();
        Map<String, Object> userInfo = RequestValidationUtils.appUserInfo();
        String id1 = (String)userInfo.get("id");
        // 六种用户的 访问过滤
        String[] arr = {"1","2","4","5","6","7"};
        boolean flag = RequestValidationUtils.userValid(userInfo, arr);
        if (!flag) {
            throw new Exception("您没有权限");
        }
        //查询自己  的校验
        if (validNormalUser(id1, id)) {
            return getAppUserById(id);
        }

        String rylx = (String)userInfo.get("rylx");
        boolean flag2 = equal(rylx, id1, id);
        if (flag2) {
            return getAppUserById(id);
        } else {
            throw new LogicException("您没有权限");
        }
    }

    /**
     *  删除用户
     */
    @Transactional
    public void deleteUser(String id) throws Exception {
        // id做一个校验，不能为汉字
        boolean isChinese = isContainChinese(id);
        if (isChinese) {
            throw new Exception("用户名格式错误");
        }

        // 参数id校验
		boolean empty = StringUtils.isEmpty(id);
		if (empty) {
			throw  new LogicException("用户不能为空");
		}
        Map<String, Object> userInfo = RequestValidationUtils.appUserInfo();
        String id1 = (String) userInfo.get("id");

        String rylx = (String)userInfo.get("rylx");
        boolean flag2 = equal(rylx, id1, id);
        if (flag2) {
            //deleteAppUser(id); 改为假删，修改 zgzt这个字段为“2”。
			AppUser one = appUserDao.findOne(id);
			if (one.getZgzt().equals(ZgztCode.ON_GUARD.getId())) {
				one.setZgzt(ZgztCode.OFF_GUARD.getId());
				//修改是否删除状态，伪删除
				appUserDao.save(one);
				//删除时如果绑定微信，解绑
				wxDao.deleteByUserId(id);

			} else {
				throw new Exception("只能对在岗的人员进行删除");
			}
		} else {
            throw new LogicException("您没有权限，删除失败");
        }
    }
    /**
     * id 校验。 不能为汉字
     */
    public static boolean isContainChinese(String str) {

        Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher m = p.matcher(str);
        if (m.find()) {
            return true;
        }
        return false;
    }



    /**
     * 根据id，修改用户。
     */
    public void updateUser(String id, AppUser user) throws Exception {
		AppUser appUserById = getAppUserById(id);
		if (null == appUserById) {
			throw new LogicException("用户不存在，修改失败。");
		}

        Map<String, Object> userInfo = RequestValidationUtils.appUserInfo();
        String id1 = (String) userInfo.get("id");
        String rylx1 = user.getRole().getId();
        if ("3".equals(rylx1)) {
            appUservalidation.checkXm(user.getXm());
            if (validTransportCompany(id1, id)) {
                updateAppUser(id, user);
                return;
            }
        }
        // 参数id校验
		boolean empty = StringUtils.isEmpty(id);
		if (empty) {
			throw  new LogicException("修改的用户不能为空");
		}
        // 手机号校验
        appUservalidation.checkSjh(user.getSjh());
        String sjh = getAppUserById(id).getSjh();
        if (!sjh.equals(user.getSjh())) {
            // 手机号唯一性校验
            hasSjh(user.getSjh());
        }
        // id主键不能修改校验
        if (!user.getId().equals(id)) {
            throw new LogicException("用户名不能修改");
        }

		String[] arr = {"1","2","3","4","5","6","7"};
        boolean flag = RequestValidationUtils.userValid(userInfo, arr);
        if (!flag) {
            throw new Exception("您没有权限");
        }

        //查询自己  的校验
        if (validNormalUser(id1, id)) {
            updateAppUser(id, user);
            return;
        }
        String rylx = (String)userInfo.get("rylx");
        boolean flag2 = equal(rylx, id1, id);
        if (flag2) {
            updateAppUser(id, user);
        } else {
            throw new LogicException("您没有权限,修改失败");
        }
    }

    /**
     * 修改用户密码
     */
    public void updatePassword(String id, PasswordDto passwordVo) throws Exception {
		boolean empty = StringUtils.isEmpty(id);
		if (empty) {
			throw  new LogicException("用户不能为空");
		}
		AppUser appUserById = getAppUserById(id);
		if (null == appUserById) {
			throw new LogicException("用户不存在，修改失败。");
		}
        // password 参数校验
        String password = passwordVo.getPassword();
		String pw = AESUtils.desEncrypt(password);
        appUservalidation.checkMM(pw);
        Map<String, Object> userInfo = RequestValidationUtils.appUserInfo();
        String[] arr = {"1","2","3","4","5","6","7"};
        boolean flag = RequestValidationUtils.userValid(userInfo, arr);
        if (!flag) {
            throw new Exception("您没有权限");
        }
        String id1 = (String) userInfo.get("id");

        //查询自己  的校验
        if (validNormalUser(id1, id)) {
            updateAppUserPassoword(id, password);
            return;
        }
        String rylx = (String)userInfo.get("rylx");
        boolean flag2 = equal(rylx, id1, id);
        if (flag2) {
            updateAppUserPassoword(id, password);
        } else {
            throw new LogicException("您没有权限,修改失败");
        }
    }
    /**
     * 抽象出来一个方法, 当前用户rylx 的权限判断
     */
    public boolean equal(String rylx, String id1, String id) {
        boolean flag = false;
        switch (rylx) {
            case "6" :
                flag = valid(id1,id);
                break;
            case "5" :
                flag = validHospital(id1,id);
                break;
            case "7" :
                flag = validTransportCompany(id1,id);
                break;
            default:
                break;
        }
        return flag;
    }


    /**
     *  修改用户的审核状态
     */
    public void updateIssh(String id, IsshDto vo) throws Exception {
		AppUser appUserById = getAppUserById(id);
		if (null == appUserById) {
			throw new LogicException("用户不存在，审核失败。");
		}
        // 参数id校验
        //appUservalidation.checkId(id);
        String issh = vo.getIssh();
        String wtgyy = vo.getWtgyy();
        appUservalidation.checkIssh(issh);
        if ("2".equals(issh)) {
            appUservalidation.checkWgtyy(wtgyy);
        }

        Map<String, Object> userInfo = RequestValidationUtils.appUserInfo();
        String rylx = (String) userInfo.get("rylx");
        String oldId = (String) userInfo.get("id");

        boolean flag = false;
        if ("6".equals(rylx)) {
            flag = valid(oldId, id);
        }  else if ("5".equals(rylx)) {
            flag = validHospital(oldId, id);
        }
        if (flag) {
            updateAppUserIssh(id, vo);
        } else {
            throw new LogicException("您没有权限");
        }

    }

    /**
	 * 用户条件查询结果导出 pagebean 中分封装的数据，写入excel
	 */
	public void exportExcel(PageBean<AppUser> pageBean, OutputStream os) throws IOException {

		Long num = pageBean.getTotalNum();
		List<AppUser> items = pageBean.getItems();
		// 创建一个excel表，并且设置好头信息
		Workbook workbook = new HSSFWorkbook();
		Sheet sheet1 = workbook.createSheet("分表一");
        sheet1.setDefaultColumnWidth((short) 15);
		if (null == pageBean) {
			workbook.write(os);
			return;
		}
		Row row = sheet1.createRow(0);
        row.setHeightInPoints(20);
		row.createCell(0).setCellValue("用户名");
		row.createCell(1).setCellValue("姓名");
		row.createCell(2).setCellValue("机构名称");
		row.createCell(3).setCellValue("用户状态");
		row.createCell(4).setCellValue("人员类型");
		for (int i = 0; i < num.intValue(); i++) {
			Row row1 = sheet1.createRow(i + 1);
			AppUser user = items.get(i);
			String employe = validEmployer(user.getId());
			String issh = null;
            String issh1 = user.getIssh();
            if ("0".equals(issh1)) {
                issh = "未审核";
            } else if ("1".equals(issh1)) {
                issh = "审核通过";
            } else if ("2".equals(issh1)) {
                issh = "审核不通过";
            } else if ("3".equals(issh1)) {
                issh = "待审核";
            }
            row1.createCell(0).setCellValue(user.getId());
			row1.createCell(1).setCellValue(user.getXm());
			row1.createCell(2).setCellValue(employe);
			row1.createCell(3).setCellValue(issh);
			row1.createCell(4).setCellValue(user.getRole().getRoleName());
		}
		workbook.write(os);
	}

	/**
	 * 运输公司条件查询导出
	 */
	public void exportTransportExcel(PageBean<AppUser> pageBean, OutputStream os) throws IOException {
		Long num = pageBean.getTotalNum();
		List<AppUser> items = pageBean.getItems();
		// 创建一个excel表，并且设置好头信息
		Workbook workbook = new HSSFWorkbook();
		Sheet sheet1 = workbook.createSheet("分表一");
        sheet1.setDefaultColumnWidth((short) 15);
		if (null == pageBean) {
			workbook.write(os);
			return;
		}
		Row row = sheet1.createRow(0);
        row.setHeightInPoints(20);
		row.createCell(0).setCellValue("运输单位");
		row.createCell(1).setCellValue("姓名");
		for (int i = 0; i < num.intValue(); i++) {
			Row row1 = sheet1.createRow(i + 1);
			AppUser user = items.get(i);
            String ysgsid = user.getYsgsid();
            String xm = getAppUserById(ysgsid).getXm();
            // row1.createCell(1).setCellValue(user.getJgdwJbxx().getJgdwmc());
			row1.createCell(0).setCellValue(xm);
			row1.createCell(1).setCellValue(user.getXm());
		}
		workbook.write(os);
	}


    /**
     * 校验。 判断当前用户是 医疗机构的 还是监管机构的
     */
    public String validEmployer(String id) {
        AppUser user = getAppUserById(id);
        JgdwJbxx jbxx = user.getJgdwJbxx();
        YlwsJbxx jbxx1 = user.getYlwsJbxx();

		if ("7".equals(user.getRole().getId())) {
			return user.getXm();
		}

        if (null == jbxx) {
            return user.getYlwsJbxx().getDwmc();
        }
        if (null == jbxx1) {
            return user.getJgdwJbxx().getJgdwmc();
        }



        return null;
    }
    /**
     * 校验。 假如当前用户,医疗机构和监管单位都不为空，则根据其人员类型，置空一个。   本方法用在修改中
     */
    public void judge(AppUser appUser) {
        String rylx = appUser.getRole().getId();
        String[] arr = {"1", "2", "5"};
        List<String> list = Arrays.asList(arr);
        String[] arr1 = {"4", "6"};
        List<String> list1 = Arrays.asList(arr1);
        JgdwJbxx jgdwJbxx = appUser.getJgdwJbxx();
        YlwsJbxx ylwsJbxx = appUser.getYlwsJbxx();
        if (jgdwJbxx != null && ylwsJbxx != null) {
            if (list.contains(rylx)) {
                appUser.setJgdwJbxx(null);
            }
            if (list1.contains(rylx)) {
                appUser.setYlwsJbxx(null);
            }
        }
    }


	/**
	 * 校验。 判断当前的用户，能否对这个用户（id）做删除操作(是否是当前管理员下面的监督员)
     *                          补充一个是否是当前管理员下面的医院管理员
	 *                                  是否是下面的运输公司管理人员
	 * 
	 * @throws Exception
	 *             首先可以肯定 oldId是管理员 其实开始判断 id的类型。
	 */
	public boolean valid(String oldId, String id) {
		// 拿到当前用户的监管单位的id
		AppUser appUser = getAppUserById(oldId);
		String id1 = appUser.getJgdwJbxx().getId();
		String xzqh1 = appUser.getJgdwJbxx().getXzqh();
		// String[] strings1 = xzqh1.split(",");
		// 根据 等待删除的用户的id，得到其监管单位的id和邮政编码
		AppUser user = getAppUserById(id);
		String rylxId = user.getRole().getId();
		String[] arr = { "4", "5", "7" };
		List<String> list = Arrays.asList(arr);
		if (!list.contains(rylxId)) {
			return false;
		}
		String id2 = null;
		String xzqh2 = null;
		// 当是 id是监督员时
		if ("4".equals(rylxId)) {
			id2 = user.getJgdwJbxx().getId();
			xzqh2 = user.getJgdwJbxx().getXzqh();

		} else if ("5".equals(rylxId)) { // 当id是医院管理员
			// 根据该医院管理员的医院机构名称得到其监管单位 。
			// 然后查询这个监管单位，得到行政编码。
//			id2 = user.getYlwsJbxx().getId();
			id2 = user.getYlwsJbxx().getJgdwJbxx().getId();
			// user.getYlwsJbxx().getDwdzbm();
            xzqh2 =jgdwJbxxDao.findOne(id2).getXzqh();
		} else if ("7".equals(rylxId)) {
			return true;
		}
		if (id1 == id2) {
			return true;
		}
		
		xzqh1 = this.translateXZQH(xzqh1);
		xzqh2 = this.translateXZQH(xzqh2);
		
		// 判断行政区划的从属关系
		if (!(-1 == (xzqh2.indexOf(xzqh1)))) {
			return true;
		}
		return false;
	}
	
	public String translateXZQH(String userxzqh) {
		if(userxzqh!=null&&userxzqh.split(",").length>1){
			String[] split = userxzqh.split(",");
			if(split[split.length-1].equals(split[split.length-2])){
				userxzqh= userxzqh.substring(0,userxzqh.lastIndexOf(","));
			}
		}
		return userxzqh;
	}


	/**
	 * 校验。 判断是否是当前医院的 下属的 收集人员，交接人员。
	 * 
	 * @throws Exception
	 */
	public boolean validHospital(String hostpitalId, String id) {
		AppUser user1 = getAppUserById(hostpitalId);
		AppUser user2 = getAppUserById(id);
		String id3 = user2.getRole().getId();
		String[] arr = { "3", "4", "5", "6", "7" };
		List<String> list = Arrays.asList(arr);
		if (list.contains(id3)) {
			return false;
		}
		String id1 = user1.getYlwsJbxx().getId();
		String id2 = null;
		//String id2 = user2.getYlwsJbxx().getId();
		if (RylxCode.HANDOVEROR.getRylx().equals(id3)) {
			id2 = user2.getYlwsJbxx().getZcdid();
		}
		if (RylxCode.RECEIVER.getRylx().equals(id3)) {
			if (user2.getYlwsJbxx().getZcdid() == null || "".equals(user2.getYlwsJbxx().getZcdid())) {
				id2 = user2.getYlwsJbxx().getId();
			} else if (user2.getYlwsJbxx().getZcdid() != null){
				id2 = user2.getYlwsJbxx().getZcdid();
			}
		}
		if (id1.equals(id2)) {
			return true;
		}
		return false;
	}

	/**
	 * 校验。 判断是否是当前运输公司下面的 运输人员
	 * 
	 * @throws Exception
	 */
	public boolean validTransportCompany(String companyId, String id) {
		AppUser user1 = getAppUserById(companyId);
		AppUser user2 = getAppUserById(id);
		String id3 = user2.getRole().getId();
		String[] arr = { "1", "2", "4", "5", "6", "7" };
		List<String> list = Arrays.asList(arr);
		if (list.contains(id3)) {
			return false;
		}
		String xm = user1.getId();
		String name = user2.getYsgsid();
		if (xm.equals(name)) {
			return true;
		}
		return false;
	}

	/**
	 * 校验。 普通用户 类型 123. 只能操作自己
	 * 
	 * @throws Exception
	 */
	public boolean validNormalUser(String normalId, String id) {
		if (normalId.equals(id)) {
			return true;
		}
		return false;
	}

	/**
	 * 审核 。 本市的只能审核本市的， 本县的只能审核本县的。
	 * 
	 * @throws Exception
	 */
	public boolean checkValid(String oldId, String id) {
		AppUser user1 = getAppUserById(oldId);
		AppUser user2 = getAppUserById(id);
		String id3 = user2.getRole().getId();
		String[] arr = { "4" };
		List<String> list = Arrays.asList(arr);
		if (!list.contains(id3)) {
			return false;
		}
		String id1 = user1.getJgdwJbxx().getId();
		String id2 = user2.getJgdwJbxx().getId();

		if (id1.equals(id2)) {
			return true;
		}
		return false;
	}

	@Transactional
	public void addUser(AppUser appUser) throws Exception {
		// 新增id唯一性校验
		userIsExit(appUser);
		// 医疗机构id和监督单位id非空校验
		dwIdNotNull(appUser);
		// 操作权限校验
		authAddAppUser(appUser);
		//id长度校验
		appUservalidation.checkId(appUser.getId());
		// 手机号校验
		appUservalidation.checkSjh(appUser.getSjh());
		// 手机号唯一性校验
		hasSjh(appUser.getSjh());
		// 姓名非空校验
		appUservalidation.checkXm(appUser.getXm());
		// 密码处理
		//String mm = appUser.getMm();
		// 解密！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
		// mm=AESUtils.desEncrypt(mm);
		// 校验密码
		//appUservalidation.checkMM(mm);
		// md5加密
		appUser.setMm(MD5Utils.md5Digest("12345678"));
		// 审核通过，在岗
		appUser.setIssh("1");
		appUser.setZgzt("1");
		appUserDao.save(appUser);
	}

	private void hasSjh(String sjh) throws InspectionException {
		List<AppUser> userList = appUserDao.findBySjh(sjh);
		if (userList.size() > 0)
			throw new InspectionException("手机号已存在");
	}

	/**
	 * 获取登录用户
	 * 
	 * @return
	 * @throws Exception
	 */
	private AppUser getLoginUser() throws Exception {
		Map<String, Object> userInfoMap = RequestValidationUtils.appUserInfo();
		String username = (String) userInfoMap.get("id");
		if (StringUtils.isEmpty(username))
			throw new LogicException("用户名为空");
		AppUser user = appUserDao.findOne(username);
		if (user == null)
			throw new LogicException("用户不存在");
		return user;
	}

	/**
	 * 当前登录用户是否又添加权限
	 * 
	 * @param appUser
	 * @throws Exception
	 */
	private void authAddAppUser(AppUser appUser) throws Exception {
		AppUser admin = getLoginUser();
		String rylx = admin.getRole().getId();
	
		if (rylx.equals("6")) {	//监督管理员可新增监督员，医院管理员，运输公司管理员
			String adminXZQH = admin.getJgdwJbxx().getXzqh();
			adminXZQH = this.translateXZQH(adminXZQH);
			String userXZQH = "";
			// 市级管理员可新建市县级监督员
			if (appUser.getRole().getId().equals("4")) {// 监督员
				JgdwJbxx jgdwjbxx = jgdwJbxxDao.findOne(appUser.getJgdwJbxx().getId());
				userXZQH = jgdwjbxx.getXzqh();
				userXZQH = this.translateXZQH(userXZQH);
			} else if (appUser.getRole().getId().equals("5")) {// 医院管理员
				YlwsJbxx ylwsjbxx = ylwsJbxxDao.findOne(appUser.getYlwsJbxx().getId());
				userXZQH = ylwsjbxx.getJgdwJbxx().getXzqh();
				userXZQH = this.translateXZQH(userXZQH);
			}
			// 不为运输管理员时权限判断
			if (!userXZQH.contains(adminXZQH) && !appUser.getRole().getId().equals("7"))
				throw new LogicException("无创建该用户权限");

			// 运输公司管理员只能由市级监督单位创建
			if (appUser.getRole().getId().equals("7") && admin.getJgdwJbxx().getBmjb().equals("3"))
				throw new LogicException("只能由市级管理员新建运输公司管理员");
		}else if(rylx.equals("5")) {//医院管理员新增收集者，交接员
			if(!(appUser.getRole().getId().equals("1")||appUser.getRole().getId().equals("2")))throw new LogicException("医院管理员只能操作本医院的交接员和收集员");
			YlwsJbxx ylws = ylwsJbxxDao.findOne(appUser.getYlwsJbxx().getId());
			String yljgId = "";
			if(ylws.getYljgtype()==1) {
				yljgId = ylws.getId();
			}else {
				yljgId = ylws.getZcdid();
			}
			if(!admin.getYlwsJbxx().getId().equals(yljgId)) throw new LogicException("医院管理员只能操作本医院的用户");
		}else
			throw new LogicException("非监督管理员或医院管理员不可操作用户");
		
		
	}

	/**
	 * 新增时判断用户是否存在
	 * 
	 * @param appUser
	 * @throws InspectionException
	 */
	private void userIsExit(AppUser appUser) throws InspectionException {
		AppUser oldUser = appUserDao.findOne(appUser.getId());
		if (oldUser != null)
			throw new InspectionException("用户名已存在");
	}

	/**
	 * 医疗机构id和监督单位id非空校验
	 * 
	 * @param appUser
	 */
	public void dwIdNotNull(AppUser appUser) throws InspectionException {
		if (appUser.getRole() == null)
			throw new InspectionException("人员类型不能为空");
		String rylx = appUser.getRole().getId();
		if (rylx.equals("4")) {// 监督员
			if (appUser.getJgdwJbxx() == null || StringUtils.isEmpty(appUser.getJgdwJbxx().getId())) {
				throw new InspectionException("机构不能为空");
			} else {
				appUser.setYlwsJbxx(null);// 是监督员则ylwsid为空
				appUser.setYsgsid(null);
			}
		}
		if (rylx.equals("5")||rylx.equals("1")||rylx.equals("2")) {//医院管理员,接收者，收集者
			if (appUser.getYlwsJbxx() == null || StringUtils.isEmpty(appUser.getYlwsJbxx().getId())) {
				throw new InspectionException("机构不能为空");
			} else {
				YlwsJbxx ylwsJbxx = ylwsJbxxDao.findOne(appUser.getYlwsJbxx().getId());
				if(rylx.equals("5")&&(ylwsJbxx==null||ylwsJbxx.getYljgtype()!=1))throw new InspectionException("医院管理人员只能属于暂存点");
				appUser.setJgdwJbxx(null);// 是医院管理员接收者收集者 则jgdwid为空
				appUser.setYsgsid(null);
			}
		}
		if (rylx.equals("7")) {// 运输管理员
			if(StringUtils.isEmpty(appUser.getYsgsid())) {
				appUser.setYsgsid(appUser.getXm());
			}
			appUser.setJgdwJbxx(null);
			appUser.setYlwsJbxx(null);
			
		}
	}

	/**
	 * 运输人员新增
	 * 
	 * @param user
	 * @throws Exception
	 */
	public void addTransportUser(AppUser user) throws Exception {
		// 获取运输管理员信息
		AppUser admin = getLoginUser();
		if (!admin.getRole().getId().equals("7"))
			throw new LogicException("无操作权限");
		// 新增时设置字段
		AppUser transportUser = new AppUser();
		// 姓名非空校验
		appUservalidation.checkXm(user.getXm());
		transportUser.setId(UUIDUtils.generateID());
		transportUser.setXm(user.getXm());
		transportUser.setYsgsid(admin.getId());// 运输公司id为运输管理员用户名（id）
		// 审核通过，在岗(数据库中必填字段)
		Role role = new Role();
		role.setId("3");
		transportUser.setRole(role);
		transportUser.setIssh("1");
		transportUser.setZgzt("1");
		appUserDao.save(transportUser);

	}

	/**
	 * 用户分页查询
	 * 
	 * @param appUserQuery
	 * @return
	 * @throws Exception
	 */
	public PageBean<AppUser> findAppUserByConditions(AppUserQuery appUserQuery) throws Exception {
		AppUser user = getLoginUser();
		if (user == null)
			throw new LogicException("当前登录用户出错");
		String rylx = user.getRole().getId();//人员类型
		
		// 创建分页对象
		PageRequest pageRequest = null;
		// 创建查询结果集对象
		PageBean<AppUser> pageBean = new PageBean<>();
		// 创建条件查询对象
		Specification<AppUser> specification = new Specification<AppUser>() {
			@Override
			public Predicate toPredicate(Root<AppUser> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				// 创建一个集合，将所有创建好的条件存进集合，一次查询。
				List<Predicate> predicateList = new ArrayList<Predicate>();

				//不在岗的不显示
				Predicate predicateZG = cb.equal(root.get("zgzt"), "1");
				predicateList.add(predicateZG);
				
				if (!StringUtils.isEmpty(appUserQuery.getId())) {// 用户名
					Predicate predicate = cb.like(root.get("id"), "%" + appUserQuery.getId() + "%");
					predicateList.add(predicate);
				}
				if (!StringUtils.isEmpty(appUserQuery.getXm())) {// 姓名
					Predicate predicate = cb.like(root.get("xm"), "%" + appUserQuery.getXm() + "%");
					predicateList.add(predicate);
				}
				if (!StringUtils.isEmpty(appUserQuery.getRylx())) {// 人员类型
					Predicate predicate = cb.equal(root.get("role").get("id"), appUserQuery.getRylx());
					predicateList.add(predicate);
				}

				if (!StringUtils.isEmpty(appUserQuery.getJgmc())) {// 机构名称
					Join<AppUser, ?> joinForJgdw = root.join(root.getModel().getSingularAttribute("jgdwJbxx"),
							JoinType.LEFT);
					Predicate or1 = cb.like(joinForJgdw.get("jgdwmc"), "%" + appUserQuery.getJgmc() + "%");
					Join<AppUser, ?> joinForYlws = root.join(root.getModel().getSingularAttribute("ylwsJbxx"),
							JoinType.LEFT);
					Predicate or2 = cb.like(joinForYlws.get("dwmc"), "%" + appUserQuery.getJgmc() + "%");
					Predicate or3 = cb.like(root.get("ysgsid"), "%" + appUserQuery.getJgmc() + "%");
					Predicate predicate = cb.or(or1, or2, or3);
					predicateList.add(predicate);
				}
				if (!StringUtils.isEmpty(appUserQuery.getIssh())) {// 是否审核
					Predicate predicate = cb.equal(root.get("issh"), appUserQuery.getIssh());
					predicateList.add(predicate);
				}
				// 运输者与监督管理员不显示
				Predicate p1 = cb.notEqual(root.get("role").get("id"), "3");
				Predicate p2 = cb.notEqual(root.get("role").get("id"), "6");
				predicateList.add(p1);
				predicateList.add(p2);
				//未审核状态不显示
				Predicate p3 = cb.notEqual(root.get("issh"), "0");
				predicateList.add(p3);
				// 查询过滤
				// 监督管理员（6）
				if (rylx.equals("6")) {// 监督管理员只能查看监督人员，医院管理员，运输管理员（排除交接人员，接收人员）
					Predicate predicate1 = cb.notEqual(root.get("role").get("id"), "1");
					Predicate predicate2 = cb.notEqual(root.get("role").get("id"), "2");
					// 行政区划限制
					// 。。。。。。。。。。。有坑啊。root.get("jgdwJbxx").get("xzqh")这样去用了那么查出来的数据至少jgdwid不是空的。他做的是where不是join!!
					String xzqh = user.getJgdwJbxx().getXzqh();// 查询行政区划
					
					//********************************************
					 if(xzqh!=null&&xzqh.split(",").length>1){
				            String[] split = xzqh.split(",");
				            if(split[split.length-1].equals(split[split.length-2])){
				            	xzqh= xzqh.substring(0,xzqh.lastIndexOf(","));
				            }
				        }
					//********************************************
					
					Join<AppUser, ?> joinForJgdw = root.join(root.getModel().getSingularAttribute("jgdwJbxx"),
							JoinType.LEFT);
					Predicate or1 = cb.like(joinForJgdw.get("xzqh"), "%" + xzqh + "%");
					Join<AppUser, ?> joinForYlws = root
							.join(root.getModel().getSingularAttribute("ylwsJbxx"), JoinType.LEFT)
							.join("jgdwJbxx", JoinType.LEFT);
					Predicate or2 = cb.like(joinForYlws.get("xzqh"), "%" + xzqh + "%");
					Predicate or3 = cb.equal(root.get("role").get("id"), "7");
					Predicate predicate3 = cb.or(or1, or2, or3);
					predicateList.add(predicate1);
					predicateList.add(predicate2);
					predicateList.add(predicate3);
					//为监督管理员时根据部门等级限制能否查看医院管理员运输公司管理员
					String bmjb =user.getJgdwJbxx().getBmjb();
					if(bmjb.equals("3")) {//监督管理员部门等级为3县级时，不能查看运输公司管理员
						Predicate predicateByBmjb1 = cb.notEqual(root.get("role").get("id"), "7");
						predicateList.add(predicateByBmjb1);
					}
				}
				// 医院管理员（5）
				if (rylx.equals("5")) {// 医院管理员只能查看本医院的用户
					String yljgid = user.getYlwsJbxx().getId();
					Predicate or1 = cb.equal(root.get("ylwsJbxx").get("id"), yljgid);// 只能看到自己下的用户,且暂存点（医院）底下产生点也要查询
					Join<AppUser, ?> joinForYlws = root
							.join(root.getModel().getSingularAttribute("ylwsJbxx"), JoinType.LEFT);
					Predicate or2 = cb.equal(joinForYlws.get("zcdid"), yljgid);
					Predicate predicate1 = cb.or(or1,or2);
					Predicate predicate2 = cb.notEqual(root.get("role").get("id"), "5");// 不能看到管理员
					predicateList.add(predicate1);
					predicateList.add(predicate2);
				}

				// 将条件集合转换为数组并返回
				Predicate[] p = new Predicate[predicateList.size()];
				return cb.and(predicateList.toArray(p));
			}
		};

		// 倒序排序
		Sort sort = new Sort(Sort.Direction.DESC, "id");

		if (appUserQuery.getPage() > 0 && appUserQuery.getSize() > 0) {
			// 如果是分页条件查询
			pageRequest = new PageRequest(appUserQuery.getPage() - 1, appUserQuery.getSize(), sort);
			Page<AppUser> pageInfo = appUserDao.findAll(specification, pageRequest);
			List<AppUser> content = pageInfo.getContent();

			pageBean.setItems(content);
			pageBean.setTotalNum(pageInfo.getTotalElements());
		} else {
			// 如果是条件查询
			List<AppUser> findAll = appUserDao.findAll(specification, sort);

			pageBean.setItems(findAll);
			pageBean.setTotalNum((long) findAll.size());

		}

		return pageBean;

	}

	/**
	 * 运输公司条件查询， 条件：姓名 加上分页功能
	 */
	public PageBean<AppUser> findTransportorByPageAndConditions(String xm, AbstarctQuery abstarctQuery)
			throws Exception {

		Map<String, Object> info = RequestValidationUtils.appUserInfo();
		Object id = info.get("id");
		// 创建分页对象
		PageRequest pageRequest = null;
		// 创建查询结果集对象
		PageBean<AppUser> pageBean = new PageBean<>();

		// 创建条件查询对象
		Specification<AppUser> specification = new Specification<AppUser>() {
			@Override
			public Predicate toPredicate(Root<AppUser> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				// 创建一个集合，将所有创建好的条件存进集合，一次查询。
				List<Predicate> predicateList = new ArrayList<Predicate>();
				// 条件查询
                if (null != xm) {
                    Predicate p1 = cb.like(root.get("xm"), "%" + xm + "%");
                    predicateList.add(p1);
                }
                // 只显示在岗状态为  ”1“的
				Predicate p2 = cb.equal(root.get("zgzt"), ZgztCode.ON_GUARD.getId());
				predicateList.add(p2);

				Predicate predicate = cb.equal(root.get("ysgsid"), id);
				predicateList.add(predicate);

				// 将条件集合转换为数组并返回
				Predicate[] p = new Predicate[predicateList.size()];
				return cb.and(predicateList.toArray(p));
			}
		};
		// 倒序排序
		Sort sort = new Sort(Sort.Direction.DESC, "xm");

		if (abstarctQuery.getPage() > 0 && abstarctQuery.getSize() > 0) {
			// 如果是分页条件查询
			pageRequest = new PageRequest(abstarctQuery.getPage() - 1, abstarctQuery.getSize(), sort);
			Page<AppUser> pageInfo = appUserDao.findAll(specification, pageRequest);
			List<AppUser> content = pageInfo.getContent();

			pageBean.setItems(content);
			pageBean.setTotalNum(pageInfo.getTotalElements());
		} else {
			// 如果是条件查询
			List<AppUser> findAll = appUserDao.findAll(specification, sort);

			pageBean.setItems(findAll);
			pageBean.setTotalNum((long) findAll.size());

		}

		return pageBean;

	}

	/**
	 * 注册（人员类型为0，id自动生成，手机号和密码传入）
	 * 
	 * @param appUser
	 * @throws Exception
	 */
	public void registUser(AppUser appUser) throws Exception {
		// 校验只能是收集者接收者监督员注册
		// isJsSjJdy(appUser);
		// 医疗机构id和监督单位id非空校验
		// dwIdNotNull(appUser);
		// 手机号校验
		appUservalidation.checkSjh(appUser.getSjh());
		// 手机号唯一性校验
		hasSjh(appUser.getSjh());
		// 新增id唯一性校验
		appUser.setId("ylfw" + appUser.getSjh());
		userIsExit(appUser);
		// 密码处理
		String mm = appUser.getMm();
		// 解密！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
		// mm=AESUtils.desEncrypt(mm);
		// 校验密码
		appUservalidation.checkMM(mm);
		// md5加密
		appUser.setMm(MD5Utils.md5Digest(mm));
		// 未审核，在岗
		appUser.setIssh("0");
		appUser.setZgzt("1");
		// 人员类型为0
		Role role = new Role();
		role.setId("0");
		appUser.setRole(role);
		appUserDao.save(appUser);

	}

	public void resetMm(String id) throws Exception {
        // id做一个校验，不能为汉字
        boolean isChinese = isContainChinese(id);
        if (isChinese) {
            throw new Exception("用户名格式错误");
        }
		// 新增id唯一性校验
		AppUser appUser = appUserDao.findOne(id);
		// 操作权限校验
		authAddAppUser(appUser);
		appUser.setMm(MD5Utils.md5Digest("12345678"));
		appUserDao.save(appUser);
	}

	

	/**
	 * 校验只能是收集者接收者监督员注册
	 * 
	 * @param appUser
	 * @throws LogicException
	 */
	/*
	 * private void isJsSjJdy(AppUser appUser) throws LogicException { String rylx =
	 * appUser.getRole().getId(); if (!(rylx.equals("1") || rylx.equals("2") ||
	 * rylx.equals("4"))) throw new LogicException("只能注册收集者接收者或监督人员"); }
	 */
}
