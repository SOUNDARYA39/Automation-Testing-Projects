package databaseTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;


public class ReadDatafromNonSelectSQL {

	public static void main(String[] args) throws SQLException {
		//register or load the mysql database(abstract class)
		
				Driver driver = new Driver();
				DriverManager.registerDriver(driver);
				
				
				//get connection to database(interfaces)
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentinfo","root","MYSQL*1234567");
			    
				
				//create statement
				Statement stat = connection.createStatement();
				
				String query = "insert into mybatch(first_name,last_name,address)values('soundarya','g','bangalore')";
				int result = stat.executeUpdate(query);
				if(result==1)
				{
					System.out.println("data updated");
				}
				else
				{
					System.out.println("data not updated");
				}
				
				connection.close();
	}

}
