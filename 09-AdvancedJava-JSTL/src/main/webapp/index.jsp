<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.sql.*"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<sql:setDataSource var="ds" url="jdbc:mysql:///practice"
		driver="com.mysql.cj.jdbc.Driver" user="root" password="root" />

	<sql:update dataSource="${ds}" var="count">
		insert into student(`name`,`email`,`city`,`country`)values(?,?,?,?)
		<sql:param value="pandya" />
		<sql:param value="pandya@gmail.com" />
		<sql:param value="GT" />
		<sql:param value="IND" />
	</sql:update>
	<h1>The no of rows affected is :: ${count}</h1>
	
</body>
</html>