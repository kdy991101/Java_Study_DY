package com.iu.start.bankAccount;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Repository(value = "/bankAccount/*")
public class BankAccountController {
	
	@Autowired
	private BankAccountService bankAccountService;
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String ModelAndView (BankAccountDTO bankAccountDTO) throws Exception{
		System.out.println("ACCOUNT 실행");
		int result = bankAccountService.add(bankAccountDTO);
		System.out.println(result);
		
		return "bankAccount/list";
	}
	
	@RequestMapping(value = "list.iu", method = RequestMethod.GET)
	public ModelAndView list()throws Exception{
		System.out.println("account list실행");
		ModelAndView mv = new ModelAndView();
		List<BankAccountDTO> ar = bankAccountService.getList(null);
		mv.addObject("list",ar);
		mv.setViewName("bankAccount/list");
		return mv;
		
	}
}
