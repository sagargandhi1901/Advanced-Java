package day5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/test4")
public class FourthServlet extends HttpServlet {

	private static final long serialVersionUID = -8550156122789091018L;

	static {
		System.out.println("Servlet loading...");
	}
	
	public FourthServlet() {
		System.out.println("Servlet instantiation....");
	}
	
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Servelt is initialized...");
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("Providing the service4 for users...");
		
		res.setContentType("text/html");
		
		PrintWriter writer = res.getWriter();
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<title>Fourth Servlet</title>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<h1 style='color:purple'>Welcome to home page of Fourth Servlet...</h1>");
		writer.println("</body>");
		writer.println("</html");
		
		writer.close();
	}

	public void destroy() {
		System.out.println("Servelt deinstantiation...");
	}
}
