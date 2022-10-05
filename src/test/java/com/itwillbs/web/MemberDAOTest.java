package com.itwillbs.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.persistence.MemberDAO;

@RunWith(SpringJUnit4ClassRunner.class)
	// 파일 테스트할 서버 종류 설정
@ContextConfiguration(
	// 테스트 시 필요한 설정 불러오기
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		)
public class MemberDAOTest {
	// root-context의 <context>를 통해 설정 후 @Inject해서
	// 해당 위치에 있는 MemberDAO 인터페이스를 부르면 MemberDAOImpl을 사용하도록  
	@Inject
	private MemberDAO dao;
	
	private static final Logger log = LoggerFactory.getLogger(MemberDAOTest.class);
	
//	@Test
	public void daoTest() {
		log.info("@@@@ dao: "+dao);
	}
	
//	@Test
	public void 디비시간정보조회() {
		log.info("@@@@ dao.getTime(): "+dao.getTime());
	}
	
//	@Test
	public void 회원가입테스트() {
		MemberVO vo = new MemberVO();
		vo.setUserid("아이디");
		vo.setUserpw("비밀번호");
		vo.setUsername("이름");
		vo.setUseremail("이메일");
		
//		dao.insertMember(vo);
	}
	
//	@Test 
	public void 로그인로직테스트() {
		log.info("========== 로그인 체크(DB 연동 후 값 비교) ==========");
		MemberVO vo = new MemberVO();
		vo.setUserid("아이디");
		vo.setUserpw("비밀번호");
		
//		MemberVO resultVO = dao.loginMember(vo);
		MemberVO resultVO = dao.loginMember(vo.getUserid(), vo.getUserpw());
		
		if(resultVO == null) {
			log.info("회원정보가 없거나 아이디 또는 비밀번호가 일치하지 않습니다.");	
		} else {
			log.info("로그인에 성공했습니다.");
			log.info(resultVO.getUsername()+"님 환영합니다.");
		}
	}
	
	// 회원정보 조회(userid)
//	@Test
	public void 회원정보_조회() {
		MemberVO vo = dao.getMember("아이디");
		
		if(vo != null) {
			log.info("아이디: "+vo.getUserid());
			log.info("비밀번호: "+vo.getUserpw());
			log.info("이름 : "+vo.getUsername());
			log.info("이메일 : "+vo.getUseremail());
			log.info("가입일 : "+vo.getRegdate());
			log.info("수정일 : "+vo.getUpdatedate());
		} else {
			log.info("해당 아이디에 해당하는 회원정보가 없습니다");
		}
		
	}
	
//	@Test
	public void 회원정보_업데이트() {
		// 아이디와 비밀번호 일치할 경우 다른 회원정보 수정
		MemberVO vo = new MemberVO();
		vo.setUserid("아이디"); 		// 기존과 일치
		vo.setUserpw("비밀번호"); 	// 기존과 일치
		vo.setUsername("아이티윌");
		vo.setUseremail("itwillbs@naver.com");
		int result = dao.updateMember(vo);
		if(result == 1) {
			log.info("회원정보 수정이 완료되었습니다.");
		} else {
			log.info("회원정보 수정이 실패했습니다.");
		}
	}
	
	@Test
	public void 회원정보_삭제() {
		MemberVO dvo = new MemberVO();
		dvo.setUserid("아이디");
		dvo.setUserpw("비밀번호");
		int result = dao.deleteMember(dvo);
		
		if(result==1) {
			log.info("회원정보를 삭제했습니다.");
		} else {
			log.info("회원정보 삭제에 실패했습니다.");
		}
		
	}
	
	@Test
	public void 회원목록리스트_조회() {
		List<MemberVO> memberList = dao.getMemberList();
		
		for(MemberVO vo: memberList) {
			log.info("아이디: "+vo.getUserid()+", 이름 :"+vo.getUsername());
		}
	}

}
