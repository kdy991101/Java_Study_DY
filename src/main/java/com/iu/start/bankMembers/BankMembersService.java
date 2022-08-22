package com.iu.start.bankMembers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.start.bankAccount.BankAccountDAO;
import com.iu.start.bankAccount.BankAccountDTO;

@Service
public class BankMembersService {
	
	@Autowired
	private BankMembersDAO bankMembersDAO;
	@Autowired
	private BankAccountDAO bankAccountDAO;
	
	//로그인
	public BankMembersDTO getlogin(BankMembersDTO bankMembersDTO)throws Exception{
		return bankMembersDAO.getlogin(bankMembersDTO);
	}
	
	//bankMembers 회원가입
	public int setJoin(BankMembersDTO bankMembersDTO)throws Exception{
		return bankMembersDAO.setJoin(bankMembersDTO);
	};
	
	//검색어를 입력해서 ID를 찾기 abc 순으로
	public List<BankMembersDTO> getSearchByID(String search)throws Exception{
		return bankMembersDAO.getSearchByID(search);
	}

	public BankMembersDTO getMyPage(BankMembersDTO bankMembersDTO) throws Exception {
		// TODO Auto-generated method stub
		List<BankAccountDTO> ar = bankAccountDAO.getList(bankMembersDTO);
		return bankMembersDAO.getMyPage(bankMembersDTO);
	};

}
