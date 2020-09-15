<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device=width" initial-scale="1">
<link rel = "stylesheet" href="../css/bootstrap.css">
<meta charset="UTF-8">
<title>resInsert.jsp</title>
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
	<h3>식당등록</h3>
	<form method="post" name="frm" id="frm" 
		  action="../ResInsert.do">
		<div>
			<label>제목</label>
			<input type="text" name="title" id="title">
		</div>
		<div>
			<label>내용</label>
			<textarea name="content" id="content"></textarea>
		</div>
		<div>
			<label>식당이름</label>
			<input type="text" name="name" id="name">
		</div>
		<div>
			<label>전화번호</label>
			<input type="text" name="tel" id="tel">
		</div>
		<div>
			<label>주소</label>
			<input type="text" name="address" id="address">
		</div>
		<button type="reset">초기화</button>
		<button>등록</button>
	</form>
</body>
</html>