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
 * Servlet implementation class NewDoses
 */
@WebServlet("/NewDoses")
public class NewDoses extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewDoses() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private Vaccine getVaccine(int id)
    {
        @SuppressWarnings("unchecked")
		List<Vaccine> vaccines = (List<Vaccine>) getServletContext().getAttribute( "vaccines" );
        for( Vaccine vaccine : vaccines )
            if( vaccine.getId() == id ) return vaccine;
        return null;
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			response.setContentType("text/html");
		    PrintWriter out = response.getWriter();
		    @SuppressWarnings("unchecked")
			List<Vaccine> vaccines = (List<Vaccine>) getServletContext().getAttribute("vaccines");
		    out.println("<html><head><title>New Doses</title>");
		    out.println("<p><a href='ListVaccines'>Vaccine List</a><br>");
		    out.println("<table border=\"1\" cellpadding=\"2\">");
		    out.println("<form action='NewDoses' method='post'>");
		    out.println("<tr><th>Vaccine: </th><td><select name=\"vaccine\">");
		    for (Vaccine vaccine : vaccines) {
		        out.println("<option value='" + vaccine.getId() + "'>" + vaccine.getName() + "</option>");
		        }
		    out.println("</select></td></tr>");
		    out.println("<tr><th>New Doses: <th><input type = \"text\" name = \"newDoses\"></tr>");
		    out.println("<input type='hidden' name='id' value=''>");
		    out.println("<tr><td colspan=\"2\"><button>Add Doses</button></td></tr>");
		    out.println("</form></table></body></html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    int id = Integer.parseInt(request.getParameter("vaccine"));
	    Vaccine vaccine = getVaccine(id); 
		vaccine.setDosesRecived(vaccine.getDosesRecived() + Integer.parseInt(request.getParameter("newDoses")));
        response.sendRedirect( "ListVaccines" );
	}

}
