<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
	function back() {
		location.href = "login";
	}
	$(function() {
		//전체선택 체크박스 클릭 
		$("#allCheck").click(function() {
			//만약 전체 선택 체크박스가 체크된상태일경우 
			if ($("#allCheck").prop("checked")) {
				//해당화면에 전체 checkbox들을 체크해준다 
				$("input[type=checkbox]").prop("checked", true);
				// 전체선택 체크박스가 해제된 경우
			} else {
				//해당화면에 모든 checkbox들의 체크를해제시킨다. 
				$("input[type=checkbox]").prop("checked", false);
			}
		});
	});


	function pwk() {
		var userPw = document.getElementById("userPw").value;
		var userPwCheck = document.getElementById("userPwCheck").value;

		if (userPwCheck == "") {
			document.getElementById("userPwCheckText").innerHTML = "<b><font color=red size=3px>패스워드를 입력하세요.</font><b>"
		} else if (userPw != userPwCheck) {
			document.getElementById("userPwCheckText").innerHTML = "<b><font color=red size=3px>패스워드가 일치하지 않습니다</font><b>"
		} else {
			document.getElementById("userPwCheckText").innerHTML = "<b><font color=blue size=3px>패스워드가 일치합니다.</font><b>"
		}
	}
</script>

<style>
body {
	background-color: #F5BCA9;
}

#jo_div {
	margin : auto;
	margin-top: 70px;
	margin-bottom: 70px;
	border-radius: 10px;
	background-color: white;
	border: 3px solid #FE2E2E;
	width: 46%;
	height: 700px;
}

#jo_div2 {
	margin: auto;
	margin-top: 50px;
	margin-left: 2%;
}

#jo_div3 {
	margin-left: 40%;
	margin-top: 9%;
}

.jo {
	border: 2px solid #F5BCA9;
	border-radius: 5px;
}
</style>
</head>
<body>
	<form action="joinForm" method="post">
		<div id="jo_div">
			<div id="jo_div2">
				<table>
					<tr>
						<td>아이디</td>
						<td><input type="text" name="userId" id="userId"
							maxlength="50" class="jo"></td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td><input type="password" name="userPw" id="userPw"
							class="jo" maxlength="50"></td>
					</tr>
					<tr>
						<td>비밀번호 확인</td>
						<td><input type="password" name="userPwCheck"
							id="userPwCheck" class="jo" maxlength="50" onkeyup="pwk()"><br></td>
						<td id="userPwCheckText"></td>
					</tr>
					<tr>
						<td>이름</td>
						<td><input type="text" name="userName" maxlength="50"
							class="jo" /></td>
					</tr>
					<tr>
						<td>핸드폰</td>
						<td><input type="text" name="userPhone" maxlength="13"
							placeholder="예)010-0000-0000" class="jo" /></td>
					</tr>
					<tr>
						<td>이메일</td>
						<td><input type="text" name="email1" id="email1"
							maxlength="50" class="jo" />@ <!-- <input type="text" name="email2" id="email2" maxlength="50" disabled value="naver.com" /> -->
							<select id="email2" name="email2" class="jo">
								<!-- <option value="1">직접입력</option> -->
								<option value="naver.com" selected>naver.com</option>
								<option value="hanmail.net">hanmail.net</option>
								<option value="hotmail.com">hotmail.com</option>
								<option value="nate.com">nate.com</option>
								<option value="yahoo.co.kr">yahoo.co.kr</option>
								<option value="empas.com">empas.com</option>
								<option value="dreamwiz.com">dreamwiz.com</option>
								<option value="freechal.com">freechal.com</option>
								<option value="lycos.co.kr">lycos.co.kr</option>
								<option value="korea.com">korea.com</option>
								<option value="gmail.com">gmail.com</option>
								<option value="hanmir.com">hanmir.com</option>
								<option value="paran.com">paran.com</option>

						</select></td>
					</tr>
					<tr>
						<td>성별</td>
						<td><input type="radio" name="userGender" value="남" />남
						 <input type="radio" name="userGender" value="여" />여
							</td>
					</tr>
					<tr>
						<td>생년월일</td>
						<td><input type="text" name="userIden1" maxlength="4"
							placeholder="년(4자)" size="6" class="jo"> <select
							name="userIden2" class="jo">
								<option value="" class="jo">월</option>
								<c:forEach begin="1" end="12" step="1" var="mnum">
									<option>${mnum }</option>
								</c:forEach>
						</select> <select name="userIden3">
								<option value="" class="jo">일</option>
								<c:forEach begin="1" end="31" step="1" var="dnum">
									<option>${dnum }</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<td>주소</td>
						<td><input type="text" size="50" name="userAddr" class="jo"></td>
					</tr>
					<tr>
						<td>비밀번호 힌트</td>
						<td><select name="userPwhintList" class="jo">
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
						<!-- <input type="text" size="20" name="userPwhint"
					placeholder="직접입력"></td> -->
					</tr>
					<tr>
						<td></td>
						<td><input type="text" maxlength="50" placeholder="답 입력"
							name="userPwhint" class="jo"></td>
					</tr>
					<tr>
						<td>관심분야</td>
						<td><input type="checkbox" name="userInterests" value="코믹">코믹
							<input type="checkbox" name="userInterests" value="멜로">멜로
							<input type="checkbox" name="userInterests" value="액션">액션
							<input type="checkbox" name="userInterests" value="성인">성인
							<input type="checkbox" name="userInterests" value="공포,호러">공포,호러</td>
					</tr>
					<tr>
						<td></td>
						<td><input type="checkbox" name="userInterests" value="게임">게임
							<input type="checkbox" name="userInterests" value="요리">요리
							<input type="checkbox" name="userInterests" value="뷰티">뷰티
							<input type="checkbox" name="userInterests" value="동물">동물
							<input type="checkbox" name="userInterests" value="패션">패션</td>
					</tr>
					<tr>
						<td></td>
						<td><input type="checkbox" name="userInterests" value="영화">영화
							<input type="checkbox" name="userInterests" value="드라마">드라마
							<input type="checkbox" name="userInterests" value="시사">시사
							<input type="checkbox" name="userInterests" value="다큐멘터리">다큐멘터리
							<input type="checkbox" name="userInterests" value="음악">음악</td>
					</tr>
					<tr>
						<td></td>
						<td><input type="checkbox" name="userInterests" value="스포츠">스포츠
							<input type="checkbox" name="userInterests" value="인강">인강
							<input type="checkbox" name="userInterests" value="유아">유아
							<input type="checkbox" name="userInterests" value="예능">예능
							<input type="checkbox" name="userInterests" value="전체"
							id="allCheck">전체</td>
					</tr>
					<tr>
						<td>닉네임</td>
						<td><input type="text" name="userNick" maxlength="50"
							class="jo"></td>
					</tr>
				</table>
			</div>
			<div id="jo_div3">
				<input type="submit" value="가입" class="btn btn-outline-primary">
				<input type="button" value="취소" class="btn btn-outline-primary" onclick="back()" />
			</div>
		</div>
	</form>
</body>
</html>
<%@include file="../footer.jsp"%>