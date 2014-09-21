package com.bt.chains.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bt.chains.bean.domain.Notice;

@Repository
public interface SettingMapper {
	/**
	 * 查询通知信息
	 * @return
	 */
	public List<Notice> queryNotices();
}
