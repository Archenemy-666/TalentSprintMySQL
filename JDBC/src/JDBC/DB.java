package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


	public class DB {
		public static void main(String[] args) throws SQLException , ClassNotFoundException {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection  = DriverManager.getConnection("jdbc:mysql://localhost:3306/class1","root","Siddharth98");
			Statement stmt = connection.createStatement();
			ResultSet result = stmt.executeQuery("SELECT * FROM product ; ");
			
			System.out.println("Id | product_name | cost | units | totoal cost ");
			while(result.next()) {
				System.out.println(result.getInt(1)+"\t"+result.getString(2)+"\t"+result.getFloat(3)+"\t"+result.getInt(4)+"\t"+result.getFloat(5));
				
			}
			result.close();
			connection.close();
			
		}

	}

