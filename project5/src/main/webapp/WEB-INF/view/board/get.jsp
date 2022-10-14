<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<%@include file="../include/header.jsp" %>
<body class="bg-gradient-primary">

    <div class="container">

        <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-5">
                <!-- Nested Row within Card Body -->
                <div class="row">
                	<div class="col-lg-12">
                		<h1 class="page-header">게시물 1개 조회</h1>
                	</div>
                	
                </div>
                
                <div class="row">
                	<div class="col-lg-12">
                		<div class="panel panel-default">
                			<div class="panel-heading">Board Read Page</div>
                			
                			<div class="panel-body">
                				<div class="form-group">
                					<label>Bno</label><input class="form-control" name="bno"
                					value='<c:out value="${board.bno}"/>' readonly="readonly">
                				</div>
                				
                				<div class="form-group">
                					<label>Title</label><input class="form-control" name="title"
                					value='<c:out value="${board.title}"/>' readonly="readonly">
                				</div>
                				
                				<div class="form-group">
                					<label>Text area</label>
                					<textarea class="form-control"rows="3" name="cnotent"
                					 readonly="readonly"><c:out value="${board.content}"/></textarea>
                				</div>
                				
                				<div  class="form-group">
                					<label>Writer</label><input class="form-control" name="writer"
                					value='<c:out value="${board.writer }"/>' readonly="readonly">
                				</div>
                				<button data-oper='modify' class="btn btn-default">
                				<a href="/board/modify?bno=<c:out value="${board.bno }"/>">
                				Modify</a></button>
                				<button data-oper='list' class="btn btn-info">
                				<a href="/board/list">list</a></button>
                			</div>
                		</div>
                	</div>
                </div>
                
            </div>
        </div>
    </div>
</body>

</html>