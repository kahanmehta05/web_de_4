package user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utility.DBConnection;

/**
 * Servlet implementation class UserRegister
 */
@WebServlet("/userreg")
public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		try {
			Connection con = DBConnection.getCon();
			 PreparedStatement ps = con.prepareStatement("insert into register values(?,?,?,?,?,?,?)");
			
			ps.setString(1, request.getParameter("uname"));
			ps.setString(2, request.getParameter("pword"));
			ps.setString(3, request.getParameter("firstname"));
			ps.setString(4, request.getParameter("lastname"));
			ps.setString(5, request.getParameter("address"));
			ps.setLong(6, Long.parseLong(request.getParameter("phoneno")));
			ps.setString(7, request.getParameter("mailid"));
			int k = ps.executeUpdate();
			if(k==1) {
				RequestDispatcher rd = request.getRequestDispatcher("UserLogin.html");
				rd.include(request, response);
				pw.println("<div class='tab'><p1 class='menu'>User Registered Successfully !</p1></div>");
				
			}
		}
		catch(Exception e) {
			RequestDispatcher rd = request.getRequestDispatcher("UserLogin.html");
			rd.include(request, response);
			pw.println("<div class='tab'><p1 class='menu'>Something went wrong.User is not Registered</p1></div>");
			
		}
	}

	

}
