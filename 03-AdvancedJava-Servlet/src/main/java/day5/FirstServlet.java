package day5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FirstServlet implements Servlet {
	
	static {
		System.out.println("Servlet loading...");
	}
	
	public FirstServlet() {
		System.out.println("Servlet instantiation....");
	}
	
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Servelt is initialized...");
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("Providing the service1 for users...");
		
		res.setContentType("text/html");
		
		PrintWriter writer = res.getWriter();
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<title>First Servlet</title>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<h1 style='color:red'>Welcome to home page of First Servlet...</h1>");
		writer.println("</body>");
		writer.println("</html");
		
		writer.close();
	}

	public void destroy() {
		System.out.println("Servelt deinstantiation...");
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public String getServletInfo() {
		return "Developed by Sagar";
	}

}
