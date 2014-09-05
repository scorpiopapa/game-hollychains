package com.joinway.admin.controller;

import javax.validation.constraints.Min;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.joinway.admin.bean.UserContext;
import com.joinway.admin.bean.view.LoginView;
import com.joinway.admin.bean.view.TreeMenuView;
import com.joinway.admin.service.AdminService;
import com.joinway.admin.utils.SessionHelper;
import com.joinway.bean.exception.ValidationException;
import com.joinway.bean.logging.annotation.InputLog;
import com.joinway.bean.logging.annotation.OutputLog;
import com.joinway.utils.DataUtils;
import com.joinway.web.audit.ExceptionController;
import com.joinway.web.audit.annotation.Audit;
import com.joinway.web.security.annotation.SecurityCheck;

/**
 * @author Administrator
 *
 */
@Controller
@RequestMapping("")
@Validated
@SecurityCheck
public class AdminController extends ExceptionController {

	private final static Logger log = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired @Qualifier("AdminService") AdminService service;
	
	@RequestMapping(value="login/context", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@Audit
	@InputLog
	@OutputLog
	public LoginView getLoginContext() throws ValidationException {
		LoginView view = new LoginView();
		
		UserContext uc = SessionHelper.getUserContext(true);
		view.setUserId(uc.getUserId());
		view.setLoginName(uc.getLoginName());
		view.setLastLoginTime(uc.getLastLoginTime());
		view.setLoginCount(uc.getLoginCount());
		
		return view;
	}

	@RequestMapping(value="navigator", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@Audit
	@InputLog
	@OutputLog
	public TreeMenuView navigator() throws Exception {
		return service.getNavigatorMenus(SessionHelper.getUserContext().getUserId());
	}

	@RequestMapping(value="role/menu", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@Audit
	@InputLog
	@OutputLog
	public TreeMenuView roleMenu(@RequestParam(value="roleIds",required=false) String roleIds) throws Exception {
		return service.getRoleMenus(DataUtils.convertToInt(roleIds));
	}

}


