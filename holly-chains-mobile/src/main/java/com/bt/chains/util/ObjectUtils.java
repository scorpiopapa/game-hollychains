package com.bt.chains.util;

import java.util.ArrayList;
import java.util.List;

import com.bt.chains.bean.domain.LastItem;
import com.bt.chains.bean.domain.UserMagic;
import com.bt.chains.bean.domain.UserWeapon;
import com.bt.chains.bean.view.Item;

public final class ObjectUtils {

	public static int getSize(List<?> list){
		return list == null ? 0 : list.size();
	}
	
	public static List<Item> convertUserMagic(List<UserMagic> magics){
		List<Item> items = new ArrayList<Item>();
		
		for(UserMagic m : magics){
			Item item = new Item();
			item.setId(m.getMagicId());
			item.setRank(m.getMagicRank());
			
			items.add(item);
		}
		
		return items;
	}
	
	public static List<Item> convertUserWeapon(List<UserWeapon> weapons){
		List<Item> items = new ArrayList<Item>();
		
		for(UserWeapon w : weapons){
			Item item = new Item();
			item.setId(w.getwId());
			item.setRank(w.getWeaponRank());
			
			items.add(item);
		}
		
		return items;
	}
	
	
	public static List<LastItem> convertUserMagicNew(List<UserMagic> magics){
		List<LastItem> items = new ArrayList<LastItem>();
		
		for(UserMagic m : magics){
			LastItem item = new LastItem();
			item.setKeyId(m.getId());
			item.setId(m.getMagicId());
			item.setRank(m.getMagicRank());
			
			items.add(item);
		}
		
		return items;
	}
	
	public static List<LastItem> convertUserWeaponNew(List<UserWeapon> weapons){
		List<LastItem> items = new ArrayList<LastItem>();
		
		for(UserWeapon w : weapons){
			LastItem item = new LastItem();
			item.setKeyId(w.getId());
			item.setId(w.getwId());
			item.setRank(w.getWeaponRank());
			
			items.add(item);
		}
		
		return items;
	}
	
	private ObjectUtils(){}
}
