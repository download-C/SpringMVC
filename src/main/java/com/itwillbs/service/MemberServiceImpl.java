package com.itwillbs.service;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.persistence.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService	{
	
	private static final Logger log = LoggerFactory.getLogger(MemberServiceImpl.class);
	
	@Inject
	private	MemberDAO dao;
	
	@Override
	public void memberJoin(MemberVO vo) {
		log.info("컨트롤러 -> 서비스(Impl)");
		log.info("MemberServiceImpl - memberJoin() 호출");
		log.info("서비스(Impl) -> DAO(Impl)"); // -> MemberDAO 주입
		
		dao.insertMember(vo);
		
	}

	@Override
	public MemberVO memberLogin(MemberVO vo) {
		log.info("memberLogin(vo) 호출");
		dao.loginMember(vo);
		return vo;
	}

	@Override
	public MemberVO memberGet(String userid) {
		log.info("memberGet(userid) 호출"); 
//		MemberVO vo = dao.getMember(userid);
//		return vo;
		
		return dao.getMember(userid);
	}

}
