<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
</head>
<body>
<%@ include file="./User_menu.jsp" %>
<div class="container">
<div class="col-md-6"></div>
<div class="col-md-12">
	<div class="card" background-color:#" align="center">
  		<div class="card-header">
   			 Shopp Basket
  		</div>
        <button class="list-group-item list-group-item-action"  onclick="location.href ='./User_Sidebar.jsp'">Coffee</button>
        <button class="list-group-item list-group-item-action" onclick="location.href ='./User_Sidebar.jsp'" >Latte</button>
        <button  class="list-group-item list-group-item-action"  onclick="location.href ='./User_Sidebar.jsp'">Ade</button>
        <button  class="list-group-item list-group-item-action"  onclick="location.href ='./User_Sidebar.jsp'">Smoothi</button>
	</div>
</div>
<div class="col-md-6"></div>
</div>
</body>
</html>