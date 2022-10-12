<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>member/info.jsp</h1>
	<form action="" method="post">
		<fieldset>
			<legend>${userVO.userid }님의 회원정보</legend>
			<div>아이디 <input type="text" value="${userVO.userid }" name="userid" readonly="readonly"> </div>
			<div>비밀번호 <input type="password" value="${userVO.userpw }" name="userpw"> </div>
			<div>이름 <input type="text" value="${userVO.username }" name="username"> </div>
			<div>이메일 <input type="email" value="${userVO.useremail }" name="useremail"> </div>
			<div>회원가입일 ${userVO.regdate }</div>
		</fieldset>
		<input type="submit" value="수정하기"> <br>
		
		<a href="/member/main">메인 페이지</a>
		
	</form>
</body>
</html>