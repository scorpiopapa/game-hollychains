package com.bt.chains.controller;

import static java.lang.System.out;
import static org.springframework.test.web.server.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.server.setup.MockMvcBuilders.standaloneSetup;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import com.bt.chains.BaseTest;

public class SettingControllerTest extends BaseTest {
	@Autowired
	SettingController controller;
	@Test
	public void test() throws Exception {
		String output = standaloneSetup(controller)
				.build()
				.perform(
						get("/setting/queryNotices")
								.accept(MediaType.APPLICATION_JSON)
				)
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		out.println(output);
	}
}
