<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
	function user_infoCandC() {
		location.href = "/spring_myprj/mypageMain";
	}
	function user_faVideo() {
		location.href = "/spring_myprj/mypageFaVideo";
	}
	function user_insertVideo() {
		location.href = "/spring_myprj/mypageInserVideo";
	}

	function btn_changInfo() {
		document.all.userName.style.border = "1px solid #dddddd";
		document.all.userNick.style.border = "1px solid #dddddd";
		document.all.userAddr.style.border = "1px solid #dddddd";
		document.all.userphone.style.border = "1px solid #dddddd";
		document.all.eMail.style.border = "1px solid #dddddd";
		document.all.userInterests.style.border = "1px solid #dddddd";
		document.all.userPw.style.border = "1px solid #dddddd";

		document.all.userName.readOnly = false;
		document.all.userNick.readOnly = false;
		document.all.userAddr.readOnly = false;
		document.all.userphone.readOnly = false;
		document.all.eMail.readOnly = false;
		document.all.userInterests.readOnly = false;
		document.all.userPw.readOnly = false;

		document.all.changInfo.style.display = "none";
		document.all.changInfoOk.style.display = "inline";
	}
	function btn_changInfoOk() {
		document.all.userName.readOnly = true;
		document.all.userNick.readOnly = true;
		document.all.userAddr.readOnly = true;
		document.all.userphone.readOnly = true;
		document.all.eMail.readOnly = true;
		document.all.userInterests.readOnly = true;
		document.all.userPw.readOnly = true;

		document.all.changInfo.style.display = "inline";
		document.all.changInfoOk.style.display = "none";
	}
	function myDeleteBtn() {
		location.href="/spring_myprj/myDelete";
	}
</script>
<style>
body {
	background-color: #F5BCA9;
}
h4{
	margin-bottom: 4%;
}
#myMain_div {
	text-align: center;
	border: 3px solid white;
	height: 630px;
	width: 45%;
	margin: auto;
	margin-top: 5%;
	padding-top: 2%;
}
table{
width: 60%;
margin: auto;
text-align: center;
}
#changInfo{
margin-top: 2%;
}

#changInfoOk{
margin-top: 2%;
}
</style>
<title>Insert title here</title>
</head>
<body>
<div id="myMain_div">
	<input type="button" value="개인정보확인 및 변경" onclick="user_infoCandC()"
		id="infoCandC"  class="btn btn-primary" />
	<input type="button" value="즐겨찾기한 동영상" onclick="user_faVideo()"
		id="faVideo"  class="btn btn-primary" />
	<input type="button" value="내가올린 동영상" onclick="user_insertVideo()"
		id="insertVideo"  class="btn btn-primary" />
	<br>
	<br>

	<div id="m_userSelect">
		<fieldset>
			<h4>회원 정보 조회</h4>
			<form action="userModify">
				<c:forEach items="${myInfo}" var="myInfo">
					<table>
						<tr>
							<td>이름 :</td>
							<td><input type="text" name="userName" id="userName"
								value="${myInfo.userName}" readonly="readonly" /></td>
						</tr>
						<tr>
							<td>아이디 :</td>
							<td><input type="text" name="userId" id="userId"
								value="${myInfo.userId}" readonly="readonly" /></td>
						</tr>
						<tr>
							<td>닉네임 :</td>
							<td><input type="text" name="userNick" id="userNick"
								value="${myInfo.userNick}" readonly="readonly" /></td>
						</tr>
						<tr>
							<td>비밀번호 :</td>
							<td><input type="password" name="userPw" id="userPw"
								value="${myInfo.userPw}" readonly="readonly" /></td>
						</tr>
						<tr>
							<td>주소 :</td>
							<td><input type="text" name="userAddr" id="userAddr"
								value="${myInfo.userAddr}" readonly="readonly" /></td>
						</tr>
						<tr>
							<td>핸드폰번호 :</td>
							<td><input type="text" name="userphone" id="userphone"
								value="${myInfo.userPhone}" readonly="readonly"
								placeholder="예)010-0000-0000" /></td>
						</tr>
						<tr>
							<td>이메일 :</td>
							<td><input type="email" name="eMail" id="eMail"
								value="${myInfo.eMail}" readonly="readonly" /></td>
						</tr>
						<tr>
							<td>성별 :</td>
							<td><input type="text" name="userGender" id="userGender"
								value="${myInfo.userGender}" readonly="readonly" /></td>
						</tr>
						<tr>
							<td>생년월일 :</td>
							<td><input type="text" name="userIden" id="userIden"
								value="${myInfo.userIden}" readonly="readonly" /></td>
						</tr>
						<tr>
							<td>관심분야 :</td>
							<td><input type="text" name="userInterests"
								id="userInterests" value="${myInfo.userInterests}"
								readonly="readonly" /></td>
						</tr>
					</table>
				</c:forEach>
				<input type="button" value="정보변경하기" id="changInfo"
								onclick="btn_changInfo()"  class="btn btn-primary" />
				<input type="submit" value="저장" id="changInfoOk"
								onclick="btn_changInfoOk()" style="display: none;"  class="btn btn-primary" />
			</form>
				<input type="button" value="탈퇴하기" onclick="myDeleteBtn()"  class="btn btn-primary" style="margin-top: 2%;" />
		</fieldset>
	</div>
</div>

</body>
</html>
<%@include file="../footer.jsp"%>