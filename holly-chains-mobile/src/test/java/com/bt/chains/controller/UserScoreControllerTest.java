package com.bt.chains.controller;

import static java.lang.System.out;
import static org.springframework.test.web.server.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.server.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import com.bt.chains.BaseTest;
import com.bt.chains.bean.form.UserScoreForm;
import com.joinway.utils.json.JsonConverter;

public class UserScoreControllerTest extends BaseTest{
	@Autowired
	private UserScoreController controller;
	
	@Test
	public void test() throws Exception {
		UserScoreForm form = new UserScoreForm();
		form.setUserId(404);
		form.setMoney(100);
		form.setScore(1000);
		form.setType("R");
//		form.setUserName("111");
	   
	    
	    out.println(JsonConverter.objectToJson(form));
	    
	    // a json string
		String output = standaloneSetup(controller)
				.build()
				.perform(
						post("/score/saveUserScore").body(JsonConverter.objectToJson(form).getBytes("UTF-8"))
								.contentType(MediaType.APPLICATION_JSON)
								.accept(MediaType.APPLICATION_JSON)
//								.headers(ClientHelper.getHeaders())
				)
				.andReturn().getResponse().getContentAsString();
		
		out.println(output);
	}
}
