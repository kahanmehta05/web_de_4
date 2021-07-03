package admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class adminviewtrainfwd
 */
@WebServlet("/adminviewtrainfwd")
public class adminviewtrainfwd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminviewtrainfwd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	    response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		RequestDispatcher rd = request.getRequestDispatcher("ViewTrains.html");
		rd.include(request, response);
		pw.println("<div class='main'><p1 class='menu'>Running Trains</p1></div>");
		pw.println("<div class='tab'><table><tr><th>Train Name</th><th>Train Number</th>"
				+ "<th>From Station</th><th>To Station</th><th>Seats Available</th><th>Fare (INR)</th></tr>");
		long trainNo=1008;
		String fromStn="bhavnagar";
		String toStn="ghogha road";
		String tr_name="bvnexp01";
		int available=4;
		long fare=1000;
	
			pw.println(""
			+ "<tr> "+ ""
			+ "<td><a href='viewadmin?trainNo="+trainNo+"&fromStn="+fromStn+"&toStn="+toStn+"'>" +tr_name+"</a></td>"
			+ "<td>"+trainNo+"</td>"
			+ "<td>"+fromStn +"</td>"
			+ "<td>"+toStn+"</td>"
			+ "<td>"+available +"</td>"
			+ "<td>"+fare+" RS</td></tr>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
