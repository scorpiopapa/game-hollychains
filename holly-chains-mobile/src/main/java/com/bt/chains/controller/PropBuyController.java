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

import com.bt.chains.bean.form.BuyWeaponForm;
import com.bt.chains.bean.form.PropBuyForm;
import com.bt.chains.bean.view.BuyGemView;
import com.bt.chains.bean.view.BuyWeaponView;
import com.bt.chains.bean.view.PropBuyView;
import com.bt.chains.bean.view.PropListView;
import com.bt.chains.constant.ErrorCodeConstants;
import com.bt.chains.exception.RequestException;
import com.bt.chains.service.GashaService;
import com.bt.chains.service.UserService;
import com.joinway.bean.logging.annotation.InputLog;
import com.joinway.bean.logging.annotation.OutputLog;
import com.joinway.web.audit.ExceptionController;
import com.joinway.web.audit.annotation.Audit;
import com.joinway.web.security.annotation.SingleSignOn;

@Api(name = "Prop API", description = "道具购买")
@Controller
@RequestMapping("prop")
@Validated
@SingleSignOn
public class PropBuyController extends ExceptionController{
	
	private final static Logger log = LoggerFactory.getLogger(PropBuyController.class);
	@Autowired
	private UserService service;
	@Autowired
	private GashaService gashaService;
	
	@ApiMethod(path="prop/propBuy", verb=ApiVerb.POST, description="购买道具", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ApiResponseObject
	@ApiErrors(apierrors={
			@ApiError(code=ErrorCodeConstants.NOT_ENOUGH_GEM, description=ErrorCodeConstants.NOT_ENOUGH_GEM_MSG)
	})
	@RequestMapping(value = "propBuy", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	@Audit
	@InputLog
	@OutputLog
	public PropBuyView propBuy(@ApiBodyObject @Valid @RequestBody PropBuyForm form) throws RequestException{
		return service.propBuy(form);
	}
	
	@ApiMethod(path = "prop/queryPropList?userId={userId}", verb = ApiVerb.GET, description = "查询购买道具列表", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponseObject
	@RequestMapping(value = "queryPropList", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	@Audit
	@InputLog
	@OutputLog
	public PropListView queryPropList(
			@ApiParam(name = "userId", description = "用户ID", paramType = ApiParamType.QUERY) @RequestParam(value = "userId") @Min(1) int userId) {
		return service.queryPropList(userId);
	}
	
	@ApiMethod(path = "prop/buyGem?productId={productId}&userId={userId}", verb = ApiVerb.GET, description = "购买宝石", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponseObject
	@ApiErrors(apierrors={
			@ApiError(code=ErrorCodeConstants.GEM_MAX_ERROR, description=ErrorCodeConstants.GEM_MAX_MSG)
	})
	@RequestMapping(value = "buyGem", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	@Audit
	@InputLog
	@OutputLog
	public BuyGemView buyGem(
			@ApiParam(name = "productId", description = "产品ID", paramType = ApiParamType.QUERY)  @RequestParam(value = "productId") String productId,
			@ApiParam(name = "userId", description = "用户ID", paramType = ApiParamType.QUERY) @RequestParam(value = "userId") @Min(1) int userId) throws RequestException{
		return service.buyGem(productId, userId);
	}
	
	@ApiMethod(path="prop/weaponBuy", verb=ApiVerb.POST, description="购买武器", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ApiResponseObject
	@ApiErrors(apierrors={
			@ApiError(code=ErrorCodeConstants.NOT_ENOUGH_WEAPON_SECURITIES, description=ErrorCodeConstants.NOT_ENOUGH_WEAPON_SECURITIES_MSG),
			@ApiError(code=ErrorCodeConstants.NOT_ENOUGH_GEM, description=ErrorCodeConstants.NOT_ENOUGH_GEM_MSG),
			@ApiError(code=ErrorCodeConstants.NOT_ENOUGH_STROE_ERROR, description=ErrorCodeConstants.NOT_ENOUGH_STROE_MSG),
			@ApiError(code=ErrorCodeConstants.BUY_WEAPON_ERROR, description=ErrorCodeConstants.BUY_WEAPON_MSG),
			@ApiError(code=ErrorCodeConstants.GACHA_ID_ERROR, description=ErrorCodeConstants.GACHA_ID_ERROR_MSG),
	})
	@RequestMapping(value = "weaponBuy", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	@Audit
	@InputLog
	@OutputLog
	public BuyWeaponView weaponBuy(@ApiBodyObject @Valid @RequestBody BuyWeaponForm form) throws RequestException{
		return gashaService.buyWeapon(form);
	}
}
