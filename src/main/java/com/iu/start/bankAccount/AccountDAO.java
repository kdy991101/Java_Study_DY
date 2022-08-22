package com.iu.start.bankAccount;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.iu.start.bankMembers.BankMembersDTO;

public interface AccountDAO {
	
	public int add(BankAccountDTO bankAccountDTO) throws Exception;
	
	public List<BankAccountDTO> getList(BankMembersDTO bankMembersDTO)throws Exception;

	
}
