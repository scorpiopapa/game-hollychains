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
import com.bt.chains.bean.form.BuyWeaponForm;
import com.bt.chains.bean.form.PropBuyForm;
import com.joinway.utils.json.JsonConverter;

public class PropBuyControllerTest extends BaseTest {
	@Autowired
	PropBuyController propBuyController;
	@Test
	public void test() throws Exception {
		PropBuyForm form = new PropBuyForm();
	    
	    form.setUserId(375);
	    form.setPropId(3);

	    out.println(JsonConverter.objectToJson(form));
	    
	    // a json string
		String output = standaloneSetup(propBuyController)
				.build()
				.perform(
						post("/prop/propBuy").body(JsonConverter.objectToJson(form).getBytes("UTF-8"))
								.contentType(MediaType.APPLICATION_JSON)
								.accept(MediaType.APPLICATION_JSON)
//								.headers(ClientHelper.getHeaders())
				)
				.andReturn().getResponse().getContentAsString();
		
		out.println(output);
	}
	
	@Test
	public void test1() throws Exception {
		// a json string
		String output = standaloneSetup(propBuyController)
				.build()
				.perform(
						get("/prop/queryPropList?userId=111").accept(
								MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn().getResponse()
				.getContentAsString();
		
		out.println(output);
	}
	
	@Test
	public void test2() throws Exception {
		// a json string
		String output = standaloneSetup(propBuyController)
				.build()
				.perform(
						get("/prop/buyGem?productId=1gem&userId=375").accept(
								MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn().getResponse()
				.getContentAsString();
		
		out.println(output);
	}
	
	@Test
	public void testBuyWeapon() throws Exception {
		BuyWeaponForm form = new BuyWeaponForm();
	    
	    form.setUserId(378);
	    form.setGashaId(1);
	    form.setBuyType("G");
	    
	    out.println(JsonConverter.objectToJson(form));
	    
	    // a json string
		String output = standaloneSetup(propBuyController)
				.build()
				.perform(
						post("/prop/weaponBuy").body(JsonConverter.objectToJson(form).getBytes("UTF-8"))
								.contentType(MediaType.APPLICATION_JSON)
								.accept(MediaType.APPLICATION_JSON)
//								.headers(ClientHelper.getHeaders())
				)
				.andReturn().getResponse().getContentAsString();
		
		out.println(output);
	}
}
