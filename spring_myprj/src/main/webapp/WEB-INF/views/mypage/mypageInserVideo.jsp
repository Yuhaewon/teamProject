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
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
	function user_infoCandC() {
		location.href = "/spring_myprj/mypageMain";
	}
	function user_faVideo() {
		location.href = "/spring_myprj/mypageFaVideo";
	}
	function user_insertVideo() {
		location.href = "/spring_myprj/mypageInserVideo";
	}

	//유튜브 플레이어 사용부
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

	//youtube api가져오기
	var tag = document.createElement('script');
	tag.src = "https://www.youtube.com/iframe_api";
	var firstScriptTag = document.getElementsByTagName('script')[0];
	firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);
</script>
<style>
#myVideo {
	text-align: center;
	border: 3px solid white;
	height: 1300px;
	width: 45%;
	margin: auto;
	margin-top: 5%;
	padding-top: 2%;
	padding-left: 1%;
	padding-right: 1%;
}

body {
	background-color: #F5BCA9;
}

h3 {
	text-align: center;
	margin-top: 50px;
	margin-bottom: 50px;
}
#myi_div {
	text-align: center;
}
.paging {
	margin-left: 40%;
	margin-top: 3%;
}
</style>

</head>
<body>
	<h3>내가 올린 동영상</h3>
	<div id="myi_div">
		<input type="button" value="개인정보확인 및 변경" onclick="user_infoCandC()"
			id="infoCandC" class="btn btn-primary" /> <input type="button"
			value="즐겨찾기한 동영상" onclick="user_faVideo()" id="faVideo"
			class="btn btn-primary" /> <input type="button" value="내가올린 동영상"
			onclick="user_insertVideo()" id="insertVideo" class="btn btn-primary" /><br>
		<br>
	</div>
	<div id="myVideo">
		<table border="1">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>미리보기</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
			<c:forEach items="${uploadVideo}" var="dto2">
				<tr>
					<td>${dto2.vNum }</td>
					<td><a href="content_view?wNum=${dto2.vNum }">${dto2.vTitle }</a></td>
					<c:set var="videoCheck" value="${dto2.vContent}" />
					<c:set var="vc" value="${fn:substring(videoCheck,0,5)}" />
					<c:choose>
						<c:when test="${vc eq 'https'}">
							<td><iframe
									src="${dto2.vContent}?rel=0&amp;autoplay=1&amp;enablejsapi=1&amp;version=3&amp;playerapiid=player"
									width="500px" height="325px" id="player"></iframe></td>
						</c:when>
						<c:otherwise>
							<td><video src="resources/upload/${dto2.vContent}"
									width="500px" height="325px" controls="controls">${dto2.vContent}</td>
						</c:otherwise>
					</c:choose>
					<td>${dto2.vDate }</td>
					<td>${dto2.vHit }</td>
				</tr>
				<tr>
					<td colspan="5" style="text-align: right; padding-right: 20px;"></a>&nbsp;<a
						href="delete?wNum=${dto2.vNum}">삭제</a></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="5"><a href="write_view">작성</a></td>
			</tr>
		</table>
		<c:if test="${searchVO.totPage>1}">
			<div class="paging">
				<ul class="pagination">
					<c:if test="${searchVO.page>1}">
						<li class="page-item active">
						<a class="page-link" href="mypageInserVideo?page=1">[처음]</a>
						</li>
						<li class="page-item active">
						<a class="page-link" href="mypageInserVideo?page=${searchVO.page-1}">[이전]</a>
						</li>
					</c:if>
					<c:forEach var="i" begin="${searchVO.pageStart}"
						end="${searchVO.pageEnd}" step="1">
						<c:url var="pageLink" value="board2List">
							<c:param name="page" value="${i}" />
						</c:url>
						<%-- <c:choose>
						<c:when test="${i eq searchVO.page}">
							<c:out value="${i}" />
						</c:when>
						<c:otherwise> --%>
						<li class="page-item active"><a href="mypageInserVideo?page=${i }" class="page-link"><c:out
									value="${i}" /></a></li>
						<%--</c:otherwise>
					</c:choose> --%>
					</c:forEach>
					<c:if test="${searchVO.totPage > searchVO.page}">
						<li class="page-item active"><a class="page-link"
							href="mypageInserVideo?page=${searchVO.page+1}">[다음]</a></li>
						<li class="page-item active"><a class="page-link"
							href="mypageInserVideo?page=${searchVO.totPage}">[마지막]</a></li>
					</c:if>
				</ul>
			</div>
			<br />
		</c:if>
	</div>
</body>
</html>
<%@include file="../footer.jsp"%>