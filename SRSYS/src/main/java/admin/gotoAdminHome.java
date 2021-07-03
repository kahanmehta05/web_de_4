package admin;

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
 * Servlet implementation class gotoAdminHome
 */
@WebServlet("/gotoAdminHome")
public class gotoAdminHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public gotoAdminHome() {
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
		Cookie ck[] = request.getCookies();
		String uName="";
		String pWord="";
		String role="";
		if(ck!=null) {
			uName = ck[0].getValue();
		    pWord = ck[1].getValue();
		    role=ck[2].getValue();
		}
		
		if("ADMIN".equals(role) && "admin".equals(uName) && "admin".equals(pWord)) {
			RequestDispatcher rd = request.getRequestDispatcher("AdminHome.html");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("AdminLogin.html");
			rd.include(request, response);
			pw.println("<div class='tab'><p1 class='menu'>You are logged out, please login Again</p1></div>");
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
