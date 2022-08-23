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
	<h1>글 상세보기</h1>
		<table class="table table-striped">
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
			<tr>
				<td>${boardDTO.num}</td>
				<td>${boardDTO.title}</td>
				<td>${boardDTO.writer}</td>
				<td>${boardDTO.regDate}</td>
				<td>${boardDTO.hit}</td>
			</tr>
		</tbody>
		
</table>


  <label for="exampleFormControlTextarea1" class="form-label"><b>내용</b></label>
         <textarea class="form-control" readonly id="exampleFormControlTextarea1" rows="20">${requestScope.boardDTO.contents}</textarea>


	<a class="btn btn-secondary" href="./update.iu?num=${boardDTO.num}" role="update">수정</a>
	<a class="btn btn-secondary" href="delete.iu?num=${boardDTO.num}" role="delete">삭제</a>
</section>
 <c:import url="../template/footer.jsp"></c:import>
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>

</body>
</html>