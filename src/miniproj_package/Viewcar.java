package miniproj_package;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Viewcar
 */
public class Viewcar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Viewcar() {
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
		doGet(request, response);
		
		String username = Username.getUsername();
		
		Connection con=DbConnection.connection();
		
		try{
			response.setContentType("text/html");
			PreparedStatement pstmt=con.prepareStatement("select * from lender where Username=?");
			pstmt.setString(1, username);
            
			ResultSet rs=pstmt.executeQuery();
			
			PrintWriter out=response.getWriter();
			
			out.println("<html><body><center><table border='1'><tr><th>Car Manufacturer</th><th>Car No.</th><th>Capacity(No. of seats)</th><th>Fuel type</th><th>Cost per hour(in Rs.)</th></tr>");
			while(rs.next()){
				if(rs.getInt(9)!=-99){
				out.println("<tr><td>"+rs.getString(7)+"</td><td>"+rs.getString(8)+"</td><td>"+rs.getInt(9)+"</td><td>"+rs.getString(10)+"</td><td>"+rs.getInt(11)+"</td><tr>");
				}
			}
			out.println("</table></center></body></html>");
		} catch(Exception e){
			System.out.println(e);
		}		
	}

}
