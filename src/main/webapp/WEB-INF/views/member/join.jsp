<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
	<section class="container-fluid col-lg-2 mt-5">
	<h3>회원가입</h3>
	<div class="row">
	
	<form action="join.iu" method="post" enctype="multipart/form-data">
	
			<div class="mb-3">
		  		<input type="text" placeholder="아이디를 입력해주세요"class="form-control" name="username">
			</div>
			
			<div class="mb-3">
		  		<input type="password" placeholder="비밀번호를 입력해주세요"class="form-control" name="password">
			</div>
			
			<div class="mb-3">
		  		<input type="text" placeholder="이름을 입력해주세요"class="form-control" name="name">
			</div>
			
			<div class="mb-3">
			  <input type="tel" placeholder="전화번호를 입력해주세요"class="form-control" name="phone">
			</div>
			
			<div>
				<p>Photo</p>
				<p><input class="form-control form-control-lg" type="file" aria-label=".form-control-lg example" name="photo" id="files"></p>
			</div>
			
			<div class="mb-3">
  				<input type="email" placeholder="이메일을 입력해주세요"class="form-control" name="email">
			</div>
			
			 <button type="submit" class="btn btn-secondary">로그인</button>

    </form>
	</div>
</section>
</body>
</html>