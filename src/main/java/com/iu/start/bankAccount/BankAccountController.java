package com.iu.start.bankAccount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Repository(value = "bankAccount/*")
public class BankAccountController {
	
	@Autowired
	private BankAccountService bankAccountService;
	
	@RequestMapping(value = "add.iu", method = RequestMethod.GET)
	public String add() {
		return "bankAccount/add";
	
	}
	
	@RequestMapping(value = "add.iu", method = RequestMethod.POST)
	public ModelAndView add(BankAccountDTO bankAccountDTO) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		int result = bankAccountService.add(bankAccountDTO);
		
		mv.setViewName("redirect:./list.do");
		return mv;
		
		
	}
}
