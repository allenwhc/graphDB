package graphDB;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.*;
import java.util.Properties;

public class MySQLAccess  {
	static final String jdbc_driver = "com.mysql.jdbc.Driver";
	private Connection connect = null;
	private Statement st = null;
	
	//Create a connection to desired database
	private void establishConnection(){
		String url = "jdbc:mysql://localhost:3306/claim";	//Select database
		String user = "alan";	
		String password = "Whc910131";	//Authentication
		try{
			Class.forName(jdbc_driver);	//Register jdbc driver
			connect = DriverManager.getConnection(url,user,password);	//Establish mysql database connection
			if(connect != null){System.out.println("Successfully connected to database!");}
			
		}catch(SQLException e){
			System.out.println("An error occured, can't connect to database!");
			System.out.println("Please check if url, user or password is correct");
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	//CRUD database
	private void updateDatabase(){
		try {
			st = connect.createStatement();
			String drop_table = "DROP TABLE IF EXISTS example";
			st.executeUpdate(drop_table);	//Drop existing table
			String sql = "CREATE TABLE example AS SELECT * FROM clean_suptemp_c LIMIT 0,100";
			st.executeUpdate(sql);	//Create a new table
			System.out.println("Update Successfully!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Update unsuccessfully!");
			e.printStackTrace();
		}
	}
	
	//Read database
	private void readDatabse(){
		
	}

	//Close database connection
	private void closeConnection() {
		// TODO Auto-generated method stub
		
	}

	public void operate(){
		// TODO Auto-generated method stub
		establishConnection();
		updateDatabase();
	}
	
}
