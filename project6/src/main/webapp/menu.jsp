<%@ page contentType ="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<link rel ="stylesheet" href ="./resources/css/bootstrap.min.css"/>
<%
	String sessionId = (String) session.getAttribute("sessionId");
%>
<nav class="navbar navbar-expand-lg" style="background-color: 	#FFA500;">
  <div class="container-fluid">
    <a class="navbar-brand" href="./MainHome.jsp"><font style="vertical-align: inherit;"><font style="vertical-align: inherit; color:white;">MainHome</font></font></a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor02" aria-controls="navbarColor01" aria-expanded="false" aria-label="탐색 전환">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarColor01">
      <ul class="navbar-nav ml-auto">
     <c:choose>
      	<c:when test="${empty sessionId}">
        <li class="nav-item">
          <a class="nav-link active" href="./login.jsp"><font style="vertical-align: inherit;"><font style="vertical-align: inherit; color:white;">로그인</font></font></span></a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="./addMember.jsp"><font style="vertical-align: inherit;"><font style="vertical-align: inherit; color:white;">회원가입</font></font></a>
        </li>
       </c:when>
        <c:otherwise>
         	<li class="nav-item">
          	<a class="nav-link active" href="./LogoutUser.jsp"><font style="vertical-align: inherit;"><font style="vertical-align: inherit; color:white;">로그아웃</font></font></span></a>
        	</li>
        	<li class="nav-item">
         	 <a class="nav-link" href="./editUser.jsp"><font style="vertical-align: inherit;"><font style="vertical-align: inherit; color:white;">회원 정보</font></font></a>
       		</li>
        </c:otherwise>
        </c:choose> 
 		 <li class="nav-item">
          <a class="nav-link" href="<c:url value="BoardListAction.do?pageNum=1"/>">
          <font style="vertical-align: inherit;"><font style="vertical-align: inherit; color:white;">
          게시판</font></font></a>
        </li>
        
    </div>
  </div>
</nav>