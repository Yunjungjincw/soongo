package freeboard.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import freeboard.model.FreeBoard;
import freeboard.service.ListBoardService;
import freeboard.service.ReadBoardService;
import freeboard.service.UpdateBoardService;
import mvc.command.CommandHandler;

public class UpdateBoardHandler implements CommandHandler {

	UpdateBoardService updateBoardService = new UpdateBoardService();
	ListBoardService listBoardService = new ListBoardService();
	ReadBoardService readBoardService = new ReadBoardService();
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		if(request.getMethod().equalsIgnoreCase("GET")) {
			return processForm(request,response);
		} else if(request.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(request,response);
		} else {
			response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
		}
		
		
		return null;
	}
	
	private String processForm(HttpServletRequest request, HttpServletResponse response) {
		String no = request.getParameter("no");
		
		FreeBoard freeBoard 
	 	= readBoardService.getBoardDetail(no);
		System.out.println("freeBoard ="+freeBoard);
		request.setAttribute("freeBoard", freeBoard);
		
		
		return "/view/freeboard/freeBoardUpdate.jsp";
	}


	
	private String processSubmit(HttpServletRequest request, HttpServletResponse response) {
		String no = request.getParameter("no");
		System.out.println("no2222="+no);
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		
	
		int result = updateBoardService.update(no, title, content);
		
		
		//insert 되었다는 변수
		request.setAttribute("result",result);
		
		
		
		return "/view/freeboard/freeBoardList.jsp";
	}
}
