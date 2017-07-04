package graphDB;
import java.sql.Connection;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.*;
import java.util.Date;
import java.util.Properties;

public class MySQLAccess  {
	static final String jdbc_driver = "com.mysql.jdbc.Driver";
	private Connection connect = null;
	private Statement st = null;
	private ResultSet resultSet = null;
	private boolean isUpdated = false;
	
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
			System.out.println("Please check if server is running, or url, user or password is correct");
		}catch (ClassNotFoundException e) {
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
			isUpdated = true;
		} catch (SQLException e) {
			System.out.println("Update unsuccessfully!");
			e.printStackTrace();
		}
	}
	
	//Read database
	private void readDatabase(){
		try {
			st = connect.createStatement();
			String sql = "SELECT * FROM example";
			resultSet = st.executeQuery(sql);
			writeResultSet(resultSet);
			
			
		} catch (SQLException e) {
			System.out.println("Fail to read from database");
			e.printStackTrace();
		}
	}

	//Close database connection
	private void closeConnection() {
		try{
			if(resultSet != null) { 
				resultSet.close();
			}
			if(st != null) {
				st.close();
			}
			if(connect != null) {
				connect.close();
			}
			System.out.println("Database successfully disconnected!");
		}catch(Exception e){
			System.out.println("Unable to close connection");
		}
	}
	
	private void writeResultSet(ResultSet resultSet) throws SQLException{ 
		while(resultSet.next()){
			/*String supplier = resultSet.getString("供应商名称");
			String brand_name = resultSet.getString("品牌名称");
			String part_name = resultSet.getString("配件名称");
			String simp_part_name = resultSet.getString("配件简称");
			String oe = resultSet.getString("原厂编码oe");
			String supplier_id_code = resultSet.getString("供应商配件识别编号");
			String picture = resultSet.getString("图片");
			String part_category = resultSet.getString("配件分类");
			String part_detail = resultSet.getString("配件详情");
			String part_quality = resultSet.getString("配件类型");
			String part_manufacturer = resultSet.getString("配件生产厂家");
			String quantity = resultSet.getString("数量");
			String unit = resultSet.getString("单位");
			String retail_price = resultSet.getString("零售价");
			String platform_price = resultSet.getString("平台售价");
			String tax_fare = resultSet.getString("税费");
			String service_fee = resultSet.getString("服务费");
			String part_belong_car_type = resultSet.getString("配件车辆类别");
			String proper_vehicle_type = resultSet.getString("适用车型");
			String cover_province = resultSet.getString("供应省份");
			String warranty = resultSet.getString("质保期");
			Date import_time = resultSet.getDate("导入时间");
			Date clean_time = resultSet.getDate("清洗时间");
			
			System.out.print("供应商名称:"+supplier);
			System.out.print(", 品牌名称:"+brand_name);
			System.out.print(", 配件名称:"+part_name);
			System.out.print(", 配件简称:"+simp_part_name);
			System.out.print(", 原厂编码oe:"+oe);
			System.out.print(", 供应商配件识别编号:"+supplier_id_code);
			System.out.print(", 图片:"+picture);
			System.out.print(", 配件分类:"+part_category);
			System.out.print(", 配件详情:"+part_detail);
			System.out.print(", 配件类型:"+part_quality);
			System.out.print(", 配件生产厂家:"+part_manufacturer);
			System.out.print(", 数量:"+quantity);
			System.out.print(", 单位:"+unit);
			System.out.print(", 零售价:"+retail_price);
			System.out.print(", 平台售价:"+platform_price);
			System.out.print(", 税费:"+tax_fare);
			System.out.print(", 服务费:"+service_fee);
			System.out.print(", 配件车辆类别:"+part_belong_car_type);
			System.out.print(", 供应省份:"+cover_province);
			System.out.print(", 质保期:"+warranty);
			System.out.print(", 导入时间:"+import_time);
			System.out.print(", 清洗时间:"+clean_time);
			System.out.print(", 适用车型:"+proper_vehicle_type);
			System.out.println();*/
			
		}
	}

	public void operate(){
		// TODO Auto-generated method stub
		establishConnection();
		if(!isUpdated) updateDatabase();	//Determine whether to run update method
		readDatabase();	//read + print table rows
		closeConnection();
	}
	
}
