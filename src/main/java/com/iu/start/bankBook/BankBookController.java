package com.iu.start.bankBook;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JacksonInject.Value;
import com.iu.start.util.CommentPager;

@Controller
@RequestMapping(value = "/bankbook/*")
public class BankBookController {
 
	@Autowired
	private BankBookService bankBookService;
	
	@RequestMapping(value = "list.iu", method = RequestMethod.GET)
	public String list(Model model) throws Exception {
		System.out.println("list실행");
		List<BankBookDTO> ar =bankBookService.getList();
		model.addAttribute("list", ar);
		return "bankbook/list";
	}
	
	@RequestMapping(value = "detail.iu", method = RequestMethod.GET)
	public ModelAndView detail(BankBookDTO bankBookDTO)throws Exception{
 		ModelAndView modelAndView = new ModelAndView();//model+view
		System.out.println("detail실행");
//		System.out.println("bookNum : " + bookNum);
		bankBookDTO =bankBookService.getDetail(bankBookDTO);
		modelAndView.setViewName("bankbook/detail");
		modelAndView.addObject("detail", bankBookDTO);
//		modelAndView.setViewName("redirect:./update");
		return modelAndView;
	}
	
	@RequestMapping(value = "add.iu", method = RequestMethod.GET)
	public String add() throws Exception {
		System.out.println("add실행");
		return "bankbook/add";//jsp경로명
	}
	
	@RequestMapping(value = "add.iu", method = RequestMethod.POST)
	public ModelAndView add(BankBookDTO bankBookDTO) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		
		int result = bankBookService.setBankBook(bankBookDTO);
		
		if(result == 1) {
			System.out.println("성공");
		} else {
			System.out.println("실패");
		}
		mv.setViewName("redirect:./list.iu");
		return mv;
		
		
//		return "ban/add";
	}
	@RequestMapping(value = "update.iu", method = RequestMethod.GET)
	public void update(BankBookDTO bankBookDTO, Model model) throws Exception{
		System.out.println("업데이트 실행");
		System.out.println(bankBookDTO.getBookNum());
		bankBookDTO = bankBookService.getDetail(bankBookDTO);
		model.addAttribute("detail", bankBookDTO);
	}
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ModelAndView update(BankBookDTO bankBookDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = bankBookService.setUpdate(bankBookDTO);
		
		if(result == 1) {
			System.out.println("성공");
		} else {
			System.out.println("실패");
		}
		
		mv.setViewName("redirect:./detail.iu?bookNum="+bankBookDTO.getBookNum());
		return mv;	
	}
	@RequestMapping(value = "delete.iu", method = RequestMethod.GET)
	public ModelAndView delete(BankBookDTO bankBookDTO)throws Exception {
		ModelAndView mv = new ModelAndView();
		System.out.println("delete실행");
		int result = bankBookService.setDelete(bankBookDTO);
		
		if(result == 1) {
			System.out.println("성공");
		} else {
			System.out.println("실패");
			
		}
		mv.setViewName("redirect:./list.iu");
		return mv;
	}
	//=======================Comment
//	@PostMapping(value = "commentAdd")
//	public ModelAndView commentAdd(BankBookCommentDTO bankBookCommentDTO)throws Exception{
//		//리턴 타입이 void일 때에는 commentAdd.jsp를 찾으러 감
//		ModelAndView mv = new ModelAndView();
//		
//		int result = bankBookService.setCommentAdd(bankBookCommentDTO);
//		
//		mv.addObject("result", result);
//		mv.setViewName("common/ajaxResult");
//		
//		return mv;
//	}
	//=========================json에 담아 보내기
	@PostMapping(value = "commentAdd")
	@ResponseBody
	//ResponseBody=>리턴하는 데이터를 body(응답)에 담음
	public String commentAdd(BankBookCommentDTO bankBookCommentDTO)throws Exception{
		//리턴 타입이 void일 때에는 commentAdd.jsp를 찾으러 감
		ModelAndView mv = new ModelAndView();
		
		int result = bankBookService.setCommentAdd(bankBookCommentDTO);
		//{}
		String jsonResult = "{\"result\":\""+result+"\"}";
		
		return jsonResult;
	}
	
	//1.jsp에 출력하고 결과물을 응답으로 전송
	//우리가 알고있는 방식
	//jsp 로 보내서 table태그를 직접 만드는 것
	//후에 응답의 결과로 보내줌
	//vs코드 reponseText로 들어감
//	@GetMapping(value = "commentList")
//	public ModelAndView getCommentList(CommentPager commentPager) throws Exception{
//		ModelAndView mv = new ModelAndView();
//		List<BankBookCommentDTO> ar = bankBookService.getCommentList(commentPager);
//		System.out.println(ar.size());
//		mv.addObject("commentList", ar);
//		mv.setViewName("common/commentList");
//		return mv;
//	}
	//2.json
	@GetMapping(value = "commentList")
	@ResponseBody
	public Map<String, Object> getCommentList(CommentPager commentPager) throws Exception{
		List<BankBookCommentDTO> ar = bankBookService.getCommentList(commentPager);
		System.out.println(ar.size());
		//json은 여러개의 묶음을 배열로 표시한다, [{key, value}]
		//DTO == {}
		//num=1 == {"num":1, "bookNum":123, "writer":"name"}과 같음
		//[{"num":1, "bookNum":123, "writer":"name"}, {"num":1, "bookNum":123, "writer":"name"}, {"num":1, "bookNum":123, "writer":"name"}]
		//""잘 챙기기
		Map<String, Object> map = new HashMap<String, Object>(); 
				//map은 인터페이스임
		map.put("list", ar);
		map.put("pager", commentPager);
		
		return map;
	}
	@PostMapping(value = "commentDelete")
	@ResponseBody
	public int setCommentDelete(BankBookCommentDTO bankBookCommentDTO)throws Exception{
		
		int result = bankBookService.setCommentDelete(bankBookCommentDTO);
		
		return result;
	}
	
	@PostMapping("commentUpdate")
	@ResponseBody
	public int setCommentUpdate(BankBookCommentDTO bankBookCommentDTO)throws Exception{
		int result = bankBookService.setCommentDelete(bankBookCommentDTO);
		return result;
	}
}
