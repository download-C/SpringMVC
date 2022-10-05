package com.itwillbs.persistence;

import java.util.List;

import org.junit.Test;

import com.itwillbs.domain.MemberVO;

public interface MemberDAO {
	// DB 테스트용 메서드 (DB 현재시간 조회)
	@Test
	public String getTime();
	
	// 회원가입 
	public void insertMember(MemberVO vo);
	
	// 로그인 
	public MemberVO loginMember(MemberVO vo);
	
	// 로그인2
	public MemberVO loginMember(String userid, String userpw);
	
	// 회원정보 조회
	public MemberVO getMember(String userid);
	
	// 회원정보 수정
	public Integer updateMember(MemberVO vo);
	
	// 회원정보 삭제 
	public Integer deleteMember(MemberVO vo);
	
	// 회원정보 삭제2
//	public Integer deleteMember(String userid, String userpw);
	
	// 회원목록조회
	public List<MemberVO> getMemberList();
}
