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

#fpwhint_div {
	margin: auto;
	margin-top: 70px;
	margin-bottom: 70px;
	border-radius: 10px;
	background-color: white;
	border: 3px solid #FE2E2E;
	width: 35%;
	height: 450px;
	text-align: center;
}

#fpwhint_div2 {
	margin-top: 10%;
	padding-left: 20%;
	padding-right: 20%;
}

#fpwhint_div3 {
	margin-top: 7%;
	margin-bottom : 4%;
	padding-left: 27%;
	padding-right: 27%;
}

#fpwhint_h {
	text-align: center;
	color: #FE2E2E;
	margin-top: 10%;
}
</style>
</head>
<body>
	<div id="fpwhint_div">
		<h3 id="fpwhint_h">비밀번호 힌트로 찾기</h3>
		<form action="checkPwhint">
			<div id="fpwhint_div2">
				<table>
					<tr>
						<td>아이디<br></td>
						<td><input type="text" name="checkId"
							class="form-control mr-sm-2"></td>
					</tr>
					<tr>
						<td>비밀번호 힌트<br></td>
						<td><select name="checkPwhintList"
							class="form-control mr-sm-2">
								<option value="자신이 태어난곳은?">자신이 태어난곳은?</option>
								<option value="어머니 성함은?">어머니 성함은?</option>
								<option value="아버지 성함은?">아버지 성함은?</option>
								<option value="자신의 보물 1호는?">자신의 보물 1호는?</option>
								<option value="자신이 졸업한 학교이름은?">자신이 졸업한 학교이름은?</option>
								<option value="자신이 키운 애완동물 이름은?">자신이 키운 애완동물 이름은?</option>
								<option value="자신이 살고있는 동네는?">자신이 살고있는 동네는?</option>
								<option value="가장 좋아하는 음식은?">가장 좋아하는 음식은?</option>
								<option value="가장 추억에 남는 장소는?">가장 추억에 남는 장소는?</option>
								<option value="가장 좋아하는 가수는?">가장 좋아하는 가수는?</option>
								<option value="즐겨듣는 음악은?">즐겨듣는 음악은?</option>
						</select></td>
					</tr>
				</table>
			</div>
			<div id="fpwhint_div3">
				<input type="text" maxlength="20" placeholder="답 입력"
					name="checkPwhint" class="form-control mr-sm-2" id="answer"
					style="width: 300px" />
					<br><br> 
				<input type="submit" value="확인"class="btn btn-outline-primary" />
			</div>
		</form>
	</div>
</body>
</html>
<%@include file="../footer.jsp"%>