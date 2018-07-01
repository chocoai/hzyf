package com.cd.zjyf.controller;

import com.cd.zjyf.base.controller.BaseController;
import com.cd.zjyf.base.controller.ServiceHandlerAdapter;
import com.cd.zjyf.bean.AppUser;
import com.cd.zjyf.bean.YlfwJsdj;
import com.cd.zjyf.bean.YlwsJbxx;
import com.cd.zjyf.enums.ReportTemplateEnum;
import com.cd.zjyf.exception.SystemException;
import com.cd.zjyf.exception.ValidateException;
import com.cd.zjyf.pojo.Dropdown;
import com.cd.zjyf.pojo.PageBean;
import com.cd.zjyf.pojo.Response;
import com.cd.zjyf.pojo.qc.*;
import com.cd.zjyf.pojo.qr.JSQKQR;
import com.cd.zjyf.pojo.qr.SDLQR;
import com.cd.zjyf.pojo.qr.YlwsJbxxQR;
import com.cd.zjyf.service.ProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


@RestController
public class ProjectController extends BaseController {


	@Autowired
	private ProjectService projectService;

	private static Logger log = LoggerFactory.getLogger(ProjectController.class);


	@GetMapping("/querySewage")
	public Response querySewage(SewageQC qc) {
		log.info("污水监测查询");
		return super.query(new ServiceHandlerAdapter() {
			@Override
			public Object serviceQueryOperate() {
				return projectService.querySewage(qc);
			}
		});
	}
	
	
	@GetMapping("/querySewageInfo")
	public Response querySewageInfo(SewageQC qc) {
		log.info("污水监测详情查询");
		return super.query(new ServiceHandlerAdapter() {
			@Override
			public Object serviceQueryOperate() {
				return projectService.querySewageInfo(qc);
			}
		});
	}
	
	/**
	 * 上传pdf
	 * @param uploadFile
	 * @param id
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="/uploadSewage",method = RequestMethod.POST)
	@ResponseBody
	public Response uploadSewage(@RequestParam("file") MultipartFile[] uploadFile, @RequestParam(value="id")String id,String[] filename) throws IOException {
		log.info("批量上传污水监监测报告");
		return 	genericSaveOrUpdate(new ServiceHandlerAdapter() {
			@Override
			public Object serviceSaveOrUpdateOperate() throws SystemException {
				return projectService.uploadSewage(id,uploadFile,filename);
			}
		});
	}

	@RequestMapping(method = RequestMethod.GET,value="/getRegionsByUnitUuid")
	public Response getRegionsByUnitUuid() {
		log.info("调用海康接口：获取区域信息通过uuid");
		return super.queryHasException(new ServiceHandlerAdapter() {
			@Override
			public Object serviceQueryOperateHasExcpetoin()  {
				return projectService.getRegionsByUnitUuid();
			}
		});
	}

	@RequestMapping(method = RequestMethod.GET,value="/area")
	public Response getArea(@RequestParam(value="userxzqh",required = true) String areacode,@RequestParam(value="address") String isAddr) {
		log.info("行政区划/地址编码 级联查询");
		return super.query(new ServiceHandlerAdapter() {
			@Override
			public Object serviceQueryOperate() {
				return projectService.getArea(areacode,isAddr);
			}
		});
	}

	@PostMapping("/addYLJG")
	public Response addYLJG(@RequestBody YlwsJbxx ylwsJbxx) {
		log.info("医疗机构新增");
		return super.genericSaveOrUpdate(new ServiceHandlerAdapter() {
			@Override
			public Object serviceSaveOrUpdateOperate() throws SystemException, ValidateException {
				return projectService.addYLJG(ylwsJbxx);
			}
		});
	}

	@PutMapping("/updateYLJG")
	public Response updateYLJG(@RequestBody YlwsJbxx ylwsJbxx) {
		log.info("医疗机构修改");
		return super.genericSaveOrUpdate(new ServiceHandlerAdapter() {
			@Override
			public Object serviceSaveOrUpdateOperate() throws SystemException, ValidateException {
				return projectService.updateYLJG(ylwsJbxx);
			}
		});
	}

	@DeleteMapping("/deleteYLJG/{id}")
	public Response deleteYLJG(@PathVariable("id") String id) {
		log.info("医疗机构删除");
		return super.genericSaveOrUpdate(new ServiceHandlerAdapter() {
			@Override
			public Object serviceSaveOrUpdateOperate() throws SystemException, ValidateException {
				return projectService.deleteYLJG(id);
			}
		});
	}

	@GetMapping("/queryYLJG/{id}")
	public Response queryYLJG(@PathVariable("id") String id) {
		log.info("医疗机构查看详情");
		return super.query(new ServiceHandlerAdapter() {
			@Override
			public Object serviceQueryOperate() {
				return projectService.queryYLJG(id);
			}
		});
	}

	@GetMapping("/cqueryYLJG")
	public Response cqueryYLJG(YlwsJbxxQC qc) {
		log.info("医疗机构条件查询");
		return super.query(new ServiceHandlerAdapter() {
			@Override
			public Object serviceQueryOperate() {
				return projectService.cqueryYLJG(qc);
			}
		});
	}

	@GetMapping("/cqueryYLJGExport")
	public Response cqueryYLJGExport(YlwsJbxxQC qc) {
		log.info("医疗机构条件查询导出");
		PageBean<YlwsJbxxQR> ylwsJbxxPageBean = projectService.cqueryYLJG(qc);
		return exportRopert(ReportTemplateEnum.YLJG,ylwsJbxxPageBean.getItems() );
	}

/*
	*/
/*********************人员**************//*

	@PostMapping("/addRY")
	public Response addRY(AppUser appUser) {
		log.info("人员新增");
		return super.genericSaveOrUpdate(new ServiceHandlerAdapter() {
			@Override
			public Object serviceSaveOrUpdateOperate() throws SystemException, ValidateException {
				return projectService.addRY(appUser);
			}
		});
	}

	@PutMapping("/updateRY")
	public Response updateRY(AppUser appUser) {
		log.info("人员修改");
		return super.genericSaveOrUpdate(new ServiceHandlerAdapter() {
			@Override
			public Object serviceSaveOrUpdateOperate() throws SystemException, ValidateException {
				return projectService.updateRY(appUser);
			}
		});
	}

	@DeleteMapping("/deleteRY/{id}")
	public Response deleteRY(@PathVariable("id") String id) {
		log.info("人员删除");
		return super.genericSaveOrUpdate(new ServiceHandlerAdapter() {
			@Override
			public Object serviceSaveOrUpdateOperate() throws SystemException, ValidateException {
				return projectService.deleteRY(id);
			}
		});
	}

	@GetMapping("/queryRY/{id}")
	public Response queryRY(@PathVariable("id") String id) {
		log.info("人员查看详情");
		return super.query(new ServiceHandlerAdapter() {
			@Override
			public Object serviceQueryOperate() {
				return projectService.queryRY(id);
			}
		});
	}

	@GetMapping("/cqueryRY")
	public Response cqueryRY(AppUserQC qc) {
		log.info("人员条件查询");
		return super.query(new ServiceHandlerAdapter() {
			@Override
			public Object serviceQueryOperate() {
				return projectService.cqueryRY(qc);
			}
		});
	}

	@GetMapping("/cqueryRYExport")
	public Response cqueryRYExport(AppUserQC qc) {
		log.info("人员条件查询导出");
		PageBean<AppUser> AppUserPageBean = projectService.cqueryRY(qc);
		return exportRopert(ReportTemplateEnum.RY,AppUserPageBean.getItems() );
	}
*/

	//

	@GetMapping("/queryJSMX")
	public Response queryJSMX(JSMX qc) {
		log.info("接收情况列表查询");
		return super.query(new ServiceHandlerAdapter() {
			@Override
			public Object serviceQueryOperate() {
				return projectService.queryJSMX(qc);
			}
		});
	}
	@GetMapping("/queryJSMXExport")
	public Response queryJSMXExport(JSMX qc) {
		log.info("接收情况列表查询导出");
		return exportRopert(ReportTemplateEnum.JSMX,projectService.queryJSMX(qc).getItems() );
	}


	@GetMapping("/queryJSTB")
	@Deprecated
	public Response queryJSTB(JSTB qc) {
		log.info("接收同比统计查询");
		return super.query(new ServiceHandlerAdapter() {
			@Override
			public Object serviceQueryOperate() {
				return projectService.queryJSTB(qc);
			}
		});
	}

	@GetMapping("/queryJSTBN")
	public Response queryJSTBN(JSTB qc) {
		log.info("接收同比统计查询（新）");
		return super.query(new ServiceHandlerAdapter() {
			@Override
			public Object serviceQueryOperate() {
				return projectService.queryJSTBN(qc);
			}
		});
	}


	@GetMapping("/queryJSHB")
	public Response queryJSHB(JSHB qc) {
		log.info("接收环比统计查询");
		return super.query(new ServiceHandlerAdapter() {
			@Override
			public Object serviceQueryOperate() {
				return projectService.queryJSHB(qc);
			}
		});
	}

	@GetMapping("/queryJSQK")
	public Response queryJSQK(JSQK qc) {
		log.info("接收明细查询");
		return super.query(new ServiceHandlerAdapter() {
			@Override
			public Object serviceQueryOperate() {
				return projectService.queryJSQK(qc);
			}
		});
	}
	@GetMapping("/queryJSQKExport")
	public Response queryJSQKExport(JSQK qc) {
		log.info("接收明细查询导出");
		return exportRopert(ReportTemplateEnum.JSQK,projectService.queryJSQK(qc).getItems() );
	}

	@GetMapping("/querySDL")
	public Response querySDL(SDL qc) {
		log.info("送达率查询");
		return super.query(new ServiceHandlerAdapter() {
			@Override
			public Object serviceQueryOperate() {
				return projectService.querySDL(qc);
			}
		});
	}
	@GetMapping("/querySDLExport")
	public Response querySDLExport(SDL qc) {
		log.info("送达率查询导出");
		return exportRopert(ReportTemplateEnum.SDL,projectService.querySDL(qc).getItems() );
	}

	@GetMapping("/zcdDropdown")
	public Response zcdDropdown(String jgdwid) {
		log.info("医疗机构管理新增/修改——暂存点下拉");
		return super.query(new ServiceHandlerAdapter() {
			@Override
			public Object serviceQueryOperate() {
				return projectService.zcdDropdown(jgdwid);
			}
		});
	}

	@GetMapping("/zcdDropdown1")
	public Response zcdDropdown1(String userxzqh) {
		log.info("医疗机构，接收明细，接收情况条件查询——暂存点下拉");
		return super.query(new ServiceHandlerAdapter() {
			@Override
			public Object serviceQueryOperate() {
				return projectService.zcdDropdown1(userxzqh);
			}
		});
	}

	@GetMapping("/jgdwDropdown")
	public Response jgdwDropdown(String userxzqh) {
		log.info("监管单位下拉");
		return super.query(new ServiceHandlerAdapter() {
			@Override
			public Object serviceQueryOperate() {
				return projectService.jgdwDropdown(userxzqh);
			}
		});
	}

	@GetMapping("/userjgDropdown")
	public Response userjgDropdown(String userxzqh,String rylx) {
		log.info("人员机构下拉");
		return super.query(new ServiceHandlerAdapter() {
			@Override
			public Object serviceQueryOperate() {
				return projectService.userjgDropdown(userxzqh,rylx);
			}
		});
	}


	@GetMapping("/userYljgDropdown")
	public Response userYljgDropdown(String userxzqh,String rylx,String zcdid) {
		log.info("人员管理新增/修改—医疗机构下拉");
		return super.query(new ServiceHandlerAdapter() {
			@Override
			public Object serviceQueryOperate() {
				return projectService.userYljgDropdown(userxzqh,rylx,zcdid);
			}
		});
	}


	@GetMapping("/userJgdwDropdown")
	public Response userJgdwDropdown(String userxzqh,String rylx) {
		log.info("人员管理新增/修改—监管单位下拉");
		return super.query(new ServiceHandlerAdapter() {
			@Override
			public Object serviceQueryOperate() {
				return projectService.userJgdwDropdown(userxzqh,rylx);
			}
		});
	}

}








