package com.iu.start.bankMembers;

import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.start.bankAccount.BankAccountDAO;
import com.iu.start.bankAccount.BankAccountDTO;
import com.iu.start.util.FileManager;

@Service
public class BankMembersService {
	
	@Autowired
	private BankMembersDAO bankMembersDAO;
	
	@Autowired
	private FileManager fileManager;
	
//	@Autowired
//	private ServletContext servletContext;//어플리케이션 객체임
	
//	@Autowired
//	private BankAccountDAO bankAccountDAO;
	
	//로그인
	public BankMembersDTO getlogin(BankMembersDTO bankMembersDTO)throws Exception{
		return bankMembersDAO.getlogin(bankMembersDTO);
	}
	
	
	
	//bankMembers 회원가입
	public int setJoin(BankMembersDTO bankMembersDTO, MultipartFile photo, ServletContext servletContext)throws Exception{
		int result =bankMembersDAO.setJoin(bankMembersDTO);
			   	
		String path = "resources/upload/member";
		
		 
		String fileName = fileManager.saveFile(path, servletContext, photo);
		if(!photo.isEmpty()) {
			
		//2.저장된 파일정보를 db에 저장하는 단계
			   	//저장된 파일명이 필요함 FileName,OriginFileName도 필요함
			   	BankMembersFileDTO bankMembersFileDTO = new BankMembersFileDTO();
			   	bankMembersFileDTO.setFileName(fileName);//저장된 파일명
			   	bankMembersFileDTO.setOriName(photo.getOriginalFilename());//업로드시 파일 명
			   	bankMembersFileDTO.setUserName(bankMembersDTO.getUsername());
			   	bankMembersDAO.setAddFile(bankMembersFileDTO);
		}
			   	
			   return 0;
	};
	
	//검색어를 입력해서 ID를 찾기 abc 순으로
	public List<BankMembersDTO> getSearchByID(String search)throws Exception{
		return bankMembersDAO.getSearchByID(search);
	}
//==========================================================================================++1++
//	public Map<String, Object> getMyPage(BankMembersDTO bankMembersDTO) throws Exception {
//		// TODO Auto-generated method stub
//		Map<String, Object> map = new HashMap<String, Object>();
//		List<BankAccountDTO> ar = bankAccountDAO.getList(bankMembersDTO);
//		bankMembersDTO = bankMembersDAO.getMyPage(bankMembersDTO);
//		map.put("list", ar);
//		map.put("dto", bankMembersDTO);
//		return map;
//	};
//==========================================================================================++2++
	public BankMembersDTO getMyPage(BankMembersDTO bankMembersDTO) throws Exception{
		return bankMembersDAO.getMyPage(bankMembersDTO);
	}

















	

}
