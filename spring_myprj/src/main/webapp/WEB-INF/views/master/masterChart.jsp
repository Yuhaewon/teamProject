<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="../header.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="http://code.highcharts.com/highcharts.js"></script>
<script src="http://code.highcharts.com/modules/exporting.js"></script>
<script>

	var datainfo = new Array();//담을 데이터 베열로 저장

	$(function () {
	<c:forEach items="${joinData}" var="cd">
	var userData = ${cd.count};
	datainfo.push(userData);
	</c:forEach>
	
	console.log("datainfo : "+datainfo[0]);
	var data =datainfo;
	console.log("data : "+data);
    $('#userJoinData').highcharts({ //div아이디 요소 설정
        title: { text: '가입자수 통계',x: 0 }, //제목
        xAxis: { categories: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] },
        yAxis: { title: { text: '월별 통계'},//좌측 subname
        plotLines: [{ value: 0, width: 1, color: '#808080'}]}, //그래프 선 제어
        tooltip: { valueSuffix: '명'}, //벨류값 뒤의 글씨
        legend: { //우측 그래프에 대한 설명 범위관련
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle',
            borderWidth: 0
        },
        series: [{ 
            name : '가입자수',
            data : data
        }]
    });
});


</script>
<style type="text/css">
body {
	background-color: #F5BCA9;
}
</style>
</head>
<body>
<br><br><br>
<div id="userJoinData" style="min-width: 310px; height: 400px; margin: 0 auto; background-color: aqua;"></div>
<br><br><br>
</body>
</html>
<%@include file="../footer.jsp"%>