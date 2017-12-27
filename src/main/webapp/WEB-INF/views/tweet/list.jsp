<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

<!--  
		Available tweets:
		<ul class="list-group">
			<c:forEach items="${availableTweets}" var="tweet">
				<li class="list-group-item"><c:out value="${tweet.user.fullName}: ${tweet.title} Options: " /> 
				<a href="${tweet.id}/edit">Edit</a> <a href="${tweet.id}/delete">Delete</a></li>
				<p>
					<c:out value="${tweet.tweetText}" />
				</p>
			</c:forEach>
		</ul>
		-->
		<h3>Available tweets:</h3><br/>
		<div class="list-group">
		<c:forEach items="${availableTweets}" var="tweet">
			<a href="#" class="list-group-item list-group-item-action flex-column align-items-start">
    		<div class="d-flex w-100 justify-content-between">
      		<h5 class="mb-1"><c:out value="${tweet.user.fullName}: ${tweet.title}" /></h5>
      		<small><a href="${tweet.id}/edit">Edit</a> <a href="${tweet.id}/delete">Delete</a></small>
    		</div>
    	<p class="mb-1"><c:out value="${tweet.tweetText}" /></p>
    	</a>
    	</c:forEach>
		</div>
		
	</div>
<%@include file="../jspf/foot_config.jspf"%>
</body>
</html>