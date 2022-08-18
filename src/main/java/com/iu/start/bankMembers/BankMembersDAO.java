package com.iu.start.bankMembers;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BankMembersDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.iu.start.bankMembers.BankMembersDAO."; 
	
	public BankMembersDTO getlogin(BankMembersDTO bankMembersDTO)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getlogin",bankMembersDTO);
	}
	
	
	public int setJoin(BankMembersDTO bankMembersDTO) throws Exception {
		
		return sqlSession.insert(NAMESPACE+"setJoin", bankMembersDTO);
	}
		
	public List<BankMembersDTO> getSearchByID(String search) throws Exception {

		return sqlSession.selectList(NAMESPACE+"getSearchByID",search);
	}

}
