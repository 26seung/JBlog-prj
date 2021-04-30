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

	<h1>회원 가입</h1>
	
	<div class="content">
	<form
		id="join-form"
		name="registerForm" 
		action="<c:url value="/members/join"/>"
		method="POST"
		>
		<input type="hidden" name="check" value="f">
		<input type="hidden" name="a" value="join">
		
		<label for="name">이름</label>
		<input name="name" type="text" placeholder="이름을 입력하십시오"><br>
	
		<label for="id">아이디</label>
		<input type="text" name="id" placeholder="아이디를 입력하십시오.">
		<!-- 이메일 체크 버튼 -->
		<input type="button" value="id 중복 체크"
			onclick="checkid(this.form.id, '<c:url value="/members/idcheck" />')" /><br>

		<label for="password">비밀번호</label>
		<input name="password" type="password" placeholder="비밀번호를 입력하십시오"><br>
	
	
		
		
		<label for="agreement">약관동의</label><br>
		<label><input type="checkbox" name="agreement" value="M">서비스 약관에 동의합니다.</label><br>
		
		<input type="submit" value="회원가입">
		
	
	</form>
		</div>
		</div>
	
</body>
</html>