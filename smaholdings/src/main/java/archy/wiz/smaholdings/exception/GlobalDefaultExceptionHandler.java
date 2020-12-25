package archy.wiz.smaholdings.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFoundException() {
		ModelAndView model = new ModelAndView("error");
		model.addObject("ErrorTitle","Opps Page not Found!!");
		model.addObject("errorDescription","Check your Url and try again");
		model.addObject("title","404 Error");
		model.addObject("link","otherwise");
		return model;
	}
	
	@ExceptionHandler(ProjectNotFoundException.class)
	public ModelAndView handlerProjectNotFoundException() {
		ModelAndView model = new ModelAndView("error");
		model.addObject("ErrorTitle","Project Not Found!!");
		model.addObject("errorDescription","The Project your looking for is not Available");
		model.addObject("title","404 Error");
		model.addObject("link","otherwise");
		return model;
	}
	
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception ex) {
		ModelAndView model = new ModelAndView("error");
		model.addObject("ErrorTitle","Contact your admistrator!!");
		model.addObject("errorDescription",ex.toString());
		model.addObject("title","404 Error");
		model.addObject("link","otherwise");
		return model;
	}
	

}
