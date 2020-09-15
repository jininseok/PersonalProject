<%@page import="model.ResVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.ResDAO" %>
<%@ page import="java.io.PrintWriter" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="res" class="model.ResVO" scope="page" />
<jsp:setProperty name="res" property="userID" />
<jsp:setProperty name="res" property="userPassword" />
<jsp:setProperty name="res" property="userName" />
<jsp:setProperty name="res" property="userGender" />
<jsp:setProperty name="res" property="userEmail" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		if (res.getUserID() == null || res.getUserPassword() == null) {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('입력이 되지않았습니다.')'");
		script.println("history.back()");
		script.println("</script>");
	} else {
		ResDAO resDAO = new ResDAO();
		int result = resDAO.join(res);
		if (result == -1) {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("이미존재하는 아이디입니다.");
		script.println("</script>");
	} else if (result == 0) {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("location.href='main.jsp");
		script.println("</script>");
		}
	}
	%>
</body>
</html>