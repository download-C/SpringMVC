package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SampleController1 {
	

	private static final Logger log = LoggerFactory.getLogger(SampleController1.class);
	
	//http://localhost:8088/web/doA
	// @GetMapping("/doA")
	@RequestMapping(method = RequestMethod.GET, value = "/doA") // doA 가 들어오면 doA() 실행
	public void doA(@ModelAttribute("name") String name,
			@ModelAttribute("tel") String tel) {
		log.info("======/doA 주소 호출 -> doA() 실행");
	}
	
	// http://localhost:8088/web/doD?id=admin
	@RequestMapping("/doB")
	public void doB() {
		log.info("=======/doB 주소 호출 -> doB(); 실행");
	}
}
