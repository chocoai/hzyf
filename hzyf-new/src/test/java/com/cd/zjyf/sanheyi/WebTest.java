package com.cd.zjyf.sanheyi;

import com.cd.zjyf.util.MockUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static com.cd.zjyf.util.MockUtil.getMethod;

/**
 * Created by chen.shuodong on 2018/5/28.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class WebTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void setupMockMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        MockUtil.mockMvc=mockMvc;
    }


    @Test
    public void queryJSQK() {
            getMethod("/queryJSQK", "userxzqh", "330000000, 330500000","page","1","size","10");
    }


    @Test
    public void queryJSMX() {
        getMethod("/queryJSMX", "userxzqh", "330000000, 330500000");
    }


    @Test
    public void queryJSTB() {
        getMethod("/queryJSTB", "userxzqh", "330000000, 330500000","level","2");
    }

    //

    @Test
    public void listYFZLByOne() {
        getMethod("/home/listYFZLByOne", "userxzqh", "330000000, 330500000","timeType","2");
    }

    @Test
    public void qst() {
        getMethod("/home/qst", "userxzqh", "330000000, 330500000","timeType","2");
    }



    @Test
    public void home() {
        getMethod("/home/listYFZLByMonth", "userxzqh", "330000000, 330500000","timeType","2");
        getMethod("/home/listYFZLByOne", "userxzqh", "330000000, 330500000","timeType","2");
        getMethod("/home/listDWnocollect", "userxzqh", "330000000, 330500000","timeType","2");
        getMethod("/home/yearTotalZL", "userxzqh", "330000000, 330500000","timeType","2");
        getMethod("/home/qst", "userxzqh", "330000000, 330500000","timeType","2");
        getMethod("/home/sjjsqk", "userxzqh", "330000000, 330500000","timeType","2");
    }

    @Test
    public void screen() {
        getMethod("/listYFZLByOne", "regionCode", "330000000, 330500000","timeType","2");
        getMethod("/listDWnocollect", "regionCode", "330000000, 330500000","timeType","2");
        getMethod("/yearTotalZL", "regionCode", "330000000, 330500000","timeType","2");
        getMethod("/qst", "regionCode", "330000000, 330500000","timeType","2");
        getMethod("/sjjsqk", "regionCode", "330000000, 330500000","timeType","2");
    }




    @Test
    public void screen2() {
        getMethod("/znjg", "regionCode", "330000000, 330500000","page","1","size","10");
        getMethod("/areaZL", "regionCode", "330000000, 330500000","page","1","size","10");
        getMethod("/carLocation", "regionCode", "330000000, 330500000","page","1","size","10");
        getMethod("/zcdList", "regionCode", "330000000, 330500000","page","1","size","10");
        getMethod("/csdList", "regionCode", "330000000, 330500000","page","1","size","10");
        getMethod("/yearTotalZL", "regionCode", "330000000, 330500000","page","1","size","10");
        getMethod("/areaDropdown", "regionCode", "330000000, 330500000","page","1","size","10");
        getMethod("/listDWsjqk2", "regionCode", "330000000, 330500000","page","1","size","10");
        getMethod("/listDWinfo", "regionCode", "330000000, 330500000","page","1","size","10");
        getMethod("/listDLXX", "regionCode", "330000000, 330500000","page","1","size","10","zdTypes","1,2,3");
        getMethod("/listYFZLByOneMonth", "regionCode", "330000000, 330500000","page","1","size","10");

    }

    /*
        index
    qrcodeCheckZCD
    qrcode
    queryTGZ
    history
     */
    @Test
    public void app() {
        getMethod("/sjz/index", "id", "330000000, 330500000","page","1","size","10");
        getMethod("/sjz/queryTGZ", "id", "330000000, 330500000","page","1","size","10");

    }


}
