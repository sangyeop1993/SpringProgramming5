package com.mycompany.web.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("ch09Dao3")
public class Ch09Dao3 {
	private static final Logger logger = LoggerFactory.getLogger(Ch09Dao3.class);
	
	public Ch09Dao3() {
		logger.debug("###Ch09Dao3의 객체를 생성했습니다.###");
	}
	
	public void insert() {
		logger.debug("##insert 실행##");
	}

}
