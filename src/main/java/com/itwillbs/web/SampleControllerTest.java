package com.itwillbs.web;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

//스프링MVC 전용 테스트 파일을 위한 애너테이션 3개
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration 
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class SampleControllerTest {
	// 컨트롤러의 역할을 대신하는 테스트 파일이기 때문에 @Controller를 적지 않음.

	private static final Logger log = LoggerFactory.getLogger(SampleControllerTest.class);	
	
	// 객체 주입
	@Inject
	private WebApplicationContext waCTX; // 웹 프로젝트 객체 
	@Inject
	private MockMvc mocMvc;  // 브라우저에서 요청/응답 처리 객체
	@Before // @Test 전에 실행
	public void setUp() {
		this.mocMvc = MockMvcBuilders.webAppContextSetup(this.waCTX).build();
		log.info("테스트 사전 준비 완료");
	}
	
	@Test
	public void testDoA() {
		log.info("Junit 실행 테스트");
		
		try {
			mocMvc.perform(MockMvcRequestBuilders.get("/doA"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
