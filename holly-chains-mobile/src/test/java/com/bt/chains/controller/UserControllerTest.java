package com.bt.chains.controller;

import static java.lang.System.out;
import static org.springframework.test.web.server.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.server.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.server.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import com.bt.chains.BaseTest;
import com.bt.chains.bean.form.BindForm;
import com.bt.chains.bean.form.LoginForm;
import com.bt.chains.bean.form.UpdateUserNameForm;
import com.joinway.utils.json.JsonConverter;

public class UserControllerTest extends BaseTest {

	@Autowired
	private UserController controller;
	
	@Test
	public void testLogin() throws Exception {
	    LoginForm form = new LoginForm();
	    
	    form.setId("Rose");
	    form.setMarket("G");
	    
	    out.println(JsonConverter.objectToJson(form));
	    
	    // a json string
		String output = standaloneSetup(controller)
				.build()
				.perform(
						post("/user/login").body(JsonConverter.objectToJson(form).getBytes("UTF-8"))
								.contentType(MediaType.APPLICATION_JSON)
								.accept(MediaType.APPLICATION_JSON)
//								.headers(ClientHelper.getHeaders())
				)
				.andReturn().getResponse().getContentAsString();
		
		out.println(output);
	}
	
	/*	@Test
	public void testUser() throws Exception {
		String id = "0";
		
	    // a json string
		String output = standaloneSetup(controller)
				.build()
				.perform(
						get("/user?id=" + id)
								.contentType(MediaType.APPLICATION_JSON)
								.accept(MediaType.APPLICATION_JSON)
//								.headers(ClientHelper.getHeaders())
				)
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		
		out.println(output);
		
//		LoginUser user = JsonConverter.convert(output, new TypeReference<LoginUser>(){});
//		Assert.assertEquals(id, user.getId());
	}

	@Test
	public void testShop() throws Exception {
//		LoginUser user = login();
		
		ShoppingForm form = new ShoppingForm();
		
	    form.setId(1);
	    form.setUserId(1);
	    form.setCost(10);
	    form.setCostType(DBConstants.CostType.Money);
	    form.setDevice("G");
	    
	    out.println(JsonConverter.objectToJson(form));
	    
	    // a json string
		String output = standaloneSetup(controller)
				.build()
				.perform(
						post("/user/shop").body(JsonConverter.objectToJson(form).getBytes("UTF-8"))
								.contentType(MediaType.APPLICATION_JSON)
								.accept(MediaType.APPLICATION_JSON)
				)
				.andReturn().getResponse().getContentAsString();
		
		out.println(output);
	}
	
	@Test
	public void testGetAchievements() throws Exception {
		String id = "8";
		
	    // a json string
		String output = standaloneSetup(controller)
				.build()
				.perform(
						get("/user/achievement?id=" + id)
								.contentType(MediaType.APPLICATION_JSON)
								.accept(MediaType.APPLICATION_JSON)
//								.headers(ClientHelper.getHeaders())
				)
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		
		out.println(output);
		
//		LoginUser user = JsonConverter.convert(output, new TypeReference<LoginUser>(){});
//		Assert.assertEquals(id, user.getId());
	}

	@Test
	public void testPostAchievements() throws Exception {
		AchievementForm form = new AchievementForm();
		form.setAchievementId(4);
		form.setUserId(8);
		
	    // a json string
		String output = standaloneSetup(controller)
				.build()
				.perform(
						post("/user/achievement").body(JsonConverter.objectToJson(form).getBytes("UTF-8"))
								.contentType(MediaType.APPLICATION_JSON)
								.accept(MediaType.APPLICATION_JSON)
//								.headers(ClientHelper.getHeaders())
				)
				.andReturn().getResponse().getContentAsString();
		
		out.println(output);
		
//		LoginUser user = JsonConverter.convert(output, new TypeReference<LoginUser>(){});
//		Assert.assertEquals(id, user.getId());
	}

	private LoginUser login() throws Exception {
	    LoginForm form = new LoginForm();
	    
	    form.setId("googleId");
	    form.setMarket("G");
	    
	    String output = standaloneSetup(controller)
				.build()
				.perform(
						post("/user/login").body(JsonConverter.objectToJson(form).getBytes("UTF-8"))
								.contentType(MediaType.APPLICATION_JSON)
								.accept(MediaType.APPLICATION_JSON)
//								.headers(ClientHelper.getHeaders())
				).andReturn().getResponse().getContentAsString();
	    
	    LoginUser user = JsonConverter.convert(output, new TypeReference<LoginUser>(){});
	    
	    return user;
	}*/
	
//	@Test
//	public void insertUserLastRecordsTest() throws Exception {
//		/**
//		 * 插入用户
//		 */
//		UserLastRecordsForm form = new UserLastRecordsForm();
//		List<UserLastRecords> roles = new ArrayList<UserLastRecords>();
//		UserLastRecords records = new UserLastRecords();
//		records.setUserId(11);
//		records.setType(0);
//		records.setId(1);
//		records.setRank(1);
//		roles.add(records);
//		List<UserLastRecords> weapons = new ArrayList<UserLastRecords>();
//		UserLastRecords records1 = new UserLastRecords();
//		records1.setUserId(11);
//		records1.setType(1);
//		records1.setId(1);
//		records1.setRank(1);
//		UserLastRecords records2 = new UserLastRecords();
//		records2.setUserId(11);
//		records2.setType(1);
//		records2.setId(2);
//		records2.setRank(1);
//		weapons.add(records1);
//		weapons.add(records2);
//		List<UserLastRecords> magics = new ArrayList<UserLastRecords>();
//		UserLastRecords records3 = new UserLastRecords();
//		records3.setUserId(11);
//		records3.setType(2);
//		records3.setId(1);
//		records3.setRank(1);
//		magics.add(records3);
//		
//	    //用户ID
//	    form.setUserId(11);
//	    form.setRoles(roles);
//	    form.setWeapons(weapons);
//	    form.setMagics(magics);
//	    out.println(JsonConverter.objectToJson(form));
//	    
//	    // a json string
//		String output = standaloneSetup(controller)
//				.build()
//				.perform(
//						post("/user/insertUserLastRecords").body(JsonConverter.objectToJson(form).getBytes("UTF-8"))
//								.contentType(MediaType.APPLICATION_JSON)
//								.accept(MediaType.APPLICATION_JSON)
////								.headers(ClientHelper.getHeaders())
//				)
//				.andReturn().getResponse().getContentAsString();
//		
//		out.println(output);
//	}
	
	@Test
	public void test() throws Exception {
	    // a json string
		String output = standaloneSetup(controller)
				.build()
				.perform(
						get("/user/code?id=371")
								.accept(MediaType.APPLICATION_JSON)
				)
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		out.println(output);
	}
	
	@Test
	public void testBind() throws Exception {
		
		BindForm form = new BindForm();
		form.setId(371);
		form.setUserId(375);
		form.setCode("1111");
//		form.setMarketId("aaa");
//		form.setMarket("G");
		
		out.println(JsonConverter.objectToJson(form));
		    
	    // a json string
		String output = standaloneSetup(controller)
				.build()
				.perform(
						post("/user/bind").body(JsonConverter.objectToJson(form).getBytes("UTF-8"))
								.contentType(MediaType.APPLICATION_JSON)
								.accept(MediaType.APPLICATION_JSON)
//									.headers(ClientHelper.getHeaders())
				)
				.andReturn().getResponse().getContentAsString();
		
		out.println(output);
	}
	
	@Test
	public void testUpdateUserName() throws Exception {
		
		UpdateUserNameForm form = new UpdateUserNameForm();
		form.setUserId(371);
		form.setUserName("张三");
		
		
		out.println(JsonConverter.objectToJson(form));
		    
	    // a json string
		String output = standaloneSetup(controller)
				.build()
				.perform(
						post("/user/updateUserName").body(JsonConverter.objectToJson(form).getBytes("UTF-8"))
								.contentType(MediaType.APPLICATION_JSON)
								.accept(MediaType.APPLICATION_JSON)
//									.headers(ClientHelper.getHeaders())
				)
				.andReturn().getResponse().getContentAsString();
		
		out.println(output);
	}
}
