<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@include file="../header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
body {
	background-color: #F5BCA9;
}
</style>
</head>
<body>
	<hr>
	<h3>select video</h3>
	<hr>
	비디오 검색결과
	<table>
		<colgroup>
			<col width="2%">
			<col width="10%">
			<col width="5%">
			<col width="5%">
		</colgroup>
		<tr>
			<td></td>
			<td>제목</td>
			<td>작성자</td>
			<td>조회수</td>
		</tr>
		
		<c:forEach items="${selectVideo}" var="sV">
			<c:set var="videoCheck3" value="${sV.vContent}"/>
			<c:set var="vc3" value="${fn:substring(videoCheck3,0,5)}"/>
				<c:choose>
					 <c:when test="${vc3 eq 'https'}">
					<tr>
						<td><a href="videoView?vNum=${sV.vNum }&userInterests=${sV.userInterests}"> <img
								alt="not found" src="${sV.vImage}" width="200px" height="100px">
						</a></td>
						<td><a href="videoView?vNum=${sV.vNum }&userInterests=${sV.userInterests}"> ${sV.vTitle} </a></td>
						<td>${sV.userId}</td>
						<td>${sV.vHit}</td>
					</tr>
					</c:when>
					<c:otherwise>
					<tr>
						<td><a href="videoView?vNum=${sV.vNum }&userInterests=${sV.userInterests}"> <img
								alt="not found" src="resources/upload/${sV.vImage}" width="200px" height="100px">
						</a></td>
						<td><a href="videoView?vNum=${sV.vNum }&userInterests=${sV.userInterests}"> ${sV.vTitle} </a></td>
						<td>${sV.userId}</td>
						<td>${sV.vHit}</td>
					</tr>
					</c:otherwise>
				</c:choose>

		</c:forEach>
	</table>
</body>
</html>
<%@include file="../footer.jsp"%>