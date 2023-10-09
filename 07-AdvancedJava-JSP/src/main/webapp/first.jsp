<h1 style='color:green;'>This is First JSP</h1>
<%
	pageContext.include("second.jsp");	
%>
<h1 style='color:blue;'>Control coming back to First JSP page...</h1>