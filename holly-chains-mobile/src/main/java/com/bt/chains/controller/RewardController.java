package com.bt.chains.controller;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Length;
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

import com.bt.chains.bean.view.ClickToObtainAchivementView;
import com.bt.chains.bean.view.RewardListView;
import com.bt.chains.constant.ErrorCodeConstants;
import com.bt.chains.exception.RequestException;
import com.bt.chains.service.RewardService;
import com.joinway.bean.logging.annotation.InputLog;
import com.joinway.bean.logging.annotation.OutputLog;
import com.joinway.web.audit.ExceptionController;
import com.joinway.web.audit.annotation.Audit;
import com.joinway.web.security.annotation.SingleSignOn;

@Api(name = "Reward API", description = "奖励操作")
@Controller
@RequestMapping("reward")
@Validated
@SingleSignOn
public class RewardController extends ExceptionController {
	private final static Logger log = LoggerFactory.getLogger(RewardController.class);
	
	@Autowired
	private RewardService rewardService;
	
	@ApiMethod(path="reward/getAchivementList?userId={userId}", verb=ApiVerb.GET, description="显示成就列表", produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiResponseObject
	@RequestMapping(value = "getAchivementList", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	@Audit
	@InputLog
	@OutputLog
	public RewardListView getAchivementList(@ApiParam(name="userId", description="用户ID", paramType = ApiParamType.QUERY) @Min(1) @RequestParam(value="userId") int userId){
		return rewardService.getAchivementList(userId);
	}
	
	@ApiMethod(path="reward/clickToObtainAchivement?archivementId={archivementId}&userId={userId}", verb=ApiVerb.GET, description="获取成就", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ApiResponseObject
	@ApiErrors(apierrors={
			@ApiError(code=ErrorCodeConstants.NOT_ENOUGH_STROE_ERROR, description=ErrorCodeConstants.NOT_ENOUGH_STROE_MSG)
	})
	@RequestMapping(value = "clickToObtainAchivement", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	@Audit
	@InputLog
	@OutputLog
	public ClickToObtainAchivementView clickToObtainAchivement(@ApiParam(name="archivementId", description="奖励ID", paramType = ApiParamType.QUERY) @Min(1) @RequestParam(value="archivementId") int archivementId,
			@ApiParam(name="userId", description="userId", paramType = ApiParamType.QUERY) @Min(1) @RequestParam(value="userId") int userId) throws RequestException{
		return rewardService.clickToObtainAchivement(archivementId, userId);
	}
	
	@ApiMethod(path="reward/getAchivementCounts?userId={userId}", verb=ApiVerb.GET, description="查询是否有成就", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ApiResponseObject
	@RequestMapping(value = "getAchivementCounts", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	@Audit
	@InputLog
	@OutputLog
	public int getAchivementCounts(@ApiParam(name="userId", description="用户ID", paramType = ApiParamType.QUERY) @Min(1) @RequestParam(value="userId") int userId){
		return rewardService.getAchivementCounts(userId);
	}
	
	@ApiMethod(path="reward/insertCheckPointAchivement?checkPointId={checkPointId}&userId={userId}", verb=ApiVerb.GET, description="插入关卡奖励", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ApiResponseObject
	@RequestMapping(value = "insertCheckPointAchivement", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	@Audit
	@InputLog
	@OutputLog
	public int insertCheckPointAchivement(@ApiParam(name="checkPointId", description="checkPointId", paramType = ApiParamType.QUERY) @Min(1) @RequestParam(value="checkPointId") int checkPointId,
			@ApiParam(name="userId", description="userId", paramType = ApiParamType.QUERY) @Min(1) @RequestParam(value="userId") int userId){
		return rewardService.insertCheckPointAchivement(checkPointId, userId);
	}
	
	@ApiMethod(path="reward/insertChallengeAchivement?compCount={compCount}&userId={userId}", verb=ApiVerb.GET, description="插入天梯奖励", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ApiResponseObject
	@RequestMapping(value = "insertChallengeAchivement", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	@Audit
	@InputLog
	@OutputLog
	public int insertChallengeAchivement(@ApiParam(name="compCount", description="compCount", paramType = ApiParamType.QUERY) @Min(0) @RequestParam(value="compCount") int compCount,
			@ApiParam(name="userId", description="userId", paramType = ApiParamType.QUERY) @Min(1) @RequestParam(value="userId") int userId){
		return rewardService.insertChallengeAchivement(compCount, userId);
	}
}
