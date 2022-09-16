package com.iu.start.file;

import com.iu.start.bankMembers.BankMembersFileDTO;

public class FileDTO {
	private Long fileNum;
	private String fileName;//하드디스크에 저장된 이름
	private String oriName;//시용자가 올릴떄의 내용
	
	//username이 빠졌지만 memberfileDTO를 만들어서 상속받는다
	
	public String getFileName() {
		return fileName;
	}
	public Long getFileNum() {
		return fileNum;
	}
	public void setFileNum(Long fileNum) {
		this.fileNum = fileNum;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getOriName() {
		return oriName;
	}
	public void setOriName(String oriName) {
		this.oriName = oriName;
	}
	

}
