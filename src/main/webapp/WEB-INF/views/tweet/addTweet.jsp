<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@	taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="../jspf/head_config.jspf"%>
<title>Insert title here</title>
</head>
<body>
<%@include file="../jspf/main_menu.jspf"%>
	<div class="container">
		<h3>Add new tweet:</h3>
		<form:form method="post" modelAttribute="tweet">
		Title: <form:input path="title" /><form:errors path="title" /><br />
		Tweet: <form:textarea path="tweetText" /><form:errors path="tweetText" /><br />
		User: <form:select type="text" path="user">
				<form:options items="${availableUsers}" itemValue="id" itemLabel="fullName" />
			</form:select>
			<input type="submit">
		</form:form>
		<br /> ${tweet}
	</div>
<%@include file="../jspf/head_config.jspf"%>
</body>
</html>