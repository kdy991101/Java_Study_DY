package com.iu.start.board.notice;

import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.start.board.impl.BoardDAO;
import com.iu.start.board.impl.BoardDTO;
import com.iu.start.board.impl.BoardFileDTO;
import com.iu.start.board.impl.BoardService;
import com.iu.start.util.Pager;

@Service
public class NoticeService implements BoardService {

	@Autowired
	private NoticeDAO noticeDAO;
	@Autowired
	private ServletContext servletContext;
	
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		// TODO Auto-generated method stub
			Long totalCount=noticeDAO.getCount(pager);
			pager.getNum(totalCount);
			pager.getRowNum();
		
		return noticeDAO.getList(pager);	
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.getDetail(boardDTO);
	}

	@Override
	public int setAdd(BoardDTO boardDTO, MultipartFile[] files) throws Exception {
		// TODO Auto-generated method stub
		int result = noticeDAO.setAdd(boardDTO);
		
		//저장할 폴더의 실제경로를 반환
		//realpath=>실제 경로
		  String realPath = servletContext.getRealPath("resources/upload/notice");//v
		  System.out.println("realpath : "+realPath);//v
		  
		  //저장할 폴더의 정보를 가지는 자바 객체를 만들어줘야 함
		  
		 
		 for(MultipartFile f : files) {
		  
			 if(f.isEmpty()) {
				 continue;
			 }
			 File file = new File(realPath);//v
			 System.out.println("File : " + file.exists());		 
			 if(!file.exists()) {		
				 file.mkdirs();
			 }
		 //카피해서 넣는작업 중복되지 않는 파일명을 저장하기 위해 calender를 이용한 것
		   String fileName=UUID.randomUUID().toString();
		   System.out.println("file name : " + fileName);
		   fileName=fileName+"_"+f.getOriginalFilename();
		   System.out.println("확장자 file name : " + fileName);
		   file = new File(file, fileName);
		   
		   Calendar ca = Calendar.getInstance();
		   Long time = ca.getTimeInMillis();
		   System.out.println("time : " + time);
   
		   	f.transferTo(file);
		   			   	
		   	//f.transferTo(new File(file, fileName));가능
		   	BoardFileDTO boardFileDTO = new BoardFileDTO();
		   	boardFileDTO.setFileName(fileName);
		   	boardFileDTO.setOriName(f.getOriginalFilename());
		   	boardFileDTO.setNum(boardDTO.getNum());
		   	noticeDAO.setAddFile(boardFileDTO);
		
		 }
		return 0;
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
