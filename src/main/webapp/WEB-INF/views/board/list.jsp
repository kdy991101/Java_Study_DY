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
<c:import url="../template/header.jsp"></c:import>
	<section class="container-fluid col-lg-5 mt-5">
	<h1 class="align-center">${board}</h1>
	
	<div class="row">
			<form action="./list.iu"  class="row row-cols-lg-auto g-3 align-items-center">
			  <div class="col-12">
			    <label class="visually-hidden" for="kind">Kind</label>
			    <select  name="kind" class="form-select" id="kind">
			      <option value="contents">내용</option>
			      <option value="title">제목</option>
			      <option value="writer">작성자</option>
			    </select>
			    <!-- kind란 이름으로 넘어감 -->
			  </div>
			  
			  <div class="col-12">
			    <label class="visually-hidden" for="search">검색어</label>
			    <div class="input-group">
			      <input type="text" name="search" var="" class="form-control" placeholder="검색어를 입력해 주세요">
			    </div>
			  </div>
			
			  <div class="col-12">
			    <button type="submit" class="btn btn-secondary">검색</button>
			  </div>
			</form>
		</div>
	
	<table class="table table-striped">
		<!--  NUM, TITLE, WRITER, REGDATE, HIT -->
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
						<c:forEach items="${requestScope.list}" var="list">
						<tr>
							<td>${list.num}</td>
							<td>
							<c:catch>
								<c:forEach begin="1" end="${list.depth}">&ensp;</c:forEach>
							</c:catch>
							<a  href ="detail.iu?num=${list.num}">${list.title}</a></td>
							<td>${list.writer}</td>
							<td>${list.regDate}</td>
							<td>${list.hit}</td>
						</tr>
						</c:forEach>
					</tbody>
		
		</table>
		
		<div>
			<a class="btn btn-secondary" href="./add.iu" role="add">공지사항 등록</a>
		</div>
		
		<nav aria-label="Page navigation example">
		  		<ul class="pagination">
		  			<c:if test="${pager.pre}">
		    			<li class="page-item"><a class="page-link" href="./list.iu?page=${pager.startNum-1}&kind=${pager.kind}&search=${pager.search}">◁</a></li>
		    		</c:if>
		    		
		    		<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
			  			<li class="page-item">
			  				<a class="page-link" href="./list.iu?page=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a>
			  			</li>
		  			</c:forEach>
		    		
		       <%-- <c:choose >
		    			<c:when test="${pager.next}">
		    				<li class="page-item">    		
		    			</c:when>
		    		</c:choose>
		    		
		    		<c:otherwise>
					    <li class="page-item disabled">	
		    		</c:otherwise> --%>
		    		
		    			<li class="page-item ${pager.next?'':'disabled'}">    	
		    				<a class="page-link" href="./list.iu?page=${pager.lastNum+1}">▷</a>
		    			</li>
		  				</ul>
			</nav>
		</section>
 			<c:import url="../template/footer.jsp"></c:import>
			 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous">
 		</script>
	</body>
</html>