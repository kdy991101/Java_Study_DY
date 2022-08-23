package com.iu.start.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.start.board.impl.BoardDAO;
import com.iu.start.board.impl.BoardDTO;
import com.iu.start.board.impl.BoardService;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {
	
	@Autowired//주입
	private NoticeService noticeService;
	//컨트롤러의 메서드의 리턴은 결론적으로 mv로 됨
	
	//글 목록
	@RequestMapping(value = "list.iu", method=RequestMethod.GET)
	public ModelAndView getList()throws Exception{
		System.out.println("getList실행");
		ModelAndView mv = new ModelAndView();
		List<BoardDTO> ar = noticeService.getList();
		
		mv.addObject("list", ar);
		mv.setViewName("notice/list");
		return mv;
	}
	
	//글 상세
	@RequestMapping(value = "datail.iu", method = RequestMethod.GET)
	public String getDatail(BoardDTO boardDTO, Model model)throws Exception{
		System.out.println("getDatail실행");
		
		model.addAttribute("boardDTO", boardDTO);
		boardDTO = noticeService.getDetail(boardDTO);
		return "notice/datail";
	}
	
	//글 작성
	@RequestMapping(value = "add.iu", method = RequestMethod.GET)
	public String setAdd()throws Exception{
		System.out.println("getAdd실행");
		
		return "notice/add";
	}
	@RequestMapping(value = "add.iu", method = RequestMethod.POST)
	public ModelAndView setAdd(BoardDTO boardDTO)throws Exception{
		System.out.println("postAdd실행");
		ModelAndView mv = new ModelAndView();
		
		int result = noticeService.setAdd(boardDTO);
		mv.setViewName("redirect:./list.iu");
		return mv;
	}
	
	//글 수정
	@RequestMapping(value = "update.iu", method = RequestMethod.GET)
	public ModelAndView setUpdate(BoardDTO boardDTO, ModelAndView mv)throws Exception{
		System.out.println("getUpdate실행");
		
		boardDTO = noticeService.getDetail(boardDTO);
		mv.addObject("boardDTO", boardDTO);
		mv.setViewName("notice/update");
		return mv;
	}
	@RequestMapping(value = "update.iu", method = RequestMethod.POST)
	public String setUpdate(BoardDTO boardDTO)throws Exception{
		System.out.println("postUpdate실행");
		
		int result = noticeService.setUpdate(boardDTO);
		return "redirect:./detail.iu?num="+boardDTO.getNum();//파라미터를 넣어서 보내줘야 함
	}
	
	//글 삭제
	public String setDelete(BoardDTO boardDTO)throws Exception{
		System.out.println("delete실행");

		int result=noticeService.setDelete(boardDTO);
		return "redirect:./list.iu";
	}
	
}










































