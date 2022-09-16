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
import com.iu.start.util.FileManager;
import com.iu.start.util.Pager;

@Service
public class NoticeService implements BoardService {

	@Autowired
	private NoticeDAO noticeDAO;

//	@Autowired
//	private ServletContext servletContext;

	@Autowired
	private FileManager fileManager;

	@Override
	public int setFileDelete(BoardFileDTO boardFileDTO, ServletContext servletContext) throws Exception {
		// TODO Auto-generated method stub
		boardFileDTO = noticeDAO.getFileDetail(boardFileDTO);// 삭제하기 전에 꺼내와야 함
		int result = noticeDAO.setFileDelete(boardFileDTO);
		String path = "resources/upload/notice";
		if (result > 0) {
			fileManager.deleteFile(servletContext, path, boardFileDTO);

		}
		return result;
	}

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		Long totalCount = noticeDAO.getCount(pager);
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
	public int setAdd(BoardDTO boardDTO, MultipartFile[] files, ServletContext servletContext) throws Exception {
		// TODO Auto-generated method stub
		int result = noticeDAO.setAdd(boardDTO);

		String path = "resources/upload/notice";

		for (MultipartFile multipartFile : files) {
			if (multipartFile.isEmpty()) {
				continue;
			}
			String fileName = fileManager.saveFile(path, servletContext, multipartFile);
			BoardFileDTO boardFileDTO = new BoardFileDTO();
			boardFileDTO.setFileName(fileName);
			boardFileDTO.setOriName(multipartFile.getOriginalFilename());
			boardFileDTO.setNum(boardDTO.getNum());
			noticeDAO.setAddFile(boardFileDTO);

		}

//
//		// 저장할 폴더의 실제경로를 반환
//		// realpath=>실제 경로
//		String realPath = servletContext.getRealPath("resources/upload/notice");// v
//		System.out.println("realpath : " + realPath);// v
//
//		// 저장할 폴더의 정보를 가지는 자바 객체를 만들어줘야 함
//
//		File file = new File(realPath);// v
//		System.out.println("File : " + file.exists());
//		
//		if (!file.exists()) {// /resources/upload/notice/a.jpg
//			file.mkdirs();
//		}
//		
//		for (MultipartFile f : files) {
//			//
//
//			if (f.isEmpty()) {
//				continue;
//			}
//			// 저장하는 코드
//			// 중복되지 않는 이름이어야 함 시간 또는 클래스
//			// 카피해서 넣는작업 중복되지 않는 파일명을 저장하기 위해 calender를 이용한 것
//			// 저장하려면 파일 객체를 만들어야 함 이번에 변수에 NEW를 이용해 파일 객체를 만듬
//			String fileName = UUID.randomUUID().toString();// UUID라는 클래스
//
//			System.out.println("file name : " + fileName);
//			fileName = fileName + "_" + f.getOriginalFilename();
//			System.out.println("확장자 file name : " + fileName);
//			file = new File(file, fileName);//폴더, 파일명
//
////			Calendar ca = Calendar.getInstance();
////			Long time = ca.getTimeInMillis();
////			System.out.println("time : " + time);
//
//			f.transferTo(file);//하드디스크에 저장 

		// f.transferTo(new File(file, fileName));가능
//			BoardFileDTO boardFileDTO = new BoardFileDTO();
//			boardFileDTO.setFileName(fileName);//저장된 파일명
//			boardFileDTO.setOriName(f.getOriginalFilename());//올릴 때의 실제 이름
//			boardFileDTO.setNum(boardDTO.getNum());//setNum-어느글에 대한 첨부파일이다라는걸 연결하기위해 얘가 참조한 글의 번호가 필요하기 때문에 
//			noticeDAO.setAddFile(boardFileDTO);

		return result;
	}

	@Override
	public int setUpdate(BoardDTO boardDTO, MultipartFile[] files, ServletContext servletContext) throws Exception {
		// TODO Auto-generated method stub
		String path = "resources/upload/notice";
		int result =  noticeDAO.setUpdate(boardDTO);
		
		if(result<1) {
			return result;
		}
		
		for (MultipartFile multipartFile : files) {
			if (multipartFile.isEmpty()) {
				continue;
			}
			String fileName = fileManager.saveFile(path, servletContext, multipartFile);
			BoardFileDTO boardFileDTO = new BoardFileDTO();
			boardFileDTO.setFileName(fileName);
			boardFileDTO.setOriName(multipartFile.getOriginalFilename());
			boardFileDTO.setNum(boardDTO.getNum());
			noticeDAO.setAddFile(boardFileDTO);
		}
		return result;
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.setDelete(boardDTO);
	}

}
