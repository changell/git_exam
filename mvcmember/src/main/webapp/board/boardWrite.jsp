<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!--
<h3>글쓰기 성공.</h3>
<br>
<input type="button" id="boardListBtn" value="글목록" onclick="location.href='/mvcmember/board/boardList.do?pg=1'">
 -->

<script type="text/javascript">
window.onload=function(){
	alert("글쓰기 성공");
	location.href="/mvcmember/board/boardList.do?pg=1";
}
</script>
</body>
</html>