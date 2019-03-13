<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
	function returnLogin() {
		location.href = "login";
	}
</script>
<style>
body {
	background-color: #F5BCA9;
}

#SFP_h {
	text-align: center;
	color: #FE2E2E;
	margin-top: 7%;
}

#sfp_div {
	margin: auto;
	margin-top: 70px;
	margin-bottom: 70px;
	border-radius: 10px;
	background-color: white;
	border: 3px solid #FE2E2E;
	width: 30%;
	height: 350px;
}
#sfp_div2{
	padding-top:5%;
	padding-left: 39%;
	padding-right: 39%;
}
#sfp_div3{
padding-top:5%;
text-align: center;
}
#sfp_div4{
padding-top:5%;
text-align: center;
}

table {
	text-align: center;
}
</style>
</head>
<body>
	<div id="sfp_div">
			<h3 id="SFP_h">SuccessFindPw</h3>
		<div id="sfp_div2">
			<table>
				<tr>
					<td><h5>임시비밀번호</h5></td>
				</tr>
				<tr>
					<td style="color: red;">${SfindPw}</td>
				</tr>
			</table>
		</div>
		<div id="sfp_div3">
			<label>로그인 후 비밀번호를 변경해주세요</label>
		</div>
		<div id="sfp_div4">
			<input type="button" value="로그인하기" onclick="returnLogin()" />
		</div>
	</div>
</body>
</html>
<%@include file="../footer.jsp"%>