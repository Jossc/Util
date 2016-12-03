package sqlUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * ģ�����ӳ�
 * 
 * @author JossC
 */
public class SqlConnections {
	// �������ӳ�
	private static LinkedList<Connection> pool = new LinkedList<Connection>();

	public SqlConnections() {
		try {
			for (int i = 0; i < 10; i++) {
				Connection conn = DBUtils.getConnection();
				pool.add(conn);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("��ʼ�����ݿ�ʧ��");
		}
	}
	/**
	 * �õ�����
	 * @return
	 */
	public Connection getConnectionFomrPool(){
		Connection conn = null;
		if(pool.size()>0){
			//ȡ��һ������
			 conn = pool.removeFirst();
			 return conn;
		}else{
			throw new RuntimeException("��������æ");
		}
	}
	public void close(Connection conn){
		pool.addLast(conn);
		
	}
}
