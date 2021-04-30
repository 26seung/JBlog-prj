<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
	prefix="c" %>

	<div id="navigation">
	
			<c:choose>
			<c:when test="${empty authUser }"> <!-- authUser == null: 로그인 안함 -->
				<span><a href="<c:url value="/members/login" />">로그인</a></span>
				<span><a href="<c:url value="/members/join" />">회원가입</a></span>				
			</c:when>
			<c:otherwise>	<!-- 로그인 한 상태 -->
				<li><a href="<c:url value="/members/logout" />">로그아웃</a></li>
				<li>${authUser.name }님 안녕하세요</li>
			</c:otherwise>
			</c:choose>
			
	</div>
