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
 * Servlet implementation class UserSearchFwd
 */
@WebServlet("/usersearchtrain")
public class UserSearchFwd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserSearchFwd() {
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
			if (!uName.equals("") || uName != null) {
				RequestDispatcher rd = request.getRequestDispatcher("SearchTrains.html");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			// something goes wrong, please login again
			RequestDispatcher rd = request.getRequestDispatcher("/userlogout");
			request.setAttribute("errormsg", "Something went wrong. ");
			rd.forward(request, response);
		}
	}
	// response.getWriter().append("Served at: ").append(request.getContextPath());
	

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
