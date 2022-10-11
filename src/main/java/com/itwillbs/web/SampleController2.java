package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwillbs.domain.MemberVO;

@Controller
//@RequestMapping("/sample")
public class SampleController2 {
	
	

	private static final Logger log = LoggerFactory.getLogger(SampleController2.class);
	
	// http://localhost:8088/web/doC?msg=busan
	@RequestMapping("/doC")
	public String doC(@ModelAttribute("msg") String msg) {
		log.info("===== doC 주소 호출 -> doC() 실행 -> itwill.jsp 호출");
		log.info("msg: "+msg);
	
		return "itwill";
	}
	
	// http://localhost:8088/web/doC1?name=itwill&tel=0518030909
	@RequestMapping("/doC1")
	public String doC1(@ModelAttribute("name") String name,
			@ModelAttribute("tel") String tel) {
		log.info("===== doD 주소 호출 -> doD() 실행 -> doA.jsp 호출");
		
		return "doA";
	}
	
	// http://localhost:8088/web/doD?id=admin
	@RequestMapping("/doD")
	public void doD(@ModelAttribute("id") String id) {
		log.info("===== doD 주소 호출 -> doD() 실행");
		log.info("id :"+id);
	}
	
	// http://localhost:8088/web/doD1?email=test@test.com
	@RequestMapping("/doD1")
	public String doD1(@ModelAttribute("email") String email) {
		log.info("===== doD1 주소 호출 -> doD1() 실행 -> test.jsp 호출");
		log.info("email :"+email);
		
		return "test";
	}
	
	// http://localhost:8088/web/doBean?userid=admin
	// http://localhost:8088/web/doBean?userpw=1234	
	@RequestMapping("/doBean")
	public String doBeanTest(MemberVO vo, Model model) {
		log.info("===== doBean 주소 호출 -> doBeanTest() 실행 -> test.jsp 호출");
		log.info("vo: "+vo);
		
		
		MemberVO dbVO = new MemberVO();
		dbVO.setUserid("user1");
		dbVO.setUserpw("1234");
		dbVO.setUsername("유저1");
		dbVO.setUseremail("user1@naver.com");
		
		model.addAttribute("dbVO", dbVO);
		
		return "test";
	}
}
