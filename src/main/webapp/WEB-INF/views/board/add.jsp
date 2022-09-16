<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<!-- bootStrap -->
<!-- jQuery -->
<script type="text/javascript" src="//code.jquery.com/jquery-3.6.0.min.js"></script>
<title>Insert title here</title>
<!-- include summernote css/js-->
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
	<h1>${board} Add Page</h1>
	
	<form action="add.iu" method="post" enctype="multipart/form-data">
	
		<div class="mb-3">
			<label for="exampleFormControlInput1" class="form-label">Title</label>
			<input type="text" class="form-control" name="title">
		</div>
		<div class="mb-3">
			<label for="inputPassword" class="form-label">Writer</label>
			<input type="text" class="form-control" name="writer"></input>
		</div>
		<div class="mb-3">
			<label for="inputPassword" class="form-label">Contents</label>
			<input type="text" class="form-control" name="contents"></input>
			<textarea class="form-control" name="contents" id="contents" rows="3"></textarea>
		</div>

		<div id="addFiles">
			<button type="button" id="fileAdd">파일추가</button>

		</div>
<!-- <div class="mb-3">
			<label for="files" class="form-label">File</label>
			<input type="file" class="form-control" name="files" id="files" placeholder="파일 입력"></input>
		</div>
		<div class="mb-3">
			<label for="files" class="form-label">File</label>
			<input type="file" class="form-control" name="files" id="files" placeholder="파일 입력"></input>
		</div>
		<div class="mb-3">
			<label for="files" class="form-label">File</label>
			<input type="file" class="form-control" name="files" id="files" placeholder="파일 입력"></input>
		</div> -->
		<input type="submit">
		</form>
		<c:import url="../template/footer.jsp"></c:import>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
	<script type="text/javascript">
		$("#contents").summernote();
	</script>
	<script src="/resources/js/board_files.js"></script>
<!-- bootStrap -->
</body>
</html>