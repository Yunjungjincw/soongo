package mvc.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//p531 
// 이 인터페이스는 모든 컨트롤러클래스 (교재에서는 ~~ Handler)에서
//무조건 구현하게 함으로써
//모든 컨트롤러 클래스에서 process()를 반드시 
//오버라이딩하도록 강제화 시키는 역할을 한다.

//이 인터페이스를 구현하는 클래스에서 모두 똑같은 process를 사용하기 위한 용도로 쓰이는건가

   
public interface CommandHandler {
	
	public abstract String process(HttpServletRequest request,
			HttpServletResponse response) throws Exception;
	
		
	//String 타입의 view 리턴해주는 메서드
}
