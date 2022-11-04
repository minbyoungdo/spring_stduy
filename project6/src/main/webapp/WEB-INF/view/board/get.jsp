<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<%@include file="../include/header.jsp" %>
<body class="bg-gradient-primary">
	<script type="text/javascript" src ="/resources/js/reply.js"></script>
	<script>
	console.log("===============");
	console.log("JS Tset");
	var bnoValue='<c:out value="${board.bno}"/>';

	//for replyService add test
/*  	replyService.add(
		{reply:"JS Test", replyer:"tester",bno:bnoValue},
		function(result)
		{
			alert("RESULT:"+result);
		}
	);
 
	replyService.getList({bno:bnoValue, page:1}, function(list){
		for(var i=0, len=list.length||0;i<len;i++){
			console.log(list[i]);
		}
	}); 
	
	//삭제
	replyService.remove(30,function(count){
		console.log(count);
		
		if(count=="success"){
			alert("removed");
		}
	},function(err){
		alert('Error...........1');
	});
	
	replyService.update({
		rno :22,
		bno : bnoValue,
		reply : "modified reply..."
	},function(result){
		alert("수정완료...");	
	});
	replyService.get(14,function(data){
		console.log(data);
	});*/
	
	
	function showList(page){
		replyService.getList({bno:bnoValue, page : page || 1}, function(list){
			var str ="";
			if(list == null || list.length ==0){
				replyUL.html("rrr");
				return;
			}
			for(var i=0, len = list.length || 0; i<len ; i++){
				str+="<li class ='letf clearfix' data-rno='"+list[i].rno+"'>";
				str+="	 <div><div class='header'><strong class='primary-font'>"+list[i].replyer+"</strong>";
				str+="		<small class='pull-right text-muted'>"+list[i].replyDate+"</small></div>";
				str+="		<p>"+list[i].reply+"</p></div></li>";
			}
			replyUL.html(str);
			
		});
	}
	</script>
	
	<script type="text/javascript">
		$(function(){
			const formObj = $("#operForm");
			$('button').on("click",function(e)
			{
				e.preventDefault();
				const operation = $(this).data("oper");
				console.log(operation);
				if(operation === 'remove')
				{
					formObj.attr("action", "/board/remove");
				}
				else if(operation === "list")
				{
					//self.location="/board/list";
					formObj.find("#bno").remove();
					formObj.attr("action","/board/list");
				}
				formObj.submit();
			});
		});
	</script>
	
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
                		<%-- 		<button data-oper='modify' class="btn btn-default">
                				<a href="/board/modify?bno=<c:out value="${board.bno }"/>">
                				Modify</a></button>
                				<button data-oper='remove' class="btn btn-danger">
                					<a href="/board/remove?bno=<c:out value="${ board.bno}"/>">Remove</a>
                				</button>
                				<button data-oper='list' class="btn btn-info">
                				<a href="/board/list">list</a></button> --%>
                				<button type="submit" data-oper='modify' class="btn btn-default">Modify</button>
                				<button type="submit" data-oper='remove' class="btn btn-danger">Remove</button>
                				<button type="submit" data-oper='list' class="btn btn-info">List</button>
                				
                				<form id='operForm' action="/board/modify" method="get">
                					<input type='hidden' id='bno' name='bno' value='<c:out value="${board.bno}"/>'>
                				</form>
                			</div>
                		</div>
                	</div>
                </div>
                
            </div>
        </div>
    </div>
</body>

</html>