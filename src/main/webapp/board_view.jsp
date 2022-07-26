<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#btn_delete").click(function(){
			var d = "boardDelete.do?bno=${requestScope.board.bno}";
			//alert(d);
			location.href=d;
		});
		$("#btn_update").click(function(){
			var d = "boardUpdateView.do?bno=${requestScope.board.bno}";
			location.href=d;
		});
		$("#btn_like").click(function(){
			var d = "bno=${requestScope.board.bno}";
			$.ajax({
				url : "boardLike.do",
				data:d,
				type:"get",
				success:function(r){
					if(r == "1")
						alert("이 글을 추천하셨습니다.");
					else
						alert("이 글을 추천을 취소 하셨습니다.");
					location.reload();
				}
			});
		});
		$(".btn_comment_like").click(function(){
			var d = "cno="+$(this).parent().parent().find("input").val();
			$.ajax({
				url : "boardCommentLike.do",
				data:d,
				type:"get",
				success:function(r){
					if(r == "1")
						alert("이 댓글을 추천하셨습니다.");
					else
						alert("이 댓글을 추천을 취소 하셨습니다.");
					location.reload();
				}
			});
		});
		$(".btn_comment_hate").click(function(){
			var d = "cno="+$(this).parent().parent().find("input").val();
			$.ajax({
				url : "boardCommentHate.do",
				data:d,
				type:"get",
				success:function(r){
					if(r == "1")
						alert("이 댓글을 싫어요 하셨습니다.");
					else
						alert("이 댓글을 싫어요를 취소 하셨습니다.");
					location.reload();
				}
			});
		});
		$("#btn_hate").click(function(){
			var d = "bno=${requestScope.board.bno}";
			$.ajax({
				url : "boardHate.do",
				data:d,
				type:"get",
				success:function(r){
					if(r == "1")
						alert("이 글을 싫어요 하셨습니다.");
					else
						alert("이 글을 싫어요를 취소 하셨습니다.");
					location.reload();
				}
			});
		});
	});
</script>
</head>
<body>
	<table>
		<tr>
			<td>글번호</td>
			<td>${requestScope.board.bno }</td>
		</tr>
		<tr>
			<td>제목 : </td>
			<td>${requestScope.board.title}</td>
		</tr>
		<tr>
			<td>작성자 : </td>
			<td>${requestScope.board.nick}</td>
		</tr>
		<tr>
			<td>조회수 : </td>
			<td>${requestScope.board.bcount}</td>
		</tr>
		<tr>
			<td colspan="2"> 
				${requestScope.board.content}
			</td>
		</tr>
		<tr>
			<td><h3>첨부파일</h3></td>		
			<c:forEach var = "f" items="${requestScope.fList }">
				<tr><td><a href="fileDown.do?bno=${f.bno }&fno=${f.order}">${f.fileName}</a></td></tr>
			</c:forEach>
		</tr>		
		<tr>
			<td colspan="2"> 
				<a href="#" id="btn_like">좋아요 ${requestScope.board.blike}</a>
				<a href="#" id="btn_hate">싫어요 ${requestScope.board.bhate}</a>
			</td>
		</tr>
		<c:if test="${requestScope.board.writer == sessionScope.dto.id }">
		<tr>
			<td colspan="2"> 
				<button id="btn_update">수정</button>
				<button id="btn_delete">삭제</button>
			</td>
		</tr>		
		</c:if>
	</table>
	<form action="commentWrite.do" method="post">
		<input type="hidden" name="bno" value="${requestScope.board.bno }">
		<textarea name="comment" placeholder="댓글을 입력하세요"></textarea>
		<button>댓글작성</button>
	</form>
	<hr>
	<c:forEach var="comment" items="${requestScope.list }">
		<div>
			<p>
				<input type="hidden" name="cno" value="${comment.cno }">
				<span>${ comment.writer}</span><span>작성일 : ${comment.cdate }</span>
				<span><a href="#" class="btn_comment_like">좋아요 : ${comment.clike }</a></span>
				<span><a href="#" class="btn_comment_hate">싫어요 : ${comment.chate}</a></span>
			</p>
			<p>
				${comment.comment }
			</p>
			<c:if test="${sessionScope.dto.id == comment.writer }">
				<a href="commentDelete.do?cno=${comment.cno }&bno=${requestScope.board.bno}">댓글삭제</a>
			</c:if>
		</div>
	</c:forEach>
</body>
</html>







