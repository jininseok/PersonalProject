<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device=width" initial-scale="1">
<link rel = "stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
<meta charset="UTF-8">
<title>Insert title here</title>
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
	<h3 class="page_title" style="text-align : center; ">식당 전체조회</h3>
	<form action="../ResSearchAll.do" style="text-align : center; ">
	<table border="1" id="restb" style="text-align : center; ">
		<thead>
			<tr>
				<th>게시글번호</th>
				<th>게시글이름</th>
				<th>내용</th>
				<th>식당이름</th>
				<th>전화번호</th>
				<th>주소</th>
				<th>등록일자</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="res">
				<tr>
					<td>${res.no}</td>
					<td>${res.title}</td>
					<td>${res.content}</td>
					<td>${res.name}</td>
					<td>${res.tel}</td>
					<td>${res.address}</td>
			<td><fmt:parseDate value="${res.regdate}" pattern="yyyy-MM-dd"
					var="ParseReg" /> <fmt:formatDate value="${ParseReg}"
					pattern="MM/dd" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</form>
</body>
</html>