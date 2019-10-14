package com.mycompany.web.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("ch09Dao2")
public class Ch09Dao2 {
	private static final Logger logger = LoggerFactory.getLogger(Ch09Dao2.class);
	
	public Ch09Dao2() {
		logger.debug("###Ch09Dao2의 객체를 생성했습니다.###");
	}
	
	public void insert() {
		logger.debug("##insert method 실행##");
	}
}
