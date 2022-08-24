package com.iu.start.board.notice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.start.board.impl.BoardDAO;
import com.iu.start.board.impl.BoardDTO;
import com.iu.start.board.impl.BoardService;
import com.iu.start.util.Pager;

@Service
public class NoticeService implements BoardService {

	@Autowired
	private NoticeDAO noticeDAO;
	
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		// TODO Auto-generated method stub
			pager.getRowNum();
			Long totalCount=noticeDAO.getCount();
			pager.getNum(totalCount);
		
		
//		System.out.println("Service Page :"+page);
////		//페이지에 5.10.15,,,,개씩 보는 것을 기준
//		//page		startrow		lastrow
//		//1			1				15
//		//2			16				30
//		//3			31				45
//		//4			46				60,,,
//		Long perPage=10L;//한피이지에 출력할 목록의 갯수,perPage는 변수
//		
//		Long startRow=(page-1)*perPage+1;
//		Long lastRow=page*perPage;
//		
//		System.out.println("StartRow : "+startRow);
//		System.out.println("LastRow : "+lastRow);
////		map은 인터페이스타입임
//		Map<String, Long> map = new HashMap<String, Long>();
//		map.put("startRow", startRow);
//		map.put("lastRow", lastRow);
//		
//		//글의 갯수가 총 80개
//		//jsp에 페이지 번호를 출력 1~?;
//		//1.글의 총갯수
//		Long totalCount = noticeDAO.getCount();//total갯수를 가쟈옴
//		//2.글의 총 갯수를 이용해서 페이지 수 구하기
//		Long totalPage = totalCount/perPage;
//		
//		if(totalPage%perPage != 0) {
//			totalPage = totalPage+1;
//			//totalPage++;
//		}
//		System.out.println(totalPage);
//				
//		//3.page수를 하나의 단위로 묶어야 함 ex) 1-10,11-20,,,
//		//	perBlock:한 페이지에 출력할 번호의 수
//		//	전체의 블럭의 갯수를 구해야 함
//		//	Block : 
//		Long perBlock=5L;
//		
//		Long totalBlock = totalPage/perBlock;
//		if(totalPage%perBlock != 0 ) {
//			totalBlock++;
//		}
//		//4.Page로 현재 블럭번호 찾기
//		//1번블럭 1-5
//		//2번블럭6-10,,,
//		//page		curBlock
//		//1			1
//		//2			1
//		//3			1
//		//4			1
//		//5			1
//		//6			2
//		//,,,
//		//18		4
//		Long curBlock= page/perBlock;
//		if(page%perBlock != 0) {
//			curBlock++;
//		}
//		
//		//5.현재 블럭번호로 시작번호,끝번호 알아오기
//		//curBlock		startNum		lastNum
//		//1				1				5
//		//2			4	6				10
//		//3			8	11				15
////		Long startRow=(page-1)*perPage+1;
////		Long lastRow=page*perPage;
//		
//		Long startNum = (curBlock-1)*perBlock+1;
//		Long lastNum = curBlock*perBlock;
//		
//	
		return noticeDAO.getList(pager);
		
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
