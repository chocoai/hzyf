package com.cd.zjyf;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.cd.hik.carlocation.DeviceNode;
import com.cd.zjyf.bean.AppUserExample;
import com.cd.zjyf.bean.YlwsUpload;
import com.cd.zjyf.mapper.AppUserMapper;
import com.cd.zjyf.mapper.ProjectMapper;
import com.cd.zjyf.mapper.YlfwJsdjMapper;
import com.cd.zjyf.mapper.YlwsUploadMapper;
import com.cd.zjyf.pojo.qc.JSQK;
import com.cd.zjyf.proxy.carlocation.CarlocationClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cd.zjyf.bean.AppUser;
import com.cd.zjyf.bean.YlfwJsdj;

import com.github.pagehelper.PageHelper;
import org.springframework.web.client.RestTemplate;

import javax.xml.bind.JAXBElement;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ZjyfApplicationTests {



    @Autowired
    ProjectMapper projectMapper;
	@Test
	public void testDWinfo() {
        projectMapper.deleteUserByYLJGID("123");
	}

    @Autowired
    AppUserMapper appUserMapper;

	@Autowired
    YlwsUploadMapper ylwsUploadMapper;

    @Test
    public void test3(){
        YlwsUpload ylwsUpload = new YlwsUpload();
        ylwsUpload.setYljgid("111111");
        ylwsUpload.setYear(String.valueOf(LocalDate.now().getYear()));
        ylwsUpload.setQuarter("3");
        ylwsUploadMapper.insertSelective(ylwsUpload);
    }

	@Test
	public void test(){
        PageHelper.startPage(1,10);
        AppUserExample appUserExample = new AppUserExample();
        appUserExample.createCriteria().andIdIsNotNull();
        List<AppUser> appUsers = appUserMapper.selectByExample(appUserExample);



    }


    @Autowired
    ProjectMapper m;

    @Test
    public void t2(){
        JSQK jsqk = new JSQK();
        jsqk.setUserxzqh("330000000, 330500000");

        m.queryJSQK(jsqk);
      //  System.out.println("数量"+m.getTotal());

    }


    @Autowired
    YlfwJsdjMapper ylfwJsdjMapper;
    @Test
    public void test2(){
        YlfwJsdj ylfwJsdj = ylfwJsdjMapper.selectByPrimaryKey("9776-fba9-498b-97c4-dce83a72a4d0");
        ylfwJsdj.setJstime(new Date());
        ylfwJsdj.setEndtime(new Date());
        ylfwJsdj.setId(null);
        ylfwJsdjMapper.insertSelective(ylfwJsdj);
    }

    @Autowired
    CarlocationClient carlocationClient;


    @Test
    public void test22(){
        List<DeviceNode> devTreeInfo = carlocationClient.getDevTreeInfo();
        JAXBElement<String> devicename = devTreeInfo.get(0).getDevicename();
        System.out.println("xxxx");
        System.out.println(devicename.getValue());
        System.out.println("xxxx");
    }

}
