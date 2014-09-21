package com.bt.chains.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.bt.chains.bean.domain.Weapon;
import com.bt.chains.mapper.UserMapper;

@Repository
public class WeaponRepository {

	@Autowired UserMapper userMapper;
	
	public int getWeaponOrderId(int weaponId){
		int wid = 0;
		
		List<Weapon> weapons = userMapper.selectAllWeapons(null);
		if(!CollectionUtils.isEmpty(weapons)){
			for(Weapon w : weapons){
				if(w.getWeaponId() == weaponId){
					wid = Integer.valueOf(w.getWid());
					break;
				}
			}
		}
		
		return wid;
	}
}
