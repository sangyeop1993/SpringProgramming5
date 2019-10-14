package com.mycompany.web.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("ch09Dao4")
public class Ch09Dao4 {
	private static final Logger logger = LoggerFactory.getLogger(Ch09Dao4.class);
	
	public Ch09Dao4() {
		logger.debug("###Ch09Dao4의 객체를 생성했습니다.###");
	}
	
	public void insert() {
		logger.debug("##insert 실행##");
	}

}
