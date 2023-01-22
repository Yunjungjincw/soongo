package jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//p586
//web.xml 문서에서 설정한 poolName=board으로 지정한 
// board를 풀 이름으로 사용하여 connection을 제공하는 클래스.
/*Connection을 필요하는 외부에서 
 * Connection 참조변수 = ConnectionProvider.getConnection()*/


public class ConnectionProvider {
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(
				"jdbc:apache:commons:dbcp:board");	
	}
}
