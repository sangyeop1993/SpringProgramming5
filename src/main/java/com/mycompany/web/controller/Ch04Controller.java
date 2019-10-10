package com.mycompany.web.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ch04")
public class Ch04Controller {
	private static final Logger logger = LoggerFactory.getLogger(Ch04Controller.class);
	
	@RequestMapping("/content")
	public String content(@RequestHeader("User-Agent") String userAgent, HttpServletRequest request) {
		logger.debug("User-Agent: "+userAgent);
		
		String browserKind=null;
		if(userAgent.contains("Chrome")) {
			browserKind="Chrome";
		} else if(userAgent.contains("Trident/7.0")) {
			browserKind="IE 11";
		}
		
		request.setAttribute("browserKind", browserKind);
		return "ch04/content";
	}
	
	@RequestMapping("/setCookie")
	public String setCookie(HttpServletResponse response, String mname) {
		Cookie cookie = new Cookie("name", mname);
		response.addCookie(cookie);
		return "ch04/content";
	}
	
	@RequestMapping("/getCookie")
	public String getCookie(@CookieValue String name, HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie cookie:cookies) {
				if(cookie.getName().equals("name")) {
					request.setAttribute("name", cookie.getValue());
				}
			}
		}
		return "ch04/getCookie";
	}

}
