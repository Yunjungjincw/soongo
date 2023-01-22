package freeboard.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import freeboard.model.FreeBoard;
import freeboard.service.ReadBoardService;
import mvc.command.CommandHandler;

public class ReadBoardHandler implements CommandHandler {

	ReadBoardService readBoardService = new ReadBoardService();
	
	@Override
	public String process(HttpServletRequest request,
					HttpServletResponse response) throws Exception {
		System.out.println("ReadBoardHandler 진입");
		
		
		String no 
			= request.getParameter("no");
		
		
		
		 FreeBoard freeBoard 
		 	= readBoardService.getBoardDetail(no);
		 request.setAttribute("freeBoard", freeBoard);
		
		return "/view/freeBoard/freeBoardRead.jsp";
	}
}
