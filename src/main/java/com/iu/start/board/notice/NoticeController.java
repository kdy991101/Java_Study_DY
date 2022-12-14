package com.iu.start.board.notice;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.start.bankMembers.BankMembersDTO;
import com.iu.start.board.impl.BoardDAO;
import com.iu.start.board.impl.BoardDTO;
import com.iu.start.board.impl.BoardFileDTO;
import com.iu.start.board.impl.BoardService;
import com.iu.start.util.Pager;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {
	
	@Autowired//주입
	private NoticeService noticeService;
	
	@ModelAttribute("board")
	public String getBoard() {
		return "notice";
	}
	//컨트롤러의 메서드의 리턴은 결론적으로 mv로 됨
	
	@PostMapping(value = "fileDelete")
	@ResponseBody
	public int setFileDelete(BoardFileDTO boardFileDTO, HttpSession session)throws Exception{
		int result = noticeService.setFileDelete(boardFileDTO, session.getServletContext());
		return result;
	}
	
	//글 목록
	@RequestMapping(value = "list.iu", method=RequestMethod.GET)
	public ModelAndView getList(Pager pager)throws Exception{
//		실제로 리턴되는건 boardDTO가 아닌 noticeDTO가 담긴다,,
		ModelAndView mv = new ModelAndView();
		List<BoardDTO> ar = noticeService.getList(pager);
		
		System.out.println(pager.getPage());
		System.out.println("getList실행");
		System.out.println("pager.getKind(): " + pager.getKind());
		System.out.println(pager.getSearch());

		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.setViewName("board/list");
		
		return mv;
	}
	
	//글 상세
	@RequestMapping(value = "detail.iu", method = RequestMethod.GET)
	public String getDatail(BoardDTO boardDTO, Model model)throws Exception{
		System.out.println("getDetail실행");
		
		boardDTO = noticeService.getDetail(boardDTO);
		model.addAttribute("boardDTO", boardDTO);
		return "board/detail";
	}
	
	//글 작성
	@RequestMapping(value = "add.iu", method = RequestMethod.GET)
	public String setAdd(HttpSession session)throws Exception{
		System.out.println("getAdd실행");
		BankMembersDTO bankMembersDTO = (BankMembersDTO)session.getAttribute("member");
		if(bankMembersDTO != null) {
			
			return "board/add";
		}else {
			return "redirect:../member/login.iu";
		}
		
	}
	@RequestMapping(value = "add.iu", method = RequestMethod.POST)
	public ModelAndView setAdd(BoardDTO boardDTO, MultipartFile[] files, HttpSession session)throws Exception{
		System.out.println("postAdd실행");
		ModelAndView mv = new ModelAndView();
		int result = noticeService.setAdd(boardDTO, files, session.getServletContext());
		
		String message = "글 등록 실패";
		if(result > 0) {
			message = "글 등록 성공";
	}
	
		mv.addObject("message", message);
		mv.addObject("result", result);
		mv.addObject("url", "list.iu");
		mv.setViewName("common/result");
		
		return mv;
	}
	
	//글 수정
	@RequestMapping(value = "update.iu", method = RequestMethod.GET)
	public ModelAndView setUpdate(BoardDTO boardDTO, ModelAndView mv)throws Exception{
		System.out.println("getUpdate실행");
		
		boardDTO = noticeService.getDetail(boardDTO);
		mv.addObject("boardDTO", boardDTO);
		mv.setViewName("board/update");
		return mv;
	}
	@RequestMapping(value = "update.iu", method = RequestMethod.POST)
	public String setUpdate(BoardDTO boardDTO, MultipartFile [] files, HttpSession session)throws Exception{
		System.out.println("postUpdate실행");
		
		int result = noticeService.setUpdate(boardDTO, files, session.getServletContext());
		return "redirect:./detail.iu?num="+boardDTO.getNum();//파라미터를 넣어서 보내줘야 함
	}
	
	//글 삭제
	@RequestMapping(value = "delete.iu")
	public ModelAndView setDelete(BoardDTO boardDTO)throws Exception{
		System.out.println("delete실행");
		int result=noticeService.setDelete(boardDTO);
		ModelAndView mv = new ModelAndView();
		
		if(result == 1) {
			System.out.println("성공");
		} else {
			System.out.println("실패");
			
		}
		mv.setViewName("redirect:./list.iu");
		return mv;
	}
	
	//exception을 조종하겠다~
	//null exception을 잡고싶으면=>@ExceptionHandler(NullPointerException.class) 
	@ExceptionHandler(NullPointerException.class)
	public ModelAndView exceptionTest() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("errors/error_404");
		return mv;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView exceptionTest2(Exception e) {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("errors/error_404");
		return mv;
	}
	
}










































