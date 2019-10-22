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
 * Servlet implementation class New_borrower
 */
public class New_borrower extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public New_borrower() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String name=request.getParameter("name");
		String addr=request.getParameter("addr");
		int mob=Integer.parseInt(request.getParameter("mob"));
		String email=request.getParameter("email");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
			
		Connection con=DbConnection.connection();
		
		try{        
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from borrower");
			int i=0;
			String uname[]=new String[30];
			while(rs.next()){
				uname[i]=rs.getString(5);
				i++;
			}
			for(i=0;i<30;i++){
				if(uname[i]==username){
					response.setContentType("text/html");
					PrintWriter out=response.getWriter();
					out.println("<html><body><center>");
					out.println("<br><br>Username already exists ! Please choose another one.");
					out.println("<br><br><a href='getcar.html'>Register again</a>");
					break;
				} else{
					continue;
				}
			}
			if(i==30){
				PreparedStatement pstmt=con.prepareStatement("insert into borrower values(?,?,?,?,?,?)");
	            pstmt.setString(1, name);
	            pstmt.setString(2, addr);
	            pstmt.setInt(3, mob);
	            pstmt.setString(4, email);
	            pstmt.setString(5, username);
	            pstmt.setString(6, password);
	            
	            int j=pstmt.executeUpdate();
	            
	            System.out.println(j+"Registered successfully !");
	            System.out.println("Redirecting to login page");

	            response.sendRedirect("loginborrower.html");
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
