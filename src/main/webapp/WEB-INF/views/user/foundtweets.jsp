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

		Tweets starting with <c:out value="${start}"></c:out>:
		<ul>
			<c:forEach items="${tweets}" var="tweet">
				<li><c:out value="${tweet.user.fullName}: ${tweet.title} Options: " /> 
				<a href="${tweet.id}/edit">Edit</a> <a href="${tweet.id}/delete">Delete</a></li>
				<p>
					<c:out value="${tweet.tweetText}" />
				</p>
			</c:forEach>
		</ul>
	</div>
	<%@include file="../jspf/foot_config.jspf"%>
</body>
</html>