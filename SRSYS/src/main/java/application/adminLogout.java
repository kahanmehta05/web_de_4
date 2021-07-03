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
 * Servlet implementation class adminLogout
 */
@WebServlet("/adminlogout")
public class adminLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminLogout() {
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
		Object msg = request.getAttribute("errormsg");
		String errmsg = "";
		if (msg != null) {
			errmsg = (String) msg;
		}
		Cookie ck[] = request.getCookies();
		if(ck!=null) {
			Cookie ck1 = new Cookie("ckname","");
			ck1.setMaxAge(0);
			response.addCookie(ck1);
			Cookie ck2 = new Cookie("ckpwd","");
			ck2.setMaxAge(0);
			response.addCookie(ck2);
			Cookie ck3 = new Cookie("role", "");
			ck3.setMaxAge(0);
			response.addCookie(ck3);

			RequestDispatcher rd = request.getRequestDispatcher("AdminLogin.html");
			rd.include(request, response);
			pw.println("<div class='tab'><p1 class='menu'>"+errmsg+"You have been successfully logged out !</p1></div>");
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("AdminLogin.html");
			rd.include(request, response);
			pw.println("<div class='tab'><p1 class='menu'>"+errmsg+"You are Already Logged Out !</p1></div>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
