<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
아이디 : ${param.id }는(은) 사용 가능한 아이디 입니다.<br>

<input type="button" id="checkIdOkBtn" value="사용하기" onclick="checkIdInput('${param.id }')">

<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="../js/member.js"></script>
</body>
</html>