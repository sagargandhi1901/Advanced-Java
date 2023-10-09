package day8;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/servletconfigapp2" }, initParams = {
		@WebInitParam(name = "jdbcUrl", value = "jdbc:mysql://localhost:3306/enterprisejavabatch"),
		@WebInitParam(name = "user", value = "root"), 
		@WebInitParam(name = "password", value = "root123") })
public class ServletConfigAppUsingAnnotation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static {
		System.out.println("ServletConfigAppUsingAnnotation loading.....");
	}

	public ServletConfigAppUsingAnnotation() {
		System.out.println("ServletConfigAppUsingAnnotation Instantiation...");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("ServletConfigAppUsingAnnotation Initialization...");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Request Processing for GET request type....");

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Output</title></head>");
		out.println("<body align='center'>");
		out.println("<table border='1'");
		out.println("<tr><th>ParameterName</th><th>ParamterValue</th></tr>");

		ServletConfig config = getServletConfig();

		Enumeration<String> parameterNames = config.getInitParameterNames();

		// Parameter data which is static
		while (parameterNames.hasMoreElements()) {
			String parameterName = (String) parameterNames.nextElement();
			String parameterValue = config.getInitParameter(parameterName);

			out.println("<tr>");
			out.println("<td>" + parameterName + "</td><td>" + parameterValue + "</td>");
			out.println("</tr>");
		}
		out.println("<tr><th>Company</th><th>" + config.getInitParameter("Company") + "</th></tr>");
		out.println("</table>");

		out.println("</body>");
		out.println("</html>");

		out.close();

	}

	@Override
	public void destroy() {
		System.out.println("ServletConfigAppUsingAnnotation DeInstantiation....");
	}

}