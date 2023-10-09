package day7;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/image", loadOnStartup = 1)
public class ImageResponseApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static {
		System.out.println("Servlet Loading....");
	}

	public ImageResponseApp() {
		System.out.println("Servlet Instantiation...");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("Serlvet initialization....");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("image/jpg");

		ServletOutputStream os = response.getOutputStream();

		String path = getServletContext().getRealPath("myphoto.jpg");
		// this will search image in C:\Users\sagandhi\Desktop\Advanced Java\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\04-AdvancedJava-Servlet\myphoto.jp
		System.out.println(path);

		File file = new File(path);
		FileInputStream fis = new FileInputStream(file);

		byte[] b = new byte[(int) file.length()];
		fis.read(b);// reading and placing the image data into byte array

		os.write(b);// writing the data as the response from byte array
		os.flush();

		fis.close();
		os.close();

	}

}
