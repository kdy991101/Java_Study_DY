
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
	<div class="row">
		<h1>상품 등록</h1>
		
		<form action="add.iu" method="post">
		
			<div class="mb-3">
				<br><input type="text" placeholder="통장의 이름을 입력해주세요" class="form-control" name="bookName">
			</div>
			
			<div class="mb-3">
				<br><input type="text" placeholder="이자율을 입력해주세요"class="form-control" name="bookRate">
			</div>
			
			<div class="mb-3">
			<br><input type="text" placeholder="CONTENTS를 입력해주세요"class="form-control" name="bookContents">
			</div>
		
			<div class="mb-3">
				<input type="submit" class="btn btn-secondary" value="등록" name="상품등록">
			</div>
			
		</form>
		</div>
		</section>
</body>
</html>