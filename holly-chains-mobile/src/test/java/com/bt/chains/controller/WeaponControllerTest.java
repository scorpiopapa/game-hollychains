package com.bt.chains.controller;

import static java.lang.System.out;
import static org.springframework.test.web.server.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.server.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.server.setup.MockMvcBuilders.standaloneSetup;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import com.bt.chains.BaseTest;
import com.bt.chains.bean.domain.Param;
import com.bt.chains.bean.domain.UserWeapon;
import com.bt.chains.bean.form.WeaponForm;
import com.bt.chains.bean.form.WeaponSellForm;
import com.joinway.utils.json.JsonConverter;

public class WeaponControllerTest extends BaseTest {
	@Autowired
	private WeaponController controller;
	
	
	

	@Test
	public void testPlayStage1List() throws Exception {
		// a json string
		String output = standaloneSetup(controller)
				.build()
				.perform(
						get("/weapon/queryWeaponInfo?userId=386").accept(
								MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn().getResponse()
				.getContentAsString();
		out.println(output);
	}

	
	@Test
	public void test() throws Exception {
//		/**
//		 * 测试武器合成
//		 */
//	    WeaponComposeForm form = new WeaponComposeForm();
//	    //用户ID
//	    form.setUserId(1);
//	    //贡品ID
//	    Param param = new Param();
//	    param.setId(1);
//	    Param param1 = new Param();
//	    param1.setId(2);
//	    Param param2 = new Param();
//	    param2.setId(3);
//	    Param param3 = new Param();
//	    param3.setId(4);
//	    List<Param> list = new ArrayList<Param>();
//	    list.add(param);
//	    list.add(param1);
//	    list.add(param2);
//	    list.add(param3);
//	    
//	    form.setTributeIds(list);
//	    //合成的武器ID
//	    form.setId(5);
//	    //级别
//	    form.setWeaponRank(3);
//	    
//	    out.println(JsonUtils.objectToString(form));
//	    
//	    // a json string
//		String output = standaloneSetup(controller)
//				.build()
//				.perform(
//						post("/weapon/composeWeapon").body(JsonUtils.objectToString(form).getBytes("UTF-8"))
//								.contentType(MediaType.APPLICATION_JSON)
//								.accept(MediaType.APPLICATION_JSON)
////								.headers(ClientHelper.getHeaders())
//				)
//				.andReturn().getResponse().getContentAsString();
//		
//		out.println(output);
		
//		/**
//		 * 测试武器导入
//		 */
//		WeaponImportForm form = new WeaponImportForm();
//	    //用户ID
//	    form.setUserId(2);
//	    Param param = new Param();
//	    param.setId(1);
//	    Param param1 = new Param();
//	    param1.setId(2);
//	    List<Param> list = new ArrayList<Param>();
//	    list.add(param);
//	    list.add(param1);
//	    form.setIds(list);
//	    
//	    out.println(JsonUtils.objectToString(form));
//	    
//	    // a json string
//		String output = standaloneSetup(controller)
//				.build()
//				.perform(
//						post("/weapon/importWeapon").body(JsonUtils.objectToString(form).getBytes("UTF-8"))
//								.contentType(MediaType.APPLICATION_JSON)
//								.accept(MediaType.APPLICATION_JSON)
////								.headers(ClientHelper.getHeaders())
//				)
//				.andReturn().getResponse().getContentAsString();
//		
//		out.println(output);
		
		/**
		 * 测试武器贩卖
		 */
		WeaponSellForm form = new WeaponSellForm();
	    //用户ID
	    form.setUserId(386);
	    Param param = new Param();
	    param.setId(27);
	    Param param1 = new Param();
	    param1.setId(28);
	    List<Param> list = new ArrayList<Param>();
	    list.add(param);
	    list.add(param1);
	    form.setIds(list);
	    
	    out.println(JsonConverter.objectToJson(form));
	    
	    // a json string
		String output = standaloneSetup(controller)
				.build()
				.perform(
						post("/weapon/sellWeapon").body(JsonConverter.objectToJson(form).getBytes("UTF-8"))
								.contentType(MediaType.APPLICATION_JSON)
								.accept(MediaType.APPLICATION_JSON)
//								.headers(ClientHelper.getHeaders())
				)
				.andReturn().getResponse().getContentAsString();
		
		out.println(output);
		/**
		 * 插入新武器
		 */
//		WeaponForm form = new WeaponForm();
//	    //用户ID
//	    form.setUserId(1);
////	    form.setWeaponIds("1,2,3,4");
////	    form.setWeaponRankIds("5,3,5,5");
////	    form.setWeaponIds("1");
////	    form.setWeaponRankIds("5");
//	    List<UserWeapon> weapons = new ArrayList<UserWeapon>();
//	    UserWeapon userWeapon = new UserWeapon();
//	    userWeapon.setWeaponId(1);
//	    userWeapon.setWeaponRank(1);
//	    UserWeapon userWeapon1 = new UserWeapon();
//	    userWeapon1.setWeaponId(2);
//	    userWeapon1.setWeaponRank(2);
//	    weapons.add(userWeapon);
//	    weapons.add(userWeapon1);
//	    form.setWeapons(weapons);
//	    
//	    out.println(JsonConverter.objectToJson(form));
//	    
//	    // a json string
//		String output = standaloneSetup(controller)
//				.build()
//				.perform(
//						post("/weapon/insertWeapons").body(JsonConverter.objectToJson(form).getBytes("UTF-8"))
//								.contentType(MediaType.APPLICATION_JSON)
//								.accept(MediaType.APPLICATION_JSON)
////								.headers(ClientHelper.getHeaders())
//				)
//				.andReturn().getResponse().getContentAsString();
//		
//		out.println(output);
		
		
//		/**
//		 * 测试武器强化
//		 */
//		IntensifyUserWeaponForm form = new IntensifyUserWeaponForm();
//	    form.setId(24);
//	    form.setUserId(375);
//		form.setWeaponRank(10);
//		form.setPayStatus("1");
//		form.setPayType("0");
//		form.setMoney(500);
//	    
//	    out.println(JsonConverter.objectToJson(form));
//	    
//	    // a json string
//		String output = standaloneSetup(controller)
//				.build()
//				.perform(
//						post("/weapon/intensifyUserWeapon").body(JsonConverter.objectToJson(form).getBytes("UTF-8"))
//								.contentType(MediaType.APPLICATION_JSON)
//								.accept(MediaType.APPLICATION_JSON)
////								.headers(ClientHelper.getHeaders())
//				)
//				.andReturn().getResponse().getContentAsString();
//		
//		out.println(output);
	}
	
	@Test
	public void testUpdateWeapon() throws Exception {
		WeaponForm form = new WeaponForm();
		form.setUserId(386);
		List<Param> wids = new ArrayList<Param>();
		Param param = new Param();
		param.setId(28);
		wids.add(param);
		form.setIds(wids);
		
		out.println(JsonConverter.objectToJson(form));
	    
	    // a json string
		String output = standaloneSetup(controller)
				.build()
				.perform(
						post("/weapon/updateUserWeapons").body(JsonConverter.objectToJson(form).getBytes("UTF-8"))
								.contentType(MediaType.APPLICATION_JSON)
								.accept(MediaType.APPLICATION_JSON)
//								.headers(ClientHelper.getHeaders())
				)
				.andReturn().getResponse().getContentAsString();
		
		out.println(output);
	}
}
