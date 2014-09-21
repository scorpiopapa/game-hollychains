package com.bt.chains.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.bt.chains.bean.domain.RoleBaseData;
import com.bt.chains.bean.domain.RoleConfig;
import com.bt.chains.bean.domain.RoleUpgradeConfig;
import com.bt.chains.bean.domain.UserRole;

@Repository
public interface RoleMapper {
	/**
	 * 插入用户职业
	 * @param userRole
	 * @return
	 */
	public int insertUserRole(UserRole userRole);
	
	/**
	 * 更新职业级别
	 * @param userRole
	 * @return
	 */
	public int updateUserRole(UserRole userRole);
	
	void resetUserRoleInUseStatus(@Param("userId") int userId, @Param("status") int status);
	
	/**
	 * 查询用户级别
	 */
	public UserRole queryRole(@Param("userId") int userId, @Param("roleId") Integer roleId, @Param("inUse") Integer inUse);
	
	public List<UserRole> queryAllRole(@Param("userId") int userId);
	
	/**
	 * 查询职业升级配置
	 * @param roleId
	 * @param rank
	 */
	public RoleUpgradeConfig selectRoleUpgradeConfig(@Param("roleId") int roleId, @Param("rank") int rank);
	/**
	 * 查询职业的基础数据
	 * @return
	 */
	public RoleBaseData selectRoleBaseData(@Param("roleId") int roleId, @Param("roleRank") int roleRank);
}
