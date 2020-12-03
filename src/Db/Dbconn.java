package Db;

import java.sql.*;


public final class Dbconn {

	
	
	public static  Connection getconn()
	{
		Connection conn = null;
		
		String user   = "root";
		String passwd = "root";
		String url = "jdbc:mysql://localhost:3306/chatRoom";
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver"); 
			conn = DriverManager.getConnection(url,user,passwd);
		}catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		return conn;
	}
	

}
