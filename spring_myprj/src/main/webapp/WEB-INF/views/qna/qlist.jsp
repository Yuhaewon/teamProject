<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

#qna_h {
	color: black;
	margin-top: 10px;
}

#qna_div {
	text-align: center;
	border: 3px solid white;
	width: 71%;
	margin: auto;
	display: inline;
	float: left;
}

#qna_div_table tr th{
	text-align: center;
	border-radius: 20px;
}

#search_div {
	margin-bottom: 1%;
}

#q_jin {
	float: left;
	display: inline;
	padding-top: 5%;
}
#q_div {
	width : 100%;
	height: 800px;
}
</style>
</head>
<body>
	<div id="q_div">
		<h3 id="qna_h">질문게시판</h3>
		<div id="q_jin">
			<img alt="jin"
				src="${pageContext.request.contextPath}/resources/image/jin.png"
				width="550px" height="350px" />
		</div>
		<div id="qna_div">
			<table id="qna_div_table" class="table table-hover">
				<colgroup>
					<col width="5%">
					<col width="30%">
					<col width="10%">
					<col width="5%">
					<col width="5%">
				</colgroup>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성일</th>
					<th>아이디</th>
					<th>조회수</th>
				</tr>
				<c:forEach items="${list}" var="dto">
					<tr>
						<td>${dto.qNum }</td>
						<td style="text-align: left;"><c:set value="${dto.qIndent }" var="endIndent" /> <c:forEach
								begin="1" end="${dto.qIndent }" var="cnt"> &nbsp;
				<c:if test="${cnt eq endIndent }">
									<img alt="" width="20px" height="20px" src="${pageContext.request.contextPath}/resources/image/heart.png"> 
								</c:if>
							</c:forEach> <a href="qcontent_view?qNum=${dto.qNum }">${dto.qTitle }</a></td>
						<td>${dto.qDate }</td>
						<td>${dto.userId }</td>
						<td>${dto.qHit }</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="5"><a href="qwrite_view">작성</a></td>
				</tr>
			</table>

			<form id="form1" name="form1" action="qlist" method="post">
				<input type="hidden" name="page" id="page" value="" />
				<script type="text/javascript">
					function fnSubmitForm(page) {
						document.form1.page.value = page;
						document.form1.submit();
					}
				</script>

				<c:if test="${searchVO.totPage>1}">
					<div class="paging">
						<c:if test="${searchVO.page>1}">
							<%-- <a href="qlist?page=1">[처음]</a>
					<a href="qlist?page=${searchVO.page-1}">[이전]</a> --%>
							<a href="javascript:fnSubmitForm(${1});">[처음]</a>
							<a href="javascript:fnSubmitForm(${searchVO.page-1});">[이전]</a>
						</c:if>
						<c:forEach var="i" begin="${searchVO.pageStart}"
							end="${searchVO.pageEnd}" step="1">
							<c:url var="pageLink" value="board2List">
								<c:param name="page" value="${i}" />
							</c:url>
							<c:choose>
								<c:when test="${i eq searchVO.page}">
									<c:out value="${i}" />
								</c:when>
								<c:otherwise>
									<a href="qlist?page=${i }"><c:out value="${i}" /></a>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<c:if test="${searchVO.totPage > searchVO.page}">
							<%-- <a href="qlist?page=${searchVO.page+1}">[다음]</a>
					<a href="qlist?page=${searchVO.totPage}">[마지막]</a> --%>
							<a href="javascript:fnSubmitForm(${searchVO.page+1});">[다음]</a>
							<a href="javascript:fnSubmitForm(${searchVO.totPage});">[마지막]</a>
						</c:if>
					</div>
					<br />
				</c:if>
				<div id="search_div">
					<select name="f" style="height: 37px;">
						<option ${param. f=="doSelect"?"selected":"" } value="doSelect">선택</option>
						<option ${param.f =="qTitle"?"selected":""} value="qTitle">제목</option>
						<option ${param.f =="qContent"?"selected":"" } value="qContent">내용</option>
						<option ${param.f =="btit_bcon"?"selected":"" } value="btit_bcon">제목
							내용</option>

					</select> <input type="text" name="sk" value="${searchKeyword}"
						style="height: 37px;" />
					<button class="btn btn-primary" type="submit">검색</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
<%@include file="../footer.jsp"%>