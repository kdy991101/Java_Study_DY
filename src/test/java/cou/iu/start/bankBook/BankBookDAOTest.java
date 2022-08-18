package cou.iu.start.bankBook;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.start.bankBook.BankBookDAO;
import com.iu.start.bankBook.BankBookDTO;

import cou.iu.start.MyAbstractTest;


public class BankBookDAOTest extends MyAbstractTest{
	

	@Autowired//DAO에생성된 객체를 주입
	private BankBookDAO bankBookDAO;
	
	@Test
	public void getListTest() throws Exception {
	 List<BankBookDTO> ar = bankBookDAO.getList();
	}
	
	@Test
	public void setBankBookTest() throws Exception{
		BankBookDTO bankBookDTO = new BankBookDTO();
		Calendar ca = Calendar.getInstance();	
		bankBookDTO.setBookName("--");
		bankBookDTO.setBookNum(ca.getTimeInMillis());
		bankBookDTO.setBookRate(1.1);
		bankBookDTO.setBookSale(1);
		bankBookDTO.B
		
	}
	
	@Test
	public void getDetailTest() throws Exception{
		BankBookDTO bankBookDTO = bankBookDAO.getDetail();
	}
	
	
	
}
