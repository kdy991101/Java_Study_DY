package com.iu.start.board.impl;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.iu.start.util.Pager;

public interface BoardService {
	
	//글 목록
	public List<BoardDTO> getList(Pager pager)throws Exception;
	
	//글 조회
	public BoardDTO getDetail(BoardDTO boardDTO)throws Exception;
	
	//글 수정
	public int setUpdate(BoardDTO boardDTO)throws Exception;
	
	//글 삭제
	public int setDelete(BoardDTO boardDTO)throws Exception;
	//글 작성
	public int setAdd(BoardDTO boardDTO, MultipartFile[] files) throws Exception;
	

}
