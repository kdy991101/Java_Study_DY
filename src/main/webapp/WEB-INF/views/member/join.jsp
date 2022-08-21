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
	
	<form action="join.iu" method="post">
			<div class="mb-3">
			아이디를 입력하세요<br>
		  <input type="text" class="form-control" name="username">
			</div>
			
			<div class="mb-3">
		  비밀번호를 입력하세요<br>
		  <input type="password" class="form-control" name="password">
			</div>
			
			<div class="mb-3">
		  성함를 입력하세요<br>
		  <input type="text" class="form-control" name="name">
			</div>
			
			<div class="mb-3">
		  전화번호를 입력하세요<br>
		  <input type="tel" class="form-control" name="phone">
			</div>
			
			<div class="mb-3">
 			Email 입력하세요<br>
  			<input type="email" class="form-control" name="emil">
			</div>
			
			 <button type="submit" class="btn btn-secondary">로그인</button>
	
	<!-- <div>
	
        ID <input type="text" name="username"> <br>
        비밀번호 <input type="password" name="password"> <br>
        이름 <input type="text" name="name"> <br>
        이메일 <input type="email" name="email"> <br>
        전화번호 <input type="tel" name="phone"> <br>
       
        <input type="submit" value="회원가입">
    </div> -->
    </form>
    
    
	</div>
</section>
</body>
</html>