<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@include file="../jspf/head_config.jspf"%>
</head>
<body>
<%@include file="../jspf/main_menu.jspf"%>
	<div class="container">

		Available users:
		<ul class="list-group">
			<c:forEach items="${availableUsers}" var="user">
				<li class="list-group-item"><c:out value="${user.firstName} ${user.lastName} "></c:out>
					<a href="${user.id}/edit">Edit</a> <a href="${user.id}/delete">Delete</a>
					<a href="${user.id}/tweets">Show all tweets</a></li>
			</c:forEach>
		</ul>
	</div>
	<%@include file="../jspf/foot_config.jspf"%>
</body>
</html>