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
	List<OrderVO> order2 = (List)request.getAttribute("order");
	List<Order_detailVO> od2=(List)request.getAttribute("otlist");
	List<ProductJoinVO> product =(List)request.getAttribute("product");
	System.out.println("가나다라마바사 아자차카차라바"+order2);
	System.out.println("가나다라마바사 아자차카차라바"+od2);
	System.out.println("가나다라마바사 아자차카차라바"+product);
%>
</head>
<body>
<%@ include file="./User_menu.jsp" %>
<div class="container">
<div class="col-md-6"></div>
<div class="col-md-12">
	<div class="card" background-color:#" align="center">
  		<div class="card-header">
   			 나의 주문 내역
  		</div>
  		<div>
  		<% for(int a=0; a<order2.size();a++)
  			{
  				
  			
  		%>
  		<div class="row">
  		<div class="col-md-8"align="left"><label >주문번호 : <%= order2.get(a).getOid() %></label></div>
  		<div class="col-md-4" align="right">주문상태 :  <%= order2.get(a).getStatus() %></div>
  		</div>
  		<div class="row" style="border-top:1px solid;padding:0px;margin:0px;">
  		<div class="col-md-8" align="left"><label>회원 아이디 :  <%= order2.get(a).getUserid() %></label></label></div>
  		<div class="col-md-4" align="right">주문 시작 시간 :  <%= order2.get(a).getRegistdate() %></div> 
  		</div>
  		<%	
  			int index=0;
  			for(int i=0; i<product.size();i++)
  			{	
  		%>
  		<div class="card-body" style="border-top:1px solid" align="left">
  				메뉴명 : <%=product.get(i).getPname()%>
  				선택용량 : <%=product.get(i).getCapacity() %> (ml)
  				냉/온 : 
  				<% if(product.get(i).getTemperature()==0) 
  				{
  					%>
  						ICE
  					<%
  				}
  				else
  				{
  					%>
						HOT
					<%
  				}
  				%>
  				단일가격 : <%=product.get(i).getPrice() %> (원)
  				갯수 : 
  				<% 
  				for(int j=0; j<od2.size();j++)
  				{
  						if(product.get(i).getPid().equals(od2.get(j).getPid()))
  						{
  				%>
  						<%=od2.get(j).getPieces() %>
  				<% 
  							index=j;
  							break;
  						}
  				}
  				%>
  		</div>
  		<%
  				if(product.size() == i)
				{break;}
  			}
  		%>
  		<div align="right" style="border-top:1px solid;border-bottom:2px; solid">
  			구매 총액 : <%= order2.get(0).getTotalprice() %> 원 입니다.
  		</div>
  		<%} %>
  	</div>
	</div>
</body>
</html>