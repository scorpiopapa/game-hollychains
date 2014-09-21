package com.bt.chains.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bt.chains.bean.domain.NoviceNavigation;
import com.bt.chains.bean.view.NoviceNavigationInfosView;
import com.bt.chains.bean.view.NoviceNavigationView;
import com.bt.chains.constant.ErrorCodeConstants;
import com.bt.chains.exception.RequestException;
import com.bt.chains.mapper.NoviceNavigationMapper;

@Service
public class NoviceNavigationService {
	private final static Logger log = LoggerFactory.getLogger(NoviceNavigationService.class);
	
	@Autowired
	private NoviceNavigationMapper noviceNavigationMapper;
	
	public NoviceNavigationInfosView queryNavigations(int userId){
		NoviceNavigationInfosView noviceNavigationInfosView = new NoviceNavigationInfosView();
		List<NoviceNavigation> list = noviceNavigationMapper.queryNoviceNavigations(userId);
		noviceNavigationInfosView.setNoviceNavigation(list);
		return noviceNavigationInfosView;
	}
	
	public NoviceNavigationView queryNextNavigation(int userId, int navigationId) throws RequestException{
		NoviceNavigationView noviceNavigationView = new NoviceNavigationView();
		NoviceNavigation noviceNavigation = noviceNavigationMapper.queryCurNoviceNavigation(userId);
		//查询下一步操作的ID
		if(navigationId == 0){
			//如果没有数据说明没有进行新手导航操作，返回第一步导航
			if(noviceNavigation == null){
				noviceNavigationView.setNavigationId(1);
			}else{
				int curNavigationId = noviceNavigation.getNavigationId();
				if(curNavigationId < 8){
					noviceNavigationView.setNavigationId(curNavigationId + 1);
				}else{
					noviceNavigationView.setNavigationId(0);
				}
			}
		}else{
			if(noviceNavigation != null){
				if(noviceNavigation.getNavigationId() != navigationId){
					//插入当前操作
					noviceNavigationMapper.insertNavigation(userId, navigationId);
					if(navigationId < 8){
						noviceNavigationView.setNavigationId(navigationId + 1);
					}else{
						noviceNavigationView.setNavigationId(0);
					}
				}else{
					throw new RequestException(ErrorCodeConstants.NAVIGATION_EQUAL, ErrorCodeConstants.NAVIGATION_EQUAL_MSG);
				}
			}else{
				//插入当前操作
				noviceNavigationMapper.insertNavigation(userId, navigationId);
				noviceNavigationView.setNavigationId(navigationId + 1);
			}
		}
		return noviceNavigationView;
	}
}
