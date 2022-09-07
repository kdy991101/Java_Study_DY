<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>

	<h1>BankBook Detail</h1>
<c:import url="../template/header.jsp"></c:import>
<section class="container-fluid col-lg-5 mt-5">
	
	<!-- /bankbook/detail -->
	<!-- link 주소는 상대경로 작 -->
	
	<!-- 상대경로 -->

	<table class="table table-striped">
	<thead>
		<tr>
			<th>bookNum</th><th>bookName</th><th>bookRate</th><th>bookSale</th><th>bookContents</th>
		</tr>
	</thead>

	<tbody>
		<tr>
			<td>${detail.bookNum}</td>
			<td>${detail.bookName}</td>
			<td>${detail.bookRate}</td>
			<td>${detail.bookSale}</td>
			<td>${detail.bookContents}</td>
		</tr>
	</tbody>
</table>

	<!-- 비 로그인 -->
	<c:if test="${empty sessionScope.member}">
		<a class="btn btn-secondary" href="./list.iu" role="List">상품리스트로 돌아가기</a>
		<a class="btn btn-secondary" href="/member/login.iu" role="Join">로그인</a>
		<a class="btn btn-secondary" href="./update.iu?bookNum=${detail.bookNum}" role="Update">수정</a>
		<a class="btn btn-secondary" href="delete.iu?bookNum=${detail.bookNum}" role="delete">삭제</a>
	</c:if>
		
	<!-- 로그인 했을 때 -->
	<c:if test="${not empty sessionScope.member}">
		<a class="btn btn-secondary" href="./list.iu" role="List">상품리스트로 돌아가기</a>
		<a class="btn btn-secondary" href="./update.iu?bookNum=${detail.bookNum}" role="Update">수정</a>
		<a class="btn btn-secondary" href="delete.iu?bookNum=${detail.bookNum}" role="delete">삭제</a>
		<a class="btn btn-secondary" href="../bankAccount/add.iu?bookNum=${detail.bookNum}" role="detail">가입</a>
	</c:if> 

	<!-- comment시작 -->
	<div class="row">

		<div class="mb-3">
			<label for="writer" class="form-label">USERNAME</label>
			<input type="text" class="form-control" id="writer" placeholder="Enter Your USERNAME">
		</div>

		<div class="mb-3">
			<label for="contents" class="form-label">WRITE CONTENTS</label>
			<textarea class="form-control" id="contents" rows="3"></textarea>
		</div>

		<div class="mb-3">
			<button type="button" id="btn" data-bookNum="${detail.bookNum}">댓글 작성</button>
		</div>

		<!-- comment List -->
		<div>
			<table class="table table-striped" id="commentList">

			</table>
			
			
		</div>
		<button id="more" class="btn btn-danger disabled">더보기</button>

		

	</div>
	<!-- comment끝 -->
	<!-- ====================================Modal================================== -->
		<div>
			<button type="button" class="btn btn-primary" style="display: none;" id="up" data-bs-toggle="modal"
				data-bs-target="#exampleModal" data-bs-whatever="@getbootstrap">Openmodal for @getbootstrap</button>

			<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel">Update</h5>
							<button type="button" class="btn-close" data-bs-dismiss="modal"
								aria-label="Close"></button>
						</div>
						<div class="modal-body">
							<form>
								<div class="mb-3">
									<label for="recipient-name" class="col-form-label">writer:</label>
									<input type="text" class="form-control" id="recipient-name">
								</div>
								
								<div class="mb-3">
									<label for="message-text" class="col-form-label">contents:</label>
									<textarea class="form-control" id="message-text"></textarea>
								</div>
							</form>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-bs-dismiss="modal">Close</button>
							<button type="button" class="btn btn-primary">Send
								message</button>
						</div>
					</div>
				</div>
			</div>
	</section>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>

<script src="/resources/js/bankBookComment.js"></script>
</body>
</html>