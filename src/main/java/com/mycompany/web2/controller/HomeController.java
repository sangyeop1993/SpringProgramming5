package com.mycompany.web2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.web2.service.Ch09CommonService;

@Controller
@RequestMapping("/dispatcher2")
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private Ch09CommonService ch09CommonService;
	
	@RequestMapping("")
	public String home() {
		logger.debug("home 실행");
		return "home";
	}
	
	@RequestMapping("/method1")
	public String method1() {
		logger.debug("#method1 실행#");
		ch09CommonService.method1();
		return "redirect:/dispatcher2/method1";
	}
}