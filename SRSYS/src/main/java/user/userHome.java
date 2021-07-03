package user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class userHome
 */
@WebServlet("/userhome")
public class userHome extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public userHome() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String uName = "kahan";
		RequestDispatcher rd = request.getRequestDispatcher("UserHome.html");
		rd.include(request, response);
		pw.println("<div class='tab'>" + "		<p1 class='menu'>" + "	Hello " + uName
				+ " ! Welcome to our new NITRTC Website" + "		</p1>" + "	</div>");
		pw.println("<div class='main'><p1 class='menu'>User Home</p1></div>");
		pw.println("<div class='tab'>Hello " + uName + " ! Good to See You here.<br/> Here you can Check up the train "
				+ "details, train schedule, fare Enquiry and many more information.<br/>Just go to the Side Menu Links and "
				+ "Explore the Advantages.<br/><br/>Thanks For Being Connected with us!" + "</div>");
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
