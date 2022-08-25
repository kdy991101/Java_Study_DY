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
	//이전Blockㅣ의 유뮤를 판단-이전 블럭이 있으면 true 없으면  false 
	private boolean pre;
	//다음 Block의 유무-다름블럭이 읶으면 true 없으면 false
	private boolean next;
	//검색 컬럼의 종류
	private String kind;
	//검색어
	private String search;
	
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
		System.out.println("2totalPage" + totalPage);//20
		if(totalCount%this.getPerPage() != 0) {
			totalPage++;
			int result = (int) (totalCount%this.getPerPage());
			
			System.out.println(totalCount);//206,db데이터가 들어가있음
			System.out.println("2result"+result);//6
			System.out.println("2totalPage" + totalPage);//21
		}
		
		//2_1 totalPage보다 page가 더 클 경우
		System.out.println("perpage"+this.getPerPage());
		System.out.println("2_1totalpage" + totalPage);
		if(this.getPage()>totalPage) {
			this.setPage(totalPage);
			//마지막 페이지로가게 하는 것
		}
		
		//3.위에서 구한 totalPage21를 이용해서 totalBock구하기
		Long totalBlock = totalPage/this.getPerBlock();
		System.out.println("3perBlock"+this.getPerBlock());
		if(totalPage%this.getPerBlock() != 0) {
			totalBlock++;
			System.out.println("3perBlock"+totalBlock); 
		}
	
		//4.이 페이지가 몇번페이지에 속하는지,,curBlock찾기
		Long curBlock = this.getPage()/this.getPerBlock();
		if(this.getPage()%this.getPerBlock() != 0) {
			curBlock++;
		}
		
		//5.위애서 구한 curBlock으로 startNum,lastNum계산
		this.startNum = (curBlock-1)*this.getPerBlock()+1;
		System.out.println("startNum"+startNum);
		this.lastNum = curBlock*this.getPerBlock();
		
		//6.현재 블럭이 마지막 블럭일 때 (현재Block=totalBlock)
		if(curBlock == totalBlock) {
			this.lastNum=totalPage;
		}
		
		//7. 이전,다음 블럭의 유뮤
		if(curBlock>1) {
			pre = true;
		}
		
		if(curBlock<totalBlock) {
			next=true;
		}
	}
	
	
	//=============================
	public Long getPage() {
		if(this.page==null || this.page < 1) {
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
	//is로 시작하는 메서드는 true,false로 리턴된다 getter이지만 is로 되어있음
	public boolean isPre() {
		return pre;
	}
	public void setPre(boolean pre) {
		this.pre = pre;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getSearch() {
		if(this.search == null) {
			this.search="";
		}
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	
}
