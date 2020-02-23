package com.yunheur.board.common;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
@Slf4j
public class ExceptionHandler {

	// 실제 프로젝트에서는 기본 예외 및 프로젝트에 필요한 커스텀 예외를 포함해서 각각의 예외에 맞는 적절한 예외처리가 필요합니다.
	// 절대로 Exception 클래스를 이용해서 한번에 모든 예외를 처리하지 않도록 합니다.
	@org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
	public ModelAndView defaultExceptionHandler(HttpServletRequest request, Exception exception){
		ModelAndView mv = new ModelAndView("/error/error_default");
		mv.addObject("exception", exception);

		log.error("defaultExceptionHandler", exception);

		return mv;
	}
}
