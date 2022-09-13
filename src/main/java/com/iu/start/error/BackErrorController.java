package com.iu.start.error;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

//@ControllerAdvice => 예외처리를 전문적으로 하는 Controller
@ControllerAdvice
public class BackErrorController {
	//exceptionHandler만 모아줌
	//url을 처리하는 controller가 아닌 에러를 처리하는 controller임
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
