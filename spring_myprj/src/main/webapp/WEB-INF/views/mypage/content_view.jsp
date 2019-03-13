<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="modify" method="post">
		<input type="hidden" name="wNum" value="${content_view.wNum }" />
		<table border="1">

			<tr>
				<td>번호</td>
				<td>${content_view.wNum}</td>
			</tr>
			<tr>
				<td>조회수</td>
				<td>${content_view.wHit }</td>
			</tr>
			<tr>
				<td>닉네임</td>
				<td>${content_view.userNick }</td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="wTitle"
					value="${content_view.wTitle }" /></td>
			</tr>

			<tr>
				<td>동영상</td>
				<td><video width="300px" height="250px"
						src="resources/upload/${content_view.wFile}" type="video"
						controls="controls">%{content_view.wFile}</td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="5" cols="30" type="text" name="wContent">
						${content_view.wContent }</textarea></td>
			</tr>
			<tr>
				<td>첨부파일</td>
				<td><input type="file" name="wFile" /></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="수정" />&nbsp;&nbsp;
					<a href="list">목록보기</a></td>
			</tr>
		</table>
	</form>
</body>
</html>
<%@include file="../footer.jsp"%>