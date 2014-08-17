package com.joinway.admin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.joinway.web.security.annotation.Logout;

@Controller
@RequestMapping("")
@Validated
public class WebController {

	private final static Logger log = LoggerFactory.getLogger(WebController.class);
	
	@RequestMapping(value="logout")
	@Logout
	public ModelAndView logout() throws Exception {
		ModelAndView mv = new ModelAndView("redirect:login.html");
		return mv;
	}
}
