package application;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class adminLogin
 */
@WebServlet("/adminLogin")
public class adminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public adminLogin() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
		String uName = request.getParameter("uname");
		String pWord = request.getParameter("pword");

		try {

			if ("admin".equals(uName) && "admin".equals(pWord)) {

				Cookie ck1 = new Cookie("ckname", uName);
				response.addCookie(ck1);
				Cookie ck2 = new Cookie("ckpwd", pWord);
				response.addCookie(ck2);
				Cookie ck3 = new Cookie("role", "ADMIN");
				response.addCookie(ck3);

				RequestDispatcher rd = request.getRequestDispatcher("AdminHome.html");
				rd.include(request, response);
				pw.println("<div class='main'><p1 class='menu'>Hello, " + uName + " ! Welcome </p1></div>");
				pw.println("<div class='tab'>Hi ! Here You can Manage Train Information as per Your Requirement</div>");

			} else {
				RequestDispatcher rd = request.getRequestDispatcher("AdminLogin.html");
				rd.include(request, response);
				pw.println("<div class='tab'><p1 class='menu'>Invalid Username Or Password !</p1></div>");

			}
		} catch (Exception e) {
		}
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
