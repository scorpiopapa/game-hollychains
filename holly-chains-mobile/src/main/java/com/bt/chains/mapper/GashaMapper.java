package com.bt.chains.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.bt.chains.bean.domain.ProductConfig;
import com.bt.chains.bean.domain.UserProp;
import com.bt.chains.bean.form.GashaForm;
import com.bt.chains.bean.view.ShopWeaponMenu;
import com.bt.chains.bean.view.WeaponConfigView;

@Repository
public interface GashaMapper {
	/**
	 * 查询是否有扭蛋券
	 * @param userId
	 * @return
	 */
	public UserProp selectGashaCounts(@Param("userId")int userId);
	
	/**
	 * 查询扭蛋先关武器信息
	 * @param 
	 * @return
	 */
	public List<WeaponConfigView> getWeaponConfig();
	
	/**
	 * 更新用户扭蛋券数量
	 * @param form
	 * @return
	 */
	public void updateWeaponNum(GashaForm form);
	
	/**
	 * 更新用户购买扭蛋个数
	 * @param form
	 * @return
	 */
	public void updateGashaNum(GashaForm form);
	
	/**
	 * 更新用户购买扭蛋个数
	 * @param form
	 * @return
	 */
	public void updateGashaAddNum(GashaForm form);
	
	/**
	 * 第一次添加购买扭蛋券
	 * @param form
	 * @return
	 */
	public void insertGasha(GashaForm form);
	
	/**
	 * 添加扭蛋历史信息
	 * @param form
	 * @return
	 */
	public void insertWeaponConfig(GashaForm form);
	
	/**
	 * 
	 * @param roleId
	 * @return
	 */
	public int getGaShaRoleConfig(@Param("roleId") int roleId);
	/**
	 * 购买武器的 条目列表 
	 * @param gashaid
	 */
	public List<ShopWeaponMenu> getWeaponPurchase(@Param("gashaId") Integer gashaId);

	List<ProductConfig> selectProductConfig();
	
}
