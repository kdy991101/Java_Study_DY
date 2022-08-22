package com.iu.start.bankMembers;

import java.util.List;

public interface MembersDAO {
	//bankMembers 회원가입
			public int setJoin(BankMembersDTO bankMembersDTO)throws Exception;

			public List<BankMembersDTO> getSearchByID(String search)throws Exception;
			
			public BankMembersDTO getMyPage(BankMembersDTO bankMembersDTO) throws Exception;

}
