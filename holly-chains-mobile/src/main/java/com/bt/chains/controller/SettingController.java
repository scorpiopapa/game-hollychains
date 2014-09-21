package com.bt.chains.controller;

import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiResponseObject;
import org.jsondoc.core.pojo.ApiVerb;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bt.chains.bean.view.NoticeView;
import com.bt.chains.service.SettingService;
import com.joinway.bean.logging.annotation.InputLog;
import com.joinway.bean.logging.annotation.OutputLog;
import com.joinway.web.audit.ExceptionController;
import com.joinway.web.audit.annotation.Audit;

@Api(name = "Setting API", description = "设置页面")
@Controller
@RequestMapping("setting")
@Validated
public class SettingController extends ExceptionController{
	private final static Logger log = LoggerFactory.getLogger(SettingController.class);
	
	@Autowired
	private SettingService settingService;
	
	@ApiMethod(path="setting/queryNotices", verb=ApiVerb.GET, description="查询通知信息，不需要传递参数", produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiResponseObject
	@RequestMapping(value = "queryNotices", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	@Audit
	@InputLog
	@OutputLog
	public NoticeView queryNotices(){
		return settingService.queryNotices();
	}
}
