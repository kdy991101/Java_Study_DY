package com.iu.start.board.qna;

import java.io.File;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.start.board.impl.BoardDTO;
import com.iu.start.board.impl.BoardFileDTO;
import com.iu.start.board.impl.BoardService;
import com.iu.start.util.Pager;

import oracle.net.aso.l;

@Service
public class QnaService implements BoardService{

	@Autowired
	private QnaDAO qnaDAO;
	@Autowired
	private ServletContext servletContext;
	
	public int setReply(QnaDTO qnaDTO)throws Exception{
		
		 BoardDTO boardDTO = qnaDAO.getDetail(qnaDTO);
		 QnaDTO parent = (QnaDTO)boardDTO;
		 
		 qnaDTO.setRef(parent.getRef());
		 qnaDTO.setStep(parent.getStep()+1);
		 qnaDTO.setDepth(parent.getDepth()+1);
		 
		 qnaDAO.setStepUpdate(parent);
		 int result= qnaDAO.setReplyAdd(qnaDTO);
		 return result;
		 
	}
	
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		Long totalCount=qnaDAO.getCount(pager);
		pager.getNum(totalCount);
		pager.getRowNum();
		
		return qnaDAO.getList(pager);
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.getDetail(boardDTO);
	}

	@Override
	public int setAdd(BoardDTO boardDTO, MultipartFile[] files, ServletContext servletContext) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("insert전 : "+boardDTO.getNum());
		int result = qnaDAO.setAdd(boardDTO);
		System.out.println("insert후 : "+boardDTO.getNum());
		
		String realPath = servletContext.getRealPath("resources/upload/qna");
		for(MultipartFile f : files) {
			
			if(f.isEmpty()) {
				continue;
			};
			File file = new File(realPath);
			if(!file.exists()) {
				file.mkdirs();
			}
			String fileName=UUID.randomUUID().toString();
			fileName = fileName+"_"+f.getOriginalFilename();
			file = new File(file, fileName);
			
			Calendar ca = Calendar.getInstance();
			Long time = ca.getTimeInMillis();
			
			f.transferTo(file);
			
			BoardFileDTO boardFileDTO = new BoardFileDTO();
		   	boardFileDTO.setFileName(fileName);
		   	boardFileDTO.setOriName(f.getOriginalFilename());
		   	boardFileDTO.setNum(boardDTO.getNum());
		   	qnaDAO.setAddFile(boardFileDTO);

		}
		return 0;
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.setUpdate(boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.setDelete(boardDTO);
	}
	
	
	
	
	
	
	
}
