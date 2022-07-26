<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		var count = 3;
		$("#plus").click(function(){
			if(count == 5) return;
			count++;
			$("form").append("<p><input type='file' name='file"+count+"'></p>");
		});
		$("#minus").click(function() {
			if(count == 1) return;
			count--;
			$("form").children("p").last().remove();
		});
		$(".btn_back").click(function(){
			history.back();
		});
		$(".btn_submit").click(function(){
			$("form").submit();
		});
	});
</script>
</head>
<body>
	<jsp:include page="template/header.jsp"></jsp:include>
	<section>
		<h2>글쓰기</h2>
		<form action="boardWrite.do" method="post" enctype="multipart/form-data">
			<input type="hidden" name="writer" value="${sessionScope.dto.id }">
			<input type="text" name="title" placeholder="제목을 입력하세요">
			<textarea name="content" placeholder="내용을 입력하세요"></textarea>
			<p>
				<input type="file" name="file1">
		   		<button type="button" id="plus">+</button>
		   		<button type="button" id="minus">-</button>
	    	</p>
			<p><input type="file" name="file2"></p>
			<p><input type="file" name="file3"></p>
		</form>
		<div class="form_bar">
			<button type="button" class="btn_submit">글쓰기</button><button type="button" class="btn_back">뒤로가기</button>
		</div>
	</section>
</body>
</html>
