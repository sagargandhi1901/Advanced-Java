package day7;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/details" }, loadOnStartup = -1)
public class ClientServerDetailsApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static {
		System.out.println("DemoServlet Loading....");
	}

	public ClientServerDetailsApp() {
		System.out.println("DemoServlet Instantiation...");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("DemoServlet Initialization....");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("RequestProcessing for GET Request type....\n\n");
		
		System.out.println("Client IPAddress is :: " + request.getRemoteAddr());
		System.out.println("Client Host      is :: " + request.getRemoteHost());
		System.out.println("Client port      is :: " + request.getRemotePort());
		System.out.println("Server Name      is :: " + request.getServerName());
		System.out.println("Server Port      is :: " + request.getServerPort());

	}

}
