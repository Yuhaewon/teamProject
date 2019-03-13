<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function returnLogin(){
	location.href="login";
}
</script>
<style>
body {
	background-color: #F5BCA9;
}

#wrap {
	margin: auto;
	margin-top: 70px;
	margin-bottom: 70px;
	border-radius: 10px;
	background-color: white;
	border: 3px solid #FE2E2E;
	width: 30%;
	height: 250px;
	padding-top: 3%;
	padding-left: 8%;
	padding-right: 8%;
}
#wrap2{
	padding-left: 15%;
}

table {
	text-align: center;
}

#lo_div3 {
	margin-top: 30px;
	margin-left: 70px;
}
</style>

</head>
<body>
	<div id="wrap">
		<div id="wrap2">
			<table>
				<tr>
					<td><h3>가입된 아이디</h3></td>
				</tr>
				<tr>
					<td><h5 style="color: red;">${SfindId}</h5></td>
				</tr>
			</table>
		</div>
		<div id="lo_div3">
			<input type="button" value="로그인하기" onclick="returnLogin()"
				class="btn btn-outline-primary" />
		</div>
	</div>
</body>
</html>
<%@include file="../footer.jsp"%>