<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:url var="url" value="/home"></c:url>
	<a href='${url }'>Home</a><br/>
	<img alt="image"
		src="${pageContext.request.contextPath }/resources/img/img.jpg">
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/resources/js/a.js"></script>
</body>
</html>