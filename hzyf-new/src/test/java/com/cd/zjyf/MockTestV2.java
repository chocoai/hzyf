package com.cd.zjyf;

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

import static com.cd.zjyf.util.MockUtil.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MockTestV2 {
	
	
    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void setupMockMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        MockUtil.mockMvc=mockMvc;
    }

    
   
    public void testV2() {
    	getMethod("/areaDropdown", "regionCode", "330000000, 330500000");
    	getMethod("/yearTotalZL", "regionCode", "330000000, 330500000");
    	getMethod("/qst", "regionCode", "330000000, 330500000");
    	getMethod("/sjjsqk", "regionCode", "330000000, 330500000");
    	getMethod("/csdList", "regionCode", "330000000, 330500000");
    	getMethod("/zcdList", "regionCode", "330000000, 330500000");
    	getMethod("/carLocation", "regionCode", "330000000, 330500000");
    	getMethod("/listDWsjqk2", "regionCode", "330000000, 330500000");
    }

    //


}

