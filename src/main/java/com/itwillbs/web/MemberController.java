package com.itwillbs.web;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.service.MemberService;

@Controller
@RequestMapping("/member/*") // member로 시작하는 모든 주소 관리 
public class MemberController {

	private static final Logger log = LoggerFactory.getLogger(MemberController.class);
	
	@Inject
	private MemberService service;
	
//	// http://localhost:8088/member/test
//	@RequestMapping("/test")
//	public void TestMember() {
//		log.info("testMember() 메서드 호출");
//	}
	
	// GET 방식 회원가입 -> 조회, 입력
	
	// http://localhost:8088/member/insert
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public void insertGET() {
		log.info("insertGET() 호출");
		log.info("연결된 view 페이지 출력");
	}
	

	// POST 방식 회원가입 -> 입력 정보 DB 저장
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	// == @PostMapping(value="insertPro")
	public String insertPOST(MemberVO vo, HttpServletRequest request) throws Exception {
		log.info("insertPOST() 호출");
		
		// 한글처리
		 request.setCharacterEncoding("UTF-8");

		// 정보 저장 VO
		// MemberVO vo = new MemberVO();
		// String userid = request.getParameter("userid");
		// String userpw = request.getParameter("userpw");
		// String username = request.getParameter("username");
		// String useremail = request.getParameter("useremail");
		// vo.setUserid(userid);
		// vo.setUserpw(userpw);
		// vo.setUsername(username);
		// vo.setUseremail(useremail);

		 log.info(vo+"");
						
		// 정보 DB 저장
				
		service.memberJoin(vo);
		
		log.info("회원가입 성공");
		// 페이지 이동
		return "redirect:/member/login";
	}
	
	// http://localhost:8088/member/login
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginGET() {
		log.info("loginGET() 호출"); 
		log.info("연결된 view 페이지 이동");
		
		return "/member/memberLogin";
	}
	
	// 로그인 POST
	@RequestMapping(value="/memberLogin", method = RequestMethod.POST)
	public String loginPOST(MemberVO vo, HttpSession session) {
		log.info("loginPOST() 호출");
		log.info("vo: "+vo);
		
		MemberVO loginVO = service.memberLogin(vo);
		
		if(loginVO != null) {
			// 로그인 성공
			session.setAttribute("loginVO", loginVO);
			return "redirect:/member/main";
		} else {
			// 로그인 실패시 다시 로그인 페이지로 이동
			return "redirect:/member/login";
		}
	}
	
	// http://localhost:8088/member/main
	@RequestMapping(value="/main", method = RequestMethod.GET)
	public void mainGET() {
		log.info("mainGET() 호출");
		log.info("연결된 view 페이지로 이동");
	}
	
	// 로그아웃 GET/POST
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutGET(HttpSession session) {
		log.info("logoutGET() 호출");
		session.invalidate();
		log.info("세션 초기화 완료 후 메인 페이지로 이동");
		
		return "redirect:/member/main";
	}
	
	// 회원정보 조회 GET
	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public void infoGET(HttpSession session, Model model) {
		log.info("infoGET() 호출");
		MemberVO vo = (MemberVO)session.getAttribute("loginVO");
		log.info("id: "+vo.getUserid());
		
		// 서비스 사용 -> DB 정보 가져오기
		MemberVO userVO = service.memberGet(vo.getUserid());
		log.info("userVO: "+userVO);
		model.addAttribute("userVO", userVO);
		
		log.info("연결된 view 페이지 이동");
		//
	}

}
