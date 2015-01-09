<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="app" uri="/app"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/resources/js/base64.js"></script>
</head>
<body>
	<c:url value="hello?name=张三&age=22"></c:url>
	<br />
	<script type="text/javascript">
		var url = "hello?" + base64.encode('name=张三&age=22');
		alert(url);
	</script>
	<app:url url="hello?name=张三&age=22" />
	<br />
	<app:url url="hello?name=张三&age=22" var="url" />
	<a href="${url }">this is a link</a>

	<a
		href="<app:url url="hello?name=张三&age=22&email=zhangsan@yonyou.com&position=测试工程师&info=this is the information&birthday=2012-12-31&hobby=篮球&hobby=唱歌&hobby=跑步"/>">hahahahahhaha</a>
</body>
</html>