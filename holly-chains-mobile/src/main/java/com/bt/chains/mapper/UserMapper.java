package com.bt.chains.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.bt.chains.bean.domain.Magic;
import com.bt.chains.bean.domain.ProductConfig;
import com.bt.chains.bean.domain.Prop;
import com.bt.chains.bean.domain.PropBuyHis;
import com.bt.chains.bean.domain.Role;
import com.bt.chains.bean.domain.User;
import com.bt.chains.bean.domain.UserAchievementHistory;
import com.bt.chains.bean.domain.UserAuth;
import com.bt.chains.bean.domain.UserAuthMarket;
import com.bt.chains.bean.domain.UserLastRecord;
import com.bt.chains.bean.domain.UserMagic;
import com.bt.chains.bean.domain.UserMarket;
import com.bt.chains.bean.domain.UserProp;
import com.bt.chains.bean.domain.UserReward;
import com.bt.chains.bean.domain.UserRewardHis;
import com.bt.chains.bean.domain.UserRole;
import com.bt.chains.bean.domain.UserScore;
import com.bt.chains.bean.domain.UserWeapon;
import com.bt.chains.bean.domain.UserWeaponUpgradeParam;
import com.bt.chains.bean.domain.Weapon;
import com.bt.chains.bean.view.MainView;

@Repository
public interface UserMapper {
	/**
	 * 查询用户
	 * @param id
	 * @return
	 */
	public User selectUser(@Param("id") int id);
	/**
	 * 从市场获取用户
	 * @param marketId
	 * @return
	 */
	public User selectUserByMarket(@Param("marketId") String marketId);
	
	/**
	 * 更新用户
	 * @param user
	 * @return int
	 */
	public int updateUser(User user);
	/**
	 * 插入用户
	 * @param user
	 * @return int
	 */
	public int insertUser(User user);
	/**
	 * 查询登录用户
	 * @param userId
	 * @return
	 */
	public User selectLoginUser(@Param("userId") int userId, @Param("status") String status);
	/**
	 * 插入用户奖励
	 * @param status
	 * @return
	 */
	public int insertUserReward(UserReward status);
	/**
	 * 设置用户默认职业
	 * @return
	 */
	public int insertUserRole(UserRole userRole);
	/**
	 * 返回用户职业
	 * @param userId
	 * @return
	 */
	public List<UserRole> selectJobs(@Param("userId") Integer userId);
	/**
	 * 返回用户武器
	 * @param userId
	 * @return
	 */
	public List<UserWeapon> selectWeapons(@Param("userId") Integer userId, @Param("id") Integer id);
	
	/**
	 * 返回用户所有职业
	 * @param userId
	 * @return
	 */
	public List<Role> selectAllJobs();
	/**
	 * 返回用户所有武器
	 * @param userId
	 * @return
	 */
	public List<Weapon> selectAllWeapons(@Param("weaponRare") Integer weaponRare);
	
	/**
	 * 返回所有魔法
	 * @param userId
	 * @return
	 */
	public List<Magic> selectAllMagics();
	
	/**
	 * 返回用户魔法
	 * @param userId
	 * @return
	 */
	public List<UserMagic> selectMagics(@Param("userId") int userId);
	
	/**
	 * 返回用户最后一次使用职业
	 * @param userId
	 * @return
	 */
//	@Deprecated public UserRole selectLastUseRole(@Param("userId") int userId);
	/**
	 * 返回用户最后一次使用武器
	 * @param userId
	 * @return
	 */
//	public List<UserWeapon> selectLastUseWeapons(@Param("userId") int userId);
	/**
	 * 返回用户最后一次使用魔法
	 * @param userId
	 * @return
	 */
//	public List<UserMagic> selectLastUseMagics(@Param("userId") int userId);
	/**
	 * 删除用户信息
	 * @param userId
	 * @return
	 */
//	public void deteleUserRecord(@Param("userId") int userId, @Param("type") Integer type);
	/**
	 * 保存用户最后信息
	 * @param userId
	 * @return
	 */
	public void insertUserLastRecords(UserLastRecord userLastRecords);
	/**
	 * 更改用户金币
	 * @param user
	 * @return
	 */
	public int updateUserMoney(User user);
	/**
	 * 更改用户宝石
	 * @param user
	 * @return
	 */
	public int updateUserSpecialMoney(User user);
	/**
	 * 获得用户成就
	 * @param user
	 * @return
	 */
	public List<UserAchievementHistory> selectUserAchievementHistory(@Param("userId") int userId
			, @Param("type") Integer type, @Param("status") String status, @Param("today") Integer today, @Param("rewardId") Integer rewardId);

	/**
	 * 插入用户成就
	 * @param user
	 * @return
	 */
	public void insertUserAchievementHistory(UserAchievementHistory userAchievementHistory);
	/**
	 * 更新用户成就
	 * @param user
	 * @return
	 */
	public void updateUserAchievementHistory(
			UserAchievementHistory userAchievementHistory);
	
	/**
	 * 插入用户成就（有关money）
	 * @param user
	 * @return
	 */
	public void inserUserRewardHis(UserRewardHis rhis);
	/**
	 * 获取当前用户奖励
	 */
	public int queryUserPropCount(UserProp userProp);
	/**
	 * 插入用户道具
	 * @param userProp
	 * @return
	 */
	public int insertUserProp(UserProp userProp);
	
	/**
	 * 更新用户道具
	 * @param userProp
	 * @return
	 */
	public int updateUserProp(UserProp userProp);
	
	/**
	 * 更新用户道具
	 * @param userProp
	 * @return
	 */
	public int updateUProp(UserProp userProp);
	
	/**
	 * 查询用户所有道具信息
	 */
	public List<UserProp> queryUserProps(int userId);
	
	/**
	 * 查询用户指定的道具信息
	 */
	public UserProp queryUserProp(@Param("userId") int userId, @Param("propId") int propId);
	/**
	 * 插入用户购买历史
	 * @param propBuyHis
	 * @return
	 */
	public int insertPropBuyHis(PropBuyHis propBuyHis);
	/**
	 * 查询用户购买道具历史信息
	 * @return
	 */
	public List<PropBuyHis> queryPropBuyHis(int userId);
	/**
	 * 查询用户信息
	 * @param userId
	 * @return
	 */
	public User queryUserByUserId(int userId);
	
	/**
	 * 体力消耗
	 */
	public int depletePower(User user);
	
	/**
	 * 体力增加
	 */
	public int addPower(User user);
	/**
	 * 查询用户最低积分
	 * @param userId
	 * @param type
	 * @return
	 */
	public UserScore queryUserMinScore(@Param("userId") int userId, @Param("type") String type);
	/**
	 * 查询用户所有积分
	 * @param userId
	 * @param type
	 * @return
	 */
	public List<UserScore> queryUserScore(@Param("userId") Integer userId, @Param("type") String type);
	/**
	 * 查询全服用户所有积分
	 * @param userId
	 * @param type
	 * @return
	 */
	public List<UserScore> queryAllUserScore(@Param("type") String type, @Param("start") int start, @Param("end") int end);
	/**
	 * 查询用户积分数量
	 * @param userId
	 * @param type
	 * @return
	 */
	public int queryUserScoreCount(@Param("userId") int userId, @Param("type") String type);
	/**
	 * 保存用户积分
	 * @param userScore
	 * @return
	 */
	public int saveUserScore(UserScore userScore);
	/**
	 * 更新用户积分
	 * @param userScore
	 * @return
	 */
	public int updateUserScore(UserScore userScore);
	/**
	 * 查询当前模式所有玩家数量
	 * @param userId
	 * @param type
	 * @return
	 */
	public int queryAllUserCount(@Param("type") String type);
	/**
	 * 查询当前用户的名次
	 * @param userId
	 * @param type
	 * @return
	 */
	public int queryUserRankings(@Param("score") int score, @Param("type") String type);
	/**
	 * 添加用户银币
	 * @param user
	 * @return
	 */
	public int addUserMoney(User user);
	/**
	 * 增加用户道具数量
	 * @param userProp
	 * @return
	 */
	public int updateUserPropNum(UserProp userProp);
//	/**
//	 * 插入用户市场信息
//	 * @param userMarket
//	 * @return
//	 */
//	public int insertUserMarket(UserMarket userMarket);
	/**
	 * 查询用户未过期的切换码
	 * @return
	 */
	public UserAuth selectUserAuth(@Param("userId") int userId);
	/**
	 * 插入切换码
	 * @param userAuth
	 */
	public void insertUserAuth(UserAuth userAuth);
	/**
	 * 更新切换码
	 * @param userAuth
	 */
	public void updateUserAuth(UserAuth userAuth);
	
//	public void insertUserAuthMarket(UserAuthMarket userAuthMarket);
	/**
	 * 修改用户状态
	 * @param user
	 */
	public void  updateUserStatus(User user);
	/**
	 * 根据用户ID和用户道具类型查询道具信息
	 */
	public UserProp queryUserPropByType(@Param("userId") int userId, @Param("propType") int propType);
	/**
	 * 修改用户名称
	 * @param userId
	 * @param userName
	 */
	public void updateUserName(@Param("userId") int userId,@Param("userName") String userName);
	
	List<UserWeaponUpgradeParam> selectUserWeaponUpgradeParams();
	/**
	 * 查询用户道具数量
	 * @param userId
	 * @param propType
	 * @return int
	 */
	public int queryUserPropNum(@Param("userId") int userId,@Param("propType") String propType);
	
	/**
	 * 跟具类型查询ID最小的道具信息
	 * @param propType
	 * @return Prop
	 */
	public Prop selectProp(@Param("propType") String propType);
	/**
	 * 查询当前道具下一级别道具
	 * @param propType
	 * @return Prop
	 */
	public Prop selectNextProp(@Param("propId") int propId,@Param("propType") String propType);
	/**
	 * 根据ID查询道具信息
	 * @param propId
	 * @return
	 */
	public Prop selectPropById(@Param("propId") int propId);
	/**
	 * 根据productId查询宝石配置信息
	 * @param productId
	 * @return
	 */
	public ProductConfig selectGem(@Param("productId") String productId);
	/**
	 * 增加用户宝石数量
	 * @param userId
	 * @param specialMoney
	 */
	public void updateAddGem(@Param("userId") int userId, @Param("specialMoney") int specialMoney);
	/**
	 * 查询仓库数量
	 * @param userId
	 * @param bagStatus
	 * @return
	 */
	public int selectStoreCount(@Param("userId") int userId, @Param("bagStatus") int bagStatus);
	/**
	 * 查询正在使用的武器
	 * @param userId
	 * @param inUse
	 * @return
	 */
	public List<UserWeapon> selectInUseWeapon(@Param("userId") int userId, @Param("inUse") int inUse);
	
	public int selectUserScoreCount(@Param("type") String type);
	
	public void updateBindUserStatus(@Param("id") int id);
}
