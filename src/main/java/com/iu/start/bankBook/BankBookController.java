package com.iu.start.bankBook;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
}
