package cou.iu.start.bankmembers;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.start.bankMembers.BankMembersDAO;
import com.iu.start.bankMembers.BankMembersDTO;

import cou.iu.start.MyAbstractTest;

public class BankMembersDAOTest extends MyAbstractTest {

	@Autowired
	private BankMembersDAO bankMembersDAO;
	
	@Test
	public void getMyPageTest()throws Exception{
		BankMembersDTO bankMembersDTO = new BankMembersDTO();
		bankMembersDTO.setUsername("qwer");
		
		bankMembersDTO = bankMembersDAO.getMyPage(bankMembersDTO);
		System.out.println(bankMembersDTO.getEmail());
		assertNotNull(bankMembersDTO);
	}
	
	
	
}


