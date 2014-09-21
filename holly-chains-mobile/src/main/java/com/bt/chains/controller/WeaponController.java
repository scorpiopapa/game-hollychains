package com.bt.chains.controller;

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

import com.bt.chains.bean.domain.WeaponInfoView;
import com.bt.chains.bean.form.WeaponComposeForm;
import com.bt.chains.bean.form.WeaponForm;
import com.bt.chains.bean.form.WeaponImportForm;
import com.bt.chains.bean.form.WeaponSellForm;
import com.bt.chains.bean.view.ComposedWeaponView;
import com.bt.chains.bean.view.WeaponView;
import com.bt.chains.constant.ErrorCodeConstants;
import com.bt.chains.exception.RequestException;
import com.bt.chains.service.WeaponService;
import com.joinway.bean.logging.annotation.InputLog;
import com.joinway.bean.logging.annotation.OutputLog;
import com.joinway.web.audit.ExceptionController;
import com.joinway.web.audit.annotation.Audit;

@Api(name = "Weapon API", description = "武器操作")
@Controller
@RequestMapping("weapon")
@Validated
public class WeaponController extends ExceptionController{
	private final static Logger log = LoggerFactory.getLogger(WeaponController.class);
	
	@Autowired
	private WeaponService weaponService;
	
	@ApiMethod(path="weapon/composeWeapon", verb=ApiVerb.POST, description="合成武器", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ApiResponseObject
	@ApiErrors(apierrors={
			@ApiError(code=ErrorCodeConstants.NOT_ENOUGH_MONEY, description=ErrorCodeConstants.NOT_ENOUGH_MONEY_MSG),
	})
	@RequestMapping(value = "composeWeapon", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	@Audit
	@InputLog
	@OutputLog
	public ComposedWeaponView composeWeapon(@ApiBodyObject @Valid @RequestBody WeaponComposeForm form) throws RequestException{
		return weaponService.composeWeapon(form);
	}
	
	@ApiMethod(path="weapon/sellWeapon", verb=ApiVerb.POST, description="贩卖武器", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ApiResponseObject
	@RequestMapping(value = "sellWeapon", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	@Audit
	@InputLog
	@OutputLog
	public int sellWeapon(@ApiBodyObject @Valid @RequestBody WeaponSellForm form){
		return weaponService.sellWeapon(form);
	}
	
	@ApiMethod(path="weapon/importWeapon", verb=ApiVerb.POST, description="导入武器", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ApiResponseObject
	@ApiErrors(apierrors={
			@ApiError(code=ErrorCodeConstants.NOT_ENOUGH_BAG_ERROR, description=ErrorCodeConstants.NOT_ENOUGH_BAG_MSG),
	})
	@RequestMapping(value = "importWeapon", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	@Audit
	@InputLog
	@OutputLog
	public WeaponView importWeapon(@ApiBodyObject @Valid @RequestBody WeaponImportForm form) throws RequestException{
		return weaponService.importWeapon(form);
	}
	
	@ApiMethod(path="weapon/updateUserWeapons", verb=ApiVerb.POST, description="记录用户当前使用的武器", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ApiResponseObject
	@RequestMapping(value = "updateUserWeapons", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json")
//	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	@Audit
	@InputLog
	@OutputLog
	public int updateUserWeapons(@ApiBodyObject @Valid @RequestBody WeaponForm form){
		weaponService.updateWeapons(form);
		return 0;
	}
	
	@ApiMethod(path = "weapon/queryWeaponInfo?userId={userId}", verb = ApiVerb.GET, description = "返回武器相关信息:仓库容量，背包容量，用户武器", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponseObject
	@RequestMapping(value = "queryWeaponInfo", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	@Audit
	@InputLog
	@OutputLog
	public WeaponInfoView queryWeaponInfo(
			@ApiParam(name = "userId", description = "用户ID", paramType = ApiParamType.QUERY) @Min(1) @RequestParam(value = "userId") int userId) {
		return weaponService.queryWeaponInfo(userId);
	}
}
