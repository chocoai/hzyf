package com.cd.zjyf;

import com.cd.zjyf.base.controller.ServiceHandlerAdapter;
import com.cd.zjyf.bean.YlwsJbxx;
import com.cd.zjyf.enums.ReportTemplateEnum;
import com.cd.zjyf.exception.SystemException;
import com.cd.zjyf.exception.ValidateException;
import com.cd.zjyf.pojo.PageBean;
import com.cd.zjyf.pojo.Response;
import com.cd.zjyf.pojo.qc.*;
import com.cd.zjyf.pojo.qr.YlwsJbxxQR;
import com.cd.zjyf.service.ProjectService;
import com.cd.zjyf.util.MockUtil;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;

import static com.cd.zjyf.util.MockUtil.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MockTest {

	private static Logger log = LoggerFactory.getLogger(MockTest.class);

	@Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void setupMockMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        MockUtil.mockMvc=mockMvc;
    }

    @Test
    public void test() {
		getMethod("/areaDropdown", "regionCode", "330000000, 330500000");
		getMethod("/yearTotalZL", "regionCode", "330000000, 330500000");
		getMethod("/qst", "regionCode", "330000000, 330500000");
		getMethod("/sjjsqk", "regionCode", "330000000, 330500000");
		getMethod("/csdList", "regionCode", "330000000, 330500000");
		getMethod("/zcdList", "regionCode", "330000000, 330500000");
		getMethod("/carLocation", "regionCode", "330000000, 330500000");
		getMethod("/listDWsjqk2", "regionCode", "330000000, 330500000");
    }

	@Test
	public void test1(){
		getMethod("/cqueryYLJG", "userxzqh", "330000000, 330500000");
	}


//
//	@PostMapping("/addYLJG")
//	public Response addYLJG(YlwsJbxx ylwsJbxx) {
//		log.info("医疗机构新增");
//		return super.genericSaveOrUpdate(new ServiceHandlerAdapter() {
//			@Override
//			public Object serviceSaveOrUpdateOperate() throws SystemException, ValidateException {
//				return projectService.addYLJG(ylwsJbxx);
//			}
//		});
//	}
	@Test
	public void test2(){
		YlwsJbxx ylwsJbxx = new YlwsJbxx();
		ylwsJbxx.setShyxdm("dafsd");

		postMethod("/addYLJG", ylwsJbxx);
	}



//	@PutMapping("/updateYLJG")
//	public Response updateYLJG(YlwsJbxx ylwsJbxx) {
//		log.info("医疗机构修改");
//		return super.genericSaveOrUpdate(new ServiceHandlerAdapter() {
//			@Override
//			public Object serviceSaveOrUpdateOperate() throws SystemException, ValidateException {
//				return projectService.updateYLJG(ylwsJbxx);
//			}
//		});
//	}
//
//	@DeleteMapping("/deleteYLJG/{id}")
//	public Response deleteYLJG(@PathVariable("id") String id) {
//		log.info("医疗机构删除");
//		return super.genericSaveOrUpdate(new ServiceHandlerAdapter() {
//			@Override
//			public Object serviceSaveOrUpdateOperate() throws SystemException, ValidateException {
//				return projectService.deleteYLJG(id);
//			}
//		});
//	}
//
//	@GetMapping("/queryYLJG/{id}")
//	public Response queryYLJG(@PathVariable("id") String id) {
//		log.info("医疗机构查看详情");
//		return super.query(new ServiceHandlerAdapter() {
//			@Override
//			public Object serviceQueryOperate() {
//				return projectService.queryYLJG(id);
//			}
//		});
//	}
//
//	@GetMapping("/cqueryYLJG")
//	public Response cqueryYLJG(YlwsJbxxQC qc) {
//		log.info("医疗机构条件查询");
//		return super.query(new ServiceHandlerAdapter() {
//			@Override
//			public Object serviceQueryOperate() {
//				return projectService.cqueryYLJG(qc);
//			}
//		});
//	}
//
//	@GetMapping("/cqueryYLJGExport")
//	public Response cqueryYLJGExport(YlwsJbxxQC qc) {
//		log.info("医疗机构条件查询导出");
//		PageBean<YlwsJbxxQR> ylwsJbxxPageBean = projectService.cqueryYLJG(qc);
//		return exportRopert(ReportTemplateEnum.YLJG,ylwsJbxxPageBean.getItems() );
//	}
//
//	@GetMapping("/queryJSMX")
//	public Response queryJSMX(JSMX qc) {
//		log.info("接收明细列表查询");
//		return super.query(new ServiceHandlerAdapter() {
//			@Override
//			public Object serviceQueryOperate() {
//				return projectService.queryJSMX(qc);
//			}
//		});
//	}
//	@GetMapping("/queryJSMXExport")
//	public Response queryJSMXExport(JSMX qc) {
//		log.info("接收明细列表查询导出");
//		return exportRopert(ReportTemplateEnum.RY,projectService.queryJSMX(qc).getItems() );
//	}
//
//	@GetMapping("/queryJSTB")
//	public Response queryJSTB(JSTB qc) {
//		log.info("接收同比统计查询");
//		return super.query(new ServiceHandlerAdapter() {
//			@Override
//			public Object serviceQueryOperate() {
//				return projectService.queryJSTB(qc);
//			}
//		});
//	}
//
//	@GetMapping("/queryJSHB")
//	public Response queryJSHB(JSHB qc) {
//		log.info("接收环比统计查询");
//		return super.query(new ServiceHandlerAdapter() {
//			@Override
//			public Object serviceQueryOperate() {
//				return projectService.queryJSHB(qc);
//			}
//		});
//	}
//
//	@GetMapping("/queryJSQK")
//	public Response queryJSQK(JSQK qc) {
//		log.info("接收情况查询");
//		return super.query(new ServiceHandlerAdapter() {
//			@Override
//			public Object serviceQueryOperate() {
//				return projectService.queryJSQK(qc);
//			}
//		});
//	}
//	@GetMapping("/queryJSQKExport")
//	public Response queryJSQKExport(JSQK qc) {
//		log.info("接收情况查询导出");
//		return exportRopert(ReportTemplateEnum.RY,projectService.queryJSQK(qc).getItems() );
//	}
//
//	@GetMapping("/querySDL")
//	public Response querySDL(SDL qc) {
//		log.info("送达率查询");
//		return super.query(new ServiceHandlerAdapter() {
//			@Override
//			public Object serviceQueryOperate() {
//				return projectService.querySDL(qc);
//			}
//		});
//	}
//	@GetMapping("/querySDLExport")
//	public Response querySDLExport(SDL qc) {
//		log.info("送达率查询导出");
//		return exportRopert(ReportTemplateEnum.RY,projectService.querySDL(qc).getItems() );
//	}
//
//	@GetMapping("/zcdDropdown")
//	public Response zcdDropdown(String userxzqh) {
//		log.info("暂存点下拉");
//		return super.query(new ServiceHandlerAdapter() {
//			@Override
//			public Object serviceQueryOperate() {
//				return projectService.zcdDropdown(userxzqh);
//			}
//		});
//	}
//
//	@GetMapping("/jgdwDropdown")
//	public Response jgdwDropdown(String userxzqh) {
//		log.info("监管单位下拉");
//		return super.query(new ServiceHandlerAdapter() {
//			@Override
//			public Object serviceQueryOperate() {
//				return projectService.jgdwDropdown(userxzqh);
//			}
//		});
//	}


}

