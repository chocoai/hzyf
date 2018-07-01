package com.cd.uap.service;

import java.util.HashMap;
import java.util.Map;

import com.cd.uap.bean.IsshCode;
import com.cd.uap.bean.dto.PhoneRegistDto;
import com.cd.uap.bean.dto.WxBindDto;
import com.cd.uap.dao.RoleDao;
import com.cd.uap.entity.Role;
import com.cd.uap.entity.User;
import com.cd.uap.exception.LogicException;
import com.cd.uap.util.MD5Util;
import com.cd.uap.validation.UserValidation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.cd.uap.dao.UserDao;
import org.springframework.util.StringUtils;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private UserValidation uservalidation;

    @Autowired
    private SmsService smsService;


    /**
     * 将结果返回
     *
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    public String getUserByUsername(String username) throws UsernameNotFoundException {

        Map<String, Object> map = new HashMap<>();

        User user = new User();
        // TODO 以后要改
        if (null != username && username.matches("^(1[356789]{1})\\d{9}$")) {
            user = userDao.findBySjh(username);
        } else {
            user = userDao.findOne(username);
        }

        if (null == user) {
            throw new UsernameNotFoundException("该用户不存在");
        }


        //校验审核状态
        if (!IsshCode.PASS.getIssh().equals(user.getIssh())) {
            if (IsshCode.UNREVIEW.getIssh().equals(user.getIssh())) {
//				throw new UsernameNotFoundException("用户未审核");
            } else if (IsshCode.UNPASS.getIssh().equals(user.getIssh())) {
                throw new UsernameNotFoundException("用户审核未通过");
            } else if (IsshCode.REVIEW.getIssh().equals(user.getIssh())) {
                throw new UsernameNotFoundException("用户待审核");
            } else {
                throw new UsernameNotFoundException("审核状态错误");
            }
        }

        Role role = roleDao.findOne(user.getRylx());
        if (role == null) {
            throw new UsernameNotFoundException("该用户没有绑定人员类型");
        }

        map.put("id", user.getId());
//		map.put("xm", user.getXm());
        map.put("sjh", user.getSjh());
        map.put("ryzp", user.getRyzp());
        map.put("zgzt", user.getZgzt());
        map.put("issh", user.getIssh());
//		map.put("wtgyy", user.getWtgyy());
        map.put("yljgid", user.getYljgid());
        map.put("jgdwid", user.getJgdwid());
        map.put("rylx", user.getRylx());
        map.put("ysgsid", user.getYsgsid());

        String userJson = JSON.toJSONString(map);
        return userJson;
    }

    /**
     * 注册（人员类型为0，id自动生成，手机号和密码传入）
     *
     * @param appUser
     * @throws Exception
     */
    public void registUser(PhoneRegistDto appUser) throws Exception {
        // 校验只能是收集者接收者监督员注册
        // isJsSjJdy(appUser);
        // 医疗机构id和监督单位id非空校验
        // dwIdNotNull(appUser);

        // 手机号校验
        uservalidation.checkSjh(appUser.getSjh());
        if (!StringUtils.isEmpty(userDao.findBySjh(appUser.getSjh()))) {
            throw new LogicException("手机号已存在");
        }

        //验证验证码
        uservalidation.checkValidateCode(appUser.getValidateCode());
        Boolean isValidateCode = smsService.checkValidateCode(appUser.getValidateCode(), appUser.getSjh());
        if (!isValidateCode) {
            throw new LogicException("验证码错误");
        }

        // 新增id唯一性校验
        appUser.setId("ylfw" + appUser.getSjh());
        userIsExit(appUser);

        // 密码处理
        String mm = appUser.getMm();
        // 解密！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
        // mm=AESUtils.desEncrypt(mm);
        // 校验密码
        uservalidation.checkMM(mm);
        // md5加密
        appUser.setMm(MD5Util.md5Digest(mm));
        // 未审核，在岗
        appUser.setIssh("0");
        appUser.setZgzt("1");
        // 人员类型为1
        //TODO：注册人员默认类型是1(交接人员)
        appUser.setRylx("1");

        User user = new User();
        BeanUtils.copyProperties(appUser, user);
        userDao.save(user);

    }

    /**
     * 新增时判断用户是否存在
     */
    private void userIsExit(User user) throws UsernameNotFoundException {
        User oldUser = userDao.findOne(user.getId());
        if (oldUser != null)
            throw new UsernameNotFoundException("用户名已存在");
    }

    /**
     * 修改密码
     *
     * @param phoneRegistVo
     */
    public void updateUser(PhoneRegistDto phoneRegistVo) throws Exception {
        //1.判断手机号是否存在
        uservalidation.checkSjh(phoneRegistVo.getSjh());
        User oldUser = userDao.findBySjh(phoneRegistVo.getSjh());
        if (oldUser == null) {
            throw new UsernameNotFoundException("该手机号未注册");
        }
        //2.判断验证码是否正确
        uservalidation.checkValidateCode(phoneRegistVo.getValidateCode());
        Boolean isValidateCode = smsService.checkValidateCode(phoneRegistVo.getValidateCode(), phoneRegistVo.getSjh());
        if (!isValidateCode) {
            throw new LogicException("验证码错误");
        }
        //3.判断手机号密码是否符合规则
        String newMm = phoneRegistVo.getMm();
        uservalidation.checkMM(newMm);

        //4.数据全部正确，录入数据库
        oldUser.setMm(MD5Util.md5Digest(newMm));
        userDao.save(oldUser);
    }

    /**
     * 判断手机号是否存在
     *
     * @param sjh
     */
    public Boolean isRegist(String sjh) throws Exception {

        return userDao.existsBySjh(sjh);
    }
}
