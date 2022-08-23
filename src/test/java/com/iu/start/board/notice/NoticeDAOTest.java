package com.iu.start.board.notice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.start.board.impl.BoardDTO;

import cou.iu.start.MyAbstractTest;

public class NoticeDAOTest extends MyAbstractTest {
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	@Test
	public void getListTest()throws Exception{
		List<BoardDTO> ar = noticeDAO.getList(); 
		assertNotEquals(0, ar.size());
	}
	
//	@Test
	public void getDatailTest()throws Exception{
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNum(1L);
		assertNotEquals(0, noticeDTO);
	}
	
//	@Test
	public void setAddTest()throws Exception{
		
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setTitle("test5");
		noticeDTO.setContents("test5");
		noticeDTO.setWriter("test5");
		int result = noticeDAO.setAdd(noticeDTO);
		assertEquals(1, result);
	}

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
