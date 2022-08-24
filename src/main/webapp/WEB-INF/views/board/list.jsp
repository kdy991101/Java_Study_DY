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
	<section class="container-fluid col-lg-5 mt-5">
	<h1 class="align-center">${board}</h1>
	<table class="table table-striped">
<!--  NUM, TITLE, WRITER, REGDATE, HIT -->
		<thead>
			<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>날짜</th>
			<th>조회수</th>
			</tr>
		</thead>
			<tbody>
				<c:forEach items="${requestScope.list}" var="list">
				<tr>
					<td>${list.num}</td>
					<td><a href ="detail.iu?num=${list.num}">${list.title}</a></td>
					<td>${list.writer}</td>
					<td>${list.regDate}</td>
					<td>${list.hit}</td>
				</tr>
				</c:forEach>
			</tbody>

</table>
<a class="btn btn-secondary" href="./add.iu" role="add">공지사항 등록</a>
</section>
 <c:import url="../template/footer.jsp"></c:import>
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>

</body>
</html>