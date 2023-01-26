<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="">
<head>
<meta charset="UTF-8">
<title>게시글 상세보기</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
</head>
<h2><a href="<%=request.getContextPath()%>/index.jsp">HOME</a></h2>
<body>


<c:forEach var="board" items="${freeBoard.list}">
			<p>글번호 : ${board.free_no}</p>
			<p>제목: ${board.free_title}</p>
			<p>내용: ${board.free_content}</p>
			<p>작성일 : ${board.free_createdate}</p>
			<p>수정일 : ${board.free_updatedate}</p>


<a href="<%=request.getContextPath()%>/freeboard/update.do?no=${board.free_no}"><button>글 수정하기</button></a>
<a href="<%=request.getContextPath()%>/freeboard/delete.do?no=${board.free_no}"><button>글 삭제하기</button></a>
	</c:forEach>

<hr>
<hr>
<form name="delete_update" id="delete_update" method="post" action="<%=request.getContextPath()%>/freeboard/commentdelete.do">
<input type="text" name="comm_no" value="${comment.commentList[0].comm_no}" hidden/>
<input type="text" name="free_no" value="${freeBoard.list[0].free_no}" hidden/>


<h3>댓글</h3> 댓글 작성 성공:<c:out value="${commentResult}"></c:out>
<table border="1">
	<tr>
		<th>작성자</th>
		<th>내용</th>
	</tr>

<c:forEach var="comment" items="${comment.commentList}">
	<tr>

		<td>${comment.user_name}</td>
		<td>${comment.comm_content}</td>
		<td><button type="submit" name="update" id="update">수정</button></td>
		<td><button type="submit" name="delete" id="delete">삭제</button></td>
	</tr>
</c:forEach>
</table>
</form>
<hr>
<%-- <c:forEach var="write" items="${comment.commentList}"> --%>
<form name="write" id="write" method="post"
		action="<%=request.getContextPath()%>/freeboard/commentwrite.do">
		
		<input type="text" name="free_no" value="${freeBoard.list[0].free_no}" hidden/>

	<table border="1">
	<tr>
		<th>댓글 내용</th>
			<td><textarea name="comm_content" id="comm_content" ></textarea></td>
	</tr>
	<tr>
		<td colspan="2" style="text-align:center;"><input type="submit" value="댓글 입력"/></td>
	</tr>
	</table>
</form>
<%-- </c:forEach> --%>
</body>
</html>