<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
	prefix="c" %>  
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Jblog</title>
	<style type="text/css">
		.contatiner{
				text-align: center; 
		}
		.content{
				width: 100%;
        		height: 100%;
       			display: flex;
       			justify-content: space-around;
       			align-items: center;
		}
	
	</style>
</head>
<body>
	<div class="contatiner">
	<jsp:include page="/WEB-INF/views/inc/header.jsp" />
	<jsp:include page="/WEB-INF/views/inc/navigation.jsp" />

	<h2>"감사합니다. 회원 가입 및 블로그가 성공적으로 만들어 졌습니다."</h2>
	
	<div class="content">
	<span><a href="<c:url value="/members/login" />">로그인 하기</a></span>
		</div>
		</div>
	
</body>
</html>