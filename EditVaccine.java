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
 * Servlet implementation class EditVaccine
 */
@WebServlet("/EditVaccine")
public class EditVaccine extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditVaccine() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    //function to get the vaccine info 
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
		
        String id = request.getParameter( "id" );
        Vaccine vaccine = getVaccine(Integer.parseInt(id));

		
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    
	    out.println("<html><head><title>Edit Vaccine</title>");
	    out.println("<p><a href='ListVaccines'>Vaccine List</a><br>");
	    out.println("<table border=\"1\" cellpadding=\"2\">");
	    out.println("<form action='EditVaccine' method='post'>");
	    out.println("<tr><input type='hidden' name='id' value='" + id + "'>");
	    out.println("<tr><th>Name:</th><td><input type='text' name='name' value='"
                + vaccine.getName() + "'></td></tr>");
	    out.println("<tr><th>Doses Required: </th><td><select name=\"dosesRequired\">");
	    out.println("<option value=\"1\"" + (vaccine.getDosesRequired() == 1 ? " selected" : "") + ">1</option>");
	    out.println("<option value=\"2\"" + (vaccine.getDosesRequired() == 2 ? " selected" : "") + ">2</option>");
	    out.println("</select></td></tr>");
	    out.println("<tr><th>Days Between Doses: </th><td><input type=\"text\" name=\"daysBetweenDoses\" value=\"" 
	    + vaccine.getDaysBetweenDoses() + "\" /></td></tr>");
	    out.println("<tr><td colspan=\"2\"><button>Edit</button></td></tr>");
	    out.println("</form></table></body></html>");
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Vaccine vaccine = getVaccine(Integer.parseInt(request.getParameter("id")));
		vaccine.setName(request.getParameter("name"));
		vaccine.setDosesRequired(Integer.parseInt(request.getParameter("dosesRequired")));
		vaccine.setDaysBetweenDoses(Integer.parseInt(request.getParameter("daysBetweenDoses")));
        response.sendRedirect( "ListVaccines" );


	}

}
