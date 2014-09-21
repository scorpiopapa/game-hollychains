package com.bt.chains.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.bt.chains.bean.domain.User;
import com.bt.chains.bean.domain.UserWeapon;
import com.bt.chains.bean.domain.Weapon;
import com.bt.chains.bean.view.WeaponConfigView;

@Repository
public interface WeaponMapper {
	/**
	 * 删除武器
	 * @param weaponIds
	 * @return
	 */
	public int deleteWeapon(User user);
	/**
	 * 更新用户武器级别
	 * @param weaponId
	 * @param level
	 * @return
	 */
	public int updateUserWeapon(UserWeapon userWeapon);
	/**
	 * 更新用户金币
	 * @param userId
	 * @param gold
	 * @return
	 */
	public int updateUserGold(User user);
	/**
	 * 更新用户背包中的武器
	 * @param weaponImportIds
	 * @return
	 */
	public int updateUserBagWeapon(User user);
	/**
	 * 插入用户新武器
	 * @param userWeapon
	 * @return
	 */
	public int insertUserWeapon(UserWeapon userWeapon);
	/**
	 * 查询用户武器信息
	 * @param id
	 * @return
	 */
	public List<UserWeapon> queryWeapon(@Param("id") Integer id, @Param("userId") Integer userId, @Param("inUse") Integer inUse);
	
	void resetUserWeaponInUseStatus(@Param("status") int status, @Param("userId") int userId);
	/**
	 * 根据武器ID查询武器WID
	 * @param weaponIds
	 * @return
	 */
	public List<com.bt.chains.bean.domain.Param> queryWeaponWIDs(@Param("weaponIds") List<WeaponConfigView> weaponIds);
	/**
	 * 根据武器ID查询武器WID
	 * @param weaponId
	 * @return
	 */
	public int queryWeaponWID(@Param("weaponId") int weaponId);
	/**
	 * 查询贩卖总金额
	 * @param wids
	 * @return
	 */
	public int selectSellTotal(@Param("wids") List<Integer> wids);
	/**
	 * 查询用户武器个数
	 * @param userId
	 * @param weaponId
	 * @return
	 */
	public int queryWeaponCount(@Param("userId") int userId, @Param("weaponId") int weaponId);
	/**
	 * 查询武器基础数据
	 * @param weaponIds
	 * @param weaponId
	 * @return
	 */
	public List<Weapon> queryWeaponBaseData(@Param("weaponIds") Integer[] weaponIds, @Param("weaponId") Integer weaponId, @Param("wid") Integer wid);
	/**
	 * 武器贩卖根据id查询武器wid
	 * @param userId
	 * @param ids
	 * @return
	 */
	public List<com.bt.chains.bean.domain.Param> queryUserWeaponWids(@Param("userId") int userId, @Param("ids") List<Integer> ids);
	/**
	 * 查询武器贩卖价格
	 * @param weaponId
	 * @return
	 */
	public int selectWeaponSellPrice(@Param("weaponId") Integer weaponId, @Param("wid") Integer wid);
}
