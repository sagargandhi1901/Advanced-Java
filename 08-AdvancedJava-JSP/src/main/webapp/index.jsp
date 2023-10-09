<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>OUTPUT</title>
</head>
<body>

	<%
	Integer count = (Integer) session.getAttribute("sessionRequestCount");
	if (count == null)
		count = 1;
	else
		count++;
	session.setAttribute("sessionRequestCount", count);
	%>
	<h1 style='color: red;'>
		Hit count of the application is ::<%=count%></h1>
</body>
</html>