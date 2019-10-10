package com.mycompany.web.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ch06")
public class Ch06Controller {
	
	private static final Logger logger = LoggerFactory.getLogger(Ch06Controller.class);
	
	@RequestMapping("/content")
	public String content() {
		return "ch06/content";
	}
	@PostMapping("/login")
	public String login(String mid, String mpassword, HttpSession sess) {
		String loginResult = "";
		if(mid.equals("admin")) {
			if(mpassword.equals("iot12345")) {
				loginResult = "success";
			} else {
				loginResult = "wrongMpassword";
			}
		} else {
			loginResult = "wrongMid";
		}
		
		sess.setAttribute("loginResult", loginResult);
		return "redirect:/ch06/content";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession sess) {
		sess.removeAttribute("loginResult");
		return "redirect:/ch06/content";
	}
	
	@RequestMapping("/fileDownload")
	public void fileDownload(String fname, HttpServletResponse res) {
		logger.debug(fname);
	}
}
