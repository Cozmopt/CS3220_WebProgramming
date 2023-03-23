package HomeWorkOne.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import HomeWorkOne.model.Vaccine;

/**
 * Servlet implementation class NewVaccine
 */
@WebServlet("/NewVaccine")
public class NewVaccine extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewVaccine() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    
	    out.println("<html><head><title>Add Vaccine</title>");
	    out.println("<p><a href='ListVaccines'>Vaccine List</a><br>");
	    out.println("<table border=\"1\" cellpadding=\"2\">");
	    out.println("<form action='NewVaccine' method='post'>");
	    out.println("<tr><th>Name:</th><td><input type='text' name='name' value=\"\"></td></tr>");
	    out.println("<tr><th>Doses Required: </th><td><select name=\"dosesRequired\">");
	    out.println("<option value=\"1\">1</option>");
	    out.println("<option value=\"2\")>2</option>");
	    out.println("</select></td></tr>");
	    out.println("<tr><th>Days Between Doses: </th><td><input type=\"text\" name=\"daysBetweenDoses\" value=\"\"></td></tr>");
	    out.println("<tr><td colspan=\"2\"><button>Add</button></td></tr>");
	    out.println("</form></table></body></html>");
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		int dr = Integer.parseInt(request.getParameter("dosesRequired"));
		int dbd = Integer.parseInt(request.getParameter("daysBetweenDoses"));
		@SuppressWarnings("unchecked")
		List<Vaccine> vaccines = (List<Vaccine>) getServletContext().getAttribute( "vaccines" );
        vaccines.add(new Vaccine(name, dr, dbd, 0, 0));
        response.sendRedirect( "ListVaccines" );


	}

}
