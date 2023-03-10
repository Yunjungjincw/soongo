package freeboard.command;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import freeboard.model.FreeBoard;
import freeboard.service.DeleteBoardService;
import freeboard.service.ListBoardService;
import freeboard.service.ReadBoardService;
import freeboard.service.UpdateBoardService;
import mvc.command.CommandHandler;

public class DeleteBoardHandler implements CommandHandler {

	UpdateBoardService updateBoardService = new UpdateBoardService();
	ReadBoardService readBoardService = new ReadBoardService();
	DeleteBoardService deleteBoardService = new DeleteBoardService();
	
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
	
	private String processForm(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		String noVal = request.getParameter("no");
		int no = Integer.parseInt(noVal);
		
		FreeBoard freeBoard 
	 	= readBoardService.getBoardDetail(no);
		System.out.println("freeBoard ="+freeBoard);
		request.setAttribute("freeBoard", freeBoard);
		
		
		return "/view/freeboard/freeBoardDelete.jsp";
	}


	
	private String processSubmit(HttpServletRequest request, HttpServletResponse response) {
		String no = request.getParameter("no");
		System.out.println("no2222="+no);
		
		int deleteresult = deleteBoardService.delete(no);
		//insert 되었다는 변수
		
		if(deleteresult!=1) {
			return "/view/freeboard/freeBoardList.jsp";
		}else {
			request.setAttribute("deleteresult",deleteresult);
			return "/view/freeboard/freeBoardDeleteSuccess.jsp";
		}
	}
}
