package com.cd.zjyf.controller;

import java.util.List;

import com.cd.zjyf.pojo.qc.CarLocationPlayback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cd.zjyf.base.controller.BaseController;
import com.cd.zjyf.base.controller.ServiceHandlerAdapter;
import com.cd.zjyf.base.exception.BaseException;
import com.cd.zjyf.bean.YlfwJsdj;
import com.cd.zjyf.exception.ValidateException;
import com.cd.zjyf.pojo.Response;
import com.cd.zjyf.pojo.qc.Region;
import com.cd.zjyf.pojo.qr.AreaDropdown;
import com.cd.zjyf.pojo.qr.AreaZL;
import com.cd.zjyf.pojo.qr.CSDlist;
import com.cd.zjyf.pojo.qr.CarLocation;
import com.cd.zjyf.pojo.qr.DWcount;
import com.cd.zjyf.pojo.qr.QST;
import com.cd.zjyf.pojo.qr.SJSJQK;
import com.cd.zjyf.pojo.qr.ZCDlist;
import com.cd.zjyf.service.ScreenService;



@RestController
//@RequestMapping("api/ylfw/v3")
public class ScreenController extends BaseController {


    @Autowired
    private ScreenService screenService;

    private static Logger log = LoggerFactory.getLogger(ScreenController.class);



    /*@RequestMapping(method = RequestMethod.GET,value="/listDWByRegion")
    public Response listDWByRegion(Region region) {
        log.info("大屏=>单位分布统计");
        return super.query(new ServiceHandlerAdapter() {
            @Override
            public Object serviceQueryOperate(Object o) {
                return screenService.listDWByRegion((Region)region);
            }
        }, region);

    }*/

    /*@RequestMapping(method = RequestMethod.GET,value="/listYFZLByMonth")
    public Response listYFZLByMonth(Region region) {
        log.info("大屏=>本区域近6个月废物收集情况按月份统计");
        return super.query(new ServiceHandlerAdapter() {
            @Override
            public Object serviceQueryOperate(Object o) {
                return screenService.listYFZLByMonth((Region)region);
            }
        }, region);

    }*/


    @RequestMapping(method = RequestMethod.GET,value="/listYFZLByOneMonth")
    public Response listYFZLByOneMonth(Region region) {
        log.info("大屏=>辖区本月废物收集情况按地区统计");
        return super.query(new ServiceHandlerAdapter() {
            @Override
            public Object serviceQueryOperate(Object o) {
                return screenService.listYFZLByOneMonth(region);
            }
        }, region);

    }


    @RequestMapping(method = RequestMethod.GET,value="/listYFZLByOne")
    public Response listYFZLByOne(Region region) {
        log.info("大屏=>本区域本月废物收集情况按类型统计");
        return super.query(new ServiceHandlerAdapter() {
            @Override
            public Object serviceQueryOperate(Object o) {
                return screenService.listYFZLByOne(region);
            }
        }, region);
    }


    /*@RequestMapping(method = RequestMethod.GET,value="/listZXSJByRegion")
    public Response listZXSJByRegion(Region region) {
        log.info("大屏=>查询某地各下属区域内在线收集人数的地区分布情况");
        return super.query(new ServiceHandlerAdapter() {
            @Override
            public Object serviceQueryOperate(Object o) {
                return screenService.listZXSJByRegion((Region)region);
            }
        }, region);
    }*/

    @RequestMapping(method = RequestMethod.GET,value="/listDLXX")
    public Response listDLXX(Region region) {
        log.info("大屏=>查询本地区地理信息列表");
        return super.query(new ServiceHandlerAdapter() {
            @Override
            public Object serviceQueryOperate(Object o) {
                return screenService.listDLXX(region);
            }
        }, region);
    }


    @RequestMapping(method = RequestMethod.GET,value="/listDWinfo")
    public Response listDWinfo(Region region) {
        log.info("大屏=>查询本地区单位信息列表");
        return super.query(new ServiceHandlerAdapter() {
            @Override
            public Object serviceQueryOperate(Object o) {
                return screenService.listDWinfo(region);
            }
        }, region);
    }


    @RequestMapping(method = RequestMethod.GET,value="/listDWnocollect")
    public Response listDWnocollect(Region region) {
        log.info("大屏=>查询本地区长期未收集单位列表，取前十条");
        return super.query(new ServiceHandlerAdapter() {
            @Override
            public Object serviceQueryOperate(Object o) {
                return screenService.listDWnocollect(region);
            }
        }, region);
    }

    //TODO 视频先不做

  /*  @Deprecated
    @RequestMapping(method = RequestMethod.GET,value="/listDWsjqk")
    public Response listDWsjqk(Region region) {
        log.info("大屏=>具体单位收集情况:查询本单位收集或提供废物列表");
        return super.query(new ServiceHandlerAdapter() {
            @Override
            public Object serviceQueryOperate(Object o) {
                return screenService.listDWsjqk((Region)region);
            }
        }, region);

    }*/

    @RequestMapping(method = RequestMethod.GET,value="/listDWsjqk2")
    public Response listDWsjqk2(Region region) {
        log.info("大屏=>具体单位收集情况:查询本单位收集或提供废物列表");
        return super.query(new ServiceHandlerAdapter() {
            @Override
            public Object serviceQueryOperate() {
                return screenService.listDWsjqk2(region);
            }
        });

    }


    @RequestMapping(method = RequestMethod.GET,value="/areaDropdown")
    public Response areaDropdown(Region region) {
        log.info("大屏=>地区下拉查询");
        return super.query(new ServiceHandlerAdapter() {
            @Override
            public Object serviceQueryOperate() {
                return screenService.areaDropdown(region);
            }
        });

    }



    @RequestMapping(method = RequestMethod.GET,value="/yearTotalZL")
    public Response yearTotalZL(Region region) {
        log.info("大屏=>地区年总收集重量（清算时间）");
        return super.query(new ServiceHandlerAdapter() {
            @Override
            public Object serviceQueryOperate() {
                return screenService.yearTotalZL(region);
            }
        });
    }

    @RequestMapping(method = RequestMethod.GET,value="/qst")
    public Response qst(Region region) {
        log.info("大屏=>16年开始近5年的垃圾收集情况和单位数量(清算时间)");
        return super.query(new ServiceHandlerAdapter() {
            @Override
            public Object serviceQueryOperate() {
                return screenService.qst(region);
            }
        });

    }

    @RequestMapping(method = RequestMethod.GET,value="/sjjsqk")
    public Response sjjsqk(Region region) {
        log.info("大屏=>实际接收情况");
        return super.query(new ServiceHandlerAdapter() {
            @Override
            public Object serviceQueryOperate() {
                return screenService.sjjsqk(region);
            }
        });

    }

    @RequestMapping(method = RequestMethod.GET,value="/csdList")
    public Response csdList(Region region) {
        log.info("大屏=>地区产生点列表");
        return super.query(new ServiceHandlerAdapter() {
            @Override
            public Object serviceQueryOperate() {
                return screenService.csdList(region);
            }
        });

    }

    @RequestMapping(method = RequestMethod.GET,value="/zcdList")
    public Response zcdList(Region region) {
        log.info("大屏=>地区暂存点列表");
        return super.query(new ServiceHandlerAdapter() {
            @Override
            public Object serviceQueryOperate() {
                return screenService.zcdList(region);
            }
        });

    }

 /*   @RequestMapping(method = RequestMethod.GET,value="/video")
    public Response video(Region region) {
        log.info("大屏=>查看视频监控");
        return super.query(new ServiceHandlerAdapter() {
            @Override
            public Object serviceQueryOperate() {
                return screenService.video(region);
            }
        });

    }*/


   @RequestMapping(method = RequestMethod.GET,value="/carLocation")
    public Response carLocation() {
       log.info("大屏=>车辆实时定位");
       return super.query(new ServiceHandlerAdapter() {
           @Override
           public Object serviceQueryOperate() {
               return screenService.carLocation();
           }
       });
   }

    @RequestMapping(method = RequestMethod.GET,value="/carLocationPlayback")
    public Response carLocationPlayback(CarLocationPlayback carLocationPlayback) {
        log.info("大屏=>车辆轨迹回访");
        return super.query(new ServiceHandlerAdapter() {
            @Override
            public Object serviceQueryOperate() {
                return screenService.carLocationPlayback(carLocationPlayback);
            }
        });
    }


    @RequestMapping(method = RequestMethod.GET,value="/areaZL")
    public Response areaZL(Region region) {
        log.info("大屏=>今年收集各地区重量");
        return super.query(new ServiceHandlerAdapter() {
            @Override
            public Object serviceQueryOperate() {
                return screenService.areaZL(region);
            }
        });
    }

    @RequestMapping(method = RequestMethod.GET,value="/znjg")
    public Response znjg(Region region) {
        log.info("大屏=>智能监管");
        return super.query(new ServiceHandlerAdapter() {
            @Override
            public Object serviceQueryOperate() {
                return screenService.znjg(region);
            }
        });
    }


}









