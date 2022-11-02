<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<!DOCTYPE html>
<html>
<head>
<link rel ="stylesheet" href ="./resources/css/bootstrap.min.css"/>
<meta charset="utf-8">
<%-- <%
	String sessionId2 = (String) session.getAttribute("sessionId");
%> --%>
<title>MainHome</title>
</head>
<body>
<%@ include file="./User_menu.jsp" %>

<div class="container">
<%@ include file="./User_Home_Content.jsp" %>
</div>
</body>
</html>