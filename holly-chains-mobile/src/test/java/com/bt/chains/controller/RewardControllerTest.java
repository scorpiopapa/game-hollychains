package com.bt.chains.controller;

import static java.lang.System.out;
import static org.springframework.test.web.server.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.server.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import com.bt.chains.BaseTest;


public class RewardControllerTest extends BaseTest {
	@Autowired
	private RewardController controller;
	
	@Test
	public void test() throws Exception {
	    // a json string
		String output = standaloneSetup(controller)
				.build()
				.perform(
						get("/reward/getAchivementList?userId=2")
								.accept(MediaType.APPLICATION_JSON)
				)
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		out.println(output);
	}
	
	@Test
	public void testClickToObtainAchivement() throws Exception {
	    // a json string
		String output = standaloneSetup(controller)
				.build()
				.perform(
						get("/reward/clickToObtainAchivement?archivementId=2")
								.accept(MediaType.APPLICATION_JSON)
				)
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		out.println(output);
	}
	
	@Test
	public void insertCheckPointAchivementTest() throws Exception {
	    // a json string
		String output = standaloneSetup(controller)
				.build()
				.perform(
						get("/reward/insertCheckPointAchivement?checkPointId=4039&userId=2")
								.accept(MediaType.APPLICATION_JSON)
				)
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		out.println(output);
	}
	
	@Test
	public void insertChallengeAchivementTest() throws Exception {
	    // a json string
		String output = standaloneSetup(controller)
				.build()
				.perform(
						get("/reward/insertChallengeAchivement?compCount=3&userId=2")
								.accept(MediaType.APPLICATION_JSON)
				)
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		out.println(output);
	}
}
