package com.mycompany.web.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

//@Service("ch09MemberService")
public class Ch09MemberService1 implements Ch09MemberService {
	private static final Logger logger = LoggerFactory.getLogger(Ch09MemberService1.class);
	
	@Override
	public void join() {
		logger.debug("#join-1 실행#");
	}
	
	@Override
	public void login() {
		logger.debug("#login-1 실행#");
	}

}
