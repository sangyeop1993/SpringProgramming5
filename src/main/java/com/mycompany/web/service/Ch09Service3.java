package com.mycompany.web.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.web.dao.Ch09Dao3;

@Service("ch09Service3")
public class Ch09Service3 {
	private static final Logger logger = LoggerFactory.getLogger(Ch09Service3.class);
	@Autowired
	private Ch09Dao3 ch09Dao3;
	
	public void method3() {
		logger.debug("##Ch09Service3의 method3실행##");
		ch09Dao3.insert();
	}

}
