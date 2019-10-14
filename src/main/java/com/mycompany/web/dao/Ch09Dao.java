package com.mycompany.web.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("ch09Dao")
public class Ch09Dao {
	private static final Logger logger = LoggerFactory.getLogger(Ch09Dao.class);
	
	public Ch09Dao() {
		logger.debug("###Ch09Dao의 객체를 생성했습니다.###");
	}
	
	public void insert() {
		logger.debug("##insert method 실행##");
	}
}
