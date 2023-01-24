package freeboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import freeboard.model.FreeBoardList;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;

public class FreeBoardDAO {
	
	public List<FreeBoardList> selectAll() {
		System.out.println("FreeBoardDAO selectAll진입");
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql="SELECT free_no,free_title,free_content,free_credate,free_update,free_readcnt,user_name,isshow,free_category,user_no"+ 
					" FROM FREEBOARD"+ 
					" ORDER BY free_no DESC";
		
		List<FreeBoardList> freeBoardList = new ArrayList<FreeBoardList>();
		try {
			Connection conn = ConnectionProvider.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			System.out.println("dao1");
			while(rs.next()) {
				FreeBoardList list = new FreeBoardList(
									rs.getInt(1),
									rs.getString(2),
									rs.getString(3),
									rs.getTimestamp(4),
									rs.getTimestamp(5),
									rs.getInt(6),
									rs.getString(7),
									rs.getString(8),
									rs.getString(9),
									rs.getInt(10));
				System.out.println("dao2"+list);
							freeBoardList.add(list);
							
}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(stmt);
			JdbcUtil.close(rs);
		}
		System.out.println("doa3"+freeBoardList);
		return freeBoardList;
	}
	
	
	
	// 상세조회
	public List<FreeBoardList> readDetail(String no) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql="SELECT free_no,free_title,free_content,free_credate,free_update,free_readcnt,user_name,isshow,free_category,user_no"+ 
				" FROM FREEBOARD"+ 
				" WHERE free_no=?";
		
		List<FreeBoardList> freeBoardList = new ArrayList<FreeBoardList>();
		try {
			Connection conn = ConnectionProvider.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, no);
			rs = stmt.executeQuery();
			
			System.out.println("dao1");
			while(rs.next()) {
				FreeBoardList list = new FreeBoardList(
											rs.getInt(1),
											rs.getString(2),
											rs.getString(3),
											rs.getTimestamp(4),
											rs.getTimestamp(5),
											rs.getInt(6),
											rs.getString(7),
											rs.getString(8),
											rs.getString(9),
											rs.getInt(10));
							freeBoardList.add(list);
							
}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(stmt);
			JdbcUtil.close(rs);
		}
		System.out.println("doa3"+freeBoardList);
		return freeBoardList;
	}
	
	
	// 글 쓰기
	public int insertBoard(String title, String content) {
		PreparedStatement stmt = null;
		
		String sql="INSERT INTO FREEBOARD (free_title,free_content,free_credate,free_update,free_readcnt,user_name,isshow,free_category,user_no)" + 
				" VALUES (?,?,now(),now(),0,'이름11','Y','자유',11)";
		
		int cnt = 0;
		
		try {
			
			Connection conn = ConnectionProvider.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, title);
			stmt.setString(2, content);
			cnt = stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(stmt);
		}
		return cnt;
	}
	
	//write 성공하고 보여줄 페이지
	/*public List<FreeBoardList> SuccessPage(String no) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql="SELECT free_no,free_title,free_content,free_credate,free_update,free_readcnt,user_name,isshow,free_category,user_no"+ 
				" FROM FREEBOARD"+ 
				" WHERE free_no=?";
		
		List<FreeBoardList> freeBoardList = new ArrayList<FreeBoardList>();
		try {
			Connection conn = ConnectionProvider.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, no);
			rs = stmt.executeQuery();
			
			System.out.println("dao1");
			while(rs.next()) {
				FreeBoardList list = new FreeBoardList(
											rs.getInt(1),
											rs.getString(2),
											rs.getString(3),
											rs.getTimestamp(4),
											rs.getTimestamp(5),
											rs.getInt(6),
											rs.getString(7),
											rs.getString(8),
											rs.getString(9),
											rs.getInt(10));
							freeBoardList.add(list);
							
}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(stmt);
			JdbcUtil.close(rs);
		}
		System.out.println("doa3"+freeBoardList);
		return freeBoardList;
	}*/
	
	
	
	//글 수정하기
	public int updateBoard(String no, String title, String content) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int result = -1;
		
		String sql="UPDATE FREEBOARD" + 
				" SET free_title=?,free_content=?" + 
				" WHERE free_no=?";
		

		try {
			Connection conn = ConnectionProvider.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, title);
			stmt.setString(2, content);
			stmt.setString(3, no);
			result = stmt.executeUpdate();
			
			System.out.println("dao-updateBoard 진입");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(stmt);
			JdbcUtil.close(rs);
		}
	
		return result;
	}
	
	
	
}































