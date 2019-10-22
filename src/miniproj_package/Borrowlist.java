package miniproj_package;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Borrowlist
 */
public class Borrowlist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Borrowlist() {
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
		response.setContentType("text/html");
		try{
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from lender");
			PrintWriter out=response.getWriter();
			out.println("<html><body><center><table border='1'><tr><th>Car Manufacturer</th><th>Capacity(No. of seats)</th><th>Fuel type</th><th>Cost per hour(in Rs.)</th></tr>");
			while(rs.next()){
				if(rs.getInt(9)!=-99){
					out.println("<tr><td>"+rs.getString(7)+"</td><td>"+rs.getInt(9)+"</td><td>"+rs.getString(10)+"</td><td>"+rs.getInt(11)+"</td><tr>");
				}
			}
			out.println("</table>");
			out.println("<center><br><a href='borrowcar.html'>Filter your 'CAR'</a></center></body></html>");
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
