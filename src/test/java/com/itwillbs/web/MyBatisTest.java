package com.itwillbs.web;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) // 실행할 때 사용할 클래스 지정
@ContextConfiguration( // 설정값 불러오기
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class MyBatisTest {
	
	// DB 연결 및  MyBatis 설정
	private static final Logger log = LoggerFactory.getLogger(MyBatisTest.class);
	
	// 의존관계 주입(Dependency Inject)
//	@Inject
	private DataSource ds;
	
	@Inject
	private SqlSessionFactory sqlFactory;
	
	@Test
	public void 객체주입여부확인() {
		log.info("@@@@ ds: "+ds);
		log.info("@@@@ sqlFactory: "+sqlFactory);
		
	}
	
	@Test
	public void 디비연결테스트() {
		SqlSession sqlSession = sqlFactory.openSession(); // 디비 연결
		log.info("@@@@ sqlSession: "+sqlSession);
//		sqlSession.insert(statement);
//		sqlSession.select(statement, handler);
//		sqlSession.update(statement);
//		sqlSession.delete(statement);
	}
	
}
