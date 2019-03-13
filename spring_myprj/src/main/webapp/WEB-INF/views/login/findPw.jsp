<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function findEmail(){
	location.href="#";
}
function findPwHint(){
	location.href="findPwHint";
}
function returnLogin(){
	location.href="login";
}
</script>
<style type="text/css">
body {
	background-color: #F5BCA9;
}

#fpw_div {
	margin: auto;
	margin-top: 70px;
	margin-bottom: 70px;
	border-radius: 10px;
	background-color: white;
	border: 3px solid #FE2E2E;
	width: 30%;
	height: 400px;
}

#fpw_h {
	text-align: center;
	color: #FE2E2E;
	margin-top: 10%;
}

#fpw_div2 {
	text-align: center;
	margin-top: 50px;
}
</style>
</head>
<body>
<div id="fpw_div">
<h3 id="fpw_h">비밀번호 찾기</h3>
<div id="fpw_div2">
	<input type="button" value="이메일인증" onclick="findEmail()" class="btn btn-outline-primary"><br><br>
	<input type="button" value="비밀번호 힌트로 찾기" onclick="findPwHint()" class="btn btn-outline-primary"><br><br>
	<input type="button" value="로그인하기" onclick="returnLogin()"class="btn btn-outline-primary">
</div>
</div>
</body>
</html>
<%@include file="../footer.jsp"%>