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
#jo_div {
	margin : auto;
	margin-top: 70px;
	margin-bottom: 70px;
	border-radius: 10px;
	background-color: white;
	border: 3px solid #FE2E2E;
	width: 40%;
	height: 650px;
}

</style>
</head>
<body>
	<%
		String id=(String)session.getAttribute("userId");
	%>
<div id="jo_div">
	<form action="write" method="post" enctype="multipart/form-data">
		<table  class="table table-hover">
			<tr>
				<td>이름</td>
				<td><input type="text" value="<%=id%>" name="userNick" size="30" readonly="readonly" style="width: 500px; " class="form-control mr-sm-2" /></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="wTitle" size="30" style="width: 500px; " class="form-control mr-sm-2" /></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><input type="text" name="wContent" size="30" style="width: 500px; " class="form-control mr-sm-2" /></td>
			</tr>
			<tr>
				<td>분야</td>
				<td><input type="checkbox" name="userInterests" value="코믹">코믹
					<input type="checkbox" name="userInterests" value="멜로">멜로 <input
					type="checkbox" name="userInterests" value="액션">액션 <input
					type="checkbox" name="userInterests" value="성인">성인 <input
					type="checkbox" name="userInterests" value="공포,호러">공포,호러</td>
			</tr>
			<tr>
				<td></td>
				<td><input type="checkbox" name="userInterests" value="게임">게임
					<input type="checkbox" name="userInterests" value="요리">요리 <input
					type="checkbox" name="userInterests" value="뷰티">뷰티 <input
					type="checkbox" name="userInterests" value="동물">동물 <input
					type="checkbox" name="userInterests" value="패션">패션</td>
			</tr>
			<tr>
				<td></td>
				<td><input type="checkbox" name="userInterests" value="영화">영화
					<input type="checkbox" name="userInterests" value="드라마">드라마
					<input type="checkbox" name="userInterests" value="시사">시사 <input
					type="checkbox" name="userInterests" value="다큐멘터리">다큐멘터리 <input
					type="checkbox" name="userInterests" value="음악">음악</td>
			</tr>
			<tr>
				<td></td>
				<td><input type="checkbox" name="userInterests" value="스포츠">스포츠
					<input type="checkbox" name="userInterests" value="인강">인강 <input
					type="checkbox" name="userInterests" value="유아">유아 <input
					type="checkbox" name="userInterests" value="예능">예능 <input
					type="checkbox" name="userInterests" value="전체" id="allCheck">전체
				</td>
			</tr>
			<tr>
				<td>첨부<br>동영상</td>
				<td><input type="file" name="wFile" class="form-control-file" aria-describedby="fileHelp" /></td>
			</tr>
			<tr>
				<td>썸네일이미지</td>
				<td><input type="file" name="pFile" class="form-control-file" aria-describedby="fileHelp" /></td>
			</tr>
			<tr>
				<td colspan="2">
				<input type="submit" value="입력" class="btn btn-outline-primary" style="float: right;" />&nbsp;&nbsp;
				<a href="list"  style="float: left;">목록보기</a></td>
			</tr>
		</table>
	</form>
</div>	
</body>
</html>
<%@include file="../footer.jsp"%>