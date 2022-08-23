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
	<section class="container-fluid col-lg-2 mt-5">
		<h1>수정</h1>
	<div class="row">
		<form action="update.iu" method="post">
		<input type="hidden" name=num value="${boardDTO.num}">
		
			<div class="mb-3">
				<br><input type="text" class="form-control" name="title" value="${boardDTO.title}">
			</div>

			<textarea name="contents" rows="10" cols="50">${boardDTO.contents}</textarea>
		
			<div class="mb-3">
				<input type="submit" class="btn btn-secondary" value="등록" name="글등록">
			</div>
			
		</form>
		</div>
		</section>
</body>
</html>