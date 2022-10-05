package com.itwillbs.web;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.jsp.tagext.TryCatchFinally;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MysqlConnectTest {
	// Junit으로 테스트 수행하는 클래스
//	private static final Logger mylog = LoggerFactory.getLogger(MysqlConnectTest.class);
	private static final Logger log = LoggerFactory.getLogger(MysqlConnectTest.class);
	
	
	@Before // 애너테이션을 붙인 뒤 Junit으로 테스트 실행 가능
	public void test() throws Exception {
		System.out.println("MysqlConnectionTest_test() 호출");
		System.out.println("테스트 클래스 실행됨");
	}
	
	@Test
	public void 디비연결테스트() throws Exception {
		System.out.println("디비연결테스트() 수행");
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("드라이버 로드 성공 ");
		
		// try-catch-finally 
//		Connection con = null;
//		try {
//			con = DriverManager.getConnection(
//					"jdbc:mysql://localhost:3306/springdb", "root", "1234");
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			con.close();
//		}

		// try-with 
		// try(자원 해제가 필요한 객체 사용 
		//	 -> autoClosable 인터페이스를 상속한 객체만 가능) {
		//   예외가 발생할만한 코드
		// } catch(Exception e) {
		// 	 예외처리 코드
		// }
		try(Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/springdb", "root", "1234")) {
			System.out.println("디비 연결 성공");
			System.out.println("con : "+con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		

		
	}
}
