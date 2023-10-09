package day5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/test3")
public class ThirdServlet extends GenericServlet {

	private static final long serialVersionUID = -298258807875763249L;

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("Providing the service3 for users...");

		res.setContentType("text/html");

		PrintWriter writer = res.getWriter();
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<title>Third Servlet</title>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<h1 style='color:green'>Welcome to home page of Third Servlet...</h1>");
		writer.println("</body>");
		writer.println("</html");

		writer.close();
	}
}
