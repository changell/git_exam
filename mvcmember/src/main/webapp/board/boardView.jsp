<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
	border-collapse: collapse;
}
table tr{
	border-bottom: 1px solid;
	border-top: 1px solid;
}
table td{
	font-size: 10px;
}
input{
	align: left;
}
</style>
</head>
<body>
	<table boarder="1" cellspacing="0" cellpadding="5" frame="hsides" rules="rows">
		<tr>
			<td colspan="3"><h3>${boardDTO.getSubject()}</h3></td>
		</tr>
		
		<tr>
			<td width="150" align="center">글번호 : ${boardDTO.getSeq()}</td>
			<td width="150" align="center">작성자 : ${boardDTO.getName()}</td>
			<td width="150" align="center">조회수 : ${boardDTO.getHit()}</td>
		</tr>
		
		<tr>
			<td colspan="3" height="200" valign="top">
				<pre>${boardDTO.getContent()}</pre>
			</td>
		</tr>	
	</table>
	<input type="button" id="boardListBtn" name="boardListBtn" onclick="location.href='boardList.do?pg=${pg}'" value="목록" />
</body>
</html>