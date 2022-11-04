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
                                			<td><c:out value="${product.pcategory}" /></td>
                                		</tr>
                                		<tr>
                                			<th>메뉴 명</th>
                                			<td><c:out value="${product.pname}" /></td>
                                		</tr>
                                		<tr>
                                			<th>함량</th>
                                			<td>1555523</td>
                                		</tr>                                		
                                		<tr>
                                			<th>판매 상항</th>
                                			<td>125553</td>
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
                                </table>
           
               	 	</div>
               	 	<div class="form-group  row">
						<div class="col-sm-offset-2 col-sm-10 ">
							<input type="submit" class="btn btn-outline-primary " value="상세 주문" > 
							<input type="button" class="btn btn-outline-warning "  value="목록"  onclick="location.href='/user/User_Drink_Menu'">
						</div>
					</div>
                </div>
			</div>
		</div>
	</div>
</body>
</html>