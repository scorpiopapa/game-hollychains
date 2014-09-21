package com.bt.chains.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GameMapper {
	public String selectConfig(@Param("key") String key);
}
