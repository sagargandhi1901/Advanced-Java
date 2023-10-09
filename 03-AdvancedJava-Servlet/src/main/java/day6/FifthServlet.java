package day6;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test5")
public class FifthServlet extends HttpServlet {

	static {
		System.out.println("Fifth servlet loading...");
	}

	public FifthServlet() {
		System.out.println("Fifth servlet instantiation...");
	}

	private static final long serialVersionUID = 8498502239330522102L;
	
	@Override
	public void init() throws ServletException {
		ServletConfig servletConfig = getServletConfig();
		System.out.println("Servlet config object available :: " + servletConfig);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Request type is GET");

		resp.setContentType("text/html");

		PrintWriter writer = resp.getWriter();
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<title>Fifth Servlet</title>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<h1 style='color:grey'>Welcome to home page of Fifth Servlet using GET request...</h1>");
		writer.println("</body>");
		writer.println("</html");

		writer.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Request type is POST");

		resp.setContentType("text/html");

		PrintWriter writer = resp.getWriter();
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<title>Fifth Servlet</title>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<h1 style='color:grey'>Welcome to home page of Fifth Servlet using POST request...</h1>");
		writer.println("</body>");
		writer.println("</html");

		writer.close();
	}

}
