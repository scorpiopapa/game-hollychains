package com.bt.chains.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.bt.chains.bean.domain.MagicUpgradeConfig;
import com.bt.chains.bean.domain.User;
import com.bt.chains.bean.domain.UserMagic;

@Repository
public interface MagicMapper {
	/**
	 * 插入用户新武器
	 * @param UserMagic
	 * @return
	 */
	public int insertUserMagic(UserMagic userMagic);
	/**
	 * 删除用户魔法
	 * @param User
	 * @return
	 */
	public void deleteMagic(User user);
	/**
	 * 更新用户金币
	 * @param userId
	 * @param gold
	 * @return
	 */
	public void updateUserGold(User user);
	
	/**
	 * 更新用户魔法级别
	 * @param userMagic
	 * @return
	 */
	public int updateUserMagic(UserMagic userMagic);
	/**
	 * 查询魔法
	 * @param userMagic
	 * @return
	 */
	public List<UserMagic> queryeMagic(@Param("userId") int userId, @Param("magicId") Integer magicId, @Param("inUse") Integer inUse);
	
	public List<UserMagic> queryAllMagic(@Param("userId") int userId);
	
	public MagicUpgradeConfig selectMagicUpgradeConfig(@Param("rank") int rank);
	
	void resetUserMagicInUseStatus(@Param("status") int status);
}
