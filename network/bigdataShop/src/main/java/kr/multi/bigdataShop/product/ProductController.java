package kr.multi.bigdataShop.product;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class ProductController {
	@Autowired
	ProductService service;
	

	//�쟾泥댁긽�뭹蹂닿린,移댄뀒怨좊━蹂� 蹂닿린
	@RequestMapping("/product/list.do")
	public ModelAndView list(String category){
		System.out.println("category=>"+category);
		ModelAndView mav = new ModelAndView();
		List<ProductDTO> list = service.productlist(category);
		mav.addObject("prdlist", list);//db�뿉�꽌 議고쉶�븳 寃곌낵 
		                               //- �꽌釉붾┸�뿉�꽌 request.setAttribute
		mav.setViewName("product/list");
		return mav;
	}
	//�긽�뭹�긽�꽭蹂닿린
		@RequestMapping("/product/read.do")
		public String showProduct(String prd_no,String category,
					Model model,HttpServletRequest req) {
			
			ProductDTO product = service.read(prd_no);
			List<ProductCommentDTO> commentlist = service.comm(prd_no);
			model.addAttribute("commentlist", commentlist);
			model.addAttribute("product", product);
			return "product/read";
		}
		
		//일반 메소드 리턴하는 것처럼 List<BoardDTO>를 리턴하면서
				//@ResponseBody로 설정하면 jackson라이브러리가 자동으로 json객체로 변환
				@RequestMapping(value = "/product/show_json",
						method=RequestMethod.GET,
						produces="application/json;charset=utf-8")
				public @ResponseBody List<ProductDTO> categoryboardlist(
																String category) {
					String result = "";
					List<ProductDTO> prdlist = service.productlist(category);
					System.out.println("ajax통신"+prdlist);
					return prdlist;
				}
}









