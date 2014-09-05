package com.joinway.admin.cobot;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.joinway.admin.bean.domain.AdminRole;
import com.joinway.cobot.ui.bean.DataGridConfig;
import com.joinway.cobot.ui.service.DataGridCobot;


public class CobotClient extends BaseTest {
	
	@Autowired DataGridCobot cobot;
	
	@Test public void test1() throws Exception {
//		cobot.produceTableHtml(Weapon.class, "c:/weapon.html");
		DataGridConfig config = new DataGridConfig();
		config.setOutputFile("c:/" + AdminRole.class.newInstance().getTableName().toLowerCase());
		config.setDataFileType("csv");
		
		cobot.produceTableHtml(AdminRole.class, config);
		System.out.println("done!");
	}
}

