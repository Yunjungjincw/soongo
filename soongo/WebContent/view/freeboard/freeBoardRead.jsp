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
	</c:forEach>
	
<%-- <a href="<%=request.getContextPath()%>"><button>글 수정하기</button></a>
<a href="<%=request.getContextPath()%>"><button>글 삭제하기</button></a> --%>
</body>
</html>