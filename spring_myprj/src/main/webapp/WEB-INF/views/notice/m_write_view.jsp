<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="resources/css/mstyle.css">
<title>Insert title here</title>
</head>
<style type="text/css">
body {
	background-color: #F5BCA9;
}
#mno_div {
	margin : auto;
	margin-top: 70px;
	border-radius: 10px;
	background-color: white;
	border: 3px solid #FE2E2E;
	width: 46%;
	height: 350px;
}
</style>
<body>
<div id="mno_div">
<%
String userIds=(String)session.getAttribute("userId");
%>
		<form action="mwrite" method="post">
		<table class="table table-hover">
			<tr>
				<td class="left">아이디</td>
				<td><input type="text" name="master" value="<%=userIds %>" size="30" readonly="readonly" class="form-control mr-sm-2"></td>
			</tr>
			<tr>
				<td class="left">제목</td>
				<td><input type="text" name="mTitle" size="30" class="form-control mr-sm-2"></td>
			</tr>
			<tr>
				<td class="left">내용</td>
				<td><textarea name="mContent" rows="6" cols="50" class="form-control mr-sm-2"></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
				<input type="submit" value="입력" class="btn btn-primary" style="float: right;" />&nbsp;&nbsp;
				<a href="list" style="float: left;">목록보기</a>
				</td>
			</tr>
		</table>
		</form>
</div>
</body>
</html>
<%@include file="../footer.jsp"%>