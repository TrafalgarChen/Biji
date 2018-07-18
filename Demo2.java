package cn.t.demo2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class Demo2 {
	@Test
	public void fun1() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		//String driverClassName = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/chendb?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC&useSSL=false";
		String username = "root";
		String password = "123";
		
		Connection con = DriverManager.getConnection(url, username, password);
		
		Statement stmt = con.createStatement();
		
		String sql = "INSERT INTO TB_STU VALUES(1,'ZHANGSAN',20,'MALE')";
		int r = stmt.executeUpdate(sql);
		System.out.println(r);
	}
	@Test
	public void fun2() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/chendb?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC&useSSL=false";
		String username = "root";
		String password = "123";
		
		Connection con = DriverManager.getConnection(url, username, password);
		
		Statement stmt = con.createStatement();
		ResultSet re = stmt.executeQuery("SELECT * FROM TB_STU");
		
		//System.out.println(re);
		while(re.next()) {
			int tbid = re.getInt(1);
			String tbname = re.getString("name");
			int tbage = re.getInt("age");
			
			System.out.println(tbid + "," + tbname + "," + tbage );
		}
		re.close();
		stmt.close();
		con.close();
	}
	@Test
	public void fun3() throws Exception {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			String driverClassName = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/chendb?useUniconde=yes&characterEncoding=utf-8&serverTimezone=UTC&useSSL=false";
			String username = "root";
			String password = "123";
			
			Class.forName(driverClassName);
			con = DriverManager.getConnection(url, username, password);
			stmt = con.createStatement();
			String sql = "select * from tb_stu";
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				System.out.println(rs.getObject(1) +"," + rs.getString("name") + "," + rs.getInt("age"));
			}
		}catch(Exception e) {
			throw new RuntimeException(e);
		}finally {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(con != null) con.close();
			
		}
	}
	
}
