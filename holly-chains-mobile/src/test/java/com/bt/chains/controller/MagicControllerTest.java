package com.bt.chains.controller;

import static java.lang.System.out;
import static org.springframework.test.web.server.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.server.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import com.bt.chains.BaseTest;
import com.bt.chains.bean.form.IntensifyUserMagicForm;
import com.joinway.utils.json.JsonConverter;

public class MagicControllerTest extends BaseTest {
	@Autowired
	private MagicController controller;
//	@Test
//	public void insertUserMagicTest() throws Exception {
//		/**
//		 * 插入新魔法
//		 */
//		MagicForm form = new MagicForm();
//		
//		List<UserMagic> magics = new ArrayList<UserMagic>();
//		UserMagic userMagic = new UserMagic();
//		userMagic.setMagicId(1);
//		userMagic.setMagicRank(1);
//		UserMagic userMagic1 = new UserMagic();
//		userMagic1.setMagicId(2);
//		userMagic1.setMagicRank(1);
//		magics.add(userMagic);
//		magics.add(userMagic1);
//	    //用户ID
//	    form.setUserId(1);
//	    form.setMagics(magics);
//	    
//	    out.println(JsonUtils.objectToString(form));
//	    
//	    // a json string
//		String output = standaloneSetup(controller)
//				.build()
//				.perform(
//						post("/magic/insertUserMagic").body(JsonUtils.objectToString(form).getBytes("UTF-8"))
//								.contentType(MediaType.APPLICATION_JSON)
//								.accept(MediaType.APPLICATION_JSON)
////								.headers(ClientHelper.getHeaders())
//				)
//				.andReturn().getResponse().getContentAsString();
//		
//		out.println(output);
//	}
//	
//	@Test
//	public void sellMagicTest() throws Exception {
//		/**
//		 * 贩卖魔法
//		 */
//		MagicSellForm form = new MagicSellForm();
//	    //用户ID
//	    form.setUserId(1);
//	    form.setMagicIds("1,2,3");
//	    
//	    out.println(JsonUtils.objectToString(form));
//	    
//	    // a json string
//		String output = standaloneSetup(controller)
//				.build()
//				.perform(
//						post("/magic/sellMagic").body(JsonUtils.objectToString(form).getBytes("UTF-8"))
//								.contentType(MediaType.APPLICATION_JSON)
//								.accept(MediaType.APPLICATION_JSON)
////								.headers(ClientHelper.getHeaders())
//				)
//				.andReturn().getResponse().getContentAsString();
//		
//		out.println(output);
//	}
	
	@Test
	public void intensifyUserMagicTest() throws Exception {
		/**
		 * 插入新魔法
		 */
		IntensifyUserMagicForm form = new IntensifyUserMagicForm();
		form.setUserId(326);
		form.setMagicId(11);
//		form.setMagicRank(20);
//		form.setPayStatus("1");
//		form.setPayType("0");
//		form.setMoney(500);
	    
	    out.println(JsonConverter.objectToJson(form));
	    
	    // a json string
		String output = standaloneSetup(controller)
				.build()
				.perform(
						post("/magic/upgradeMagic").body(JsonConverter.objectToJson(form).getBytes("UTF-8"))
								.contentType(MediaType.APPLICATION_JSON)
								.accept(MediaType.APPLICATION_JSON)
//								.headers(ClientHelper.getHeaders())
				)
				.andReturn().getResponse().getContentAsString();
		
		out.println(output);
	}
}
