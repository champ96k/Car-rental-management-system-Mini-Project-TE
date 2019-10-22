package miniproj_package;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Addcar
 */
public class Getcar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Getcar() {
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
		String cars=request.getParameter("cars");
		int seats=Integer.parseInt(request.getParameter("seats"));
		
		Connection con=DbConnection.connection();
		
		try{    
			response.setContentType("text/html");
			System.out.println("Cars" + seats);
			PreparedStatement pstmt=con.prepareStatement("select * from lender where Car_name = ? or Seats=?");
			pstmt.setString(1, cars);
			pstmt.setInt(2, seats);
            
			ResultSet rs = pstmt.executeQuery();
			System.out.println("Result set is: " + rs);
			if(rs.next()){
				rs.beforeFirst();
				PrintWriter out = response.getWriter();
				int i=0;
				out.println("<html><body><center><table border='1'><tr><th>Serial No.</th><th>Car owner's name</th><th>Mob No.</th><th>Email ID</th><th>Car Manufacturer</th><th>Car No.</th><th>Capacity(No. of seats)</th><th>Fuel type</th><th>Cost per hour(in Rs.)</th></tr>");
				while(rs.next()){
					System.out.println("Inside while loop");
					out.println("<tr><td>"+(i+1)+"</td><td>"+rs.getString(1)+"</td><td>"+rs.getInt(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(7)+"</td><td>"+rs.getString(8)+"</td><td>"+rs.getInt(9)+"</td><td>"+rs.getString(10)+"</td><td>"+rs.getInt(11)+"</td><tr>");		
					Cost.setCost(rs.getInt(11),i);
					Ownername.setName(rs.getString(1), i);
					Mob.setMob(rs.getInt(3), i);
					Manufacturer.setManuf(rs.getString(7), i);
					Carno.setCarno(rs.getString(8), i);
					Capacity.setCapacity(rs.getInt(9), i);
					i++;
				}
				Validserial.setI(i);
				
				out.println("</table></center>");
				out.println("<center><br><br><a href='borrowcar.html'>Reset and filter again</a>");
				
				out.println("<br><br>or");
				
				out.println("<form method='post' action='Hourscost'>");
				out.println("<br><br>Enter <b>Serial No.</b> of the car you want to book : <input type='text' name='no'>");
				out.println("<br><br>Enter <b>Hiring Hours</b> : <input type='text' name='hours'>");
	
				out.println("<input type='reset'>");
				out.println("<input type='submit' name='submit' value='Payment Details'>");
	
				out.println("</form></center></body></html>");	
			} 
			else
			{
				PrintWriter out=response.getWriter();
				out.println("<html><body><center><br><br><b>Sorry ! No car matches your filter</b>");
				out.println("<br><br><a href='borrower.html'>Filter again</a>");
				out.println("</center></body></html>");
			}
				finalize();
			} catch(Throwable e){
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
