<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
	border-collapse: collapse;
}
div{
	font-size: 8pt;
	color: red;
	font-weight: bold;
}
</style>
</head>
<body>
<h2>글쓰기</h2>
<form name="boardWriteForm" method="post" action="http://localhost:8080/mvcmember/board/boardWrite.do"> <!--~do 서블릿  -->
	<table cellspacing="0" cellpadding="5" border="1">
		<tr>
			<td width="50" align="center">제목</td>
			<td>
				<input type="text" id="subject" name="subject" size="40" placeholder="제목 입력" style="width: 350px">
				<div id="subjectDiv"></div>
			</td>
		</tr>
		<tr>
			<td width="100" align="center">내용</td>
			<td>
				<textarea id="content" name="content" cols="50" rows="15" placeholder="내용 입력"></textarea>
				<div id="contentDiv"></div>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="글쓰기" name="boardWriteBtn" id="boardWriteBtn">
				<input type="reset" value="다시작성" name="restBtn" id="restBtn">
			</td>
		</tr>
	</table>
</form>
<script type="text/javascript" src="http://localhost:8080/mvcmember/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="../js/board.js"></script>
</body>
</html>