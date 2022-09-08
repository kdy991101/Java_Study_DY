package cou.iu.start.bankBook;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.List;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;

import com.iu.start.bankBook.BankBookCommentDAO;
import com.iu.start.bankBook.BankBookCommentDTO;
import com.iu.start.bankBook.BankBookDAO;
import com.iu.start.bankBook.BankBookDTO;
import com.iu.start.util.CommentPager;

import cou.iu.start.MyAbstractTest;

@WebAppConfiguration
public class BankBookCommentDAOTest extends MyAbstractTest{
	@Autowired
	private BankBookCommentDAO bankBookCommentDAO;
	
////@Test
// public void setCommentAddTest() throws Exception{
//	 BankBookCommentDTO bankBookCommentDTO = new BankBookCommentDTO();
//	 bankBookCommentDTO.setWriter("reply");
//	 bankBookCommentDTO.setContents("DSA");
//	 bankBookCommentDTO.setBookNum(1660036232213L);
//	 
//	 int result = bankBookCommentDAO.setCommentAdd(bankBookCommentDTO);
//	 
//	 assertEquals(1, result);
// }
 
// @Test
 public void getCommentListTest()throws Exception{
	 
	 CommentPager commentPager = new CommentPager();
	 
	 commentPager.setBookNum(1660188204925L);
	 commentPager.setPage(1L);
	 commentPager.getRowNum();
	 
	 List<BankBookCommentDTO> ar = bankBookCommentDAO.getCommnetList(commentPager);
	 assertNotEquals(0, ar.size());
 }
 
 public void getCommentUpdateTest()throws Exception{
	 BankBookCommentDTO bankBookCommentDTO = new BankBookCommentDTO();
	 bankBookCommentDTO.setNum(1042L);
	 bankBookCommentDTO.setContents("수정");
	 bankBookCommentDTO.setWriter("성공");
	 
	 
	 
 }
	
	
	
}
