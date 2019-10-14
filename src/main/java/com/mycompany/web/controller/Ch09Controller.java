package com.mycompany.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.web.service.Ch09Service;
import com.mycompany.web.service.Ch09Service2;
import com.mycompany.web.service.Ch09Service3;

@Controller
@RequestMapping("/ch09")
public class Ch09Controller {
	private static final Logger logger = LoggerFactory.getLogger(Ch09Controller.class);
	@Autowired
	private Ch09Service ch09Service;
	@Autowired
	private Ch09Service2 ch09Service2;
	@Autowired
	private Ch09Service3 ch09Service3;
	
	@RequestMapping("/content")
	public String content() {
		return "ch09/content";
	}
	
	@RequestMapping("/method1")
	public String method1() {
		logger.debug("##controller의 method1실행##");
		ch09Service.method1();
		return "redirect:/ch09/content";
	}
	
	@RequestMapping("/method2")
	public String method2() {
		logger.debug("##controller의 method2실행##");
		ch09Service2.method1();
		return "redirect:/ch09/content";
	}
	
	@RequestMapping("/method3")
	public String method3() {
		logger.debug("##controller의 method3실행##");
		ch09Service3.method3();
		return "redirect:/ch09/content";
	}
}
