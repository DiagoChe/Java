package sqldemo;

import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class sqldemo {
	
	public static void main(String[]args) throws SQLException{
		Connection con;  //声明Connection对象
		String driver = "com.mysql.jdbc.Driver";  //驱动程序名
		String url = "jdbc:mysql://localhost:3306/student";  //URL指向要访问的数据库名student
		String user = "root";  //MySQL配置时的用户名
		String password = "687198";  //MySQL配置时的密码
		//add();
		update();
		//delete();  //增删改查功能调用
		try{
			Class.forName(driver); //加载驱动程序
			con= DriverManager.getConnection(url,user,password);  //1.getConnection()方法，连接MySQL数据库！！
			if(!con.isClosed()) {
				System.out.println("Succeeded connecting to the Database!");
			}
				Statement statement = con.createStatement(); //2.创建statement类对象，用来执行SQL语句！！
				String sql = "select * from student"; //要执行的SQL语句
				ResultSet rs = statement.executeQuery(sql);  //3.ResultSet类，用来存放获取的结果集！！
	            System.out.println("-----------------");
	            System.out.println("执行结果如下所示:");  
	            System.out.println("-----------------");  
	            System.out.println("姓名" + "\t" + "学号" + "\t" + "成绩");  
	            System.out.println("-----------------");  
	            
	            String name = null;
	            int number = 0;
	            float grade =0;
	            while(rs.next()){
	            	number = rs.getInt("number");
	            	grade = rs.getFloat("grade");  //获取列数据
	            	name = rs.getString("name");
	            	
	            	System.out.println(name + "\t" + number + "\t" + grade); //输出结果
	            }
	            rs.close();
	            con.close();
			}  catch (ClassNotFoundException e) {  //数据库驱动类异常处理
				System.out.println("Sorry,can`t find the Driver!");   
	            e.printStackTrace();   
			} catch(SQLException e) {   //数据库连接失败异常处理
				e.printStackTrace();
			} catch (Exception e) {
				// TODO: handle exception
	            e.printStackTrace();
			} finally {
				System.out.println("数据库数据成功获取！！");
			}
		}


	 private static void update() throws SQLException {
		Connection con;  //声明Connection对象
		String url = "jdbc:mysql://localhost:3306/student";  //URL指向要访问的数据库名student
		String user = "root";  //MySQL配置时的用户名
		String password = "687198";  //MySQL配置时的密码
		PreparedStatement psql;
		con = DriverManager.getConnection(url,user,password);
		psql= con.prepareStatement("update student set grade= ? where name= ?");
		psql.setFloat(1,(float)68);
		psql.setString(2, "xiaoming");
		psql.executeUpdate();
	}


	 private static void add() throws SQLException {
		Connection con;  //声明Connection对象
		String url = "jdbc:mysql://localhost:3306/student";  //URL指向要访问的数据库名student
		String user = "root";  //MySQL配置时的用户名
		String password = "687198";  //MySQL配置时的密码
		PreparedStatement psql;
		con = DriverManager.getConnection(url,user,password);  //1.getConnection()方法，连接MySQL数据库！！
		psql =  con.prepareStatement("insert into student (name,number,grade)" + "values(?,?,?)");
		psql.setString(1,"王刚");      
		psql.setInt(2,004);  
		psql.setFloat(3,77);
		psql.executeUpdate();
	}

}

