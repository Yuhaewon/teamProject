<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	background-color: #F5BCA9;
}
h3{
text-align: center;
margin-top: 50px;
margin-bottom: 50px;
}
#jo_div {
	margin : auto;
	margin-top: 70px;
	border-radius: 10px;
	background-color: white;
	border: 3px solid #FE2E2E;
	width: 46%;
	height: 350px;
}
</style>
</head>
<body>
	
	<h3>질문게시글 작성 중입니다!</h3>
	<div id="jo_div">
		<form action="qwrite" method="post">
	<table id="qna_div_table" class="table table-hover">
			<tr>
				<td>아이디</td>
				<%
				String userIds=(String)session.getAttribute("userId");
				%>
				<td><input type="text" value="<%=userIds %>" size="30" readonly="readonly" style="width: 500px;" /></td>

			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="qTitle" size="30" style="width: 500px; "  /></td>

			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="qContent" rows="6" cols="50" style="width: 500px;" ></textarea></td>

			</tr>
			<tr>
				
				<td colspan="2">
				<button type="submit" class="btn btn-primary" style="float: right;" >입력 </button>&nbsp;&nbsp;
				<a href="qlist" style="float: left;">목록보기</a>&nbsp;&nbsp;
				</td>
			</tr>
		</table>
	</form>
	</div>	
</body>
</html>
<%@include file="../footer.jsp"%>
