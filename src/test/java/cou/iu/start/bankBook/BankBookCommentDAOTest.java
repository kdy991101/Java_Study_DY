package cou.iu.start.bankBook;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.start.bankBook.BankBookCommentDAO;
import com.iu.start.bankBook.BankBookCommentDTO;
import com.iu.start.bankBook.BankBookDAO;
import com.iu.start.bankBook.BankBookDTO;

import cou.iu.start.MyAbstractTest;


public class BankBookCommentDAOTest extends MyAbstractTest{
	@Autowired
	private BankBookCommentDAO bankBookCommentDAO;
	
	@Test
 public void setCommentAddTest() throws Exception{
	 BankBookCommentDTO bankBookCommentDTO = new BankBookCommentDTO();
	 bankBookCommentDTO.setWriter("reply");
	 bankBookCommentDTO.setContents("DSA");
	 bankBookCommentDTO.setBookNum(1660036232213L);
	 
	 int result = bankBookCommentDAO.setCommentAdd(bankBookCommentDTO);
	 
	 assertEquals(1, result);
 }
	
	
	
}
