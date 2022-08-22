<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
    <c:import url="../template/header.jsp"></c:import>
	<section class="container-fluid col-lg-10 mt-5">
	<h3>my Page</h3>


	<table class="table table-striped">
		<thead>
			<tr>
	<!-- 			<th>username</th>
				<th>password</th>
				<th>name</th>
				<th>email</th>
				<th>phone</th> -->
			      <th scope="col">username</th>
			      <th scope="col">name</th>
			      <th scope="col">email</th>
			      <th scope="col">phone</th>
			</tr>
		</thead>
		
		<tbody>

			<tr>
				<td>${dto.username}</td>
				<td>${dto.name}</td>
				<td>${dto.email}</td>
				<td>${dto.phone}</td>
			</tr>
		
		</tbody>
	</table>
	</form>
</section>
</body>
</html>