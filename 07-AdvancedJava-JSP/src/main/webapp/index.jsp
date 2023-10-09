<%@page import="java.util.Enumeration"%>
<h1>
	The Init param is :: <%= config.getInitParameter("IPL")%><br/>
	The logical name of Servlet is :: <%= config.getServletName()%><br/>

	<%
		Enumeration<String> params=config.getInitParameterNames();
	%>
	Context Name is <%= config.getServletContext()%>
</h1>