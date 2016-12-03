package sqlPool;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

/**
 * 数据库连接池
 * @author JossC
 *
 */
public class PoolUtils {
	private static DataSource ds = null;
	public PoolUtils(){
		try {
			Properties prop = new Properties();
			prop.load(PoolUtils.class.getClassLoader().getResourceAsStream("dbcpconfig.properties"));
			ds = BasicDataSourceFactory.createDataSource(prop);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 返回连接
	 * @return
	 * @throws SQLException
	 */
	public static  Connection getConnection() throws SQLException{
		return ds.getConnection();
	}
	public void release(Connection conn,Statement stmt,ResultSet rs){
		// 关闭资源
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
