package com.bt.chains.mapper;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bt.chains.BaseTest;

public class GashaMapperTest extends BaseTest {
	@Autowired
	private GashaMapper mapper;
	@Test
	public void testSelectConfig(){
		mapper.getWeaponPurchase(2);
	}
}
