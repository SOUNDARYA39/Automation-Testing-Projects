package databaseTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class WriteandReadfromDb {

	public static void main(String[] args) throws SQLException {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentinfo","root","MYSQL*1234567");

		Statement stat = connection.createStatement();
		String query = "insert into mystud(first_name,last_name,address)values('soundarya','sg','kashmir')";
	      int result = stat.executeUpdate(query);
	      
	      if(result==1)
	      {
	    	  System.out.println("database updated");
	      }
	      else
	      {
	    	  System.out.println("database is not updated");
	      }
	      
	    String que = "select * from mystud";
	   ResultSet res = stat.executeQuery(que);
	   
	   while(res.next())
	   {
		   System.out.println(res.getString(1)+"\t"+res.getString(2)+"\t"+res.getString(3)+"\t"+res.getString(4));
	   }
	   connection.close();
	}

}
