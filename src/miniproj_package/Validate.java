package miniproj_package;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class Validate
 */
public class Validate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Validate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		Connection con=DbConnection.connection();
		
		String carno=request.getParameter("carno");
		String status="pending";
		String new_status="approved";
		
		String l_name="empty",l_addr="empty",l_email="empty",car_name="empty",car_no="empty",fuel="empty",l_username="empty",l_password="empty";
		int l_mob=0,seats=0,cost=0;
		String db_status="empty";
		try{
			PreparedStatement pstmt=(PreparedStatement) con.prepareStatement("select * from admin where Car_no=?");
			pstmt.setString(1, carno);
			//pstmt.setString(2, status);
			System.out.println("hi1");
			ResultSet rs=pstmt.executeQuery();
			System.out.println("hi2");
			while(rs.next()){
				db_status=rs.getString(12);
				l_name=rs.getString(1);
				l_addr=rs.getString(2);
				l_mob=rs.getInt(3);
				l_email=rs.getString(4);
				l_username=rs.getString(5);
				l_password=rs.getString(6);
				car_name=rs.getString(7);
				car_no=rs.getString(8);
				seats=rs.getInt(9);
				fuel=rs.getString(10);
				cost=rs.getInt(11);
			}
			System.out.println("hi3");
			
			if(db_status.equals(status)){	
				PreparedStatement pstmt1=(PreparedStatement) con.prepareStatement("update admin set Status=? where Car_no=?");
				pstmt1.setString(1, new_status);
				pstmt1.setString(2, carno);				
				int j=pstmt1.executeUpdate();
				
				PreparedStatement pstmt2=(PreparedStatement) con.prepareStatement("insert into lender values(?,?,?,?,?,?,?,?,?,?,?)");
				pstmt2.setString(1, l_name);
				pstmt2.setString(2, l_addr);
				pstmt2.setInt(3, l_mob);
				pstmt2.setString(4, l_email);
				pstmt2.setString(5, l_username);
				pstmt2.setString(6, l_password);
				pstmt2.setString(7, car_name);
				pstmt2.setString(8, car_no);
				pstmt2.setInt(9, seats);
				pstmt2.setString(10, fuel);
				pstmt2.setInt(11, cost);
				int i=pstmt2.executeUpdate();
				
				response.sendRedirect("adminhome.html");	
			} else{
				response.sendRedirect("validate.html");
			}				
		} catch(Exception e){
			System.out.println(e);
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
