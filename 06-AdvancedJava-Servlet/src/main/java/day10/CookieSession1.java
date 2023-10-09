package day10;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/cookiesession1")
public class CookieSession1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// collect request parameter
		String pid = request.getParameter("pid");
		String pname = request.getParameter("pname");

		// Create a cookie as per the requirement(inputs)
		Cookie c1 = new Cookie("pid", pid);
		Cookie c2 = new Cookie("pname", pname);

		// send the cookie object through response
		response.addCookie(c1);
		response.addCookie(c2);

		// forward the response to cookiesession2.html
		RequestDispatcher rd = request.getRequestDispatcher("/cookiesession2.html");
		rd.forward(request, response);

	}

}
