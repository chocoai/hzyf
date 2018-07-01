package com.cd.zjyf.util;

import com.cd.zjyf.bean.AppUser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

public class MockUtil {
		
    public static MockMvc mockMvc;


	//单参数的get方式
	public static<T> void postMethod(String url,T obj ) {
		ObjectMapper mapper = new ObjectMapper();

		try {
			mockMvc
                    .perform(
                            MockMvcRequestBuilders.
                            post(url).characterEncoding("UTF-8")
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .content(mapper.writeValueAsString(obj)))
					.andExpect(MockMvcResultMatchers.status().isOk())
					.andDo(MockMvcResultHandlers.print())
					.andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("\"code\":\"1000\"")))
					.andReturn()
                    .getResponse().getContentAsString();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	//单参数的get方式
	public static void oneParamGetMethod(String url,String name,String value )  {
		try {
			mockMvc.perform(MockMvcRequestBuilders.get(url)
			        .contentType(MediaType.APPLICATION_JSON_UTF8)
			        .param(name, value)
			        .accept(MediaType.APPLICATION_JSON))
			        .andExpect(MockMvcResultMatchers.status().isOk())
			        .andDo(MockMvcResultHandlers.print())
			        .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("\"code\":\"1000\"")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//1
	public static void getMethod(String url,String name,String value )  {
		try {
			mockMvc.perform(MockMvcRequestBuilders.get(url)
					.contentType(MediaType.APPLICATION_JSON_UTF8)
					.param(name, value)
					.accept(MediaType.APPLICATION_JSON))
					.andExpect(MockMvcResultMatchers.status().isOk())
					.andDo(MockMvcResultHandlers.print())
					.andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("\"code\":\"1000\"")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//2
	public static void getMethod(String url,String name,String value,String name1,String value1)  {
		try {
			mockMvc.perform(MockMvcRequestBuilders.get(url)
					.contentType(MediaType.APPLICATION_JSON_UTF8)
					.param(name, value).param(name1, value1)
					.accept(MediaType.APPLICATION_JSON))
					.andExpect(MockMvcResultMatchers.status().isOk())
					.andDo(MockMvcResultHandlers.print())
					.andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("\"code\":\"1000\"")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//3
	public static void getMethod(String url,String name,String value,String name1,String value1,String name2,String value2)  {
		try {
			mockMvc.perform(MockMvcRequestBuilders.get(url)
					.contentType(MediaType.APPLICATION_JSON_UTF8)
					.param(name, value).param(name1, value1).param(name2, value2)
					.accept(MediaType.APPLICATION_JSON))
					.andExpect(MockMvcResultMatchers.status().isOk())
					.andDo(MockMvcResultHandlers.print())
					.andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("\"code\":\"1000\"")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//4
	public static void getMethod(String url,String name,String value,String name1,String value1,String name2,String value2,String name3,String value3)  {
		try {
			mockMvc.perform(MockMvcRequestBuilders.get(url)
					.contentType(MediaType.APPLICATION_JSON_UTF8)
					.param(name, value).param(name1, value1).param(name2, value2).param(name3, value3)
					.accept(MediaType.APPLICATION_JSON))
					.andExpect(MockMvcResultMatchers.status().isOk())
					.andDo(MockMvcResultHandlers.print())
					.andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("\"code\":\"1000\"")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//5
	public static void getMethod(String url,String name,String value,String name1,String value1,String name2,String value2,String name3,String value3, String name4,String value4)  {
		try {
			mockMvc.perform(MockMvcRequestBuilders.get(url)
					.contentType(MediaType.APPLICATION_JSON_UTF8)
					.param(name, value).param(name1, value1).param(name2, value2).param(name3, value3).param(name4, value4)
					.accept(MediaType.APPLICATION_JSON))
					.andExpect(MockMvcResultMatchers.status().isOk())
					.andDo(MockMvcResultHandlers.print())
					.andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("\"code\":\"1000\"")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//6
	public static void getMethod(String url,String name,String value,String name1,String value1,String name2,String value2,String name3,String value3, String name4,String value4,String name5,String value5)  {
		try {
			mockMvc.perform(MockMvcRequestBuilders.get(url)
					.contentType(MediaType.APPLICATION_JSON_UTF8)
					.param(name, value).param(name1, value1).param(name2, value2).param(name3, value3).param(name4, value4).param(name5, value5)
					.accept(MediaType.APPLICATION_JSON))
					.andExpect(MockMvcResultMatchers.status().isOk())
					.andDo(MockMvcResultHandlers.print())
					.andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("\"code\":\"1000\"")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//7
	public static void getMethod(String url,String name,String value,String name1,String value1,String name2,String value2,String name3,String value3, String name4,String value4,String name5,String value5,String name6,String value6)  {
		try {
			mockMvc.perform(MockMvcRequestBuilders.get(url)
					.contentType(MediaType.APPLICATION_JSON_UTF8)
					.param(name, value).param(name1, value1).param(name2, value2).param(name3, value3).param(name4, value4).param(name5, value5).param(name6, value6)
					.accept(MediaType.APPLICATION_JSON))
					.andExpect(MockMvcResultMatchers.status().isOk())
					.andDo(MockMvcResultHandlers.print())
					.andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("\"code\":\"1000\"")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
