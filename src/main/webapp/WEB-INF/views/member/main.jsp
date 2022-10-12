<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>member/main.jsp</h1>
	
	<h3>메인 페이지</h3>
	

	<%if(session.getAttribute("loginVO") != null) { %>
		${loginVO.userid }님 환영합니다. <br>
		${sessionScope.loginVO.userid }님 환영합니다. <br>
		<input type="button" value="로그아웃" onclick="location.href='/member/logout';"> <br>
		
		<input type="button" value="회원정보 조회" onclick="location.href='/member/info';">
	<%} else {%>
		<input type="button" value="로그인" onclick="location.href='/member/login';">
	<%} %>
	
	
</body>
</html>