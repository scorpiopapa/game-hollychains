package com.joinway.admin.cobot;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.joinway.cobot.Cobot;

public class BeanClient extends BaseTest {

	private final static Logger log = LoggerFactory.getLogger(BeanClient.class);
	
	@Autowired Cobot cobot;
	
	@Test public void test() throws Exception{
		String ddlFile = "C:\\1.ddl";
		String outDir = "c:";
		
//		cobot.productDomainBean(ddlFile, null, outDir);
		
		log.info("out put file to " + outDir);
	}
}
