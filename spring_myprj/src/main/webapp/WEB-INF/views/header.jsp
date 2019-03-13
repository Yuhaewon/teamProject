<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width" />
<title>Insert title here</title>
<link href="https://bootswatch.com/4/journal/bootstrap.css" rel="stylesheet" /> 

<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<style type="text/css">
</style>
</head>
<body>
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			 <a class="navbar-brand" href="/spring_myprj/"><img alt="logoImage" src="${pageContext.request.contextPath}/resources/image/logo1.PNG" width="120px" height="70px"></a>
 			 <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor03" aria-controls="navbarColor03" aria-expanded="false" aria-label="Toggle navigation">
   			 <span class="navbar-toggler-icon"></span>
  			</button>			

			<div id="navbarColor03" class="collapse navbar-collapse" >
				
			<%
			String userId=(String)session.getAttribute("userId");
			if(userId==null){ 
			%>
			<ul class="navbar-nav mr-auto" >
				<li class="nav-item">
					<a class="nav-link" href="/spring_myprj/login">질문게시판</a>
				</li>
      			<li class="nav-item">
					<a class="nav-link" href="/spring_myprj/login">공지게시판</a>
				 </li>
      			 <li class="nav-item">
					<a class="nav-link" href="/spring_myprj/login">마이페이지</a>
				 </li>
    			<li class="nav-item active">
					<a class="nav-link" href="/spring_myprj/login">로그인<span class="sr-only">(current)</span></a>
				</li>
    		</ul>
    		<form class="form-inline my-2 my-lg-0" action="serchVideo">
     			<input class="form-control mr-sm-2" type="text" name="sVideo" placeholder="Search">
    			<button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
    		</form>
			<%}
			if(userId!=null){
				if(!(userId.equals("masterH"))){
			%>
			<ul class="navbar-nav mr-auto">
    			<li class="nav-item active">
    				<input type="text" id="check" value="<%=userId%>님 환영합니다." disabled />
				</li>
				<li class="nav-item">
					<a class="nav-link" href="/spring_myprj/write_view">게시물 작성하기</a>
				</li>
				<li class="nav-item">	
					<a class="nav-link" href="/spring_myprj/qlist">질문게시판</a>
				</li>
				<li class="nav-item">	
					<a class="nav-link" href="/spring_myprj/list">공지게시판</a>
				</li>
				<li class="nav-item">	
					<a class="nav-link" href="/spring_myprj/mypageMain">마이페이지</a>
				</li>
				<li class="nav-item active">
					<a class="nav-link" href="/spring_myprj/login">로그아웃<span class="sr-only">(current)</span></a>
				</li>
    		</ul>
    		<form class="form-inline my-2 my-lg-0" action="serchVideo">
     			<input class="form-control mr-sm-2" type="text" name="sVideo" placeholder="Search">
    			<button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
    		</form>
			<%}else if(userId.equals("masterH")){%>
				<ul class="navbar-nav mr-auto">
    			<li class="nav-item active">
    				<input type="text" id="check" value="<%=userId%>님 환영합니다." disabled />
				</li>
				<li class="nav-item">
					<a class="nav-link" href="/spring_myprj/write_view">게시물 작성하기</a>
				</li>
				<li class="nav-item">	
					<a class="nav-link" href="/spring_myprj/qlist">질문게시판</a>
				</li>
				<li class="nav-item">	
					<a class="nav-link" href="/spring_myprj/list">공지게시판</a>
				</li>
				<li class="nav-item">	
					<a class="nav-link" href="/spring_myprj/mypageMain">마이페이지</a>
				</li>
				<li class="nav-item">	
					<a class="nav-link" href="/spring_myprj/masterpage">관리자페이지</a>
				</li>
				<li class="nav-item active">
					<a class="nav-link" href="/spring_myprj/login">로그아웃<span class="sr-only">(current)</span></a>
				</li>
    		</ul>
    		<form class="form-inline my-2 my-lg-0" action="/spring_myprj/serchVideo">
     			<input class="form-control mr-sm-2" type="text" name="sVideo" placeholder="Search">
    			<button class="btn btn-secondary my-2 my-sm-0" type="submit">검색</button>
    		</form>
				<%}}%>
			</div>
		</nav>
