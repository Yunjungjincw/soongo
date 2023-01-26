package comment.service;

import java.util.List;

import comment.dao.CommentDAO;
import comment.model.Comment;
import comment.model.CommentList;

public class ListCommentService {
	
	private CommentDAO commentDAO = new CommentDAO();
	
	
	public Comment getCommentList(String no) {
		
		List<CommentList> list 
			= commentDAO.selectAllComment(no);
		

		return new Comment(list);
	}
}
