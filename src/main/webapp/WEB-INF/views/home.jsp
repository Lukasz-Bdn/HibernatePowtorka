<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@	taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Homepage</title>
<%@include file="jspf/head_config.jspf"%>
</head>
<body>
<%@include file="jspf/main_menu.jspf"%>
	<div class="container">


		<h3>Homepage</h3>
		${msg}

	</div>
<%@include file="jspf/foot_config.jspf"%>
</body>
</html>