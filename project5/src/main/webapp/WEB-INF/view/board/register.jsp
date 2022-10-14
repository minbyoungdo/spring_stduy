<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
                		<h1 class="page-header">Board Register</h1>
                	</div>
                </div>
                
                <div class="row">
                	<div class="col-lg-12">
                		<div class="panel panel-defoult">
                			<form role="form" action="/board/register" method="post">
                				<div class="form-group">
                					<label>Title</label><input class="form-control" name="title">
                				</div>
                				
                				<div class="form-group">
                					<label>Text area</label>
                					<textarea class="form-control" rows="3" name="content">
                					</textarea>
                				</div>
                				
                				<div class="form-group">
                					<label>Writer</label>
                					<input class="form-control" name="writer">
                				</div>
                				
                				<button type="submit" class="btn btn-default">Submit Button</button>
                				<button type="reset" class="btn btn-default">Reset Button</button>
                			</form>
                		</div>
                	</div>
                </div>
            </div>
        </div>

    </div>
</body>

</html>