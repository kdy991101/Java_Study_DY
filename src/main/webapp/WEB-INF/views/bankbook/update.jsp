<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>업데이트 페이지</h1>
<form action="update.iu" method="post">

	<input type="hidden" name="bookNum" readonly="readonly" value="${detail.bookNum}">
	
	
	
	<div>
		NAME : <input type="text" name="bookName" value="${detail.bookName}">
	</div>
	
	<div>
		Rate : <input type="text" name="bookRate" value="${detail.bookRate}">
	</div>
	
	<div>
		 <input type="submit" value="수정">
	</div>
	
</form>

</body>
</html>