package miniproj_package;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Hourscost
 */
public class Hourscost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Hourscost() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		int no=Integer.parseInt(request.getParameter("no"));
		int hours=Integer.parseInt(request.getParameter("hours"));
		
		int serial=Validserial.getI();
		
		if(no<=serial){
			int arr_index=no-1;
			
			int cost=Cost.getCost(arr_index);
			
			int total_cost=cost*hours;
			Total_cost.setTotal_cost(total_cost);
			
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			
			out.println("<html><body><center><table border='1'><tr><th>Car owner's name</th><th>Mob No.</th><th>Car Manufacturer</th><th>Car No.</th><th>Capacity(No. of seats)</th></tr>");
			out.println("<tr><td>"+Ownername.getName(arr_index)+"</td><td>"+Mob.getMob(arr_index)+"</td><td>"+Manufacturer.getManuf(arr_index)+"</td><td>"+Carno.getCarno(arr_index)+"</td><td>"+Capacity.getCapacity(arr_index)+"</td></tr>");
			out.println("</table>");
			out.println("<br><br>Total Cost for <b>"+hours+" hours</b> = <b>Rs."+total_cost+"/-</b>");
			out.println("<br><br><a href='bookcar.html'>Book my drive !</a>");
			out.println("</center></body></html>");
		} else{
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			
			out.println("<html><body><center>");
			out.println("<br><br>Please mention a <strong>valid Serial No.</strong> !");
			out.println("</center></body></html>");
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
