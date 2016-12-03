package sqlUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * 模拟连接池
 * 
 * @author JossC
 */
public class SqlConnections {
	// 创建连接池
	private static LinkedList<Connection> pool = new LinkedList<Connection>();

	public SqlConnections() {
		try {
			for (int i = 0; i < 10; i++) {
				Connection conn = DBUtils.getConnection();
				pool.add(conn);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("初始化数据库失败");
		}
	}
	/**
	 * 得到连接
	 * @return
	 */
	public Connection getConnectionFomrPool(){
		Connection conn = null;
		if(pool.size()>0){
			//取出一个连接
			 conn = pool.removeFirst();
			 return conn;
		}else{
			throw new RuntimeException("服务器繁忙");
		}
	}
	public void close(Connection conn){
		pool.addLast(conn);
		
	}
}
