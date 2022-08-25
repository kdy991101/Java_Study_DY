package com.iu.start.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.start.board.impl.BoardDTO;
import com.iu.start.util.Pager;

@Controller
@RequestMapping("/qna/*")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	@ModelAttribute("board")
	public String getBoard() {
		return "Qna";
	}
	
	@GetMapping("reply.iu")
	public ModelAndView setReply(BoardDTO boardDTO,ModelAndView mv)throws Exception{
		
		mv.addObject("boardDTO", boardDTO);
		mv.setViewName("board/reply");
		return mv;
	}
	
	@PostMapping("reply.iu")
	public String setReply(QnaDTO qnaDTO)throws Exception{
		int result = qnaService.setReply(qnaDTO);
		return "redirect:./list.iu";
	}
	
	@RequestMapping(value = "list.iu", method = RequestMethod.GET)
	public ModelAndView getList(Pager pager)throws Exception{
		ModelAndView mv = new ModelAndView();
		System.out.println("getlist실행");
		List<BoardDTO> ar = qnaService.getList(pager);
		
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.setViewName("board/list");
		return mv;
	}
	
	@RequestMapping(value = "detail.iu", method = RequestMethod.GET)
	public String getDetail(BoardDTO boardDTO, Model model)throws Exception{
		System.out.println("getdetail실행");
		
		boardDTO = qnaService.getDetail(boardDTO);
		model.addAttribute("boardDTO", boardDTO);
		return "board/detail";
	}
	
	@RequestMapping(value = "add.iu", method = RequestMethod.GET)
	public String setAdd(Model model)throws Exception{
		System.out.println("getadd실행");

		return "board/add";
	}
	@RequestMapping(value = "add.iu", method = RequestMethod.POST)
	public ModelAndView setAdd(BoardDTO boardDTO)throws Exception{
		System.out.println("postadd실행");
		ModelAndView mv = new ModelAndView();
		
		int result = qnaService.setAdd(boardDTO);
		mv.setViewName("redirect:./list.iu");
		return mv;
	}
	
	@RequestMapping(value = "update.iu", method = RequestMethod.GET)
	public ModelAndView setUpdate(BoardDTO boardDTO, ModelAndView mv)throws Exception{
		System.out.println("getupdate실행");
		
		boardDTO = qnaService.getDetail(boardDTO);
		mv.addObject("boardDTO", boardDTO);
		mv.setViewName("board/update");
		return mv;
	}
	@RequestMapping(value = "update.iu", method = RequestMethod.POST)
	public String setUpdate(BoardDTO boardDTO)throws Exception{
		System.out.println("postupdate실행");
		
		int result = qnaService.setUpdate(boardDTO);
		return "redirect:./detail.iu?num="+boardDTO.getNum();
	}
	
	
	//글 삭제
		@RequestMapping(value = "delete.iu")
		public ModelAndView setDelete(BoardDTO boardDTO)throws Exception{
			System.out.println("delete실행");
			int result=qnaService.setDelete(boardDTO);
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

























