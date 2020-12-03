package Db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class Dbclose
{

		public static void addClose(PreparedStatement pstmt, Connection conn)
		{

			try
			{
				if (pstmt != null)
				{
					pstmt.close();
				}
			} catch (SQLException e1)
			{
				e1.printStackTrace();
			}
			try
			{
				if (conn != null)
				{
					conn.close();
				}
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		

		public static void queryClose(PreparedStatement pstmt, ResultSet rs, Connection conn)
		{
			try
			{
				if (pstmt != null)
				{
					pstmt.close();
				}
			} catch (SQLException e1)
			{
				e1.printStackTrace();
			}
			try
			{
				if (rs != null )
				{
					rs.close();
				}
			} catch (SQLException e1)
			{
				e1.printStackTrace();
			}
			try
			{
				if (conn != null)
				{
					conn.close();
				}
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		
}
