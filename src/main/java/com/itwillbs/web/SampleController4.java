package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleController4 {
	
	private static final Logger log = LoggerFactory.getLogger(SampleController4.class);
	
	// http://localhost:8088/web/doE  
	@RequestMapping("/doE")
	public String doE() {		
//		log.info("/doE 주소 호출 -> doE() 실행 -> /doF.jsp 호출");
//		return "/doF";
		log.info("/doE 주소 호출 -> doE() 실행 -> /doF 주소 호출");
		return "redirect:/doF";
	}
	
	// http://localhost:8088/web/doF
	@RequestMapping("/doF")
	public void doF() {
		log.info("/doF 주소 호출 -> doF() 실행  -> doF.jsp 호출");
		
	}
	
	
}
