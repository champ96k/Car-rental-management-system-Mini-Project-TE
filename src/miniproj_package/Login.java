package miniproj_package;

import java.io.IOException;

import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import miniproj_package.DbConnection;

/**
 * Servlet implementation class New_user
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		String db_pw=null;
		
		Connection con=DbConnection.connection();
		
		try{            
			PreparedStatement pstmt=con.prepareStatement("select * from lender where Username=?");
			pstmt.setString(1, username);
            
			ResultSet rs=pstmt.executeQuery();
			
			while(rs.next()){
				db_pw=rs.getString(6);
				if(db_pw!=password){
					System.out.println("Login successful !");
					Username.setUsername(username);
					response.sendRedirect("lender.html");
				} else{
					System.out.println("Login unsuccessful... Please check your credentials and try again !");
					response.sendRedirect("login.html");
				}
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
