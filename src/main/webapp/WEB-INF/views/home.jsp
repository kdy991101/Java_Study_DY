<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
<h3>ADD VSCORD</h3>
<h3>add Spring</h3>

<P>  The time on the server is ${serverTime}. </P>

<div>
	<h4>MEMBER</h4>
<c:if test="${empty sessionScope.member}">
	<a href="./member/login.iu">로그인</a>
	<a href="./member/join.iu">회원가입</a>
</c:if>	
	
<c:if test="${not empty sessionScope.member}">
	<h3>★${sessionScope.member.username}님 환영합니다★</h3>
	<a href="./member/logout.iu">로그아웃</a>
	<a href="#">내 정보</a>
</c:if>

	<a href="./member/search.iu">ID찾기</a>
</div>


<div>
	<h4>BANKBOOK</h4>
	<a href="./bankbook/list.iu">상품 List</a>

</div>


</body>
</html>
