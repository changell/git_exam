<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.bean.BoardDTO" %>
<%@ page import="board.dao.BoardDAO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
th {
	font-size: 16px;
}
td {
	font-size: 13px;
}
#subjectA:link { color: black; text-decoration: none;}
#subjectA:visited {color: black; text-decoration: none;}
#subjectA:hover {color: darkgreen; text-decoration: underline;}
#subjectA:active {color: black; text-decoration: none;}
#currentPaging {
	color: red;
	text-decoration: underline;
}
#paging {
	color: black;
	text-decoration: none;
}
</style>
</head>
<body>
<table cellspacing="0" cellpadding="5" frame="hsides" rules="rows" border="1">
	<tr>
		<th width="100" >글번호</th>
		<th width="300" >제목</th>
		<th width="100" >작성자</th>
		<th width="100" >조회수</th>
		<th width="100" >작성일</th>
	</tr>	
	<c:if test="${list != null }">
		<c:forEach var="boardDTO" items="${list }">
			<tr>
				<td align="center">${boardDTO.getSeq() }</td>
				<td>
					<a href="boardView.do?seq=${boardDTO.getSeq()}&pg=${param.pg}" id="subjectA">${boardDTO.getSubject() }</a>
				</td>
				<td align="center">${boardDTO.getId() }</td>
				<td align="center">${boardDTO.getHit() }</td>
				<td align="center">${boardDTO.getLogtime() }</td>
			</tr>
		</c:forEach>
	</c:if>
</table>
<div style="width: 750px; text-align: center">
	<c:forEach var="i" begin="1" end="${totalP }" step="1">
		<c:if test="${i == pg }">
			[<a href="boardList.do?pg=${i }" id="currentPaging">${i}</a>]
		</c:if>
		<c:if test="${i != pg }">
			[<a href="boardList.do?pg=${i }" id="paging">${i}</a>]
		</c:if>
	</c:forEach>
</div>
</body>
</html>