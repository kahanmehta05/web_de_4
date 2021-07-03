package utility;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class DBConnection {
	private static Connection con;

	private DBConnection() {
	};

	static ResourceBundle rb;
	static {
		rb = ResourceBundle.getBundle("utility.database");
		try {
			Class.forName(rb.getString("driverName"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			con = DriverManager.getConnection(rb.getString("connectionString"), rb.getString("username"),
					rb.getString("password"));
	        configureAdmin();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	/**
	 * if admin table is not exit then create it for the first time using the database properties
	 */
	private static void configureAdmin() {
		try {
			if(!isAdminTableExist()) {
				createAdminTable();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			addAdminEntry();	
		}catch (Exception e) {
			// TODO: handle exception
		    e.printStackTrace();
		}
		
	}
	public static Connection getCon() {
		return con;
	}

	private static void createAdminTable() {
		String tableCreateQuery = "create table admin(uname varchar2(40) primary key,name varchar2(40),"
				+ "pword varchar2(50),mail_id varchar2(60),phone_no varchar2(12))";
		try {
			Statement st = con.createStatement();
			st.execute(tableCreateQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void addAdminEntry() {
		String addAdminQuery = "insert into admin values(?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(addAdminQuery);
			ps.setString(1, rb.getString("adminuname"));
			ps.setString(2, rb.getString("adminname"));
			ps.setString(3, rb.getString("adminpword"));
			ps.setString(4, rb.getString("adminmailid"));
			ps.setString(5, rb.getString("adminphone"));
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static boolean isAdminTableExist() throws SQLException {
		boolean isExist = false;
		DatabaseMetaData dbm = con.getMetaData();
		ResultSet tables = dbm.getTables(null, null, "employee", null);
		while (tables.next()) {
			isExist=true;
		}
		return isExist;
	}
}
