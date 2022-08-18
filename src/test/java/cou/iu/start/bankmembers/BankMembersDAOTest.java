package cou.iu.start.bankmembers;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.start.bankMembers.BankMembersDAO;

public class BankMembersDAOTest {

	@Autowired
	private BankMembersDAO bankMembersDAO;
	
	@Test
	public void setJoinTest()throws Exception{
		int result = bankMembersDAO.setJoin(null);
		throw new Exception();
		assertEquals(1, result);
	}
	
	@Test
	public void getloginTest()throws Exception{
		Object obj = bankMembersDAO.getlogin(null);
		assertNull(obj);
	}
	
	@Test
	public void getSearch()throws Exception{
	
	}
}


