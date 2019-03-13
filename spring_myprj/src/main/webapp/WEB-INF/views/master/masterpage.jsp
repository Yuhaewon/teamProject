<%@page import="java.util.function.Function"%>
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

h3 {
	text-align: center;
	margin-top: 50px;
	margin-bottom: 50px;
}
#haewon1 {
	display: inline;
	margin-right: 150px;
}
#haewon2 {
	display: inline;
}
#masteer_button {
	padding-left: 20%;
	padding-right: 13%;
	margin-bottom: 10%;
}
</style>
<script type="text/javascript">
	function mpSelectUser() {
		location.href = "master/mpSelectUser";
	}
	function mpStatisticsUser() {
		location.href = "master/masterChart";
	}
</script>
</head>
<body>
	<h3>관리자 페이지</h3>
	<div id="masteer_button">
		<div id="haewon1">
			<a href="master/mpSelectUser"><img alt="null"
				src="${pageContext.request.contextPath}/resources/image/haewon1_1.png"
				style="width: 330px" height="300px"></a>
		</div>
		<div id="haewon2">
			<a href="master/masterChart"><img alt="null"
				src="${pageContext.request.contextPath}/resources/image/haewon3_1.png"
				style="width: 330px" height="300px"></a>
		</div>
	</div>
</body>
</html>
<%@include file="../footer.jsp"%>