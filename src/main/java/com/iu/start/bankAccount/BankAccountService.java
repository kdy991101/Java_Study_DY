package com.iu.start.bankAccount;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankAccountService {
	
	@Autowired 
	BankAccountDAO bankAccountDAO;
	
	public int add(BankAccountDTO bankAccountDTO) throws Exception{
		return bankAccountDAO.add(bankAccountDTO);
	}
	
	public List<BankAccountDTO> getList()throws Exception{
		return bankAccountDAO.getList();
	}

}
