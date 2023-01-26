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
	
}