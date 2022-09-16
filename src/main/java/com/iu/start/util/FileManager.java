package com.iu.start.util;

import java.io.File;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.iu.start.file.FileDTO;

@Component
public class FileManager {
	
//	@Autowired
//	private ServletContext servletContext;
	//어너케이션 1
	//xml파일에 빈,,,,,..... 
	
	//servletcontext 어너케이션, 매개변수 둘중 하나를 이용
	
	public boolean deleteFile(ServletContext servletContext, String path, FileDTO fileDTO)throws Exception{
		//경로,파일 필요
		String realPath = servletContext.getRealPath(path);
		System.out.println(realPath);
		
		File file = new File(realPath, fileDTO.getFileName());
		
		
		return file.delete();
	}
	
	
	
	//save
	public String saveFile(String path, ServletContext servletContext, MultipartFile multipartFile)throws Exception{
	//하드디스크에 파일을 저장하는 코드를 여기에 저장
		//1.실제 경로
		String realPath = servletContext.getRealPath(path);
		System.out.println(realPath);
		
		//2.폴더(디렉토리-directory) 유무 체크
		File file = new File(realPath); 
		if(!file.exists()) {
			file.mkdirs();
		}
		
		//3.저장할 파일명을 생성
		String fileName = UUID.randomUUID().toString();
		fileName = fileName+"_"+multipartFile.getOriginalFilename();
		
		//4.하드디스크에 저장
		file = new File(file, fileName);
		multipartFile.transferTo(file);
		
		return fileName;
		

	}

}
