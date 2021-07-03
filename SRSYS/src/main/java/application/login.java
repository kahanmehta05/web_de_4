package application;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utility.DBConnection;

/**
 * Servlet implementation class login
 */
@WebServlet("/login/*")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public login() {
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
		RequestDispatcher rs = request.getRequestDispatcher("homePage.html");
		rs.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");

		// authenticate user
		String uName = request.getParameter("uname");
		String pWord = request.getParameter("pword");

		try {

			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("select * from register where uname=? and pword=?");
			ps.setString(1, uName);
			ps.setString(2, pWord);

			String db_user = "";
			String db_uPass = "";
			String db_fname="";

			ResultSet rset = ps.executeQuery();
			if (rset.next()) {
				db_user = rset.getString("uname");
				db_uPass = rset.getString("pword");
				db_fname=rset.getString("fname");
			}
			if (db_user.equals(uName) && db_uPass.equals(pWord) && !db_user.isEmpty() && !db_uPass.isEmpty()) {
				Cookie ck1 = new Cookie("ckname", uName);
				response.addCookie(ck1);
				Cookie ck2 = new Cookie("ckpwd", pWord);
				response.addCookie(ck2);
				Cookie ck3 = new Cookie("role", "USER");
				response.addCookie(ck3);

				RequestDispatcher rs = request.getRequestDispatcher("UserHome.html");
				rs.include(request, response);
				pw.println("<div class='tab'>" + "		<p1 class='menu'>" + "	Hello " + db_fname
						+ " ! Welcome to our MGS Website" + "		</p1>" + "	</div>");
				pw.println("<div class='main'><p1 class='menu'>User Home</p1></div>");
				pw.println("<div class='tab'>Hello " + db_fname
						+ " ! Good to See You here.<br/> Here you can Check up the train "
						+ "details, train schedule, fare Enquiry and many more information.<br/>Just go to the Side Menu Links and "
						+ "Explore the Advantages.<br/><br/>Thanks For Being Connected with us!" + "</div>");

			} else {
				RequestDispatcher rs = request.getRequestDispatcher("UserLogin.html");
				rs.include(request, response);
				pw.println("<div class='tab'><p1 class='menu'>Invalid Username Or Password !</p1></div>");
			}
		} catch (Exception e) {
			// TODO: handle exception
			RequestDispatcher rs = request.getRequestDispatcher("UserLogin.html");
			rs.include(request, response);
			pw.println("<div class='tab'><p1 class='menu'>Invalid Username Or Password !</p1></div>");
		}
		// rs.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
