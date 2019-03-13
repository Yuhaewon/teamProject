<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../header.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="resources/css/mstyle.css">
<title>Insert title here</title>
<style>
body {
	background-color: #F5BCA9;
}

h3 {
	text-align: center;
	margin-top: 50px;
	margin-bottom: 50px;
}

#notice_div {
	text-align: center;
	border: 3px solid white;
	width: 71%;
	margin: auto;
	display: inline;
	float: left;
}

#notice_div_table {
	text-align: center;
	border-radius: 20px;
}

#mn_h {
	color: black;
	margin-top: 10px;
}

#m_gu {
	float: left;
	display: inline;
	padding-top: 5%;
}
#m_div {
	width : 100%;
	height: 800px;
}
</style>
</head>
<body>
<div id="m_div">
	<h3 id="mn_h">공지게시판</h3>
	<div id="m_gu">
		<img alt="gu"
			src="${pageContext.request.contextPath}/resources/image/gu.png"
			width="530px" height="350px" />
	</div>
	<div id="notice_div">
		<table id="notice_div_table" class="table table-hover">
			<tr>
				<th>이름</th>
				<th>제목</th>
				<th>날짜</th>
				<th>히트</th>
			</tr>
			<c:forEach items="${lists }" var="dto">
				<tr>
					<td>${dto.master }</td>
					<td><a href="m_content_view?master=${dto.master }">${dto.mTitle }</a></td>
					<td>${dto.mDate }</td>
					<td>${dto.mHit }</td>
				</tr>
			</c:forEach>
			<%
				String userIdm = (String) session.getAttribute("userId");
				if (userIdm.equals("masterH")) {
			%>
			<tr>
				<td colspan="4"><a href="m_write_view">글작성</a></td>
			</tr>
			<%
				}
			%>
		</table>
	</div>
	</div>
</body>
</html>
<%@include file="../footer.jsp"%>