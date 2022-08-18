<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>BankBook Detail</h1>
	<a href="./list.iu">상품 보기</a>
	
	<!-- /bankbook/detail -->
	<!-- link 주소는 상대경로 작 -->
	
	<!-- 상대경로 -->
	<c:if test="${empty sessionScope.member}">
		<a href="/member/login.iu">Join</a>
		<a href="./update.iu?bookNum=${detail.bookNum}">수정</a>
		<a href="delete.iu?bookNum=${detail.bookNum}">삭제</a>
		</c:if>
		
	<c:if test="${not empty sessionScope.member}">
		<a href="/member/login.iu">Join</a>
		<a href="./update.iu?bookNum=${detail.bookNum}">수정</a>
		<a href="delete.iu?bookNum=${detail.bookNum}">삭제</a>
		<a href="../bankAccount/add.iu?bookNum=${detail.bookNum}">가입하기</a>
		 </c:if>
	
	
<table border="1">
	<thead>
		<tr>
			<th>bookNum</th><th>bookName</th><th>bookRate</th><th>bookSale</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>${detail.bookNum}</td>
			<td>${detail.bookName}</td>
			<td>${detail.bookRate}</td>
		</tr>
	</tbody>
</table>
</body>
</html>