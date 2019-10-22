package miniproj_package;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Loginborrower
 */
public class Loginborrower extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Loginborrower() {
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
			PreparedStatement pstmt=con.prepareStatement("select * from borrower where Username=?");
			pstmt.setString(1, username);
            
			ResultSet rs=pstmt.executeQuery();
			
			while(rs.next()){
				db_pw=rs.getString(6);
				if(db_pw!=password){
					System.out.println("Login successful !");
					Username.setUsername(username);
					response.sendRedirect("borrower.html");
				} else{
					System.out.println("Login unsuccessful... Please check your credentials and try again !");
					response.sendRedirect("loginborrower.html");
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
