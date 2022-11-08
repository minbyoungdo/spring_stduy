<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ page import =  "com.mycoffee.domain.OrderVO" %>
<%@ page import =  "com.mycoffee.domain.Order_detailVO" %>
<%@ page import =  "com.mycoffee.domain.ProductJoinVO" %>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<%
	OrderVO order2 = (OrderVO)request.getAttribute("order2");
	Order_detailVO od2=(Order_detailVO)request.getAttribute("od2");
	List<ProductJoinVO> product =(List)request.getAttribute("product");
	//System.out.println(order2+";;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;"+od2);
%>
</head>
<body>
<%@ include file="./User_menu.jsp" %>
<div class="container">
<div class="col-md-6"></div>
<div class="col-md-12">
	<div class="card" background-color:#" align="center">
  		<div class="card-header">
   			 나의 장바구니
  		</div>
  		<div class="row">
  		<div class="col-md-8"align="left"><label >주문번호 : <c:out value="${order.oid}"/></label></div>
  		<div class="col-md-4" align="right">주문상태 : <c:out value="${order.status}"/></div>
  		</div>
  		<div class="row">
  		<div class="col-md-8" align="left"><label>회원 아이디 : <c:out value="${order.userid}"/></label></label></div>
  		<div class="col-md-4" align="right">주문 시작 시간 : <c:out value="${order.registdate}"/></div>
  		</div>
  		<div class="card-body">
  			메뉴명 : <%=product.get(0).getPname()%>
  			선택용량 : <%=product.get(0).getCapacity() %>
  			냉/온 : <%=product.get(0).getTemperature() %>
  			단일가격 : <%=product.get(0).getPrice() %>
  			<button type="button" class="btn btn-danger" action="/user/piecesChange/minus">-</button>
  			갯수 : <%=od2.getPieces() %>
  			<button type="button" class="btn btn-primary"action="/user/piecesChange/plus">+</button>
  		</div>
</div>
<div class="col-md-6"></div>
</div>
</body>
</html>