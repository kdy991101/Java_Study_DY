//package com.iu.start.util;
//
//public class CommentPager {
//	//멤버변수 선언, Mapper에서 사용
//	private Long startRow;//시작번호
//	private Long lastRow;//끝 번호
//	private Long bookNum;
//	
//	
//	//startRow, lastRow 계산이 필요함
//	//startRow 처음에는 1 다음은 11 다음은 22 다음은 33~~~
//	//페이지 번호가 필요함,  멤버변수로 받아줘야ㅕ함
//	private Long page;
//	//페이지가 1이 들어오면 1 2가 들어오면 11 3이 들어오면 22
//	private Long perPage;//몇개씩 보여줄 것인지 담는 숫자
//	
//	
//	
//	// 메서드를 생성
//	public Long getPage() {
//		if (this.page == null || this.page < 1) {
//			this.page = 1L;// Long타입이기 때문에 L을 넣어줘야 함
//		}
//		return page;
//	}
//
//	public void setPage(Long page) {
//		this.page = page;
//	}
//
//	public Long getPerPage() {
//		if (this.perPage == null || this.perPage < 1) {
//			this.perPage = 5L;
//		}
//		return perPage;
//	}
//
//	public void setPerPage(Long perPage) {
//		this.perPage = perPage;
//	}
//
//	public void getRowNum() {
//		startRow = (this.getPage()-1)*this.getPerPage()+1;;
//		lastRow = this.getPage()*this.getPerPage();
//		//page가 널이 올 수 있음
//	}
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	public Long getStartRow() {
//		return startRow;
//	}
//	public void setStartRow(Long startRow) {
//		this.startRow = startRow;
//	}
//	public Long getLastRow() {
//		return lastRow;
//	}
//	public void setLastRow(Long lastRow) {
//		this.lastRow = lastRow;
//	}
//	public Long getBookNum() {
//		return bookNum;
//	}
//	public void setBookNum(Long bookNum) {
//		this.bookNum = bookNum;
//	}
//	
//
//}


package com.iu.start.util;

public class CommentPager {
   
   //Mapper에서 사용
   private Long startRow;
   private Long lastRow;
   private Long bookNum;
   
   private Long page;
   private Long perPage;
   
   //startRow
   public void getRowNum()throws Exception{
      this.startRow = (this.getPage()-1)*this.getPerPage()+1;
      this.lastRow = this.getPage()*this.getPerPage();      
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
   public Long getBookNum() {
      return bookNum;
   }
   public void setBookNum(Long bookNum) {
      this.bookNum = bookNum;
   }


   public Long getPage() {
      if(this.page==null || this.page <1) {
         this.page=1L;
      }
      return page;
   }


   public void setPage(Long page) {
      this.page = page;
   }

   //생성자에 넣어줘도 되고 GETTER를 이용해서 기본값 넣어주기
   public Long getPerPage() {
      if(this.perPage==null || this.perPage<1) {
         this.perPage= 5L;
      }
      return perPage;
   }


   public void setPerPage(Long perPage) {
      this.perPage = perPage;
   }

}
