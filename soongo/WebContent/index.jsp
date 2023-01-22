<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
});
</script>
</head>
<body>
<h2>메인 페이지</h2>
<a href="<%=request.getContextPath()%>/freeboard/list.do">자유게시판으로 이동</a>
<a href="http://localhost/soongo/view/freeboard/freeBoardList.jsp">자유게시판으로 이동</a>
</body>
</html>