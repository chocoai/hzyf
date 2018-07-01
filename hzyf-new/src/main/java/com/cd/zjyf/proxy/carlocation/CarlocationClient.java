package com.cd.zjyf.proxy.carlocation;


import com.cd.hik.carlocation.*;
import com.cd.zjyf.scheduled.CarLocationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBElement;
import java.util.List;

/**
 * Created by chen.shuodong on 2018/6/12.
 */
@Component
public class CarlocationClient {

    @Value("${CAR_LOCATION.HIK.USERNAME}")
    private String username;

    @Value("${CAR_LOCATION.HIK.PASSWORD}")
    private String password;

    @Value("${CAR_LOCATION.HIK.ROUTE}")
    private int route;


    private Logger log = LoggerFactory.getLogger(CarlocationClient.class);


    private  IGetDevTreeService getDevTreeServiceImplPort;

    {
         GetDevTreeServiceImplService getDevTreeServiceImplService = new GetDevTreeServiceImplService();
        getDevTreeServiceImplPort = getDevTreeServiceImplService.getGetDevTreeServiceImplPort();
    }




    public void  wsClient(){
        DeviceGpsStatus devGpsStatus = getDevTreeServiceImplPort.getDevGpsStatus("100009008");
        JAXBElement<GpsData> gpsData = devGpsStatus.getGpsData();
        GpsData value = gpsData.getValue();
        JAXBElement<String> latitude = value.getLatitude();
        System.out.println(latitude);
    }



    public List<DeviceNode> getDevTreeInfo(){
        log.trace("海康车辆定位api=>根据用户名、密码下载组织资源及设备列表");
        DevTreeInfoResult devTreeInfo = getDevTreeServiceImplPort.getDevTreeInfo(username, password, route);
        JAXBElement<ArrayOfDeviceNode> deviceNodeList = devTreeInfo.getDeviceNodeList();
        List<DeviceNode> deviceNode = deviceNodeList.getValue().getDeviceNode();
        return deviceNode;
    }

    /**
     *
     * @param deviceaccount
     * @return
     */
    public DeviceGpsStatus getDevGpsStatus(String deviceaccount){
        log.trace("海康车辆定位api=>根据设备ID获取设备状态和GPS信息");
        DeviceGpsStatus devGpsStatus = getDevTreeServiceImplPort.getDevGpsStatus(deviceaccount);
        return  devGpsStatus;
    }

    /**
     * 如果设备状态为离线（0：离线；1：在线）那么返回null
     * @param deviceaccount
     * @return
     */
    public GpsData getDevGpsStatus1(String deviceaccount){
        log.trace("海康车辆定位api=>根据设备ID获取设备状态和GPS信息1");
        DeviceGpsStatus devGpsStatus = getDevTreeServiceImplPort.getDevGpsStatus(deviceaccount);
        if(0==devGpsStatus.getDeviceStatus()) return  null;
        JAXBElement<GpsData> gpsData = devGpsStatus.getGpsData();
        GpsData gpsData1 = gpsData.getValue();
        return  gpsData1;
    }



    public static void main(String[] args) {
        GetDevTreeServiceImplService getDevTreeServiceImplService = new GetDevTreeServiceImplService();
        IGetDevTreeService getDevTreeServiceImplPort = getDevTreeServiceImplService.getGetDevTreeServiceImplPort();
        DeviceGpsStatus devGpsStatus = getDevTreeServiceImplPort.getDevGpsStatus("100009008");
        JAXBElement<GpsData> gpsData = devGpsStatus.getGpsData();
        GpsData value = gpsData.getValue();
        JAXBElement<String> latitude = value.getLatitude();
        System.out.println(latitude.getValue());
        System.out.println(value.getLongitude().getValue());
    }




}



