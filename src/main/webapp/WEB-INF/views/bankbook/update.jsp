<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

	<input type="hidden" name="bookNum" readonly="readonly" value="${detail.bookNum}">
	
	
	
	<div class="mb-3">
		NAME : <input type="text" class="form-control" name="bookName" value="${detail.bookName}">
	</div>
	
	<div class="mb-3">
		Rate : <input type="text" class="form-control" name="bookRate" value="${detail.bookRate}">
	</div>
	
	<div class="mb-3">
		Contents : <input type="text" class="form-control" name="bookContents" value="${detail.bookContents}">
	</div>
	
	<div class="mb-3">
		 <input type="submit"  class="btn btn-secondary" value="수정">
	</div>
	
</form>

</div>
</section>
</body>
</html>