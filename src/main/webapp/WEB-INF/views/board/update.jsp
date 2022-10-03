<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
            <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<!-- summerJqury -->
<script type="text/javascript" src="//code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- include summernote css/js-->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
				<section class="container-fluid col-lg-5 mt-5">
		<h1 class="align-center">${board}</h1>
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
</section>

	<section class="container-fluid col-lg-3 mt-5">
	<div class="row">
		<form action="./update.iu" method="post" enctype="multipart/form-data">
		<input type="hidden" name=num value="${boardDTO.num}">
		
			<div class="mb-3">
				제목<br><input type="text" class="form-control" name="title" value="${boardDTO.title}">
			</div>
			내용<br><textarea name="contents" rows="10" cols="60">${boardDTO.contents}</textarea>

			<c:forEach items="${boardDTO.boardFileDTOs}" var="fileDTO">
			   <div class="mb-3">
               <span>${fileDTO.oriName}</span>
               <button type="button" class="fileDelete" data-file-num="${fileDTO.fileNum}">삭제</button>
               </div>
			</c:forEach>
			
			<div id="addFiles">
				<button type="button" id="fileAdd">파일추가</button>
			</div>
			<div class="mb-3">
				<input type="submit" class="btn btn-secondary" value="등록" name="글등록">
			</div>
			
		</form>
		</div>
		</section>
		 <c:import url="../template/footer.jsp"></c:import>
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
		<script src="/resources/js/board_files.js"></script>
		<script>
			setCount(${boardDTO.boardFileDTOs.size()});
		</script>
			<script type="text/javascript">
				$("#contents").summernote();
			</script>
</body>
</html>