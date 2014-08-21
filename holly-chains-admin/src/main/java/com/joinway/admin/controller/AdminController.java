package com.joinway.admin.controller;

import javax.validation.Valid;

import org.jsondoc.core.annotation.ApiBodyObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.joinway.admin.bean.UserContext;
import com.joinway.admin.bean.form.LoginForm;
import com.joinway.admin.bean.form.RegisterForm;
import com.joinway.admin.bean.view.LoginView;
import com.joinway.admin.bean.view.LogoutView;
import com.joinway.admin.bean.view.TreeMenuView;
import com.joinway.admin.service.AdminService;
import com.joinway.admin.utils.SessionHelper;
import com.joinway.bean.exception.ValidationException;
import com.joinway.bean.logging.annotation.InputLog;
import com.joinway.bean.logging.annotation.OutputLog;
import com.joinway.web.audit.ExceptionController;
import com.joinway.web.audit.annotation.Audit;
import com.joinway.web.security.annotation.Login;
import com.joinway.web.security.annotation.Logout;
import com.joinway.web.security.annotation.SecurityCheck;

/**
 * @author Administrator
 *
 */
@Controller
@RequestMapping("")
@Validated
public class AdminController extends ExceptionController {

	private final static Logger log = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired @Qualifier("ChainsAdminService") AdminService service;
	
	@RequestMapping(value="login", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@Login
	@Audit
	@InputLog
	@OutputLog
	public LoginView login(@ApiBodyObject @Valid LoginForm form) throws Exception {
		LoginView view = service.login(form);
		
		postLogin(view);
		
		return view;
	}
	
	@RequestMapping(value="register", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@Login
	@Audit
	@InputLog
	@OutputLog
	public LoginView register(@ApiBodyObject @Valid RegisterForm form) throws Exception {
		LoginView view = service.register(form);
		
		postLogin(view);
		
		return view;
	}

	@RequestMapping(value="login/context", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@SecurityCheck
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

/*
	@RequestMapping(value="logout", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@Audit
	@Logout
	@InputLog
	@OutputLog
	public LogoutView logout(){
//		LogoutView view = service.logout();
//		
//		UserContext uc = SessionHelper.getUserContext();
//		if(uc != null){
//			view.setUserName(uc.getLoginName());
//		}
		
		log.info("user logged out");
		
		return new LogoutView();
	}
*/
	@RequestMapping(value="navigator", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@SecurityCheck
	@Audit
	@InputLog
	@OutputLog
	public TreeMenuView navigator() throws Exception {
		return service.getNavigatorMenus(SessionHelper.getUserContext().getUserId());
	}
	
	void postLogin(LoginView view){
		UserContext uc = SessionHelper.getUserContext(true);

		uc.setLastLoginTime(view.getLastLoginTime());
		uc.setLoginCount(view.getLoginCount());
		uc.setUserId(view.getUserId());
		uc.setLoginName(view.getloginName());
	}
}


