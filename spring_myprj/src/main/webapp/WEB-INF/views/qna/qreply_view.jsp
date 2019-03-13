<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
body {
	background-color: #F5BCA9;
}
#qcon_div1 {
	margin : auto;
	margin-top: 70px;
	margin-bottom: 70px;
	border-radius: 10px;
	background-color: white;
	border: 3px solid #FE2E2E;
	width: 37%;
	height: 650px;
}
#qcon_div2 {
	padding-left: 9%;
	padding-top: 2%;
}
</style>
<body>
<div id="qcon_div1">
	<div id="qcon_div2">
		<form action="qreply" method="post">
			<input type="hidden" name="qNum" value="${reply_view.qNum }" /> <input
				type="hidden" name="qGroup" value="${reply_view.qGroup }" /> <input
				type="hidden" name="qStep" value="${reply_view.qStep }" /> <input
				type="hidden" name="qIndent" value="${reply_view.qIndent }" />
			<table>

			<tr>
				<td>번호</td>
				<td style="width: 500px;" class="form-control mr-sm-2">${reply_view.qNum }</td>
			</tr>
			<tr>
				<td>조회수</td>
				<td style="width: 500px;" class="form-control mr-sm-2">${reply_view.qHit }</td>
			</tr>
			<tr>
				<td>닉네임</td>
				<td style="width: 500px;" class="form-control mr-sm-2">${reply_view.userId }</td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="qTitle"  style="width: 500px;" class="form-control mr-sm-2"
				value="${reply_view.qTitle }"/></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="5" cols="50" name="qContent" style="height: 400px;"
				 id="qCBerkioaontent" class="form-control mr-sm-2">
				${reply_view.qContent }</textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="답변" class="btn btn-outline-primary" style="float: right;" />
			</tr>
		</table>
	</form>
	</div>
	</div>
</body>
</html>
<%@include file="../footer.jsp"%>