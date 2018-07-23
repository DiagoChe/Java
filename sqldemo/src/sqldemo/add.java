package sqldemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

 public class add {
	 public static void main(String[]args) throws SQLException{
	 	Connection con;  //声明Connection对象
	 	String driver = "com.mysql.jdbc.Driver";  //驱动程序名
	 	String url = "jdbc:mysql://localhost:3306/student";  //URL指向要访问的数据库名student
	 	String user = "root";  //MySQL配置时的用户名
	 	String password = "687198";  //MySQL配置时的密码
	 	PreparedStatement psql;
	 	con= DriverManager.getConnection(url,user,password);  //1.getConnection()方法，连接MySQL数据库！！
	 	psql =  con.prepareStatement("update student set grade = ? where name = ?");
	 	psql.setFloat(1,(float) 88);      
	 	psql.setString(2,"王刚");             
		psql.executeUpdate();
	 }
}
