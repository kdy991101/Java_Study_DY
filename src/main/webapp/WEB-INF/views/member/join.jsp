<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<h3>Join Page</h3>
	
	<form action="join.iu" method="post">
	<div>
	
        ID <input type="text" name="username"> <br>
        비밀번호 <input type="password" name="password"> <br>
        이름 <input type="text" name="name"> <br>
        이메일 <input type="email" name="email"> <br>
        전화번호 <input type="tel" name="phone"> <br>
       
        <input type="submit" value="회원가입">
    </div>
    </form>
	

</body>
</html>