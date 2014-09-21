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

import com.bt.chains.bean.form.IntensifyUserMagicForm;
import com.bt.chains.bean.form.MagicForm;
import com.bt.chains.bean.view.Item;
import com.bt.chains.constant.ErrorCodeConstants;
import com.bt.chains.service.MagicService;
import com.joinway.bean.logging.annotation.InputLog;
import com.joinway.bean.logging.annotation.OutputLog;
import com.joinway.web.audit.ExceptionController;
import com.joinway.web.audit.annotation.Audit;

@Api(name = "Magic API", description = "魔法操作")
@Controller
@RequestMapping("magic")
@Validated
public class MagicController extends ExceptionController {
	private final static Logger log = LoggerFactory.getLogger(MagicController.class);
	
	@Autowired
	private MagicService magicService;
	
	@ApiMethod(path="magic/updateUserMagic", verb=ApiVerb.POST, description="更新用户魔法", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ApiResponseObject
	@RequestMapping(value = "updateUserMagic", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	@Audit
	@InputLog
	@OutputLog
	public int updateUserMagic(@ApiBodyObject @Valid @RequestBody MagicForm form){
		magicService.updateUserMagic(form);
		return 0;
	}
	
	@ApiMethod(path="magic/upgradeMagic", verb=ApiVerb.POST, description="魔法强化。返回值:0-成功;1-魔法已经达到上限", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ApiResponseObject
	@ApiErrors(apierrors = {
			@ApiError(code = ErrorCodeConstants.NOT_ENOUGH_MONEY, description = ErrorCodeConstants.NOT_ENOUGH_MONEY_MSG)
			})
	@RequestMapping(value = "upgradeMagic", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	@Audit
	@InputLog
	@OutputLog
	public int intensifyUserMagic(@ApiBodyObject @Valid @RequestBody IntensifyUserMagicForm form){
		return magicService.intensifyUserMagic(form);
	}
	
	@ApiMethod(path="magic/queryMagic?userId={userId}", verb=ApiVerb.GET, description="获取用户所有魔法", produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiResponseObject
	@RequestMapping(value = "queryMagic", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	@Audit
	@InputLog
	@OutputLog
	public List<Item> queryUserMagic(@ApiParam(name = "userId", description = "用户ID", paramType = ApiParamType.QUERY) @Min(1) @RequestParam(value = "userId") int userId){
		return magicService.getUserMagic(userId).getMagics();
	}
	
}
