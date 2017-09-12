<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
	<c:when test="${not empty sessionScope.loginId}">
		<header>
			<a href="/test">Home</a>
			<a href="board/list">Contact</a>
			<a href="making">making</a>
			<a href="advanced">Advanced</a>
			${sessionScope.loginName} 님 로그인 중
			<a href="customer/update">개인정보 수정</a>
			<a href="customer/logout">Log out</a>
		</header>
	</c:when>
	
	<c:otherwise>
		<header>
			<a href="/test">Home</a>
			<a href="board/list">Contact</a>
			<a href="making">making</a>
			<a href="customer/join">Join</a>
			<a href="customer/login">Login</a>
		</header>
	</c:otherwise>
</c:choose>