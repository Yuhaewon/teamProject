<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script>
	function join() {
		location.href = "join";
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
	height: 400px;
	padding-top: 3%;
	padding-left: 6%;
	padding-right: 6%;
}

#lo_div2 {
	margin-left: 70px;
}

#lo_div3 {
	margin-top : 30px;
	margin-left: 70px;
}

</style>
</head>
<body>
	<div id="wrap">
			<form method="post" action="loginAction"
				onsubmit="return checkValue()">
				<br>
				<table>
					<tr>
						<td>아 이 디 : &nbsp;<br></td>
						<td><input type="text" name="userId" maxlength="30"
							class="form-control mr-sm-2"><br></td>
					</tr>
					<tr>
						<td>비밀번호 : &nbsp;<br></td>
						<td><input type="password" name="userPw" maxlength="30"
							class="form-control mr-sm-2"></td>
					</tr>
				</table>
				<div id="lo_div2">
				<br> <input type="submit" class="btn btn-outline-primary"
					value="로그인" />&nbsp;&nbsp;&nbsp;

				<button type="button" class="btn btn-outline-primary"
					onclick="join()">회원가입</button>
					</div>
				<br>
				<div id="lo_div3">
				 <a href="findIdview">아이디 찾기</a>
				&nbsp;<a href="findPwview">비밀번호 찾기</a> <br>
				</div>
				<%
					String error = (String) session.getAttribute("error");
					if (error != null) {
				%>
				<br>
				<input type="text" id="check" value="<%=error%>" style="width: 300px; text-align: center; margin-left: 20px;" readonly="readonly" />
				<%
					session.invalidate();
					}
				%>
			</form>
	</div>
</body>
</html>
<%@include file="../footer.jsp"%>