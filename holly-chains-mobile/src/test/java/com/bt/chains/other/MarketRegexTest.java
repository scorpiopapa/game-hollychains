package com.bt.chains.other;

import java.util.regex.Pattern;

import org.junit.Assert;
import org.junit.Test;

import com.bt.chains.constant.RegexConstants;

public class MarketRegexTest {

	private Pattern pattern = Pattern.compile(RegexConstants.MARKET);
	
	@Test
	public void test1(){
		Assert.assertEquals(true, pattern.matcher("A").matches());
	}
	
	@Test
	public void test2(){
		Assert.assertEquals(true, pattern.matcher("G").matches());
	}

	@Test
	public void test3(){
		Assert.assertEquals(false, pattern.matcher("a").matches());
	}

	@Test
	public void test4(){
		Assert.assertEquals(false, pattern.matcher("g").matches());
	}

	@Test
	public void test5(){
		Assert.assertEquals(false, pattern.matcher(" A").matches());
	}

	@Test
	public void test6(){
		Assert.assertEquals(false, pattern.matcher("A ").matches());
	}

	@Test
	public void test7(){
		Assert.assertEquals(false, pattern.matcher("G ").matches());
	}

	@Test
	public void test8(){
		Assert.assertEquals(false, pattern.matcher(" G").matches());
	}

	@Test
	public void test9(){
		Assert.assertEquals(false, pattern.matcher("").matches());
	}
	
	@Test public void test(){
		System.out.println(101 / 10);
	}

}
