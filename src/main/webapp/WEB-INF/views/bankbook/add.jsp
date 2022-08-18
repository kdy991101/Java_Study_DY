
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h1>상품 등록</h1>
		
		<form action="add.iu" method="post">
		
			<div>
				통장의 이름을 입력하세요<br><input type="text" name="bookName"><br>
			</div>
			
			<div>
				이자율을 입력하세요<br><input type="text" name="bookRate"><br>
			</div>
		
			<div>
				<input type="submit" value="등록" name="상품등록">
				<button type="submit">Add</button>
			</div>
			
		</form>
</body>
</html>