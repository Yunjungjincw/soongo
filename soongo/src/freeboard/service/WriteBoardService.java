package freeboard.service;

import freeboard.dao.FreeBoardDAO;

public class WriteBoardService {

	
	FreeBoardDAO freeBoardDAO = new FreeBoardDAO();
	
	public int writetBoard(String title, String content) {
		
		
		
		 int cnt = freeBoardDAO.insertBoard(title, content);
		
		
		
		return cnt;
	}
	
}