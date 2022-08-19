<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 List</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
	<h3>List Page</h3>
	<section class="container-fluid col-lg-10 mt-5">

	<table class="table table-striped">
		<thead>
			<tr>
	<!-- 			<th>username</th>
				<th>password</th>
				<th>name</th>
				<th>email</th>
				<th>phone</th> -->
			      <th scope="col">username</th>
			      <th scope="col">password</th>
			      <th scope="col">name</th>
			      <th scope="col">email</th>
			      <th scope="col">phone</th>
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
</section>
</body>
</html>