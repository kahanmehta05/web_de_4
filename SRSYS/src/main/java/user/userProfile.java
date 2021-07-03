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

/**
 * Servlet implementation class userProfile
 */
@WebServlet("/userprofile")
public class userProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userProfile() {
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
		if(ck!=null) {
			String uName = ck[0].getValue();
			if(!uName.equals("")||uName!=null) {
				RequestDispatcher rd = request.getRequestDispatcher("UserHome.html");
				rd.include(request, response);
				pw.println("<div class='tab'>" + 
						"		<p1 class='menu'>" + 
						"	Hello "+uName+" ! Welcome to our new Metro Webapp" + 
						"		</p1>" + 
						"	</div>");
				pw.println("<div class='main'><p1 class='menu'><a href='viewuserprofile'>view Profile</a></p1>"
						+ "<p1 class='menu'><a href='edituserprofile'>Edit Profile</a></p1>"
						+ "<p1 class='menu'><a href='changeuserpassword'>Change Password</a></p1>"
						+ "</div>");
				pw.println("<div class='tab yellow'>Hey ! "+uName+",Welcome to Metro Governance Webapp<br/><br/>Here You can Edit,View Your Profile and change your password.<br/>"
						+ "<br/>Thanks For Being Connected With Us!"
						+ "</div>");
				
			}
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("UserLogin.html");
			rd.include(request, response);
			pw.println("<div class='tab'><p1 class='menu'>Please Login first !</p1></div>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
