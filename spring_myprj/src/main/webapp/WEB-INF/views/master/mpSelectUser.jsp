<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	function btn_comResult() {
		document.all.cUserId.style.border = "1px solid #dddddd";
		$('#cUserNick').prop('readonly', false);
		document.all.comResultOk.style.display = "inline";
		document.all.comResult.style.display = "none";
	}
	function btn_comResultOk() {
		document.all.comResultOk.style.display = "none";
		document.all.comResult.style.display = "inline";
		$('#cUserNick').prop('readonly', true);
	}
	function master_userSelect(userId) {
		location.href = "choiceUser?choiceUserId=" + userId;
	}
	function master_userNotice(userId2) {
		location.href = "mpUserVideo?choiceUserId=" + userId2;
	}
	function master_userComment(userId3) {
		location.href = "mpUserComment?choiceUserId=" + userId3;
		console.log("userId3 : " + userId3);
	}
	function master_userSelect2(userId) {
		location.href = "choiceUser?choiceUserId=" + userId;
	}
	function master_userNotice2(userId2) {
		location.href = "mpUserVideo?choiceUserId=" + userId2;
	}
	function master_userComment2(userId3) {
		location.href = "mpUserComment?choiceUserId=" + userId3;
		console.log("userId3 : " + userId3);
	}
</script>
<style>
body {
	background-color: #F5BCA9;
}

#pageChange {
	display: inline;
}

#infoPage {
	display: block;
}

#sUser {
	display: inline;
	width: 400px;
}

#sUser_sub {
	display: inline;
}
#all_div{
	width: 100%;
	height: 700px;
}
#mps_div {
	text-align: center;
	border: 3px solid white;
	height: 550px;
	width: 50%;
	margin: auto;
	margin-top: 5%;
	padding-top: 2%;
	display: inline;
	float: left;
}
#m_userSelect{
	text-align: center;
	border: 3px solid white;
	height: 550px;
	width: 50%;
	margin: auto;
	margin-top: 5%;
	padding-top: 2%;
	padding-left : 10%;
	display: inline;
	float: left;
}
#m_userNotice {
	text-align: center;
	border: 3px solid white;
	height: 550px;
	width: 50%;
	margin: auto;
	margin-top: 5%;
	padding-top: 2%;
	display: inline;
	float: left;
}
#m_userComment {
	text-align: center;
	border: 3px solid white;
	height: 550px;
	width: 50%;
	margin: auto;
	margin-top: 5%;
	padding-top: 2%;
	display: inline;
	float: left;
}
#mps_div_table {
	padding-left: 5%;
}
</style>
<body>
<div id="all_div">
	<div id="mps_div">
		<form action="serchUser">
			<input type="text" name="sUser" id="sUser"
				placeholder="아이디 또는 이름으로 회원찾기" class="form-control mr-sm-2">
			<input type="submit" value="검색" class="btn btn-primary"
				id="sUser_sub">
		</form>
		<br>
		<br>
		<div id="mps_div_table">
			<table>
				<tr>
					<th>이름</th>
					<th>아이디</th>
					<th>닉네임</th>
				</tr>
				<c:forEach items="${selectAll}" var="sa">

					<tr>
						<td>${sa.userName}</td>
						<td>${sa.userId}</td>
						<td>${sa.userNick}</td>
						<td><input type="button" value="회원 정보보기"
							onclick="master_userSelect('${sa.userId}')"
							class="btn btn-primary" /></td>
						<td><input type="button" value="회원 게시물보기"
							onclick="master_userNotice('${sa.userId}')"
							class="btn btn-primary" /></td>
						<td><input type="button" value="회원 댓글보기"
							onclick="master_userComment('${sa.userId}')"
							class="btn btn-primary" /></td>
					</tr>
				</c:forEach>
			</table>
			<table border="1">
				<c:forEach items="${seUser}" var="se">
					<tr>
						<td>${se.userName}</td>
						<td>${se.userId}</td>
						<td>${se.userNick}</td>
						<td><input type="button" value="회원 정보보기"
							onclick="master_userSelect2('${se.userId}')"
							class="btn btn-primary" /></td>
						<td><input type="button" value="회원 게시물보기"
							onclick="master_userNotice2('${se.userId}')"
							class="btn btn-primary" /></td>
						<td><input type="button" value="회원 댓글보기"
							onclick="master_userComment2('${se.userId}')"
							class="btn btn-primary" /></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<div id="m_userSelect">
		<fieldset>
			<form action="nickModify">
				<input type="hidden" name="userId" id="userId0"
					value="${cUser.userId }" /> <input type="hidden" name="userNick"
					id="userNick0" value="${cUser.userNick }" /> <input type="hidden"
					name="userNum" id="userNum0" value="${cUser.userNum }" />
				<table>
					<caption>회원 정보 조회</caption>
					<tr>
						<td>이름 :</td>
						<td><input type="text" name="userName"
							value="${cUser.userName}" readonly="readonly"
							class="form-control mr-sm-2"></td>
					</tr>
					<tr>
						<td>아이디 :</td>
						<td><input type="text" id="cUserId" name="CuserId"
							value="${cUser.userId}" readonly="readonly"
							class="form-control mr-sm-2"></td>
					</tr>
					<tr>
						<td>닉네임 :</td>
						<td><input type="text" name="CuserNick" id="cUserNick"
							value="${cUser.userNick}" readonly="readonly"
							class="form-control mr-sm-2"></td>
						<td><input type="button" value="강제 정보수정" id="comResult"
							onclick="btn_comResult()" class="btn btn-primary" /></td>
						<td><input type="submit" value="저장" id="comResultOk"
							onclick="btn_comResultOk()" style="display: none;"
							class="btn btn-primary" /></td>
					</tr>
					<tr>
						<td>가입날짜 :</td>
						<td><input type="text" name="joinDate"
							value="${cUser.userJoin}" readonly="readonly"
							class="form-control mr-sm-2"></td>
					</tr>
					<tr>
						<td>주소 :</td>
						<td><input type="text" name="userAddr"
							value="${cUser.userAddr}" readonly="readonly"
							class="form-control mr-sm-2"></td>
					</tr>
					<tr>
						<td>핸드폰번호 :</td>
						<td><input type="text" name="userphone"
							value="${cUser.userPhone}" readonly="readonly"
							class="form-control mr-sm-2"></td>
					</tr>
					<tr>
						<td>이메일 :</td>
						<td><input type="text" name="eMail" value="${cUser.eMail}"
							readonly="readonly" class="form-control mr-sm-2"></td>
					</tr>
					<tr>
						<td>성별 :</td>
						<td><input type="text" name="userGender"
							value="${cUser.userGender}" readonly="readonly"
							class="form-control mr-sm-2"></td>
					</tr>
					<tr>
						<td>생년월일 :</td>
						<td><input type="text" name="userIden"
							value="${cUser.userIden}" readonly="readonly"
							class="form-control mr-sm-2"></td>
					</tr>
					<tr>
						<td>관심분야 :</td>
						<td><input type="text" name="userInterests"
							value="${cUser.userInterests}" readonly="readonly"
							class="form-control mr-sm-2"></td>
					</tr>
				</table>
			</form>
			<form action="mpUserDelete">
				<input type="hidden" value="${cUser.userId }" name="userId">
				<input type="submit" value="탈퇴시키기" id="deleteBtn"
					class="btn btn-primary" />
			</form>
		</fieldset>
	</div>
	<div id="m_userNotice" style="display: none;">
		<fieldset>
			<h3>master_userNotice.jsp-회원게시물보기</h3>
			<table>
				<c:forEach items="${uVideos}" var="uv">
					<c:set var="videoCheck4" value="${uv.vContent}" />
					<c:set var="vc4" value="${fn:substring(videoCheck4,0,5)}" />
					<c:choose>
						<c:when test="${vc4 eq 'https'}">
							<tr>
								<td><img alt="not Found" src="${uv.vImage}" width="150px"
									height="90px"></td>
								<td>${uv.vTitle}</td>
								<td><input type="submit" value="삭제" id="m_deleteVideo"
									class="btn btn-primary"></td>
							</tr>
						</c:when>
						<c:otherwise>
							<tr>
								<td><img alt="not Found"
									src="resources/upload/${uv.vImage}" width="150px" height="90px" /></td>
								<td>${uv.vTitle}</td>
								<td><input type="submit" value="삭제" id="m_deleteVideo"
									class="btn btn-primary"></td>
							</tr>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</table>
		</fieldset>
	</div>

	<div id="m_userComment" style="display: none;">
		<fieldset>
			<h3>master_userComment.jsp-회원댓글보기</h3>
			<table>
				<c:forEach items="${uComment }" var="uc">
					<tr>
						<td>${uc.userNick }</td>
						<td>${uc.rContent }</td>
					</tr>
				</c:forEach>
			</table>
		</fieldset>
	</div>
</div>
</body>
</html>
<%@include file="../footer.jsp"%>