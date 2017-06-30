package piccfs.auto.data.infrastructure.TestGraphDatabase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLAccess {
	static final String jdbc_driver = "com.mysql.jdbc.Driver";
	private Connection connection = null;
	
	/*******Establish connection to MySQL server******/
	private void establishConnection(){
		String url = "jdbc:mysql://localhost:3306/claim";
		String user = "alan";
		String pwd = "Whc910131";
		try{
			Class.forName(jdbc_driver);	
			connection = DriverManager.getConnection(url,user,pwd);
			if(connection != null)
				System.out.println("Successfully connected to database!");
		}catch(SQLException e){
			System.out.println("Fail to connect to database");
			System.out.println("Please check if MySQL server or authentication functioning properly");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Fail to find class");
			e.printStackTrace();
		}
	}
	
	/*******Close connection to MySQL server******/
	private void closeConnection(){
		try {
			if(connection!=null)
			{	
				connection.close();
			}
			System.out.println("Database successfully disconnected!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Fail to close connection!");
			e.printStackTrace();
		}
	}
	
	public void operate(){
		establishConnection();
		closeConnection();
	}
}