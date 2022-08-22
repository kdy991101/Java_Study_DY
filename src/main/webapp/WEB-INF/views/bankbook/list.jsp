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
	<!-- /bankbook/list -->
	<section class="container-fluid col-lg-5 mt-5">
	<h1>BankBook List</h1>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Name</th><th>Rate</th>
			</tr>
		</thead>
		<tbody>			

				<c:forEach items="${requestScope.list}" var="dto">
				
				<tr>
					<td><a href ="detail.iu?bookNum=${dto.bookNum}">${dto.bookName}</a></td>
					<td>${dto.bookRate}</td>
				</tr>
			
			</c:forEach>
		</tbody>
	
	</table>
		<a class="btn btn-secondary" href="./add.iu" role="add">상품 등록</a>
</section>
</body>
</html>