package com.iu.start.board.qna;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.start.board.impl.BoardDTO;
import com.iu.start.board.notice.NoticeDTO;

import cou.iu.start.MyAbstractTest;

public class QnaDAOTest  extends MyAbstractTest{
	
	@Autowired
	private QnaDAO qnaDAO;
	
//	@Test
	public void setListTest()throws Exception{
		List<BoardDTO> ar = qnaDAO.getList();
		assertNotEquals(0, ar.size());
	}
	
//	@Test
	public void setDetailTest()throws Exception{
		QnaDTO qnaDTO = new QnaDTO();
		qnaDTO.setNum(1L);
		assertNotEquals(0, qnaDTO);
	}
//	@Test
	public void setAddTest()throws Exception{
		
		QnaDTO qnaDTO = new QnaDTO();
		qnaDTO.setTitle("test2");
		qnaDTO.setContents("test2");
		qnaDTO.setWriter("test2");
		int result = qnaDAO.setAdd(qnaDTO);
		assertEquals(1, result);
	}
	
//	@Test
	public void setUpdateTest()throws Exception{
		QnaDTO qnaDTO = new QnaDTO();
		qnaDTO.setNum(1L);
		qnaDTO.setTitle("집가자");
		qnaDTO.setContents("9시에 간다");
		int result = qnaDAO.setUpdate(qnaDTO);
		assertEquals(1, result);
	}
	
//	@Test
	public void setDeleteTest()throws Exception{
		QnaDTO qnaDTO = new QnaDTO();
		qnaDTO.setNum(201L);
		
		int result = qnaDAO.setDelete(qnaDTO);
		assertEquals(1, result);
	}
}
