package product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import front.fw.Action;
//	/product/list.do로 요청하면 실행할 클래스
public class ProductList implements Action {

	@Override
	public void run(HttpServletRequest request, HttpServletResponse response) 
											throws ServletException, IOException {
		System.out.println("전체 상품 목록 조회하기");
		
	}

}
