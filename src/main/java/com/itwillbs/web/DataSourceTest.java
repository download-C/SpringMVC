package com.itwillbs.web;

import java.sql.Connection;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) // 스프링 모드 테스트
@ContextConfiguration( 					// 프로젝트 실행 시 사용할 설정, 위치 등을 root-context.xml 파일에 저장된 내용을 사용
	locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" }
	)

public class DataSourceTest {
// DataSource 객체 생성 여부 확인
	private static final Logger log = LoggerFactory.getLogger(DataSourceTest.class);
	
// DataSource 객체 생성(직접 생성- > 강한 결합 ==> 주입 필요)
	
//	@Autowired // Inject와 같은 역할
	@Inject  // 스프링에 있는 해당 객체(bean)을 가져와서 주입
	private DataSource ds;
	
	@Test   // 테스트 파일로 JUnit 돌리기
	public void DataSource있는지() {
		// DataSource 객체 필요할 경우 의존관계
		log.info(ds.toString()); // == log.info(ds+"");
	}
	
	@Test
	public void 디비연결확인() {
		try {
			Connection con = ds.getConnection();
			
			if(con != null) {
				log.info("DB 연결 성공");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
