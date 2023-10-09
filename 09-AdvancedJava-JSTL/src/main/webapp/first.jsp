<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>OUTPUT PAGE</title>
</head>
<body>
	<h1>Welcome to home page</h1>
	<br />
	<c:url value="second.jsp" var="x" scope='request'>
		<c:param name="java" value="hyder" />
		<c:param name="jee" value="nitin" />
		<c:param name="spring" value="navinreddy" />
	</c:url>
	<h1>The modified URL is :: ${x}</h1>
	<a href="${x }">Click here to go to Next Page...</a>
</body>
</html>
