package com.joinway.admin.cobot;

import java.net.InetAddress;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mock.jndi.SimpleNamingContextBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/app-context-test.xml" })
public abstract class BaseTest extends AbstractTransactionalJUnit4SpringContextTests {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		SimpleNamingContextBuilder builder = SimpleNamingContextBuilder.emptyActivatedContextBuilder();
		
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		setupDataSource(ds);
		builder.bind("jdbc/dataSource", ds);
	}
	
	private static void setupDataSource(DriverManagerDataSource ds) throws Exception {
		String ip = "115.28.198.131";
//		String ip = "192.168.1.108";
		String localIP = InetAddress.getLocalHost().getHostAddress();
		if("10.169.151.223".equals(localIP)){
			ip = "localhost";
		}
		
		ds.setUrl("jdbc:mysql://" + ip + ":3306/framework?autoReconnect=true&amp;useUnicode=true&amp;characterEncoding=utf-8");
		ds.setUsername("appuser");
		ds.setPassword("apppwd");
	}
}

