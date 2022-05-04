package com.manish.jdbc.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ReadApp {

	public static void main(String[] args) {
		String JDBC_URL = "jdbc:postgresql://localhost:5432/manishjpadb";
		String USERNAME = "postgres";
		String PASSWORD = "Aadi@2019";

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// 1. Load the Driver Class provided by DB Vendor
			Class.forName("org.postgresql.Driver");

			// 2. Create the Connection with DB
			con = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

			// 3. Prepare the SQL Query
			String sql = "select sid,sname from myjdbcstudent";

			// 4. Prepare the JDBC Statement
			ps = con.prepareStatement(sql);

			// 5. Submit the SQL Query to DB
			rs = ps.executeQuery();

			// 6. Process the Result
			while (rs.next()) {
				int sid = rs.getInt("sid");
				String nm = rs.getString("sname");
				String eml = rs.getString("email");
				System.out.println(sid + "\t" + nm + "\t" + eml);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 7. Release the resources
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
