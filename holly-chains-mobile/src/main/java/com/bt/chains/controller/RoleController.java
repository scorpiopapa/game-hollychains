package com.bt.chains.controller;

import java.util.List;

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

import com.bt.chains.bean.domain.UserRole;
import com.bt.chains.bean.form.IntensifyUserRoleForm;
import com.bt.chains.bean.form.UserRoleForm;
import com.bt.chains.bean.view.MoneyView;
import com.bt.chains.constant.ErrorCodeConstants;
import com.bt.chains.exception.RequestException;
import com.bt.chains.service.RoleService;
import com.joinway.bean.logging.annotation.InputLog;
import com.joinway.bean.logging.annotation.OutputLog;
import com.joinway.web.audit.ExceptionController;
import com.joinway.web.audit.annotation.Audit;
import com.joinway.web.security.annotation.SingleSignOn;

@Api(name = "Role API", description = "职业操作")
@Controller
@RequestMapping("role")
@Validated
@SingleSignOn
public class RoleController extends ExceptionController{
	private final static Logger log = LoggerFactory.getLogger(RoleController.class);
	
	@Autowired
	private RoleService roleService;
	
	@ApiMethod(path="role/updateUserRole", verb=ApiVerb.POST, description="更新用户职业", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ApiResponseObject
	@RequestMapping(value = "updateUserRole", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	@Audit
	@InputLog
	@OutputLog
	public int updateUserRole(@ApiBodyObject @Valid @RequestBody UserRoleForm form){
		roleService.saveUserRole(form);
		return 0;
	}
	
	@ApiMethod(path="role/upgradeRole", verb=ApiVerb.POST, description="职业强化。返回值:0-成功;1-职业达到上限", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ApiResponseObject
	@ApiErrors(apierrors = {
			@ApiError(code = ErrorCodeConstants.NOT_ENOUGH_MONEY, description = ErrorCodeConstants.NOT_ENOUGH_MONEY_MSG),
			@ApiError(code = ErrorCodeConstants.NO_DATA_ERROR, description = ErrorCodeConstants.NO_DATA_MSG),
			@ApiError(code = ErrorCodeConstants.ROLE_NO_EXISTS, description = ErrorCodeConstants.ROLE_NO_EXISTS_MSG),
			@ApiError(code = ErrorCodeConstants.ROLE_MAX, description = ErrorCodeConstants.ROLE_MAX_MSG),
	})
	@RequestMapping(value = "upgradeRole", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	@Audit
	@InputLog
	@OutputLog
	public MoneyView intensifyUserRole(@ApiBodyObject @Valid @RequestBody IntensifyUserRoleForm form) throws RequestException{
		return roleService.intensifyUserRole(form);
	}
	
	@ApiMethod(path="role/queryRole?userId={userId}", verb=ApiVerb.GET, description="获取用户所有职业", produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiResponseObject
	@RequestMapping(value = "queryRole", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	@Audit
	@InputLog
	@OutputLog
	public List<UserRole> queryUserRole(@ApiParam(name = "userId", description = "用户ID", paramType = ApiParamType.QUERY) @Min(1) @RequestParam(value = "userId") int userId){
		return roleService.getUserRoles(userId);
	}

}
