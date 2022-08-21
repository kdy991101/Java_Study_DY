package com.iu.start.bankAccount;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

public interface AccountDAO {

	public int add()throws Exception;
	
	public List<BankAccountDTO> getList()throws Exception;
	
}
