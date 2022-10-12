package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SampleController4 {
	
	private static final Logger log = LoggerFactory.getLogger(SampleController4.class);
	
	// http://localhost:8088/web/doE  
	@RequestMapping("/doE")
	public String doE(Model model, RedirectAttributes rttr) {		
//		log.info("/doE 주소 호출 -> doE() 실행 -> /doF.jsp 호출");
//		return "/doF";
		log.info("/doE 주소 호출 -> doE() 실행 -> /doF 주소 호출");
//		return "redirect:/doF"; // redirect doF 가상 주소 호출하기
//		return "redirect:/doF?msg=itwill";
		
		rttr.addFlashAttribute("msg", "SPRING");
//		model.addAttribute("msg", "busan");
		return "redirect:/doF";
	}
	
	// http://localhost:8088/web/doF
	@RequestMapping("/doF")
	public void doF(@ModelAttribute("msg") String msg) {
		log.info("msg: "+msg);
		log.info("/doF 주소 호출 -> doF() 실행  -> doF.jsp 호출");
		
	}
	
	
}
