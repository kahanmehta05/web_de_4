package user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.javadoc.ThrowsTag;

/**
 * Servlet implementation class userviewtrainfwd
 */
@WebServlet("/userviewtrainfwd")
public class userviewtrainfwd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public userviewtrainfwd() {
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
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		Cookie ck[] = request.getCookies();
		try {
			String uName = ck[0].getValue();
			if(uName.isEmpty()) {
	            throw new Exception("uname is empty");
			}
			RequestDispatcher rd = request.getRequestDispatcher("UserViewTrains.html");
			rd.include(request, response);
			pw.println("<div class='tab'>" + "		<p1 class='menu'>" + "	Hello " + uName
					+ " ! Welcome to our new NITRTC Website" + "		</p1>" + "	</div>");
			pw.println("<div class='main'><p1 class='menu'>Running Trains</p1></div>");
			pw.println("<div class='tab'><table><tr><th>Train Name</th><th>Train Number</th>"
					+ "<th>From Station</th><th>To Station</th><th>Seats Available</th><th>Fare (INR)</th><th>Booking</th></tr>");
			long trainNo;
			String fromStn;
			String toStn;
			String trainName = "RJTExpress";
			long fare = 850;
			long available = 150;
			trainNo = 12345;
			fromStn = "Bhavnagar";
			toStn = "Rajkot";
			pw.println("" + "<tr> " + "" + "<td><a href='view?trainNo=" + trainNo + "&fromStn=" + fromStn + "&toStn="
					+ toStn + "'>" + trainName + "</a></td>" + "<td>" + trainNo + "</td>" + "<td>" + fromStn + "</td>"
					+ "<td>" + toStn + "</td>" + "<td>" + available + "</td>" + "<td>" + fare + " RS</td>"
					+ "<td><a href='booktrainbyref?trainNo=" + trainNo + "&fromStn=" + fromStn + "&toStn=" + toStn
					+ "'><div class='red'>Book Now</div></a></td></tr>");
			pw.println("</table></div>");

			// response.getWriter().append("Served at: ").append(request.getContextPath());
		} catch (Exception e) {
			RequestDispatcher rd = request.getRequestDispatcher("/userlogout");
			request.setAttribute("errormsg", "Something went wrong. ");
			rd.forward(request, response);
			

		}

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
