package com.iu.start.bankAccount;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;

@Repository
public class BankAccountDAO implements AccountDAO {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.iu.start.bankAccount.BankAccountDAO.";

	public int add(BankAccountDTO bankAccountDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(NAMESPACE+"add", bankAccountDTO);	
	}

	@Override
	public  List<BankAccountDTO> getList() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE+"getList");
	}

	@Override
	public int add() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
}
