package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeDB {
	public static void main(String[] args) throws SQLException , ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection  = DriverManager.getConnection("jdbc:mysql://localhost:3306/class1","root","Siddharth98");
		Statement stmt = connection.createStatement();
		
		Employee e = new Employee(101 , "sid" , "good");
		int id = e.getId();
		String name = e.getName();
		String address = e.getAddress();
		
		
		String insertValues = "Insert into EmployeeDetails values (? , ? , ? );";
		
		PreparedStatement pstmt = connection.prepareStatement(insertValues);
		pstmt.setInt(1,id);
		pstmt.setString(2, name);
		pstmt.setString(3, address);
		
		pstmt.executeUpdate();
		
		String query = "select * from EmployeeDetails ; ";
		ResultSet result = stmt.executeQuery(query);
		
		while(result.next()) {
			System.out.println(result.getInt(1) + "\t" + result.getString(2) + " \t " + result.getString(3));
			
		}
		result.close();
		connection.close();
	
	}
}
