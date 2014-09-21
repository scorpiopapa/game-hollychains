package com.bt.chains.controller;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Length;
import org.jsondoc.core.annotation.Api;
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

import com.bt.chains.bean.view.PropListView;
import com.bt.chains.bean.view.ShopView;
import com.bt.chains.service.GashaService;
import com.bt.chains.service.UserService;
import com.joinway.bean.logging.annotation.InputLog;
import com.joinway.bean.logging.annotation.OutputLog;
import com.joinway.web.audit.ExceptionController;
import com.joinway.web.audit.annotation.Audit;


@Api(name = "Gasha API", description = "扭蛋操作")
@Controller
@RequestMapping("gasha")
@Validated
public class GashaController extends ExceptionController {
	private final static Logger log = LoggerFactory.getLogger(GashaController.class);
	
	@Autowired
	private GashaService gashaService;
	
	@Autowired
	private UserService service;

	@ApiMethod(path="gasha/getGashaCounts?userId={userId}", verb=ApiVerb.GET, description="查询是否有扭蛋券", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ApiResponseObject
	@RequestMapping(value = "getGashaCounts", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	@Audit
	@InputLog
	@OutputLog
	public int getGashaCounts(@ApiParam(name="userId", description="用户ID", paramType = ApiParamType.QUERY) @Min(1) @RequestParam(value="userId") int userId){
		return gashaService.getGashaCounts(userId);
	}
	
	@ApiMethod(path="gasha/menu?userId={userId}", verb=ApiVerb.GET, description="商城菜单", produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiResponseObject
	@RequestMapping(value = "menu", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	@Audit
	@InputLog
	@OutputLog
	public ShopView propBuy(@ApiParam(name = "userId", description = "用户ID", paramType = ApiParamType.QUERY) @RequestParam(value = "userId") @Min(1) int userId){
		ShopView view = new ShopView();
		
		PropListView propMenu = service.queryPropList(userId);
		if(propMenu != null){
			view.setPropMenus(propMenu.getPropList());
		}
		
		view.setWeaponMenus(gashaService.getShopWeaponMenu());
		
		return view;
	}

}
