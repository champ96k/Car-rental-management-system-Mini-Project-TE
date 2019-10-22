package miniproj_package;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Adminrequest
 */
public class Adminrequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Adminrequest() {
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
		
		String status="pending";
		
		
		try{
			response.setContentType("text/html");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from admin where Status='pending'");
			//PreparedStatement pstmt=con.prepareStatement();
			//pstmt.setString(1, status);
			//int i=pstmt.executeUpdate();
			
			PrintWriter out=response.getWriter();
			out.println("<html><body><center><table border='1'><tr><th>Lender Name</th><th>Lender Address</th><th>Lender Mob</th><th>Lender Email</th><th>Lender Username</th><th>Lender Password</th><th>Car Name</th><th>Car No.</th><th>Seats</th><th>Fuel</th><th>Cost</th></tr>");
			while(rs.next()){
				out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getInt(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td><td>"+rs.getString(7)+"</td><td>"+rs.getString(8)+"</td><td>"+rs.getInt(9)+"</td><td>"+rs.getString(10)+"</td><td>"+rs.getInt(11)+"</td></tr>");
			}
			out.println("</table>");
			out.println("<br><br><a href='validate.html'>Validate Lender</a>");
			out.println("<a href='adminhome.html'>Go back</a></center></body></html>");
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
