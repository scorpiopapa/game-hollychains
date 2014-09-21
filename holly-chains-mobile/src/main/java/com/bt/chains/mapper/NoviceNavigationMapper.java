package com.bt.chains.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.bt.chains.bean.domain.NoviceNavigation;

@Repository
public interface NoviceNavigationMapper {
	/**
	 * 查询导航信息
	 * @param userId
	 * @return list
	 */
	public List<NoviceNavigation> queryNoviceNavigations(@Param("userId") int userId);
	/**
	 * 查询当前导航信息
	 * @param userId
	 * @return NoviceNavigation
	 */
	public NoviceNavigation queryCurNoviceNavigation(@Param("userId") int userId);
	/**
	 * 插入导航信息
	 * @param userId
	 * @param type
	 */
	public void insertNavigation(@Param("userId") int userId, @Param("navigationId") int navigationId);
}
