package inputFromConsoleToDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InputToDB {
	public static void main(String[]args) throws SQLException, ClassNotFoundException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/class1","root","Siddharth98");
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter no.of customer");
		int n = scan.nextInt();
		
		/*
		 * customer_id	int	YES		
			customer_name	varchar(20)	YES		
			city	varchar(20)	YES		
			grade	int	YES		
			salesman_id	int	NO	MUL	
		 */
		
		for(int i = 1 ; i <= n ; i++) {
			System.out.println("enter the values for customer "+i);
			System.out.println("customer"+i +"id");
			int cus_id = scan.nextInt();
			System.out.println("customer"+i +"name");
			String cus_name = scan.next();
			System.out.println("customer"+i +"city");
			String cus_city = scan.next();
			System.out.println("customer"+i +"grade");
			int cus_grade = scan.nextInt();
			System.out.println("customer"+i +"salesman_Id");
			int sal_id = scan.nextInt();
			
			PreparedStatement p = connection.prepareStatement("insert into customer_records values (?,?,?,?,?);");
			p.setInt(1, cus_id);
			p.setString(2, cus_name);
			p.setString(3, cus_city);
			p.setInt(4, cus_grade);
			p.setInt(5, sal_id);
			
			p.executeUpdate();
			p.close();
			
		}
		
		connection.close();
		
		
	}

}
