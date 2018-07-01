package com.cd.zjyf.management;

import com.cd.zjyf.management.bean.Response;
import com.cd.zjyf.management.bean.ResultCode;
import com.cd.zjyf.management.dao.AppUserDao;
import com.cd.zjyf.management.pojo.AppUser;
import com.cd.zjyf.management.pojo.YlwsJbxx;
import com.cd.zjyf.management.service.AppUserService;
import com.cd.zjyf.management.util.AESUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private AppUserDao appUserDao;
	@Autowired
	private AppUserService appUserService;
	@Test
	public void contextLoads() throws Exception {
		String encrypt = AESUtils.encrypt("11111111");
		System.out.println(encrypt);
		String s = AESUtils.desEncrypt("gYPK+Kolmcq8IIODu86LDg==");
		System.out.println(s);
		System.out.println(encrypt.equals(s));
	}

}
