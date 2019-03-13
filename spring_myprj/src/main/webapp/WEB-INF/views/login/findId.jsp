<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/1.9.0/jquery.js"></script>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.min.js"></script>
<style>
body {
	background-color: #F5BCA9;
}

#fid_div {
	margin: auto;
	margin-top: 70px;
	margin-bottom: 70px;
	border-radius: 10px;
	background-color: white;
	border: 3px solid #FE2E2E;
	width: 30%;
	height: 400px;
}

#fid_h {
	text-align: center;
	color: #FE2E2E;
	margin-top: 7%;
}

#fid_div2 {
	margin-left: 25%;
	margin-top: 15%;
}

#fid_div3 {
	margin-left: 23%;
	margin-top: 50px;
}
</style>
</head>
<body>
	<div id="fid_div">
		<h3 id="fid_h">아이디 찾기</h3>
		<div id="fid_div2">
			<form action="findId">
				<table>
					<tr>
						<td>이&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;름      :</td>
						<td><input name="findName" type="text"
							class="form-control mr-sm-2" /></td>
					</tr>
					<tr>
						<td>생년월일 :</td>
						<td><input name="findbirth" type="text"
							class="form-control mr-sm-2" /></td>
					</tr>
				</table>
				<div id="fid_div3">
					<tr>
						<td><input type="submit" value="확인"
							class="btn btn-outline-primary" /></td>
					</tr>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
<%@include file="../footer.jsp"%>