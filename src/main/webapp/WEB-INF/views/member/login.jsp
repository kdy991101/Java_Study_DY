<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인을 하세요</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
    <c:import url="../template/header.jsp"></c:import>
 			<form action="./login.iu" method="post" id="memberForm">
 
 	<section class="container-fluid col-lg-2 mt-5">
<h3>로그인</h3>
 		<div class="row">
 			
				  <div class="mb-3">
				   
				    <input type="text" placeholder="아이디를 입력해주세요"class="form-control" name="username" id="username">
				  </div>
				  <div class="mb-3">
	
				    <input type="password"  placeholder="비밀번호를 입력해주세요" class="form-control" name="password" id="password">
				  </div>
				  <button type="button" class="btn btn-secondary" id="memberButton">로그인</button>

 		</div>
 	</section>   
				</form>
 <!--    <form action="./login.iu" method="post">
    
        <div class="container">
            ID를 입력하세요<br> <input type="text" value="qwer" name="username" placeholder="아이디"><br>
            PW를 입력하세요<br><input type="password" value="wer" name="password" placeholder="비밀번호"><br> 
            
        </div>

        <div>
           로그인 상태 유지<input type="checkbox" name="로그인 상태 유지"><br>
            <input type="submit" value="로그인">
            <input type="reset" value="초기화">
        </div>

        <div>
            <a href="../study_index.html">index로 돌아가기</a><br>

            
        </div> -->
    <c:import url="../template/footer.jsp"></c:import>
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
<script src="/resources/js/member.js"></script>
</body>
</html>