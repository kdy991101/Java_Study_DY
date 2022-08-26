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
			      <th scope="col">username</th>
			      <th scope="col">name</th>
			      <th scope="col">email</th>
			      <th scope="col">phone</th>
			</tr>
		</thead>
		
		<tbody>
			<tr>
				<td>${requestScope.dto.username}</td>
				<td>${requestScope.dto.name}</td>
				<td>${requestScope.dto.email}</td>
				<td>${requestScope.dto.phone}</td>		
			</tr>
		</tbody>
		
	</table>
</section>
<section class="container-fluid col-lg-10 mt-5">
	<h3>가입상품</h3>
	<table class="table table-striped">
		<thead>
			<tr>
			      <th scope="col">accountNum</th>
			      <th scope="col">bookName</th>
			      <th scope="col">accountDate</th>
			</tr>
		</thead>
		
		<tbody>
				<c:forEach items="${dto.bankAccountDTOs}" var="dto">
			<tr>
					<td>${dto.accountNum}</td>
					<td>${dto.bankBookDTO.bookName}</td>
					<td>${dto.accountDate}</td>
			</tr>
				</c:forEach>
		
		</tbody>
	</table>
	<div class="row">
		<img alt="" src="../resources/upload/member/${dto.bankMembersFileDTO.fileName}">
				
	</div>
</section>
</body>
</html>