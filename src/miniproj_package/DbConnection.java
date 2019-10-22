package miniproj_package;

import java.sql.*;

public class DbConnection {
	public static Connection con=null;
	public static Connection connection(){
		try{            
			if(con==null){
			Class.forName("com.mysql.jdbc.Driver");		//Load The Drivers (forName is Method)
	        System.out.println("Driver Loaded..");		
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject","root","");
	        System.out.println("Connection Established..");
			}
	} catch(Exception e){
		System.err.println(e);
		e.printStackTrace();
	}
		return con;
	}
}
