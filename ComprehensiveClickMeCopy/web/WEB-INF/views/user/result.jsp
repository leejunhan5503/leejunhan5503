<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">${ requestScope.message }</h1>
<h2 align="center">${ requestScope.signupUser }</h2>







<!-- 	<script>
		window.onload = function() {
			
			var message = '${ requestScope.message }';

			alert(message);
/* 			location.href = '${pageContext.servletContext.contextPath}'; */
		}
	</script> -->
</body>
</html>