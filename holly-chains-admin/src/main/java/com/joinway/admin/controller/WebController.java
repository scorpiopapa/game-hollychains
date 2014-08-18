package com.joinway.admin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.joinway.web.security.annotation.Logout;
import com.joinway.web.security.annotation.SecurityCheck;

@Controller
@RequestMapping("")
@Validated
@SecurityCheck
public class WebController {

	private final static Logger log = LoggerFactory.getLogger(WebController.class);
	
	@RequestMapping(value="logout")
	@Logout
	public ModelAndView logout() throws Exception {
		ModelAndView mv = new ModelAndView("redirect:login.html");
		return mv;
	}
	
	@RequestMapping(value="tabs/{table}")
	public ModelAndView table(@PathVariable("table") String table) throws Exception {
		ModelAndView mv = new ModelAndView("tabs/" + table);
		return mv;
	}
}
