<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	var sessionId = document.getElementById("sessionId").value;
	var listId = document.getElementById("listId").value;
	console.log('sessionId : ' + sessionId);
	console.log('listId : ' + listId);
	if (sessionId != listId) {
		$('#deleteN').hide();
		$('#modifyN').hide();
		$('#modifyNBtn').hide();
	}
	if (sessionId == listId) {
		$('#deleteN').show();
		$('#modifyN').hide();
		$('#modifyNBtn').show();
	}
});


function modifyBtn() {
	document.all.qTitle.readOnly = false;
	document.all.qCBerkioaontent.readOnly = false;
	$('#modifyN').show();
	$('#modifyNBtn').hide();
}

function modifyChackBtn() {
	document.all.qTitle.readOnly = true;
	document.all.qCBerkioaontent.readOnly = true;
	$('#modifyN').hide();
	$('#modifyNBtn').show();
}
</script>
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
	height: 640px;
}
#qcon_div2 {
	padding-left: 9%;
	padding-top: 2%;
}
</style>
<body>
<div id="qcon_div1">
<div id="qcon_div2">
	<form action="qmodify" method="post">
		<input type="hidden" name="qNum" value="${content_view.qNum }">
		<table>
			<tr>
				<td>번호</td>
				<td style="width: 500px;" class="form-control mr-sm-2">${content_view.qNum }</td>
			</tr>
			<tr>
				<td>조회수</td>
				<td style="width: 500px; class="form-control mr-sm-2">${content_view.qHit }</td>
			</tr>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="userId" id="listId"
					value="${content_view.userId }" readonly="readonly" class="form-control mr-sm-2" /></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="qTitle" id="qTitle"
					value="${content_view.qTitle }" readonly="readonly" class="form-control mr-sm-2" /></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="5" cols="30" name="qCBerkioaontent" style="height: 400px;"
				 readonly="readonly" id="qCBerkioaontent" class="form-control mr-sm-2">
						${content_view.qContent }</textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<a href="qlist" style="float: left;">목록보기</a>&nbsp;&nbsp; 
				<%
					String userIdm=(String)session.getAttribute("userId");
				%>
				<input type="hidden" value="<%=userIdm%>" id="sessionId">
				<input type="button" value="수정하기" onclick="modifyBtn()" id="modifyNBtn" class="btn btn-outline-primary" style="float: right;">
				<input type="submit" value="수정확인"  id="modifyN" onclick="modifyChackBtn()" class="btn btn-outline-primary" style="float: right;" />&nbsp;&nbsp;
					<a id="deleteN" href="qdeleted?qNum=${content_view.qNum }">삭제</a>&nbsp;&nbsp; 
					<%
					if(userIdm.equals("masterH")){ 
					%>
					<a href="qreply_view?qNum=${content_view.qNum }">답변</a>
					<%} %>
					</td>
			</tr>
		</table>
	</form>
	</div>
	</div>
</body>
</html>
<%@include file="../footer.jsp"%>