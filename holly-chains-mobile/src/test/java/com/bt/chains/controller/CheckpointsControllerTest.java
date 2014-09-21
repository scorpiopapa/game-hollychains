package com.bt.chains.controller;

import static java.lang.System.out;
import static org.springframework.test.web.server.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.server.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.server.setup.MockMvcBuilders.standaloneSetup;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import com.bt.chains.BaseTest;
import com.bt.chains.bean.domain.Param;
import com.bt.chains.bean.form.CheckpointsForm;
import com.bt.chains.bean.form.EnterCheckpointForm;
import com.bt.chains.bean.form.EnterCustomCheckpointForm;
import com.bt.chains.bean.form.EnterRandomCheckpointForm;
import com.bt.chains.bean.form.EnterUnLimitedCheckpointForm;
import com.joinway.utils.json.JsonConverter;

public class CheckpointsControllerTest extends BaseTest {
	@Autowired
	private CheckpointsController controller;

	@Ignore
	@Test
	public void test() throws Exception {
		// a json string
		String output = standaloneSetup(controller)
				.build()
				.perform(
						get(
								"/checkpoints/queryCheckpoints?sceneId=1401&sceneType=4")
								.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn().getResponse()
				.getContentAsString();
		out.println(output);
	}

	/**
	 * 测试大小关卡list
	 * 
	 * @throws Exception
	 */
	@Test
	public void testPlayStage1List() throws Exception {
		// a json string
		String output = standaloneSetup(controller)
				.build()
				.perform(
						get("/checkpoints/queryStage?userId=2").accept(
								MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn().getResponse()
				.getContentAsString();
		out.println(output);
	}
	/**
	 * 测试大小关卡list
	 * 
	 * @throws Exception
	 */
	@Test
	public void testfinishCheckpoint() throws Exception {
		CheckpointsForm cf = new CheckpointsForm();
		cf.setUserId(386);
		cf.setSceneId(1003);
		String output = standaloneSetup(controller)
				.build()
				.perform(
						post("/checkpoints/finishCheckpoint")
								.body(JsonConverter.objectToJson(
										cf).getBytes("UTF-8"))
								.contentType(MediaType.APPLICATION_JSON)
								.accept(MediaType.APPLICATION_JSON)
				// .headers(ClientHelper.getHeaders())
				).andReturn().getResponse().getContentAsString();

		out.println(output);
	}
	@Test
	public void testEnterCheckpoints() throws Exception {
		EnterCheckpointForm enterCheckpointForm = new EnterCheckpointForm();
//		enterCheckpointForm.setSceneId(1001);
//		enterCheckpointForm.setSceneType(1);
//		enterCheckpointForm.setUserId(1118);
//		enterCheckpointForm.setPower(10);
		enterCheckpointForm.setSceneId(1001);
		enterCheckpointForm.setSceneType(0);
		enterCheckpointForm.setUserId(404);
		enterCheckpointForm.setPower(1);
//		enterCheckpointForm.setSceneId(1101);
//		enterCheckpointForm.setSceneType(1);
//		enterCheckpointForm.setUserId(386);
//		enterCheckpointForm.setPower(5);
		out.println(JsonConverter.objectToJson(enterCheckpointForm));

		// a json string
		String output = standaloneSetup(controller)
				.build()
				.perform(
						post("/checkpoints/enterCheckpoint")
								.body(JsonConverter.objectToJson(
										enterCheckpointForm).getBytes("UTF-8"))
								.contentType(MediaType.APPLICATION_JSON)
								.accept(MediaType.APPLICATION_JSON)
				// .headers(ClientHelper.getHeaders())
				).andReturn().getResponse().getContentAsString();

		out.println(output);
	}
	@Ignore
	@Test
	public void testEnterCheckpoints1() throws Exception {
		EnterUnLimitedCheckpointForm form = new EnterUnLimitedCheckpointForm();
		form.setSceneId(1004);
		form.setUserId(371);
		form.setDeductionType("1");
		form.setType("R");

		out.println(JsonConverter.objectToJson(form));

		// a json string
		String output = standaloneSetup(controller)
				.build()
				.perform(
						post("/checkpoints/enterUnLimitedCheckpoint")
								.body(JsonConverter.objectToJson(form).getBytes(
										"UTF-8"))
								.contentType(MediaType.APPLICATION_JSON)
								.accept(MediaType.APPLICATION_JSON)
				// .headers(ClientHelper.getHeaders())
				).andReturn().getResponse().getContentAsString();

		out.println(output);
	}
	
	@Test
	public void testRanking() throws Exception {
		// a json string
		String output = standaloneSetup(controller)
				.build()
				.perform(
						get(
								"/checkpoints/queryRanking?type=C&mode=1&userId=386&page=2")
								.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn().getResponse()
				.getContentAsString();
		out.println(output);
	}
	
	@Test
	public void enterRandomCheckpoint() throws Exception {
		EnterRandomCheckpointForm form = new EnterRandomCheckpointForm();
		
		form.setUserId(404);
		form.setPayType("0");
		form.setRoleId(1);
		List<Param> list = new ArrayList<Param>();
		Param param = new Param();
		param.setId(3022);
		Param param1 = new Param();
		param1.setId(3001);
		list.add(param);
		list.add(param1);
		form.setWeaponIds(list);
		out.println(JsonConverter.objectToJson(form));

		// a json string
		String output = standaloneSetup(controller)
				.build()
				.perform(
						post("/checkpoints/enterRandomCheckpoint")
								.body(JsonConverter.objectToJson(
										form).getBytes("UTF-8"))
								.contentType(MediaType.APPLICATION_JSON)
								.accept(MediaType.APPLICATION_JSON)
				// .headers(ClientHelper.getHeaders())
				).andReturn().getResponse().getContentAsString();

		out.println(output);
	}
	
	@Test
	public void enterCustomCheckpoint() throws Exception {
		EnterCustomCheckpointForm form = new EnterCustomCheckpointForm();
		
		form.setUserId(404);
		form.setPayType("0");
		
		out.println(JsonConverter.objectToJson(form));

		// a json string
		String output = standaloneSetup(controller)
				.build()
				.perform(
						post("/checkpoints/enterCustomCheckpoint")
								.body(JsonConverter.objectToJson(
										form).getBytes("UTF-8"))
								.contentType(MediaType.APPLICATION_JSON)
								.accept(MediaType.APPLICATION_JSON)
				// .headers(ClientHelper.getHeaders())
				).andReturn().getResponse().getContentAsString();

		out.println(output);
	}
}
