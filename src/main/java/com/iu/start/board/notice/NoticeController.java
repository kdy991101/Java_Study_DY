package com.iu.start.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.iu.start.board.impl.BoardDAO;
import com.iu.start.board.impl.BoardDTO;
import com.iu.start.board.impl.BoardService;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {
	
	@Autowired//주입
	private NoticeService noticeService;
	
	@ModelAttribute("board")
	public String getBoard() {
		return "공지사항";
	}
	//컨트롤러의 메서드의 리턴은 결론적으로 mv로 됨
	
	//글 목록
	@RequestMapping(value = "list.iu", method=RequestMethod.GET)
	public ModelAndView getList(@RequestParam(defaultValue = "1") Long page)throws Exception{
		System.out.println("getList실행");
		System.out.println("Page :"+page);
		ModelAndView mv = new ModelAndView();
		List<BoardDTO> ar = noticeService.getList(page);
		//실제로 리턴되는건 boardDTO가 아닌 noticeDTO가 담긴다,,
		
		mv.addObject("list", ar);
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
	public String setAdd(Model model)throws Exception{
		System.out.println("getAdd실행");
		
		return "board/add";
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
		mv.setViewName("board/update");
		return mv;
	}
	@RequestMapping(value = "update.iu", method = RequestMethod.POST)
	public String setUpdate(BoardDTO boardDTO)throws Exception{
		System.out.println("postUpdate실행");
		
		int result = noticeService.setUpdate(boardDTO);
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
	
}










































