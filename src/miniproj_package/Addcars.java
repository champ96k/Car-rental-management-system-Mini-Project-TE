package miniproj_package;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Addcars extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addcars() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String username = Username.getUsername();
		//L_username.setL_username(username);
		
		System.out.println("The username is: " + username); 
		String cars=request.getParameter("cars");
		String carno=request.getParameter("carno");
		int seats=Integer.parseInt(request.getParameter("seats"));
		String fuel=request.getParameter("fuel");
		int cost=Integer.parseInt(request.getParameter("cost"));
		String status="pending";
		
		Connection con=DbConnection.connection();
		
		try{    
			PreparedStatement pstmt=con.prepareStatement("select * from lender where Username=?");
			pstmt.setString(1, username);
            
			ResultSet rs=pstmt.executeQuery();
			
			while(rs.next()){
				String name=rs.getString(1);
				String addr=rs.getString(2);
				int mob=rs.getInt(3);
				String email=rs.getString(4);
				String password=rs.getString(6);
				
				PreparedStatement pstmt1=con.prepareStatement("insert into admin values(?,?,?,?,?,?,?,?,?,?,?,?)");
				pstmt1.setString(1, name);
				pstmt1.setString(2, addr);
				pstmt1.setInt(3, mob);
				pstmt1.setString(4, email);
				pstmt1.setString(5, username);
				pstmt1.setString(6, password);
				pstmt1.setString(7, cars);
				pstmt1.setString(8, carno);
				pstmt1.setInt(9, seats);
				pstmt1.setString(10, fuel);
				pstmt1.setInt(11, cost);
				pstmt1.setString(12, status);
				
				int i=pstmt1.executeUpdate();
				
				System.out.println("Records added " + i);
				break;
			}
			} catch(Exception e){
				System.out.println(e);
		}
		response.sendRedirect("lender.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
