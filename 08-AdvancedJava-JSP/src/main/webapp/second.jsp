<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Page Scope attribute :: <%= pageContext.getAttribute("p",1)%><br/>
	Request Scope attribute ::<%= pageContext.getAttribute("r",2)%><br/>
	Session Scope attribute :: <%= pageContext.getAttribute("s",3)%><br/>
	Application Scope attribute :: <%= pageContext.getAttribute("a",4) %>	
</body>
</html>