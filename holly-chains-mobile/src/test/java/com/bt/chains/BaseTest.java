package com.bt.chains;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mock.jndi.SimpleNamingContextBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-context-test.xml" })
public abstract class BaseTest extends AbstractTransactionalJUnit4SpringContextTests {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		SimpleNamingContextBuilder builder = SimpleNamingContextBuilder.emptyActivatedContextBuilder();
		
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		setupAmazon(ds);
//		setMyPC(ds);
		builder.bind("jdbc/holychains", ds);
	}
	
	private static void setLocal(DriverManagerDataSource ds){
		ds.setUrl("jdbc:mysql://192.168.1.103:3306/speed");
		ds.setUsername("speed");
		ds.setPassword("test123");
	}
	
	private static void setMyPC(DriverManagerDataSource ds){
		ds.setUrl("jdbc:mysql://192.168.1.110:3306/speed");
		ds.setUsername("speed");
		ds.setPassword("test123");
	}

	private static void setupAmazon(DriverManagerDataSource ds){
		ds.setUrl("jdbc:mysql://speed.cqv9bfjneaic.ap-northeast-1.rds.amazonaws.com:3306/holychains");
		ds.setUsername("awsuser");
		ds.setPassword("mypassword");
	}
}
