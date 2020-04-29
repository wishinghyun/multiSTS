package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import front.fw.Action;
//추가할 내용이 생기면 설정파일에 요청 path와 실행할 클래스를 등록
//실제 처리할 클래스만 추가
public class LoginAction implements Action {

	@Override
	public void run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("로그인 처리하기");
	}

}
