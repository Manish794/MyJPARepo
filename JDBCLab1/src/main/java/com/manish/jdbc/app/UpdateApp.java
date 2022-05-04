package com.manish.jdbc.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateApp {

	public static void main(String[] args) {
		String JDBC_URL = "jdbc:postgresql://localhost:5432/manishjpadb";
		String USERNAME = "postgres";
		String PASSWORD = "Aadi@2019";

		Connection con = null;
		PreparedStatement ps = null;
		try {
			// 1. Load the Driver Class provided by DB Vendor
			Class.forName("org.postgresql.Driver");

			// 2. Create the Connection with DB
			con = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

			// 3. Prepare the SQL Query
			String sql = "update myjdbcstudent set sname = ?, email = ? where sid = ?";

			// 4. Prepare the JDBC Statement
			ps = con.prepareStatement(sql);

			ps.setString(1, "M Kumar");
			ps.setString(2, "m@gmail.com");
			ps.setInt(3, 1);

			// 5. Submit the SQL Query to DB
			int count = ps.executeUpdate();

			// 6. Process the Result
			System.out.println("Record Affected " + count);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 7. Release the resources
			try {
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
