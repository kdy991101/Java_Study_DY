package com.iu.start.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.start.board.impl.BoardDTO;

@Controller
@RequestMapping("/qna/*")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	@RequestMapping(value = "list.iu", method = RequestMethod.GET)
	public ModelAndView getList()throws Exception{
		System.out.println("getlist실행");
		ModelAndView mv = new ModelAndView();
		List<BoardDTO> ar = qnaService.getList();
		
		mv.addObject("list", ar);
		mv.setViewName("qna/list");
		return mv;
	}
	
	@RequestMapping(value = "detail.iu", method = RequestMethod.GET)
	public String getDetail(BoardDTO boardDTO, Model model)throws Exception{
		System.out.println("getdetail실행");
		
		boardDTO = qnaService.getDetail(boardDTO);
		model.addAttribute("boardDTO", boardDTO);
		return "qna/detail";
	}
	
	@RequestMapping(value = "add.iu", method = RequestMethod.GET)
	public String setAdd()throws Exception{
		System.out.println("getadd실행");
		
		return "qna/add";
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
		mv.setViewName("qna/update");
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

























