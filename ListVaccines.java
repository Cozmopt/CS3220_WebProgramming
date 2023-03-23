package HomeWorkOne.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import HomeWorkOne.model.Vaccine;

/**
 * Servlet implementation class ListVaccines
 */
@WebServlet("/ListVaccines")
public class ListVaccines extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListVaccines() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init( ServletConfig config ) throws ServletException
    {
        super.init( config );

        //Arraylist of Vaccines to be displayed
        List<Vaccine> vaccines = new ArrayList<>();
        //added a vaccine so that something is diplayed
        vaccines.add(new Vaccine("Pfizer", 2, 21, 1000, 0));
        vaccines.add(new Vaccine("Moderna", 2, 29, 5000, 0));

        getServletContext().setAttribute( "vaccines", vaccines );
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @SuppressWarnings("unchecked")
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        List<Vaccine> vaccines = (List<Vaccine>) getServletContext().getAttribute("vaccines");

        //header row of form
        out.println("<html><head><title>Vaccine List</title></head><body>");
        out.println("<p><a href='NewVaccine'>New Vaccine</a> | <a href='NewDoses'>New Doses</a></p>");
        out.println("<table border='1' cellpadding='4'>");
        out.println("<form>");
        out.println("<thead>");
        out.println("<tr>");
        out.println("<th>Vaccine</th>");
        out.println("<th>Doses Required</th>");
        out.println("<th>Days Between Doses</th>");
        out.println("<th>Total Doses Received</th>");
        out.println("<th>Total Doses Left</th>");
        out.println("<th></th>");
        out.println("</tr>");    
        
        //Adds a new row for every vaccine in the arraylist
	    for (Vaccine vaccine : vaccines) {
	        out.println("<tr>");
	        out.println("<td>" + vaccine.getName() + "</td>");
	        out.println("<td>" + vaccine.getDosesRequired() + "</td>");
	        out.println("<td>" + vaccine.getDaysBetweenDoses() + "</td>");
	        out.println("<td>" + vaccine.getDosesRecived() + "</td>");
	        out.println("<td>" + (vaccine.getDosesRecived() - vaccine.getDosesUsed()) + "</td>");
	        out.println(
	                "<td><a href='EditVaccine?id=" + vaccine.getId() + "'>Edit</a> |" );
	        out.println("</tr>");
	    }

        out.println("</thead></form></table></body></html>");

    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
