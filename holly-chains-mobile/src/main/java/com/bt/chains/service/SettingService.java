package com.bt.chains.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.bt.chains.bean.domain.Notice;
import com.bt.chains.bean.view.NoticeView;
import com.bt.chains.mapper.SettingMapper;

@Service
public class SettingService {
	private final static Logger log = LoggerFactory.getLogger(SettingService.class);
	
	@Autowired
	private SettingMapper settingMapper;
	
	@Transactional(rollbackFor=Exception.class)
	public NoticeView queryNotices(){
		List<Notice> notices = settingMapper.queryNotices();
		NoticeView noticeView = new NoticeView();
		
		if(!CollectionUtils.isEmpty(notices)){
			String texts = "";
			for(Notice notice : notices){
				texts = texts + notice.getNoticeContent() + "\\r";
			}
			
			noticeView.setCount(notices.size());
			noticeView.setNotices(texts);
		}
		return noticeView;
	}
}
