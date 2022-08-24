package com.iu.start.board.notice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.start.board.impl.BoardDAO;
import com.iu.start.board.impl.BoardDTO;
import com.iu.start.board.impl.BoardService;

@Service
public class NoticeService implements BoardService {

	@Autowired
	private NoticeDAO noticeDAO;
	
	@Override
	public List<BoardDTO> getList(Long page) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("Service Page :"+page);
//		//페이지에 5.10.15,,,,개씩 보는 것을 기준
		//page		startrow		lastrow
		//1			1				15
		//2			16				30
		//3			31				45
		//4			46				60,,,
		Long perPage=10L;//한피이지에 출력할 목록의 갯수,perPage는 변수
		
		Long startRow=(page-1)*perPage+1;
		Long lastRow=page*perPage;
		
		System.out.println("StartRow : "+startRow);
		System.out.println("LastRow : "+lastRow);
//		map은 인터페이스타입임
		Map<String, Long> map = new HashMap<String, Long>();
		map.put("startRow", startRow);
		map.put("lastRow", lastRow);
		
		//글의 갯수가 총 80개
		//1.10개
		//2.그 다음 10개
		//*
		//*
		//*
		//*
		
	
		return noticeDAO.getList(map);
		
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.getDetail(boardDTO);
	}

	@Override
	public int setAdd(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.setAdd(boardDTO);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.setUpdate(boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.setDelete(boardDTO);
	}
	

}
