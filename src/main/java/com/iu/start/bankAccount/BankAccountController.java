package com.iu.start.bankAccount;

import java.util.List;

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
		System.out.println("ACCOUNT 실행");
		return "bankAccount/add";
	}
	
	@RequestMapping(value = "list.iu", method = RequestMethod.GET)
	public String list()throws Exception{
		System.out.println("account list실행");
		List<BankAccountDTO> ar = bankAccountService.getList();
		return "bankAccount/list";
		
	}
}
