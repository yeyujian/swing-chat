package Dao;

import Db.*;
import java.sql.*;

public class user {

	/*public static void main(String[] args) {
		// TODO Auto-generated method stub

	}*/
	private Connection conn=null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public  boolean add(String name,String passwd) {
		boolean bool = false;
		conn = Dbconn.getconn();
		String sql = "insert into users(name,password) "
				+ "values(?,?)";
		;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, passwd);
			int rs = pstmt.executeUpdate();
			if (rs > 0) {
				bool = true;
			}
		} catch (SQLException e) {
			return bool;
		} finally {
			Dbclose.addClose(pstmt, conn);
		}
		return bool;
	}	
	
	public boolean query(String name,String passwd) {
		boolean bool = false;
		conn = Dbconn.getconn();
		String sql = "select * from users where name=? and password=?";
		;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, passwd);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				//System.out.println(rs.getString(1));
				bool = true;
			}
		} catch (SQLException e) {
			return bool;
		} finally {
			Dbclose.addClose(pstmt, conn);
		}
		return bool;
	}
	
	public boolean update(String name,String passwd) {
		boolean bool = false;
		conn = Dbconn.getconn();
		String sql = "update users set password=? where name=?";
		;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(2, name);
			pstmt.setString(1, passwd);
			int rs = pstmt.executeUpdate();
			if (rs > 0) {
				bool = true;
			}
		} catch (SQLException e) {
			return bool;
		} finally {
			Dbclose.addClose(pstmt, conn);
		}
		return bool;
	}
	
}
