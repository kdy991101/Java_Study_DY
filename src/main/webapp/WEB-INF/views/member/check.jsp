<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>동의</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
 <c:import url="../template/header.jsp"></c:import>
<h3>약관 동의</h3>
<div>
  전체동의<input type="checkbox" name="" id="all">
  동의1(필수)<input type="checkbox" name="" id="" class="cb req">
  동의2(필수)<input type="checkbox" name="" id="" class="cb req">
  동의3(선택)<input type="checkbox" name="" id="" class="cb">
</div>

	<form action="./join.iu" id="frm">
		<button type="button" id="join">회원가입</button>
	</form>


<script src="/resources/js/member.js"></script>
<script>
  check();
</script>
</body>
</html>