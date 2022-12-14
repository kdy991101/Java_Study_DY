
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
	<section class="container-fluid col-lg-4 mt-5">
	<div class="row">
		<h1 class="align-center">${board}답글</h1>
		
		<form action="reply.iu" method="post">
		<input type="hidden" name="num" value="${boardDTO.num}">
		
			 <div class="mb-3">
				<br><input type="text" placeholder="제목을 입력해주세요" class="form-control" name="title">
			</div>
			
			<div class="mb-3">
				<br><input type="text" placeholder="작성자의 이름을 입력해주세요"class="form-control" name="writer">
			</div> 
			
			<textarea id="contents" placeholder="내용을 입력해주세요" name="contents" rows="10" cols="80"></textarea>
		
			<div class="mb-3">
				<input type="submit" class="btn btn-secondary" value="등록" name="글등록">
			</div>
			
		</form>
		</div>
		</section>
		 <c:import url="../template/footer.jsp"></c:import>
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
		
</body>
</html>