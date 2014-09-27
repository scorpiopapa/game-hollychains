package com.bt.chains.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.bt.chains.bean.domain.User;
import com.bt.chains.mapper.UserMapper;
import com.joinway.appx.service.AuditService;
import com.joinway.web.audit.AuditContext;

public class HollyChainsAuditService extends AuditService {

	private final static Logger log = LoggerFactory.getLogger(HollyChainsAuditService.class);
	
	@Autowired UserMapper mapper;
	
	@Override
	protected String getLoginName(AuditContext context) {
		String uid = context.getUserId();
		
		int userId = 0;
		String loginName = null;
		
		try{
			userId = Integer.valueOf(uid);
			User user = mapper.selectUser(userId);
			if(user != null){
				loginName = user.getMarketId();
			}
		}catch(Exception e){
			log.warn("find user id failed", e.getMessage());
		}
		
		return loginName;
	}

	
}
