package comment.service;

import comment.dao.CommentDAO;
import freeboard.dao.FreeBoardDAO;

public class WriteCommentService {

	
	CommentDAO commentDAO = new CommentDAO();
	
	
	
	
	public int writeComment(String free_no, String comm_content) {
		int cnt = commentDAO.insertComment(free_no, comm_content);
		return cnt;
	}
	
}