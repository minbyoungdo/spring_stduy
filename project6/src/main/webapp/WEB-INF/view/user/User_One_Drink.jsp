
<%@page import="java.util.List"%>
<%@page import="org.springframework.web.bind.annotation.ModelAttribute"%>
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<%@ page import = "org.springframework.ui.Model" %>
<%@ page import ="com.mycoffee.domain.ProductJoinVO" %>
<!DOCTYPE html>
<html>
<head>
<%
	List<ProductJoinVO> product =(List)request.getAttribute("list");
	//System.out.print("<<<<<<<<<<<<>>>>>>>>>>>>>><<<<<<<<<<<>>>>>>>>>>>>"+product.get(1));
%>
<meta charset="utf-8">
</head>
<body>
<%@ include file="./User_menu.jsp" %>
<div class="card" align="center">
		<div class="container row"  style="border:1px solid;width:100%;margin-right:20%;margin-left:20%;">
			<div class="col-md-12" style="border:1px solid;width:100%;">
				<h3 class="form-signin-heading">상세 메뉴 설명</h3>
			</div>
			<div class ="col-md-8" style="width:350px;height:100%;border:1px solid;">
			<img src="../resources/img/<c:out value="${product.imagefile}" />" style="width:250px; height:375px;margin-top:10px;margin-bottom:10px;">
			</div>
			<div class="col-md-4">
				<div class="card-body" style="back-ground:blue;">
					<div class="table-responsive">       
					 	<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                        	<thead>
                            	<tr>
                            		<th>항목</th>
                            			<td><%= product.get(0).getPcategory() %></td>
                            	</tr>
                           		<tr>
                            		<th>메뉴 명</th>
                           				 <td><%= product.get(0).getPname() %></td>
                            	</tr>
                                <tr>
                                			<th>함량(100g 기준)</th>
                                			<td> 지방 : <%= product.get(0).getFat() %>,
                                			 당 : <%= product.get(0).getSugars() %>, 나트륨 : <%= product.get(0).getSodium() %>,카페인 : <%= product.get(0).getCaffeine()%></td>
                                		</tr>
                                		<tr>
                                			<th>칼로리</th>
                                			<td><%= product.get(0).getCalorie() %> kcal</td>
                                		</tr>                                 		
                                		<tr>
                                			<th>냉/온</th>
                                			<% 
                                			int index=0;
                                			int hot=0;
                                			int cold=0;
                                			String s_hot = "hot";
                                			String s_cold="ice";
                                			while(product.get(index) !=null)
                                			{
                                				if(product.get(index).getTemperature()==0)
                                				{
                                					cold =1;
                                				}
                                				else if(product.get(index).getTemperature()==1)
                                				{
                                					hot=1;
                                				}
                                				if(product.size() == index+1)
                                				{
                                					index =0;
                                					break;
                                				}
                                				index++;
                                			}
                                			if(cold ==1 && hot ==1){
                                			%>
                                				<td><span class="btn btn-danger"  disabled='disabled'><%= s_hot %></span> <span class="btn btn-primary"  disabled='disabled'><%= s_cold %></span></td>
                                			<%
                                			}
                                			else if(cold ==1){
                                				%>
                                				<td><span class="btn btn-primary"  disabled='disabled'><%= s_cold %></span></td>
                                			<%	
                                			}
                                			else if(hot ==1){
                                			%>
                                				<td><span class="btn btn-danger"  disabled='disabled'><%= s_hot %></span></td>
                                			<%	
                                			}
                                			%>
                                		</tr> 
                                		<tr>
                                			<th>용량</th>
                                			<%
                                				int a=0;
                                				int start=1;
                                				boolean  shot =false;//237
                                				boolean tall = false;//355
                                				boolean grande = false;//473
                                			while(product.get(a) != null)
                                			{
                                				if(product.get(a).getCapacity()==237)
                                				{
                                					shot = true;
                                				}
                                				else if(product.get(a).getCapacity()==355)
                                				{
                                					tall= true;
                                				}
                                				else if(product.get(a).getCapacity()==437)
                                				{
                                					grande = true;
                                				}
                                				if(product.size() == a+1)
                                				{
                                					a =0;
                                					break;
                                				}
                                				a++;
                                			}
                                			%>
                                			<td>
                                			<%	
                                			if(shot == true)
                                			{
                                			%>
                                				shot(237 ml)
                                			<% 
                                			}
                                			if(tall == true)
                                			{
                                				if(shot == true)
                                				{
                                				%>
                                					/ tall(355 ml)
                                				<%
                                				}else if(shot == false)
                                				{
                                				%>
                                					tall(355 ml)
                                				<%  
                                				}
                                			}
                                			if(grande==true)
                                			{
                                				if(shot == true || tall==true)
                                				{
                                				%>
                                					/ grande(437 ml)
                                				<%
                                				}else if(shot == false && tall==false)
                                				{
                                				%>
                                					grande(437 ml) 
                                				<%  
                                				}
                                			}
                                			%>
                                			</td>
                                		</tr>                               		
                                		<tr>
                                			<th>판매 상항</th>
                                			<% if(product.get(0).getOnsale()==1) { %>
                                			<td>판매중</td>
                                			<%}else{ %>
                                			<td>제품 준비 중</td>
                                			<% }%>
                                		</tr>
                                		<tr>
                                			<th>가격</th>
                                			<td><%= product.get(0).getPrice() %></td>
                                		</tr>
                                	</thead>
                                </table>
                                 <%-- <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                	<thead>
                                		<tr>
                                			<th>항목</th>
                                			<td><c:out value="${product.pcategory}" /></td>
                                		</tr>
                                		<tr>
                                			<th>메뉴 명</th>
                                			<td><c:out value="${product.pname}" /></td>
                                		</tr>
                                		<tr>
                                			<th>함량(100g 기준)</th>
                                			<td> 지방 :<c:out value="${product.fat}" />,
                                			 당 : <c:out value="${product.sugars}" />, 나트륨 : <c:out value="${product.sodium}" />,카페인 : <c:out value="${product.caffeine}" /></td>
                                		</tr>
                                		<tr>
                                			<th>칼로리</th>
                                			<td><c:out value="${product.calorie}" /> kcal</td>
                                		</tr>                                 		
                                		<tr>
                                			<th>판매 상항</th>
                                			<td><c:out value="${product.fat}"/></td>
                                		</tr>                                		
                                		<tr>
                                			<th>판매 현황</th>
                                			<td><c:out value="${product.registdate}" /></td>
                                		</tr>
                                		<tr>
                                			<th>가격</th>
                                			<td>2000</td>
                                		</tr>
                                	</thead>
                                </table> --%>
          <%--                       <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                	<thead>
                                		<tr>
                                			<th>#번호</th>
                                			<th>제목</th>
                                			<th>작성자</th>
                                			<th>작성일</th>
                                			<th>수정일</th>
                                		</tr>
                                	</thead>
                                	
                                	<c:forEach items="${list}" var="list11">
                                		<tr>
                                			<td><c:out value="${list11.pcategory}" /></td>
                                			<td><c:out value="${list11.price}" /></td>
                                			<td><c:out value="${list11.calorie}" /></td>
                                			<td>지방 :<c:out value="${list11.fat}" /></td>
                                			<td><c:out value="${list11.updatedate}" /></td>
                                		</tr>
                                	</c:forEach>
                                </table> --%>
               	 	</div>
               	 	<div class="form-group  row">
						<div class="col-sm-offset-2 col-sm-10 ">
							<input type="button" class="btn btn-outline-primary " value="상세 주문" onclick="location.href='/user/User_Drink_Order?category=<%=product.get(0).getPcategory() %>'"> 
							<input type="button" class="btn btn-outline-warning "  value="목록"  onclick="location.href='/user/User_Drink_Menu'">
						</div>
					</div>
                </div>
			</div>
		</div>
	</div>
</body>
</html>