package com.iu.start.bankBook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class BankBookDAO implements BookDAO{
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.iu.start.bankBook.BankBookDAO.";

	public int setBankbook(BankBookDTO bankBookDTO) throws Exception {
		Calendar ca = Calendar.getInstance();
		bankBookDTO.setBookNum(ca.getTimeInMillis());
		return sqlSession.insert(NAMESPACE+"setBankbook", bankBookDTO);
	}

	public List<BankBookDTO> getList() throws Exception {
		return sqlSession.selectList(NAMESPACE+"getList");
	}

	public int setChangeSale(BankBookDTO bankBookDTO) throws Exception {		
		 return sqlSession.update(NAMESPACE+"setChangeSale", bankBookDTO);
	}

	public BankBookDTO getDetail(BankBookDTO bankBookDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getDetail", bankBookDTO);
	}
	
	public int setUpdate(BankBookDTO bankBookDTO) throws Exception {
		 return sqlSession.update(NAMESPACE+"setUpdate", bankBookDTO);
	}

	public int setDelete(BankBookDTO bankBookDTO) throws Exception {
		 return sqlSession.delete(NAMESPACE+"setDelete", bankBookDTO);
		
	}	

}
	

