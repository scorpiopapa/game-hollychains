package com.bt.chains.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiBodyObject;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bt.chains.bean.form.CheckpointsForm;
import com.bt.chains.bean.form.EnterCheckpointForm;
import com.bt.chains.bean.form.EnterCustomCheckpointForm;
import com.bt.chains.bean.form.EnterRandomCheckpointForm;
import com.bt.chains.bean.form.EnterUnLimitedCheckpointForm;
import com.bt.chains.bean.view.CheckpointResultView;
import com.bt.chains.bean.view.CheckpointsView;
import com.bt.chains.bean.view.PlayStageListView;
import com.bt.chains.bean.view.RankingListView;
import com.bt.chains.constant.ErrorCodeConstants;
import com.bt.chains.exception.RequestException;
import com.bt.chains.service.CheckpointsService;
import com.joinway.bean.logging.annotation.InputLog;
import com.joinway.bean.logging.annotation.LogIgnore;
import com.joinway.bean.logging.annotation.OutputLog;
import com.joinway.web.audit.ExceptionController;
import com.joinway.web.audit.annotation.Audit;

@Api(name = "Checkpoints API", description = "获取关卡信息")
@Controller
@RequestMapping("checkpoints")
@Validated
public class CheckpointsController extends ExceptionController {
	private final static Logger log = LoggerFactory.getLogger(CheckpointsController.class);

	@Autowired
	private CheckpointsService service;

	@ApiMethod(path = "checkpoints/queryStage?userId={userId}", verb = ApiVerb.GET, description = "返回大小关卡列表信息", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponseObject
	@RequestMapping(value = "queryStage", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	@Audit
	@InputLog
	@OutputLog
	public PlayStageListView queryStage(
			@ApiParam(name = "userId", description = "用户ID", paramType = ApiParamType.QUERY) @RequestParam(value = "userId") @Min(1) int userId) {
		return service.queryStageInfo(userId);
	}

	@ApiMethod(path = "checkpoints/enterCheckpoint", verb = ApiVerb.POST, description = "进入关卡", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponseObject
	@ApiErrors(apierrors = { 
			@ApiError(code = ErrorCodeConstants.NOT_ENOUGH_POWER, description = ErrorCodeConstants.NOT_ENOUGH_POWER_MSG), 
			@ApiError(code = ErrorCodeConstants.ROLE_NO_EXISTS, description = ErrorCodeConstants.ROLE_NO_EXISTS_MSG)
		})
	@RequestMapping(value = "enterCheckpoint", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	@Audit
	@InputLog
	@OutputLog
	public CheckpointsView enterCheckpoint(
			@ApiBodyObject @Valid @RequestBody EnterCheckpointForm enterCheckpointForm, @LogIgnore HttpServletRequest request)
			throws RequestException {
		
		if(request != null && request.getSession() != null){
			log.info("previous sessin attribute <test> value is {}", request.getSession().getAttribute("test"));
		}

		return service.enterCheckpoint(enterCheckpointForm);
	}

	@ApiMethod(path = "checkpoints/enterRandomCheckpoint", verb = ApiVerb.POST, description = "进入随机无限关卡", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponseObject
	@ApiErrors(apierrors = {
			@ApiError(code = ErrorCodeConstants.NOT_ENOUGH_MONEY, description = ErrorCodeConstants.NOT_ENOUGH_MONEY_MSG),
			@ApiError(code = ErrorCodeConstants.NOT_ENOUGH_UNLIMITED_SECURITIES, description = ErrorCodeConstants.NOT_ENOUGH_UNLIMITED_SECURITIES_MSG), })
	@RequestMapping(value = "enterRandomCheckpoint", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	@Audit
	@InputLog
	@OutputLog
	public CheckpointsView enterRandomCheckpoint(
			@ApiBodyObject @Valid @RequestBody EnterRandomCheckpointForm enterRandomCheckpointForm)
			throws RequestException {
		EnterUnLimitedCheckpointForm form = new EnterUnLimitedCheckpointForm();
		
		form.setUserId(enterRandomCheckpointForm.getUserId());
		form.setType("R");
		form.setDeductionType(enterRandomCheckpointForm.getPayType());
		form.setSceneId(1501);
		form.setRoleId(enterRandomCheckpointForm.getRoleId());
		form.setWeaponIds(enterRandomCheckpointForm.getWeaponIds());
		
		return service.enterUnLimitedCheckpoint(form);
	}

	@ApiMethod(path = "checkpoints/enterCustomCheckpoint", verb = ApiVerb.POST, description = "进入自定义无限关卡", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponseObject
	@ApiErrors(apierrors = {
			@ApiError(code = ErrorCodeConstants.NOT_ENOUGH_MONEY, description = ErrorCodeConstants.NOT_ENOUGH_MONEY_MSG),
			@ApiError(code = ErrorCodeConstants.NOT_ENOUGH_UNLIMITED_SECURITIES, description = ErrorCodeConstants.NOT_ENOUGH_UNLIMITED_SECURITIES_MSG), })
	@RequestMapping(value = "enterCustomCheckpoint", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	@Audit
	@InputLog
	@OutputLog
	public CheckpointsView enterUnLimitedCheckpoint(
			@ApiBodyObject @Valid @RequestBody EnterCustomCheckpointForm enterCustomCheckpointForm)
			throws RequestException {
		EnterUnLimitedCheckpointForm form = new EnterUnLimitedCheckpointForm();
		form.setUserId(enterCustomCheckpointForm.getUserId());
		form.setType("C");
		form.setDeductionType(enterCustomCheckpointForm.getPayType());
		form.setSceneId(1401);
		
		return service.enterUnLimitedCheckpoint(form);
	}

	/**
	 * 只有用户过关才会调用这个接口，否则不会调用
	 * @param form
	 * @return
	 */
	@ApiMethod(path = "checkpoints/finishCheckpoint", verb = ApiVerb.POST, description = "通过普通，精英，英雄，活动关卡后，用户获得的奖励结果", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponseObject
	@RequestMapping(value = "finishCheckpoint", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	@Audit
	@InputLog
	@OutputLog
	public CheckpointResultView finishCheckpoint(@ApiBodyObject @Valid @RequestBody CheckpointsForm form) {
		return service.finishCheckpoints(form);
	}

	@ApiMethod(path = "checkpoints/queryRanking?type={type}&mode={mode}&userId={userId}&page={page}", verb = ApiVerb.GET, description = "查询用户排名信息", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponseObject
	@RequestMapping(value = "queryRanking", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	@Audit
	@InputLog
	@OutputLog
	public RankingListView queryRanking(
			@ApiParam(name="type", description = "无限关卡类型:R-随机无限模式;C-自定义无限模式", paramType = ApiParamType.QUERY) @RequestParam(value = "type") String type,
			@ApiParam(name="mode", description = "排名类型:0-个人排名;1-全服排名", paramType = ApiParamType.QUERY) @RequestParam(value = "mode") @Min(0) @Max(1) int mode,
			@ApiParam(name="userId", description = "用户ID,个人排名时传参，全服排名可不传", paramType = ApiParamType.QUERY) @RequestParam(value = "userId") @Min(1) int userId,
			@ApiParam(name="page", description = "页号", paramType = ApiParamType.QUERY) @RequestParam(value="page", defaultValue="1") @Max(1) int page){
		return service.getRanking(type, mode, userId, page);
	}
}
