<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
아이디 : ${param.id }는(은) 불가능한 아이디 입니다.<br>
<form action="http://localhost:8080/mvcmember/member/checkId.do">
아이디 : <input type="text" name="id" id="id" placeholder="아이디 입력">
<input type="submit" id="checkIdBtn" value="중복체크" >
</form>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="../js/member.js"></script>
</body>
</html>