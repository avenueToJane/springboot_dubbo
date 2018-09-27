package com.springboot.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springboot.beans.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.springboot.ConsumerApplication;

/**
 * @RunWith(SpringJUnit4ClassRunner.class)，这是JUnit的注解，通过这个注解让SpringJUnit4ClassRunner
 * @WebAppCofiguration : 指定加载 ApplicationContext是一个WebApplicationContext
 *                     这个类提供Spring测试上下文。
 *                     <p>
 * 					Title: UserControllerTest
 *                     </p>
 *                     <p>
 * 					Description: 单元测试
 *                     </p>
 *                     <p>
 * 					Company: xxx
 *                     </p>
 * @author Mr.yang
 * @date 2018年9月27日 下午7:23:52
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ConsumerApplication.class) // 这里的Application是springboot的启动类名
@WebAppConfiguration
public class UserControllerTest {

	@Autowired
	private WebApplicationContext context;

	private MockMvc mockMvc;// 注入一个MockMvc实例

	@Before
	public void setupMockMvc() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void testSend() throws Exception {
		User user = new User() {
			private static final long serialVersionUID = 1L;
			{
				setAccount("1111");
				setPhone("13487878292");

			}
		};
		Gson gson = new Gson();
		String content = gson.toJson(user, User.class);
		// 调用接口，传入添加的用户参数
		mockMvc.perform(MockMvcRequestBuilders.post("/findUser")// post请求
				.contentType(MediaType.APPLICATION_JSON_UTF8)// 使用Content-Type来表示具体请求中的媒体类型信息。
				.content(content))// 请求的入参
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andDo(MockMvcResultHandlers.print());

	}

	@Test
	public void testSend2() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/findUser"))
		.andExpect(MockMvcResultMatchers.status().isOk());
		// 预期请求地址响应成功（200）
		// .andExpect(MockMvcResultMatchers.content().string("abc"));
		// 预期响应内容为“abc”
	}

}
