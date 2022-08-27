package com.iu.start.bankMembers;

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

import com.iu.start.bankAccount.BankAccountDAO;
import com.iu.start.bankAccount.BankAccountDTO;

@Service
public class BankMembersService {
	
	@Autowired
	private BankMembersDAO bankMembersDAO;
	@Autowired
	private ServletContext servletContext;//어플리케이션 객체임
//	@Autowired
//	private BankAccountDAO bankAccountDAO;
	
	//로그인
	public BankMembersDTO getlogin(BankMembersDTO bankMembersDTO)throws Exception{
		return bankMembersDAO.getlogin(bankMembersDTO);
	}
	
	//bankMembers 회원가입
	public int setJoin(BankMembersDTO bankMembersDTO, MultipartFile photo)throws Exception{
		int result =bankMembersDAO.setJoin(bankMembersDTO);
		//1.hdd에 파일을 저장하는 단계
			  //파일 저장시 파일의 경로는 
			  //1)파일 저장 위치
			  //  webapp밑에있는 /resources/upload/member
			
			  //2)저장할 폴더의 실제경로 반환(os기준)	
			  String realPath = servletContext.getRealPath("resources/upload/member");//실제 경로
			  System.out.println("realpath : "+realPath);
			 
			  //3)저장할 폴더의 정보를 가지는 자바 객체를 만들어줘야함
			  File file = new File(realPath);
			  System.out.println("File : " + file.exists());
			  
			  //**파일 첨부가 없을 때 구분
//			  if(photo.getSize() != 0) {
//				  
//			  
			  //or
			  //isEmpty()-비어있니 비어있지않니
			  //!photo.isEmpty()-포토가 비어있지 않으면~
			  if(!photo.isEmpty()) {
				  
			
			   
			   //존재하지 않는다면~~~
			   //존재하지않으면 해당파일을 만들어주련ㄴ 작업
			  if(!file.exists()) {
				
				   file.mkdirs();//미리 디렉토리를 만들어도 상괍은 없음
			   }
			   //4)이제 카피해서 집어넣는 작업 단,중복되지 않는 파일명을 생성(시간,자바클래스(java api) 이용)
			  String fileName=UUID.randomUUID().toString();
			   System.out.println("file name : " + fileName);
			   
			   Calendar ca = Calendar.getInstance();
			   Long time = ca.getTimeInMillis();
			   System.out.println("time : " + time);
			  
			   fileName=fileName+"_"+photo.getOriginalFilename();
			   System.out.println("확장자 file name : " + fileName);
			   
			   //5)하드디스크에 파일을 저장하는 단계
			   
			   	//5.1사전준비--어느 폴더에 어떤 이름으로 저장할 파일객체를 만들어줘야 함
			   	file = new File(file, fileName);//(경로, 저장할 이름)
			   
			   	//5.2, 5.3둘중 하나사용
			   	//5.2 multipartFile 클래스의 transFerTo메서드 사용
			   	photo.transferTo(file);
			   	//5.3 FileCopyUtils 클래스의 copy메서드 사용 
			   	
		  
		//2.저장된 파일정보를 db에 저장하는 단계
			   	//저장된 파일명이 필요함 FileName,OriginFileName도 필요함
			   	BankMembersFileDTO bankMembersFileDTO = new BankMembersFileDTO();
			   	bankMembersFileDTO.setFileName(fileName);//저장된 파일명
			   	bankMembersFileDTO.setOriName(photo.getOriginalFilename());//업로드시 파일 명
			   	bankMembersFileDTO.setUserName(bankMembersDTO.getUsername());
			   	bankMembersDAO.setAddFile(bankMembersFileDTO);
			   	
			  }//isempty 끝
			  
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
