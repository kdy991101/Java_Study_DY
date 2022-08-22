<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>회원정보찾기</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
   <c:import url="../template/header.jsp"></c:import>
	<section class="container-fluid col-lg-2 mt-5">
	<h3>아이디 찾기</h3>
 		<div class="row">
 		
 		<table class="table table-striped table-hover">
			<form action="search.iu" method="post">
				<input type="text" placeholder="아이디를 입력해주세요" name="search">
						<button type="submit" class="btn btn-secondary">검색</button>
				</form>
		</table>
 		</div>
 	</section>
		<c:import url="../template/footer.jsp"></c:import>
	 
</body>
</html>


