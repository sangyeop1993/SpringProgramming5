package com.mycompany.web.controller;

import java.io.File;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/ch08")
public class Ch08Controller {
	private static final Logger logger = LoggerFactory.getLogger(Ch08Controller.class);
	
	@RequestMapping("/content")
	public String content() {
		return "ch08/content";
	}
	
	@PostMapping("/fileUpload")
	public String fileUpload(
			String title, String description,
			MultipartFile attach1, MultipartFile attach2,
			HttpServletRequest req,
			Model model) throws Exception {
		ServletContext application =  req.getServletContext();
		String savePath = application.getRealPath("/resources/upload/");
		//logger.debug("###"+savePath);
		logger.debug(title);
		logger.debug(description);
		model.addAttribute("title", title);
		model.addAttribute("description", description);
		if(!attach1.isEmpty()) {
			logger.debug("----------------------------------------------------");
			logger.debug("attach1: "+attach1.getOriginalFilename()+" // "+attach1.getContentType()+" // "+attach1.getSize());
			String saveFileName = new Date().getTime()+"-"+attach1.getOriginalFilename();
			logger.debug(saveFileName);
			attach1.transferTo(new File(savePath+saveFileName));
			model.addAttribute("attach1_ofilename", attach1.getOriginalFilename());
		}
		if(!attach2.isEmpty()) {
			logger.debug("----------------------------------------------------");
			model.addAttribute("attach2_ofilename", attach2.getOriginalFilename());
			logger.debug("attach2: "+attach2.getOriginalFilename()+" // "+attach2.getContentType()+" // "+attach2.getSize());
			String saveFileName = new Date().getTime()+"-"+attach2.getOriginalFilename();
			logger.debug(saveFileName);
			attach2.transferTo(new File(savePath+saveFileName));
		}
		return "ch08/fileUpload";
	}
}
