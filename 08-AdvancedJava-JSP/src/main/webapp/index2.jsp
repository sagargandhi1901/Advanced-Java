
<%!Integer id;
	String name;
	Integer age;
	String address;%>
<%
id = Integer.parseInt(request.getParameter("id"));
name = request.getParameter("name");
address = request.getParameter("address");
age = Integer.parseInt(request.getParameter("age"));
%>


<jsp:useBean id="student" class="com.practice.Student" scope="page">
	<jsp:setProperty property="id" name="student" value='<%=id%>' />
	<jsp:setProperty property="name" name="student" value='<%=name%>' />
	<jsp:setProperty property="address" name="student" value='<%=address%>' />
	<jsp:setProperty property="age" name="student" value='<%=age%>' />
</jsp:useBean>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>OUTPUT</title>
</head>
<body>
	<center>
		<h1>STUDENT DETAILS</h1>
		<table border='1'>
			<tr>
				<th>ID</th>
				<td><jsp:getProperty property="id" name="student" /></td>
			</tr>
			<tr>
				<th>NAME</th>
				<td><jsp:getProperty property="name" name="student" /></td>
			</tr>
			<tr>
				<th>ADDRESS</th>
				<td><jsp:getProperty property="address" name="student" /></td>
			</tr>
			<tr>
				<th>AGE</th>
				<td><jsp:getProperty property="age" name="student" /></td>
			</tr>
		</table>

	</center>


</body>
</html>