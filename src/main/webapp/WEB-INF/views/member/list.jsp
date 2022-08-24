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
<c:import url="../template/header.jsp"></c:import>
	<section class="container-fluid col-lg-10 mt-5">
	<h3>List Page</h3>

	<table class="table table-striped">
		<thead>
			<tr>
	<!-- 			<th>username</th>
				<th>password</th>
				<th>name</th>
				<th>email</th>
				<th>phone</th> -->
			      <th scope="col">아이디</th>
			      <th scope="col">비밀번호</th>
			      <th scope="col">이름</th>
			      <th scope="col">email</th>
			      <th scope="col">전화번호</th>
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
<c:import url="../template/footer.jsp"></c:import>
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>

</body>
</html>