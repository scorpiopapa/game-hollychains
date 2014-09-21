package com.bt.chains.controller;

import javax.validation.Valid;

import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiBodyObject;
import org.jsondoc.core.annotation.ApiError;
import org.jsondoc.core.annotation.ApiErrors;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiResponseObject;
import org.jsondoc.core.pojo.ApiVerb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bt.chains.bean.form.UserScoreForm;
import com.bt.chains.bean.view.UserScoreView;
import com.bt.chains.constant.ErrorCodeConstants;
import com.bt.chains.exception.RequestException;
import com.bt.chains.service.UserService;
import com.joinway.bean.logging.annotation.InputLog;
import com.joinway.bean.logging.annotation.OutputLog;
import com.joinway.web.audit.ExceptionController;
import com.joinway.web.audit.annotation.Audit;

@Api(name = "Score API", description = "保存用户积分信息，并判断是否有新的奖励")
@Controller
@RequestMapping("score")
@Validated
public class UserScoreController  extends ExceptionController {

	@Autowired
	private UserService service;
	
	@ApiMethod(path="score/saveUserScore", verb=ApiVerb.POST, description="保存用户积分", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ApiResponseObject
	@ApiErrors(apierrors={
			@ApiError(code=ErrorCodeConstants.NO_DATA_ERROR, description=ErrorCodeConstants.NO_DATA_MSG)
	})
	@RequestMapping(value = "saveUserScore", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	@Audit
	@InputLog
	@OutputLog
	public UserScoreView saveUserScore(@ApiBodyObject @Valid @RequestBody UserScoreForm userScoreForm) throws RequestException{
		return service.saveUserScore(userScoreForm);
	}
}
