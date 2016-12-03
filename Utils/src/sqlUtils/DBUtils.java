package sqlUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class DBUtils {
	private static String dirverClass;
	private static String url;
	private static String username;
	private static String password;

	static {
		try {
			ResourceBundle re = ResourceBundle.getBundle("dbinfo");
			dirverClass = re.getString("dirverClass");
			System.out.println(dirverClass);
			url = re.getString("url");
			System.out.println(url);
			username = re.getString("dirverClass");
			System.out.println(username);
			password = re.getString("password");
			System.out.println(password);
			Class.forName(dirverClass);
		} catch (ClassNotFoundException e) {
			System.out.println("Message" + e.getMessage());
			//e.printStackTrace();
			throw new ExceptionInInitializerError(e);
		}
	}

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}

	public static void closeAll(ResultSet rs, Statement stmt, Connection conn) {
		// ¹Ø±Õ×ÊÔ´
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			rs = null;
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			stmt = null;
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}
}
