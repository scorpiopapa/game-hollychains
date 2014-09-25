package com.bt.chains.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
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

import com.bt.chains.bean.domain.ActiveCode;
import com.bt.chains.bean.form.BindForm;
import com.bt.chains.bean.form.LoginForm;
import com.bt.chains.bean.form.UpdateUserNameForm;
import com.bt.chains.bean.view.BaseDataView;
import com.bt.chains.bean.view.BindResult;
import com.bt.chains.bean.view.MainView;
import com.bt.chains.bean.view.UserView;
import com.bt.chains.constant.ErrorCodeConstants;
import com.bt.chains.exception.RequestException;
import com.bt.chains.service.RewardService;
import com.bt.chains.service.UserService;
import com.joinway.bean.logging.annotation.InputLog;
import com.joinway.bean.logging.annotation.LogIgnore;
import com.joinway.bean.logging.annotation.OutputLog;
import com.joinway.web.audit.ExceptionController;
import com.joinway.web.audit.annotation.Audit;
import com.joinway.web.security.annotation.Login;

@Api(name = "User API", description = "获取和更新用户信息")
@Controller
@RequestMapping("user")
@Validated
public class UserController extends ExceptionController{

	private final static Logger log = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserService service;
	
	@Autowired
	private RewardService rewardService;

	@ApiMethod(path="user/login", verb=ApiVerb.POST, description="用户登录，返回用户对象; 如果用户不存在，则注册新用户并返回此用户对象", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ApiResponseObject
	@RequestMapping(value = "login", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	@Login(name="id")
	@Audit
	@InputLog
	@OutputLog
	public MainView login(@ApiBodyObject @Valid @RequestBody LoginForm form, @LogIgnore HttpServletRequest request){
		MainView view = service.login(form);
		
		int count= rewardService.getAchivementCounts(view.getUserId());
		view.setAchievementCount(count);
		
		if(request != null && request.getSession() != null){
			log.info("set [{}] to session", form.getId());
			request.getSession().setAttribute("test", form.getId());
		}
		return view;
	}
	
	@ApiMethod(path="user/code?id={id}", verb=ApiVerb.GET, description="获得设备切换码", produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiResponseObject
	@ApiErrors(apierrors={
			@ApiError(code=ErrorCodeConstants.USER_NOEXISTS, description=ErrorCodeConstants.USER_NOEXISTS_MSG),
			@ApiError(code=ErrorCodeConstants.INVALID_MIGRATE, description=ErrorCodeConstants.INVALID_MIGRATE_MSG)
	})
	@RequestMapping(value = "code", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	@Audit("id")
	@InputLog
	@OutputLog
	public ActiveCode getCode(@ApiParam(name="id", description="用户id", paramType = ApiParamType.QUERY) @RequestParam("id") @Min(1) int id) throws RequestException {
		return service.getCode(id);
	}
	
	@ApiMethod(path="user/bind", verb=ApiVerb.POST, description="使用验证码和要切换到的帐号登录", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ApiResponseObject
	@ApiErrors(apierrors={
			@ApiError(code=ErrorCodeConstants.USER_NOEXISTS, description=ErrorCodeConstants.USER_NOEXISTS_MSG),
			@ApiError(code=ErrorCodeConstants.INVALID_MIGRATE, description=ErrorCodeConstants.INVALID_MIGRATE_MSG),
			@ApiError(code=ErrorCodeConstants.CODE_EXPIRED, description=ErrorCodeConstants.CODE_EXPIRED_MSG),
			@ApiError(code=ErrorCodeConstants.CODE_MISMATCH, description=ErrorCodeConstants.CODE_MISMATCH_MSG),
	})
	@RequestMapping(value = "bind", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	@Audit
	@InputLog
	@OutputLog
	public BindResult bind(@ApiBodyObject @Valid @RequestBody BindForm form) throws RequestException{
		return service.bindDevice(form);
	}
	
	@ApiMethod(path="user/updateUserName", verb=ApiVerb.POST, description="修改用户名称", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ApiResponseObject
	@RequestMapping(value = "updateUserName", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	@Audit
	@InputLog
	@OutputLog
	public UserView updateUserName(@ApiBodyObject @Valid @RequestBody UpdateUserNameForm form){
		return service.updateUserName(form);
	}
	
	@ApiMethod(path="user/queryBaseData?userId={userId}", verb=ApiVerb.GET, description="获取基础数据", produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiResponseObject
	@RequestMapping(value = "queryBaseData", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	@Audit
	@InputLog
	@OutputLog
	public BaseDataView queryBaseData(@ApiParam(name="userId", description="用户id", paramType = ApiParamType.QUERY) @RequestParam("userId") @Min(1) int userId){
		return service.queryBaseData(userId);
	}
}
