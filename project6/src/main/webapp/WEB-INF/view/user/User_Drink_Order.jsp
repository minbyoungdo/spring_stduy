
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
<script type="text/javascript">
		function change() {
			 var target = document.getElementById("cap");
			consol.log(123123);
			}
		}
	</script>
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
				<div class="card-body">
					<form name="order" class="form-horizontal" method="get" action="/user/User_Order">
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
                                			int ttmp=3;
                                			String s_hot = "hot";
                                			String s_cold="ice";
                                			while(product.get(index) !=null)
                                			{
                                				if(product.get(index).getTemperature()==0)
                                				{cold =1;}
                                				else if(product.get(index).getTemperature()==1)
                                				{hot=1;}
                                				if(product.size() == index+1)
                                				{index =0;break;}
                                				index++;
                                			}
                                			if(cold ==1 && hot ==1){
                                			%>
                                				<td>
                                					<select name="tem">
													<option value="0" selected>cold</option>
													<option value="1" >hot</option>
													</select>
                                				</td>
                                			<%
                                			}
                                			else if(cold ==1){
                                				%>
                                				<td>
                                					<select name="tem">
													<option value="0" id="tem" name ="tem" selected>cold</option>
													</select>
                                				</td>
                                			<%	
                                			}
                                			else if(hot ==1){
                                			%>
                                				<td>
                                					<select name="tem">
													<option value="1" id="tem" name="tem" selected>hot</option>
													</select>
                                				</td>
                                			<%	
                                			}
                                			%>
                                </tr>
                                <tr>
                                	<th>용량</th>
                                	<%
                                		int a=0;
                                		int start=1;
                                		int ctmp=0;
                                		boolean  shot =false;//237
                                		boolean tall = false;//355
                                		boolean grande = false;//473
                                		boolean venti = false;//591
                                		while(product.get(a) != null)
                                		{
                                			if(product.get(a).getCapacity()==237)
                                			{shot = true;}
                                			else if(product.get(a).getCapacity()==355)
                                			{tall= true;}
                                			else if(product.get(a).getCapacity()==437)
                                			{grande = true;}
                                			else if(product.get(a).getCapacity()==591)
                                			{venti = true;}
                                			if(product.size() == a+1)
                                			{a=0;break;}
                                			a++;
                                		}
                                	%>
                                	<td>
                                		<select id="cap" name ="cap" onchange="change()">
                                			<%	
                                			if(shot == true)
                                			{
                                			%>
												<option value="237" >(Short)237 ml</option>
                                			<% 
                                			}
                                			if(tall == true)
                                			{
                                			%>
												<option value="355" <c:if test ="${cap eq '355'}">selected="selected"</c:if>>(Tall) 355 ml</option>
                            				<% 
                                			}
                                			if(grande==true)
                                			{
                                			%>
												<option value="437">(Grande) 437 ml</option>
                            				<% 
                                			}
                                			%>
                                			<% 
                                			if(venti==true)
                                			{
                                			%>
												<option value="591">(Venti) 591 ml</option>
                            				<% 
                                			}
                                			%>
                                		</select>
                                	</td>
                                </tr>                              		
                                <tr>
                                	<th>가격</th>
                                		<td><%= product.get(0).getPrice() %></td>
                                </tr>
                           </thead>
                    </table>
                    </div>
					
               	 	<div class="form-group  row">
						<div class="col-sm-offset-2 col-sm-10 ">
							<input type="button" class="btn btn-outline-primary " value="장바구니에 담기" onclick="location.href='/user/User_Order?str=Checksession2&category=<%=product.get(0).getPcategory()%>&tem=0&cap=437'"> 
							<input type="button" class="btn btn-outline-danger "  value="취소"  onclick="location.href='/user/User_Drink_Menu'">
						</div>
					</div>
				</form>
                </div>
			</div>
		</div>
	</div>
</body>
</html>