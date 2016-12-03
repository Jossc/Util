package Test;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.apache.commons.dbutils.QueryRunner;
//import org.apache.commons.dbutils.ResultSetHandler;
//import org.apache.commons.dbutils.handlers.BeanListHandler;
//import org.junit.Test;
//
//import C3p0.C3P0Util;

public class TestCrud {
	/**
	 * ≤È—Ø
	 * @throws SQLException 
	 */
//	@Test
//	public void testSelet() throws SQLException{
//		//¥¥Ω®QueryRunner
//		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
//		List<User> list = qr.query("SELECT * FROM uses",new ResultSetHandler<List<User>>(){
//			@Override
//			public List<User> handle(ResultSet rs) throws SQLException {
//				List<User> list  = new ArrayList<User>();
//				while(rs.next()){
//					User u = new User();
//					u.setId(rs.getInt(1));
//					u.setUsername(rs.getString(2));
//					u.setPassword(rs.getString(3));
//					u.setEmail(rs.getString(4));
//					u.setBithday(rs.getDate(5));
//					list.add(u);
//				}
//				return list;
//			}
//		});
//		for(User u : list){
//			System.out.println(u);
//		}
//	}
//	@Test
//	public void testSelect2() throws SQLException{
//		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
//		List<User> list =qr.query("SELECT * FROM uses where id = ?", new BeanListHandler<User>(User.class),13);
//		for(User u : list){
//			System.out.println(u);
//		}
//
//	}
}
