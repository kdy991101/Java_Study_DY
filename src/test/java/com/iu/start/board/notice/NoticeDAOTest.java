package com.iu.start.board.notice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.start.board.impl.BoardDTO;

import cou.iu.start.MyAbstractTest;

public class NoticeDAOTest extends MyAbstractTest {
	
	@Autowired
	private NoticeDAO noticeDAO;
	
//	@Test
//	public void getListTest()throws Exception{
//		Map<String, Long> map = new 
//		List<BoardDTO> ar = noticeDAO.getList(1); 
//		assertNotEquals(0, ar.size());
//	}
	
//	@Test
	public void getDatailTest()throws Exception{
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNum(1L);
		assertNotEquals(0, noticeDTO);
	}
	
	@Test
	public void getCountTest()throws Exception{
		long count = noticeDAO.getCount();
		assertEquals(206L, count);
	
	}
	
//	@Test
//	public void setAddTest()throws Exception{
//		
//		for(int i=0; i<100; i++) {
//		NoticeDTO noticeDTO = new NoticeDTO();
//		noticeDTO.setTitle("titlr"+i);
//		noticeDTO.setContents("contents"+i);
//		noticeDTO.setWriter("writer"+i);
//		int result = noticeDAO.setAdd(noticeDTO);
//		
//			if(i%10==0) {
//			Thread.sleep(500);
//			}
//		}
//		System.out.println("끝~~~~!!!!!!!!!!!!");
//	}

//	@Test
	public void setUpdateTest()throws Exception{
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNum(1L);
		noticeDTO.setTitle("test6");
		noticeDTO.setContents("test6");
		int result = noticeDAO.setUpdate(noticeDTO);
		assertEquals(1, result);
	}
	
//	@Test
	public void  setDaleteTest()throws Exception{
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNum(1L);
		int result = noticeDAO.setDelete(noticeDTO);
		assertEquals(1, result);
	}

}
