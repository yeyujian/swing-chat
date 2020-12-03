package Db;

import Db.*;
import java.sql.*;

public class index {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hello world");
		Connection conn = null;
		Statement stmt = null;

		try {
			conn = Dbconn.getconn();

			String sql = "insert into goods(Gname,Gclass,Gdescribe" + ",Gprice,Gnum,Gimport,Gpromotion,SID) "
					+ "values('1','2','3',4,5,0,0,6)";
			stmt = conn.createStatement();
			int rs = stmt.executeUpdate(sql);
			stmt.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("hello");
		}
	}

}
