package databaseTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFromSql {

	public static void main(String[] args) throws SQLException {
		//register or load the mysql database(abstract class)
		
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		
		//get connection to database(interfaces)
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentinfo","root","MYSQL*1234567");
	    
		
		//create statement
		Statement stat = connection.createStatement();
		
		String stringQuery="select * from mybatch";
		
		ResultSet result = stat.executeQuery(stringQuery);
		
		while(result.next())
		{
			System.out.println(result.getString(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4));
		}
		
		//close connection
		connection.close();
	}

}
