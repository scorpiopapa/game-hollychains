package com.bt.chains.mapper;

import static java.lang.System.out;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bt.chains.BaseTest;
import com.bt.chains.constant.DBConstants.Achievement;

@Ignore
public class GameMapperTest extends BaseTest {
	
/*	@Autowired
	private GameMapper mapper;
	
	@Test
	public void testSelectConfig(){
		mapper.selectConfig("");
	}
	
//	@Test
//	public void testSelectShopItem1(){
//		mapper.selectShopItem(1, null);
//	}
//	
//	@Test
//	public void testSelectShopItem2(){
//		mapper.selectShopItem(1, "");
//	}
//	
//	@Test
//	public void testSelectShopItem3(){
//		mapper.selectShopItem(1, "B");
//	}

	@Test
	public void testSelectShopItems1(){
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put(SqlParamKeyConstants.SELL_TYPE, null);
//		map.put(SqlParamKeyConstants.CATS, new String[]{"1", "2"});
//		List<ShopItem> items = mapper.selectShopItems(map);
		List<ShopItem> items = mapper.selectShopItems(new String[]{"1", "2"});
		out.println(items);
	}

//	@Test
//	public void testSelectShopItems2(){
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put(SqlParamKeyConstants.SELL_TYPE, "");
//		map.put(SqlParamKeyConstants.CATS, new String[]{"1", "2"});
//		List<ShopItem> items = mapper.selectShopItems(map);
//		out.println(items);
//	}
//
//	@Test
//	public void testSelectShopItems3(){
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put(SqlParamKeyConstants.SELL_TYPE, "B");
//		map.put(SqlParamKeyConstants.CATS, new String[]{"1", "2"});
//		List<ShopItem> items = mapper.selectShopItems(map);
//		out.println(items);
//	}

	@Test
	public void testSelectAchievement(){
		Achievement achievement = mapper.selectAchievement(1);
		out.println(achievement);
	}
	
//	@Test
//	public void testSelectUpgradeItems(){
//		List<UpgradeItem> items = mapper.selectUpgradeItems();
//		out.println(items);
//	}
*/}
