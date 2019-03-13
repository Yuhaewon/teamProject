<%-- <%@page import="com.java.spring_myprj.dao.home_dao.HomeDao"%>
<%@page import="com.java.spring_myprj.dao.VideoDao"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	//유튜브 플레이어 사용부
	var player;
	var choiceVideo = new Array();
	; //선택한 비디오
	var glovalVideoFrame;
	function onYouTubeIframeAPIReady() {
		console.log("check onYouTubeIframeAPIReady");
		player = new YT.Player('player', {
			events : {
				'onReady' : onPlayerReady,
				'onStateChange' : onPlayerStateChange
			}
		});
	}
	//비디오 플레이어가 준비되면 비디오 재생
	function onPlayerReady(event) {
		console.log("onPlayerReady");
		event.target.playVideo();
	}
	//비디오 상태가 변경될 때마다 실행
	function onPlayerStateChange(event) {
		console.log("StateChange" + event.data);
		if (event.data == YT.PlayerState.ENDED) {
			console.log("동영상 종료됨");
		}
		if (event.data == YT.PlayerState.PLAYING) {
			if (choiceVideo.length >= 1) {
				glovalVideoFrame.src = choiceVideo;
				onYouTubeIframeAPIReady();
				choiceVideo.shift()//첫번째 요소 삭제
				console.log('choiceVideo : ' + choiceVideo);
			}
			console.log("동영상 재생중");
		}
		if (event.data == YT.PlayerState.PAUSED) {
			console.log("동영상 일시중지 됨");
		}
		if (event.data == YT.PlayerState.BUFFERING) {
			console.log("동영상 버퍼링중");
		}
		if (event.data == YT.PlayerState.CUED) {
			console.log("동영상 재생준비 완료됨");
		}
		if (event.data == -1) {
			console.log("동영상 시작되지 않음");
		}
	}

	function changeVideos(cValue) {
			var vFrame = document.getElementById("player"); //플레이어값 저장
			var lastaddr = "?rel=0&amp;autoplay=1&amp;enablejsapi=1&amp;version=3&amp;playerapiid=player"; //비디오설정
			var firstaddr = "resources/upload/";
			var cVideo = cValue; //주소값 받아옴
			console.log('cVideo : ' + cVideo);
			

			console.log('cVideo.substr(0,5) : '+cVideo.substr(0,5));
			if (cVideo.substr(0,5)=='https') {
			var fullVideo1 = cVideo + lastaddr; //풀 주소값
				glovalVideoFrame = vFrame; //프레임 전역변수화
				choiceVideo.push(fullVideo1);
				glovalVideoFrame.src = fullVideo1;
			}else{
			var fullVideo2 = firstaddr + cVideo; //풀 주소값
				glovalVideoFrame = vFrame; //프레임 전역변수화
				choiceVideo.push(fullVideo2);
				glovalVideoFrame.src = fullVideo2;	
			}

			//youtube api가져오기
			var tag = document.createElement('script');
			tag.src = "https://www.youtube.com/iframe_api";
			var firstScriptTag = document.getElementsByTagName('script')[0];
			firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);
			
	}

			function userInsertVideo(rNum, vNum, userInterests, vImage, vTitle,	vContent) {
				location.href = "userInsertVideo?rNums=" + rNum + "&vNums="
						+ vNum + "&userInterestss=" + userInterests
						+ "&vImages=" + vImage + "&vTitles=" + vTitle
						+ "&vContents=" + vContent;
				alert("추가되었습니다.");
			}
	//댓글부	
	$(function() {
		$("#reviewModifyBtn").click(
				function() {
					//confirm->확인alert
					if (confirm("수정하시겠습니까?")) {
						var reviewModifyForm = $("[id='reviewModifyForm']")
								.serialize();
						$.ajax({
							url : "vrModify",/* 컨트롤러에 있는 vrModify로 맵핑*/
							type : "post",
							data : reviewModifyForm,
							error : function() {
								alert("시스템 오류입니다. 관리자에게 문의하세요.");
							},
							success : function(resultData) {
								if (resultData == "2") {
									alert("수정실패");
									false;
								} else if (resultData == "1") {
									alert("수정완료");
									location.href = "videoView?vNum="+ $("#vNum").val()+"&rNum="+$("#rNum").val()+"&userInterests="+$("#userInterests").val();  
								}
							}
						});
					}
				});
	});
	$(document).ready(function() {
		var sessionId = document.getElementById("sessionId").value;
		var listId = document.getElementById("listId").value;
		console.log('sessionId : ' + sessionId);
		console.log('listId : ' + listId);
		if (sessionId != listId) {
			$('#rm').hide();
			$('#rd').hide();
		}
		if (sessionId == listId) {
			$('#rm').show();
			$('#rd').show();
		}
	});
</script>
<style>
body {
	background-color: #F5BCA9;
}

#all {
	outline: 1px solid black;
	width: 100%;
	height: 450px;
}

#contents {
	float: left;
	display: inline-block;
	outline-offset: -10px;
	text-align: center;
	width: 60%;
	height: 450px;
	background-color: gray;
}

#contents_table {
	text-align: center;
	width: 50%;
}

#vlist {
	float: left;
	display: inline-block;
	outline: 2px solid #92b0b3;
	outline-offset: -10px;
	text-align: center;
	width: 40%;
	height: 450px;
	background-color: white;
	padding-left: 3%;
	padding-top: 0.5%;
}

ul li {
	list-style: none;
}
#review_table tr th{
	text-align: center;
}
#div2{
	padding-left: 20px;
}
</style>
</head>
<body id="main">
<br>
제목 : <input type="text" value="${vView.vTitle}" readonly="readonly" 
class="form-control mr-sm-2" style="width: 300px; display: inline;" />
	<input type='button' value='즐겨찾기 추가' class="btn btn-primary"
		onclick='userInsertVideo("${vView.vNum }","${vView.vNum }","${vView.userInterests }","${vView.vImage }","${vView.vTitle }","${vView.vContent }")' />
	<br><br>
	<div id="all">
		<div id="contents">
		<c:set var="vc" value="${vView.vContent}"/>
		<c:set var="svc" value="${fn:substring(vc,0,5)}"/>
			<c:choose>
				<c:when test="${svc eq 'https'}">
					<iframe id="player" width="100%" height="100%" type="text/html"
					src="${vView.vContent}?rel=0&amp;autoplay=1&amp;enablejsapi=1&amp;version=3&amp;playerapiid=player"
					allowfullscreen></iframe>
				</c:when>
				<c:otherwise>
					<iframe id="player" width="100%" height="100%" type="text/html"
					src="resources/upload/${vView.vContent}"
					allowfullscreen></iframe>
				</c:otherwise>
			</c:choose>
		</div>
		<div id="vlist" style="overflow: scroll;">
			<br>play list
			<table>
				<colgroup>
					<col width="10%">
					<col width="25%">
					<col width="20%">
					<col width="20%">
				</colgroup>
				<c:forEach var="ran" items="${randomList}">
					<c:set var="rc" value="${ran.vContent}"/>
					<c:set var="rvc" value="${fn:substring(rc,0,5)}"/>
						<c:choose>
							<c:when test="${rvc eq 'https'}">
								<tr>
									<td><img alt="notfound" src="${ran.vImage}" width="100px"
									height="50px"></td>
									<td>${ran.vTitle}</td>
									<td><input type='button' value='영상보기' class="btn btn-primary"
									onclick='changeVideos("${ran.vContent}")' /></td>
									<td><input type='button' value='즐겨찾기 추가' class="btn btn-primary"
									onclick='userInsertVideo("${ran.vNum }","${vView.vNum }","${vView.userInterests }","${ran.vImage }","${ran.vTitle }","${ran.vContent }")' /></td>
								</tr>
							</c:when>
						<c:otherwise>
								<tr>	
									<td><img alt="notfound" src="resources/upload/${ran.vImage}" width="100px"
									height="50px"></td>
									<td>${ran.vTitle}</td>
									<td><input type='button' value='영상보기' class="btn btn-primary"
									onclick='changeVideos("${ran.vContent}")' /></td>
									<td><input type='button' value='즐겨찾기 추가' class="btn btn-primary"
									onclick='userInsertVideo("${ran.vNum }","${vView.vNum }","${vView.userInterests }","${ran.vImage }","${ran.vTitle }","${ran.vContent }")' /></td>
								</tr>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</table>
		</div>
	</div>
	<hr>
	<!-- 글수정 -->
	<div id="div2">
		<form id="reviewModifyForm">
			<table id="review_table"> 
				<colgroup>
					<col width="60%">
					<col width="20%">
					<col width="20%">
				</colgroup>
				<tr>
					<th>글내용</th>
					<th>아이디</th>
					<th>작성일</th>
				</tr>
				<c:forEach var="vre" items="${vReview}">
					<c:choose>
						<c:when test="${vre.rNum eq reNum }">
							<tr>
								<td>
								<input type="text" value="${vre.rContent}" name="revContent" class="form-control mr-sm-2"> 
								<input type="hidden" value="${vre.rNum}" id="rNum" name="rNum">
								<input type="hidden" value="${vView.vNum}" id="vNum" name="vNum">
								<input type="hidden" value="${vView.userInterests}" id="userInterests" name="userInterests"> 
								<input type="button" id="reviewModifyBtn" value="확인" class="btn btn-primary"></td>
								<td>${vre.userNick}</td>
								<td>${vre.rDate}</td>
							</tr>
						</c:when>
						<c:otherwise>
							<tr>
								<td>${vre.rContent}<%
									String uId = (String) session.getAttribute("userId");//로그인 되어있는 아이디.
								%> <input type="hidden" value="<%=uId%>" id="sessionId">
									<input type="hidden" value="${vre.userNick}" id="listId">
									<a id="rm"
									href="vrModifyView?rNum=${vre.rNum}&vNum=${vView.vNum}&userInterests=${vView.userInterests}">수정</a>
									<a id="rd"
									href="vrDelete?rNum=${vre.rNum}&vNum=${vView.vNum}&userInterests=${vView.userInterests}">삭제</a>
								</td>
								<td>${vre.userNick}</td>
								<td>${vre.rDate}</td>
							</tr>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</table>
		</form>
		<form action="rWrite">
		<hr>
			<table>
				<colgroup>
					<col width="20%">
					<col width="70%">
					<col width="10%">
				</colgroup>
				<tr>
					<!-- 로그인시에만 활성화 되게끔하기 -->
					<!-- 댓글내용, 댓글쓴사람, 댓쓴날짜  -->
					<td>댓글입력</td>
					<%
						if (userId != null) {
					%>
					<td><input type="text" name="reply" class="form-control mr-sm-2">
					<input type="hidden" name="vNum" value="${vView.vNum}" />
					<input type="hidden" name="userInterests" value="${vView.userInterests}" /></td>
					<input type="hidden" name="userId" value="${vView.userId}" class="btn btn-primary" />
					<td><input type="submit" value="입력" class="btn btn-primary"></td>
					<%
						}
					%>
					<%
						if (userId == null) {
					%>
					<td><input type="text" name="reply" readonly="readonly" value="로그인시에만 작성 가능합니다." class="form-control mr-sm-2"> 
						<input type="hidden" name="vNum" value="${vView.vNum}"> 
						<input type="hidden" name="userInterests" value="${vView.userInterests}"></td>
					<%
						}
					%>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
<%@include file="footer.jsp"%>