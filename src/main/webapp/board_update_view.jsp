<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
<style type="text/css">
	section{
		width: 1200px;
		margin:0 auto;
	}
	
	section form {
		display: flex;
		flex-direction: column;  
	}
	form > * {
		margin-top :10px;
	}
	.form_bar > button{
		width: 50%;
		box-sizing: border-box;
		font-size: 20px;
		height: 50px;
		
	}
	section h2{
		text-align: center;
	}
	section form > input{
		height: 30px;
		font-size: 20px;
	}
	section form > textarea{
		height: 300px;
		font-size: 20px;
		resize: none;
	}
	
</style>
<script type="text/javascript">
	window.onload = function(){
		var btnBack = document.querySelector(".btn_back");
		btnBack.onclick = function(){
			history.back();
		}
	}
</script>
</head>
<body>
	<jsp:include page="template/header.jsp"></jsp:include>
	<c:if test="${sessionScope.dto.id != requestScope.board.writer }">
		<script>
			location.href = "main.do";
		</script>
	</c:if>
	<section>
		<h2>게시글 수정</h2>
		<form action="boardUpdate.do" method="post">
			<input type="hidden" name="bno" value="${requestScope.board.bno }">
			<input type="text" name="title" placeholder="제목을 입력하세요" value="${requestScope.board.title }">
			<textarea name="content" placeholder="내용을 입력하세요">${requestScope.board.content }</textarea>
			<div class="form_bar">
				<button>수정하기</button><button type="button" class="btn_back">뒤로가기</button>
			</div>
		</form>
	</section>
</body>
</html>









