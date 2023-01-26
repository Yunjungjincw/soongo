package freeboard.service;

import comment.dao.CommentDAO;
import freeboard.dao.FreeBoardDAO;

public class WriteBoardService {

	
	FreeBoardDAO freeBoardDAO = new FreeBoardDAO();
	CommentDAO commentDAO = new CommentDAO();
	public int writetBoard(String title, String content, String free_category) {
		
		
		
		 int cnt = freeBoardDAO.insertBoard(title, content, free_category);
		
		
		
		return cnt;
	}

	public int writeComment(String free_no, String comm_content) {
		int cnt = commentDAO.insertComment(free_no, comm_content);
		return cnt;
	}
	
}