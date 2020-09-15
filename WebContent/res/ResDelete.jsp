<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device=width" initial-scale="1">
<link rel = "stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
<meta charset="UTF-8">
<title>Restaurant Delete</title>
</head>
<body>
	<nav class="navbar navbar-default">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="login.jsp">식당 웹사이트</a>
			</div>
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<%@ include file="/main.jsp" %>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
				<a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">접속하기<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li class="active"><a href="login.jsp">로그인</a></li>
						<li><a href="join.jsp">회원가입</a>
					</ul>
				</li>
			</ul>
			</div> 
	</nav>
<h2>식당 검색</h2>
	<form action="../ResSearch.do"> 
	식당 이름 : <input name="no">
	<button>검색</button>
<h3>검색 결과</h3>
	<table border="1" id="restb">
	<thead>
	<tr>
	<th>게시글 번호</th>
	<th>게시글 제목</th>
	<th>식당 이름</th>
	<th>전화번호</th>
	<th>주소</th>
	<th>등록일자</th>
	</tr>
	</thead>
	<tbody>
	<tr>
	<td>${res.no}</td>
	<td>${res.title}</td>
	<td>${res.name}</td>
	<td>${res.tel}</td>
	<td>${res.address}</td>
	<td>${res.regdate}</td>
	</tr>
	</tbody>
	</table>
	</form>
	<form method="post" action="ResDelete.do">
	<input name="no" value="${res.no}" type="hidden">
		<button>삭제</button>
	</form>
</body>
</html>