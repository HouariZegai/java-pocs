

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Servlet implementation class ProcessForm
 */
@WebServlet("/ProcessForm")
public class ProcessForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ProcessForm() {
        super();
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	PrintWriter out = response.getWriter();
		out.println("<h3>Hello !</h3>");
		response.sendRedirect("index.jsp");
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getAttribute("firstName").toString();
		String lastName = request.getAttribute("lastName").toString();
		PrintWriter out = response.getWriter();
		out.println("<h3>Weclome: " + firstName + " " + lastName + "!</h3>");
	}

}
