package freeboard.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import freeboard.dao.FreeBoardDAO;
import freeboard.model.FreeBoard;
import freeboard.model.FreeBoardList;
import jdbc.connection.ConnectionProvider;

public class ReadBoardService {
private FreeBoardDAO freeBoardDAO = new FreeBoardDAO();
	
	
	public FreeBoard getBoardDetail(String no) {
		System.out.println("서비스 진입");
	
		try {
			Connection conn 
						= ConnectionProvider.getConnection();
			System.out.println("db연결 확인");
			
		List<FreeBoardList> list 
			= freeBoardDAO.readDetail(no);
		System.out.println("서비스 read"+list);
		
		
		return new FreeBoard(list);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}
}
