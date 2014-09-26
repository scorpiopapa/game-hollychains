package com.bt.chains.controller;

import javax.validation.constraints.Min;

import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiError;
import org.jsondoc.core.annotation.ApiErrors;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiParam;
import org.jsondoc.core.annotation.ApiResponseObject;
import org.jsondoc.core.pojo.ApiParamType;
import org.jsondoc.core.pojo.ApiVerb;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bt.chains.bean.view.NoviceNavigationInfosView;
import com.bt.chains.bean.view.NoviceNavigationView;
import com.bt.chains.constant.ErrorCodeConstants;
import com.bt.chains.exception.RequestException;
import com.bt.chains.service.NoviceNavigationService;
import com.joinway.bean.logging.annotation.InputLog;
import com.joinway.bean.logging.annotation.OutputLog;
import com.joinway.web.audit.ExceptionController;
import com.joinway.web.audit.annotation.Audit;
import com.joinway.web.security.annotation.SingleSignOn;

@Api(name = "NoviceNavigation API", description = "获取当前导航信息")
@Controller
@RequestMapping("navigation")
@Validated
@SingleSignOn
public class NoviceNavigationController extends ExceptionController {
	private final static Logger log = LoggerFactory.getLogger(NoviceNavigationController.class);
	
	@Autowired
	private NoviceNavigationService noviceNavigationService;
	
	@ApiMethod(path = "navigation/queryNextNavigation?userId={userId}&navigationId={navigationId}", verb = ApiVerb.GET, 
			description = "查询下一步导航信息，0:只查询下一步导航ID；其他:插入当前导航信息，返回下一步导航ID", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponseObject
	@RequestMapping(value = "queryNextNavigation", method = RequestMethod.GET, produces = "application/json")
	@ApiErrors(apierrors = {
			@ApiError(code = ErrorCodeConstants.NAVIGATION_EQUAL, description = ErrorCodeConstants.NAVIGATION_EQUAL_MSG)})
	@ResponseBody
	@Audit
	@InputLog
	@OutputLog
	public NoviceNavigationView queryNextNavigation (
			@ApiParam(name = "userId", description = "用户ID", paramType = ApiParamType.QUERY) @RequestParam(value = "userId") @Min(1) int userId,
			@ApiParam(name = "navigationId", description = "导航ID", paramType = ApiParamType.QUERY) @RequestParam(value = "navigationId") @Min(0) int navigationId) 
					throws RequestException{
		return noviceNavigationService.queryNextNavigation(userId, navigationId);
	}
}
