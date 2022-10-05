package com.itwillbs.persistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO{
	
	private static final Logger log 
	= LoggerFactory.getLogger(MemberDAOImpl.class);
	
	// 1. DB 연결을 위한  sqlSessionFactory 객체 주입 -> root-context.xml에서 SqlSessionFactory 선언
	@Inject
	private SqlSessionFactory factory;
	
	// 2. DB 연결 / MyBatis 설정 + 자원 해제 -> root-context.xml에서 SqlSessionTemplate 선언 
	@Inject
	private SqlSession sqlSession; 
	
	// 3. dao 사용을 위한 주입
	@Inject
	MemberDAO dao;
	
	private static final String NAMESPACE = "com.itwillbs.mapper.MemberMapper";
	
	@Override
	public String getTime() {
		// 디비 연결 -> sql 작성 -> sql 실행 -> 데이터 처리
//		SqlSession sqlSession = factory.openSession();
		
		String now = sqlSession.selectOne("com.itwillbs.mapper.MemberMapper.getTime");
		
		return now;
	}


	@Override
	public void insertMember(MemberVO vo) {
		log.info("========== 1.2 디비 연결 - sqlSession ==========");
		log.info("========== 3-1. sql 작성 - memberMapper.xml ==========");
		log.info("========== 3-2. pstmt 객체 생성/? 처리 - sqlSession ==========");
		log.info("========== 4-1. sql 실행 - sqlSession  ==========");
		// sqlSession.insert() 실행 (DAOImpl -> mapper -> MySQL)
		sqlSession.insert(NAMESPACE+".insertMember", vo);
						 //↳ com.itwillbs.mapper.MemberMapper.insertMember
		log.info("========== 5. (select시) ResultSet 담기 ==========");
		log.info("========== 6. 자원 해제 ==========");
	}


	@Override
	public MemberVO loginMember(MemberVO vo) {
		log.info("MemberDAOImpl - loginMember(vo)");
		
		MemberVO resultVO = sqlSession.selectOne(NAMESPACE+".loginMember", vo);
		
		return resultVO;
	}


	@Override
	public MemberVO loginMember(String userid, String userpw) {
		log.info("MemberDAOImpl - loginMember(userid, userpw)");
		
//		MemberVO vo = new MemberVO();
//		vo.setUserid(userid);
//		vo.setUserpw(userpw);
//		
//		MemberVO resultVO = sqlSession.selectOne(NAMESPACE+".loginMember", vo);
//					// selectOne은 파라미터값을 한 개만 보낼 수 있음.
//		return resultVO;
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userid", userid);
		paramMap.put("userpw", userpw);
		
		return sqlSession.selectOne(NAMESPACE+".loginMember", paramMap);
	}


	@Override
	public MemberVO getMember(String userid) {
		log.info("MemberDAOImpl - getMember(userid)");
		
		MemberVO resultVO = sqlSession.selectOne(NAMESPACE+".getMember", userid);
		log.info(resultVO+"");
		
		return resultVO;
	}


	@Override
	public Integer updateMember(MemberVO uvo) {
		log.info("MemberDAOImpl - updateMember(vo)");
		
		int result = sqlSession.update(NAMESPACE+".updateMember", uvo);
		// result == 0(수정 실패)/1(수정 성공)
		return result;
	}


	@Override
	public Integer deleteMember(MemberVO dvo) {
		log.info("MemberDAOImpl - deleteMember(userid, userpw)");
		
		int result = sqlSession.delete(NAMESPACE+".deleteMember", dvo);
		// result == 0(삭제 실패)/1(삭제 성공)
		return result;
	}


	@Override
	public List<MemberVO> getMemberList() {
		List<MemberVO> memberList 
			= sqlSession.selectList(NAMESPACE+".getMemberList");
				  		// ↳ vo타입의 객체를 List에 순서대로 저장해줌↳
		return memberList;
	}
	
	
}

