<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 List</title>
</head>
<body>
	<h3>List Page</h3>
	
	<table border="1">
		<thead>
			<tr>
				<th>username</th>
				<th>password</th>
				<th>name</th>
				<th>email</th>
				<th>phone</th>
			</tr>
		</thead>
		
		<tbody>
		<c:forEach items="${requestScope.list}" var="dto">
			<tr>
				<td>${pageScope.dto.username}</td>
				<td>${pageScope.dto.password}</td>
				<td>${pageScope.dto.name}</td>
				<td>${pageScope.dto.email}</td>
				<td>${pageScope.dto.phone}</td>
			</tr>
		</c:forEach>
		</tbody>

	</table>

</body>
</html>