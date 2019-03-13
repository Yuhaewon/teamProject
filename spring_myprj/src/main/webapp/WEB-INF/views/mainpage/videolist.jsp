<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@include file="../header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>동영상 메인페이지</title>

<link type="text/css" rel="stylesheet" href="resources/css/maincss.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script>
     	//유튜브 플레이어 사용
		var player;
		var playerState;
		var nextVideo; //다음 비디오의 주소
		var choiceVideo=new Array();; //선택한 비디오
		var listNum=0; //리스트에 추가된 순서 
		var glovalVideoFrame; //전역변수화된 비디오 프레임
		var arrListNum=new Array(); //리스트에 추가된 순서 배열로 저장
		    function onYouTubeIframeAPIReady() {
		    	console.log("check onYouTubeIframeAPIReady");
				player = new YT.Player('player', {
					 events: {
				       'onReady': onPlayerReady,
				       'onStateChange': onPlayerStateChange
				     }
				 });
			}
		     	
			//비디오 플레이어가 준비되면 비디오 재생
			function onPlayerReady(event) {
				console.log("onPlayerReady");
		        event.target.playVideo(); 
		    }
				
			function onPlayerStateChange(event) {
				console.log("StateChange"+event.data);
				if (event.data == YT.PlayerState.ENDED) {
					arrListNum.shift()//첫번째 요소 삭제
					console.log("arrListNum length : "+ arrListNum.length); //배열 요소의 길이
					nextVideo = arrListNum[0]; //삭제되고 난 후의 첫번째 요소 (다음 비디오의 주소)
					console.log("nextVideo : "+ nextVideo);
					console.log('check glovalVideoFrame(addr) : ' + glovalVideoFrame.src);
					if (arrListNum.length>=1) {
						glovalVideoFrame.src=nextVideo;
						onYouTubeIframeAPIReady();
					}
					console.log("동영상 종료됨");
				}
				if (event.data == YT.PlayerState.PLAYING) {
					if (choiceVideo.length>=1) {
						glovalVideoFrame.src=choiceVideo;
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
		
		
			/* 동영상 드래그 드롭 */
			/* 드래그 시작 */
	    	function dragstart(event) {
				event.dataTransfer.effecAllowed = 'move';
				event.dataTransfer.setData("csrc", event.target.attributes.csrc.value);
				event.dataTransfer.setData("nsrc", event.target.attributes.nsrc.value);
			} 
			/* 드래그 중인 요소가 dropzone에 들어갈때 발생함 */
	    	function dragenter(event) {
			} 
			/* 드래그 중인 요소가 dropzone 위에서 드래그 중일때 계속해서 발생 */
	    	function allowDrop(event) {
				event.preventDefault();
			} 
			/* 드래그 중인 요소가 dropzone 위에서 머무를때 계속해서 발생 */
	 	   function dragleave(event) {
			}
		
			/* 동영상 리스트부 및 동영상 재생부------------------------------------------------------ */
			function listDropZone(event) {
				var csrc;
				var vFrame = document.getElementById("player"); //플레이어값 저장
				var nsrc = event.dataTransfer.getData("nsrc"); //비디오 넘버
				var lastaddr="?rel=0&amp;autoplay=1&amp;enablejsapi=1&amp;version=3&amp;playerapiid=player"; //비디오설정
				var firstaddr="resources/upload/";
				glovalVideoFrame = vFrame;
				console.log("drop");
				event.preventDefault();
					$.ajax({
						url:"myVList",
						type:"POST",
						async:false,
						data: {"nsrc" : nsrc},
						error: function() {
							alert("시스템 오류입니다. 관리자에게 문의하세요");
							},//error function끝
						success: function (resultData) {
							console.log('success : '+resultData)
								$.each(resultData, function(index,resultData) { 
									//받아온 값 string type으로 변환
									var vImage=JSON.stringify(resultData.vImage); //썸네일 이미지
									var vTitle=JSON.stringify(resultData.vTitle); //동영상 제목
									csrc=resultData.vContent;
									var strCsrc=JSON.stringify(csrc);
									
									console.log('strCsrc : '+strCsrc)
									
									if (strCsrc.substr(1,5)==='https') {
				                		console.log('https'+ strCsrc.substr(1,5));
										$('#myvideolist').append("<tr><td><img width=100px; height=50px; scroller; src="+vImage+"/></td><td>"+vTitle+"</td><td>"+listNum+"</td><td><input type='button' value='영상보기' onclick='changeVideo("+strCsrc+")'></td></tr>");
										listNum++;//list num
				                		arrListNum.push(csrc + lastaddr);//리스트 들어온 순서
				                		console.log('csrc + lastaddr : '+csrc + lastaddr);
									}else if (strCsrc.substr(1,5) !== 'https') {
										var imgFirstStr='resources/upload/';
										var changevImage=JSON.parse(vImage);
										var imgStr=imgFirstStr+changevImage;
				                		console.log('imgStr : ' + imgStr);
										$('#myvideolist').append("<tr><td><img width=100px; height=50px; scroller; src="+imgStr+" /></td><td>"+vTitle+"</td><td>"+listNum+"</td><td><input type='button' value='영상보기' onclick='changeVideo("+strCsrc+")'></td></tr>");
				                		console.log('not https : ' + strCsrc.substr(1,5));
										listNum++;//list num
					                	arrListNum.push(firstaddr + csrc);
				                		console.log('firstaddr + csrc : '+firstaddr + csrc);
									}
									
								});//each 끝
						}//success 끝
					});//ajax 끝	
			
				console.log('csrc(ajax) : '+csrc);
				console.log('nsrc(ajax) : '+nsrc);
				console.log('vFrame.src(length) : '+vFrame.src.length);
			
				//이미 재생되고 있는 동영상이 있다면 리스트에만 추가
				if (document.getElementById('player').getAttribute('src').length == 0) {
                	
                	var strCsrc=JSON.stringify(csrc);
                	if (strCsrc.substr(1,5)=='https') {
                		glovalVideoFrame.src = csrc + lastaddr;
                		console.log('strCsrc.substr(1,5) : ' + strCsrc.substr(1,5));
                		console.log('check vFrame.src(addr) : ' + vFrame.src);
                	}else if (strCsrc.substr(1,5) != 'https'){
                		glovalVideoFrame.src = firstaddr + csrc;
                    	console.log('strCsrc.substr(1,5) : ' + strCsrc.substr(1,5));
                    	console.log('check vFrame.src(addr) : ' + vFrame.src);
					}

                	//youtube api가져오기
                	var tag = document.createElement('script');
                	tag.src = "https://www.youtube.com/iframe_api";
                	var firstScriptTag = document.getElementsByTagName('script')[0];
                	firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);
                	

                	
                	//src에 주소값 삽입
           		} //if끝
			}//funtion 끝
			
			function changeVideo(strCsrc) {
				var lastaddr2="?rel=0&amp;autoplay=1&amp;enablejsapi=1&amp;version=3&amp;playerapiid=player"; //비디오설정
				var firstaddr2="resources/upload/";
				var cVideo=strCsrc + lastaddr2;
				var mVideo=firstaddr2 + strCsrc;
				console.log('cVideo : ' + cVideo);
				console.log('mVideo : ' + mVideo);
				console.log('strCsrc.substr(0,5) : ' + strCsrc.substr(0,5));
				
				if (strCsrc.substr(0,5)=='https') {
					choiceVideo.push(cVideo);
                	glovalVideoFrame.src = cVideo;
               		console.log('cVideo : ' + cVideo);
                	console.log('strCsrc : ' + strCsrc);
				}else{
					choiceVideo.push(mVideo);
	                glovalVideoFrame.src = mVideo;
	                console.log('mVideo : ' + mVideo);
	                console.log('strCsrc : ' + strCsrc);
				}
			}
			function hide() {
				$('#all').hide();
				$('#hide').hide();
				$('#Show').show();
				$('#hae_show').show();
			}
			function show() {
				$('#all').show();
				$('#hide').show();
				$('#Show').hide();
				$('#hae_show').hide();
			}
	</script>	

<style>
body {
   background: linear-gradient( to right, #fce38a, #f38181 );
}
</style>

</head>
<body id="main">
	<!-- drag&drop 자바 스크립트 기능 사용-->
	<!-- 영상이 재생되는 div -->
	<br>
	<input type="image" id="hide" onclick="hide()" value="숨기기" style="display: none;" src="resources/image/view2.png" width="40px" height="40px"/>
	<input type="image" id="Show" onclick="show()" value="펼치기" style="display: inline;" src="resources/image/view1.png" width="40px" height="40px" />
	
	<div id="hae_show">
		<img alt="hae" src="resources/image/haewon2.png" width="550px" height="350px" id="hae"/>
	</div>
	
	<div id="all"style="display: none;" >
		<div id="contents" >
			<iframe id="player" type="text/html" width="100%" height="100%" 
			src="" allowfullscreen ></iframe>
		</div>
		
		<div id="contentsList" 
			ondragenter="dragenter(event)"
			ondragleave="dragleave(event)"
			ondragover="allowDrop(event)" 
			ondrop="listDropZone(event)"
			style="overflow:scroll;"
			>
			<br><h5 style="text-align: center;">&lt; * * play list * * &gt;</h5>
			<table id="myvideolist" ></table>
		</div>
	</div>
	<!-- play list -->
	<!-- drag&drop -->

	<hr>
	<h2>최신글</h2>
	<!-- for each문 안쪽에는 배열처리된 동영상url을 데이터베이스로 부터 받아와서  다음 url이 없을때까지 반복되게한다.-->
	<c:forEach items="${vlist}" var="vdto">
		<div class="main" id="div2">
			<!-- 동영상 이미지 + 동영상 제목 -->
			<table border="1">
			<c:set var="videoCheck" value="${vdto.vContent}"/>
			<c:set var="vc" value="${fn:substring(videoCheck,0,5)}"/>
				<c:choose>
					 <c:when test="${vc eq 'https'}">
						<tr>
					<!-- 동영상 이미지  -->
							<td>
							<a href="videoView?vNum=${vdto.vNum}&userInterests=${vdto.userInterests}">
								<img 
								id="drag" 
								width="200px" 
								height="200px"
								src="${vdto.vImage }" 
								csrc="${vdto.vContent }"
								tsrc="${vdto.vTitle }"
								nsrc="${vdto.vNum }"
								draggalbe="true"
								ondragstart="dragstart(event)"  />
							</a>
							</td>
						</tr>
						<tr>
					<!-- 동영상 제목부분 -->
							<td>${vdto.vTitle}</td>
						</tr>
						<tr>
							<td>조회수 : ${vdto.vHit}</td>
						</tr>
				  	</c:when>
					<c:otherwise>
							<tr>
					<!-- 동영상 이미지  -->
							<td>
							<a href="videoView?vNum=${vdto.vNum}&userInterests=${vdto.userInterests}">
								<img 
								id="drag" 
								width="200px" 
								height="200px"
								src="resources/upload/${vdto.vImage }" 
								csrc="${vdto.vContent }"
								tsrc="${vdto.vTitle }"
								nsrc="${vdto.vNum }"
								draggalbe="true"
								ondragstart="dragstart(event)" />
							</a>
							</td>
						</tr>
						<tr>
					<!-- 동영상 제목부분 -->
							<td>${vdto.vTitle}</td>
						</tr>
						<tr>
							<td>조회수 : ${vdto.vHit}</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</table>
		</div>
	</c:forEach>
	<br>
	<a href="#">더보기</a>
	<hr>
	<h2>인기순</h2>
	<!-- for each문 안쪽에는 배열처리된 동영상url을 데이터베이스로 부터 받아와서  다음 url이 없을때까지 반복되게한다.-->
	<c:forEach items="${vlistH}" var="vdtoH">
		<div class="main" id="div2">
			<!-- 동영상 이미지 + 동영상 제목 -->
			<table border="1">
			<c:set var="videoCheck2" value="${vdtoH.vContent}"/>
			<c:set var="vc2" value="${fn:substring(videoCheck2,0,5)}"/>
				<c:choose>
					 <c:when test="${vc2 eq 'https'}">
						<tr>
					<!-- 동영상 이미지  -->
							<td>
							<a href="videoView?vNum=${vdtoH.vNum}&userInterests=${vdtoH.userInterests}">
								<img 
								id="drag" 
								width="200px" 
								height="200px"
								src="${vdtoH.vImage }" 
								csrc="${vdtoH.vContent }"
								tsrc="${vdtoH.vTitle }"
								nsrc="${vdtoH.vNum }"
								draggalbe="true"
								ondragstart="dragstart(event)" />
							</a>
							</td>
						</tr>
						<tr>
					<!-- 동영상 제목부분 -->
							<td>${vdtoH.vTitle}</td>
						</tr>
						<tr>
							<td>조회수 : ${vdtoH.vHit}</td>
						</tr>
				  	</c:when>
					<c:otherwise>
							<tr>
					<!-- 동영상 이미지  -->
							<td>
							<a href="videoView?vNum=${vdtoH.vNum}&userInterests=${vdtoH.userInterests}">
								<img 
								id="drag" 
								width="200px" 
								height="200px"
								src="resources/upload/${vdtoH.vImage }" 
								csrc="${vdtoH.vContent }"
								tsrc="${vdtoH.vTitle }"
								nsrc="${vdtoH.vNum }"
								draggalbe="true"
								ondragstart="dragstart(event)" />
							</a>
							</td>
						</tr>
						<tr>
					<!-- 동영상 제목부분 -->
							<td>${vdtoH.vTitle}</td>
						</tr>
						<tr>
							<td>조회수 : ${vdtoH.vHit}</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</table>
		</div>
	</c:forEach>
	<br>
	<a href="#">더보기</a>
</body>
</html>
<%@include file="../footer.jsp"%>