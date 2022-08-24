package com.iu.start.util;

public class Pager {
	
	//멤버변수 선언
	//파라미터를 담을 변수
	//jsp에서 꺼내서 사용할 변수 시작,끝번호
	//mepper에서 꺼내서 사용할 변수 스타트로우 라스트 로우
	//perPage : 한 페이지의 출력할 글의 갯수
	//perBlock : 한 페이지의 출력할 번호릐 갯수
	
	private Long page;
	private Long startNum;
	private Long lastNum;
	private Long startRow;
	private Long lastRow;
	private Long perPage;
	private Long perBlock;
	
	public Pager() {
		this.perPage=10L;
		this.perBlock=5L;
	}
	
	
		//페이징 처리하는 기능
		//1.mapper에서 사용할 값 계산 start,lastRow
		public void getRowNum()throws Exception{
		this.startRow = (this.getPage()-1)*this.getPerPage()+1;
		this.lastRow=(this.getPage()*this.getPerPage());
	}
	
		//2.jap로 보낼 시작.끝 번호
		public void getNum(Long totalCount)throws Exception{
		//2.totalCount로 totalPage구하기
		Long totalPage = totalCount/this.getPerPage();
		if(totalPage%this.getPerPage() != 0) {
			totalPage++;
		}
		
		//3.위에서 구한 totalPage를 이용해서 totalBock구하기
		Long totalBlock = totalPage/this.getPerBlock();
		if(totalPage%this.getPerBlock() != 0) {
			totalBlock++;
		}
	
		//4.이 페이지가 몇번페이지에 속하는지,,curBlock찾기
		Long curBlock = this.getPage()/this.getPerBlock();
		if(this.getPage()%this.getPerBlock() != 0) {
			curBlock++;
		}
		
		//5.위애서 구한 curBlock으로 startNum,lastNum계산
		this.startNum = (curBlock-1)*this.getPerBlock()+1;
		this.lastNum = curBlock*this.getPerBlock();
	}
	
	
	//=============================
	public Long getPage() {
		if(this.page==null) {
			this.page=1L;
		}
		return page;
	}
	public void setPage(Long page) {
		this.page = page;
	}
	public Long getStartNum() {
		return startNum;
	}
	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}
	public Long getLastNum() {
		return lastNum;
	}
	public void setLastNum(Long lastNum) {
		this.lastNum = lastNum;
	}
	public Long getStartRow() {
		return startRow;
	}
	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}
	public Long getLastRow() {
		return lastRow;
	}
	public void setLastRow(Long lastRow) {
		this.lastRow = lastRow;
	}

	public Long getPerPage() {
		if(this.perPage==null) {
			this.perPage=10L;
		}
		return perPage;
	}

	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}

	public Long getPerBlock() {
		return perBlock;
	}

	public void setPerBlock(Long perBlock) {
		this.perBlock = perBlock;
	}
	

	
}
