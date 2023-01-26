package comment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import comment.model.CommentList;
import freeboard.model.FreeBoardList;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;

public class CommentDAO {
	
	// 게시글 번호에 맞는 댓글 조회
		public List<CommentList> selectAllComment(String no) {
			PreparedStatement stmt = null;
			ResultSet rs = null;
			
			String sql="select comm_no,comm_content,comm_credate,user_name,isshow,comm_volt,free_no" + 
					" from free_comment" + 
					" where free_no=?";
			
			List<CommentList> commentList = new ArrayList<CommentList>();
			try {
				Connection conn = ConnectionProvider.getConnection();
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, no);
				rs = stmt.executeQuery();
				
				System.out.println("dao1");
				while(rs.next()) {
					CommentList list = new CommentList(
												rs.getInt(1),
												rs.getString(2),
												rs.getTimestamp(3),
												rs.getString(4),
												rs.getString(5),
												rs.getInt(6),
												rs.getInt(7));
					commentList.add(list);
	}
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				JdbcUtil.close(stmt);
				JdbcUtil.close(rs);
			}
			return commentList;
		}
	
	//댓글 쓰기
	public int insertComment(String free_no, String comm_content) {
		System.out.println("댓글쓰기 진입");
		PreparedStatement stmt = null;
		
		String sql="INSERT INTO FREE_COMMENT (comm_content,comm_credate,user_name,isshow,comm_volt,free_no)" + 
				" VALUES (?,now(),'이름15','Y',0,?)";
		
		int cnt = 0;
		
		try {
			
			Connection conn = ConnectionProvider.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, comm_content);
			stmt.setString(2, free_no);
			cnt = stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(stmt);
		}
		return cnt;
	}
	
	/*
	// 수정하기
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
	*/
	
	//글 삭제하기
	public int deleteComment(String comm_no) {
		System.out.println("dao-comment delete 진입");
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int result = -1;
		
		String sql="Delete from free_comment" + 
				" where comm_no=?";
		
		
		try {
			Connection conn = ConnectionProvider.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, comm_no);
			result = stmt.executeUpdate();
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(stmt);
			JdbcUtil.close(rs);
		}
	
		return result;
	} 
}































