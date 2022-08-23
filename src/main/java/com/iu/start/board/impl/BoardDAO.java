package com.iu.start.board.impl;

import java.util.List;

public interface BoardDAO {
	//인터페이스는 접근지정자 무조건public 생략 가능
	
	//글 목록
	public List<BoardDTO> getList()throws Exception;
	
	//글 상세
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception;
	
	//글 작성
	public int setAdd(BoardDTO boardDTO)throws Exception;
	
	//글 수정
	public int setUpdate(BoardDTO boardDTO)throws Exception;
	
	//글 삭제
	public int setDelete(BoardDTO boardDTO)throws Exception;
	
}