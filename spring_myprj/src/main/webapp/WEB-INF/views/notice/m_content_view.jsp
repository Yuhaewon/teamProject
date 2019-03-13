<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
function modify_Btn() {
	document.all.master.readOnly = false;
	document.all.mTitle.readOnly = false;
	document.all.mContent.readOnly = false;
	document.all.modify_Btns.style.display = "none";
	document.all.modify_Btn_sucs.style.display = "inline";
}
function modify_Btn_suc() {
	document.all.master.readOnly = true;
	document.all.mTitle.readOnly = true;
	document.all.mContent.readOnly = true;
	document.all.modify_Btn_sucs.style.display = "none";
	document.all.modify_Btns.style.display = "inline";
}
</script>
<style>
body {
	background-color: #F5BCA9;
}
h3{
	text-align: center;
	padding-top: 2%;
}
#ma_content_div{
	margin : auto;
	margin-top: 70px;
	margin-bottom: 70px;
	border-radius: 10px;
	background-color: white;
	border: 3px solid #FE2E2E;
	width: 30%;
	height: 710px;
	padding-left: 2%;
	padding-right: 2%;
}
#hit_tr{
	text-align: right;
}
</style>
<body>
	<h3>공지게시판 입니다!</h3>
	<div id="ma_content_div">
		<form action="m_modify" method="post">
			<input type="hidden" name="master" value="${content_view.master }" />
			<input type="hidden" name="mNum" value="${content_view.mNum }" />
			<table>
			<%-- <tr>
				<td>번호</td>
				<td>${content_view.mNum }</td>
			</tr> --%>
			<tr id="hit_tr" >
				<td colspan="2" style="color: red;"><br>조회수 : ${content_view.mHit } <br></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" id="master" name="master" value="${content_view.master }" class="form-control mr-sm-2" readonly="readonly" /></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" id="mTitle" name="mTitle" value="${content_view.mTitle }" class="form-control mr-sm-2" readonly="readonly" /></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea id="mContent" rows="20" cols="50" name="mContent" class="form-control mr-sm-2" readonly="readonly">${content_view.mContent }</textarea></td>
			</tr>
			<tr>
				<td colspan="2">
				<%
					String userIds=(String)session.getAttribute("userId");
				if(userId.equals("masterH")){
				%>
					<input type="button" id="modify_Btns" onclick="modify_Btn()" value="수정" class="btn btn-outline-primary" style="float: right ;"/>&nbsp;&nbsp;
					<input type="submit" id="modify_Btn_sucs" onclick="modify_Btn_suc()" value="수정완료" style="display: none;" class="btn btn-outline-primary" style="float: right ;"/>&nbsp;&nbsp;
					<a href="mdelete?mNum=${content_view.mNum }" style="float: left; margin-left:30px; margin-right: 10px;">삭제</a>
				<%
				}
				%>
					<a href="list" style="float: left; margin-left:30px; margin-right: 10px;">목록보기</a>
				</td>
			</tr>
		</table>
		</form>
		</div>
</body>
</html>
<%@include file="../footer.jsp"%>