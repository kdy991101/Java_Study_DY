package com.iu.start.bankBook;

import java.util.List;

public interface BookDAO {
	
	public int setBankbook(BankBookDTO bankBookDTO) throws Exception;
	
	//bankbook에 있는 모든 데이터를 조회 최신순으로
	public List<BankBookDTO> getList() throws Exception;
	
	//sale컬럼 수정
	public int setChangeSale(BankBookDTO bankBookDTO)throws Exception;
	
	//booknum의 값으로 조회
	public BankBookDTO getDetail(BankBookDTO bankBookDTO)throws Exception;
	
	public int setUpdate(BankBookDTO bankBookDTO)throws Exception;
	
	public int setDelete(BankBookDTO bankBookDTO) throws Exception;

}
