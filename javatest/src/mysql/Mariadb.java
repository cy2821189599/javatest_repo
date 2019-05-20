package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Mariadb {
	private static String driver = "org.mariadb.jdbc.Driver";
	private static String url = "jdbc:mariadb://127.0.0.1:3306/stu_crm";
	private static String user = "root";
	private static String password = "chenyun";
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url,user,password); 
		Statement statement = con.createStatement();
		ResultSet set = statement.executeQuery("select * from crm_staff");
		while(set.next()) {
			System.out.println(set.getString("staffName"));
		}
		con.close();
		statement.close();
		set.close();
	}

}
