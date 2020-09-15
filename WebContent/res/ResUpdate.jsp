<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device=width" initial-scale="1">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.css">
<meta charset="UTF-8">
<title>ResUpdate</title>
<script src="https://code.jquery.com/jquery-3.5.1.js">
</script>
</head>
<body>
	<nav class="navbar navbar-default">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="../main.jsp">식당 웹사이트</a>
		</div>
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
		<%@ include file="/main.jsp" %>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">접속하기<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li class="active"><a href="login.jsp">로그인</a></li>
						<li><a href="join.jsp">회원가입</a>
					</ul></li>
			</ul>
		</div>
	</nav>
	<h3>회원 수정</h3>
	<form method="post" name="form" id="form"
		action="../ResUpdate.do">
		<div>
			<label for="no">게시글번호 : <input type="text" name="no"
				value="${res.no}"></label>
		</div>
		<div>
			<label for="title">제목: </label> <input name="title"
				value="${res.title}">
		</div>
		<div>
			<label for="content">내용: <textarea name="content" rows="10" cols="5">${res.content}</textarea>
			</label>
		</div>
		<div>
			<label for="name">식당명 : <input name="name"
				value="${res.name}">
			</label>
		</div>
		<div>
			<label for="tel">전화번호:<input name="tel"
				value="${res.tel}">
			</label>
		</div>
		<div>
			<label for="address"> 주소 : <input name="address"
				value="${res.address}">
			</label>
		</div>
		<div>
			<label for="regdate"> 등록일 : <input name="regdate"
				value="${res.regdate}" readonly="readonly">
			</label>
		</div>
		<div>
			<button type="reset">초기화</button>
			<button>수정</button>
		</div>
	</form>
</body>
</html>