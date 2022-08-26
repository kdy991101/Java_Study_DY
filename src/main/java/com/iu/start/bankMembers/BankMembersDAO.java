package com.iu.start.bankMembers;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BankMembersDAO implements MembersDAO{
	
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

	@Override
	public BankMembersDTO getMyPage(BankMembersDTO bankMembersDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+"getMyPage",bankMembersDTO);
	}


	@Override
	public int setAddFile(BankMembersFileDTO bankMembersFileDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(NAMESPACE+"setAddFile", bankMembersFileDTO);
	}


}
