package com.submission.intervalSplitter.service;

import org.apache.log4j.Logger;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.submission.intervalSplitter.core.MainBusiness;
import com.submission.intervalSplitter.model.IntervalSplitter;


@Controller
public class IntervalSplitterController implements ErrorController{
	
	@GetMapping("/intervalSplitter")
	public String intervalSplitterForm(Model model){
		model.addAttribute("intervalSplitter", new IntervalSplitter());
		return "intervalSplitter";
	}
	
	@RequestMapping(value = "/intervalSplitter")
	@PostMapping("/intervalSplitter")
	public String intervalSplitterSubmit(Model model,@ModelAttribute IntervalSplitter intervalSplitter,BindingResult bindingResult) throws Exception {
		
		if(bindingResult.hasErrors()){
			model.addAttribute("error", bindingResult.getAllErrors());
			model.addAttribute("intervalSplitter", new IntervalSplitter());
			return "intervalSplitter";
		}
		
		if(intervalSplitter.getIncludeIntervals().trim().isEmpty() || intervalSplitter.getIncludeIntervals() == null){
			return "result";
		}
		
		String result = MainBusiness.splitInputInterval(intervalSplitter.getIncludeIntervals(), intervalSplitter.getExcludeIntervals());
		intervalSplitter.setResult(result);
		if (result == null || result == "exception" || result == "error") {
			return "error";
		}
		return "result";
	}
	 
			
//	/* Handling Whitelabel Spring boot error */
	@RequestMapping(value = "/error")
	@PostMapping("/error")
	public String errorHtml(Model model){
		//model.addAttribute("error", new IntervalSplitter());
		return "error";
	} 
			
	@Override
	public String getErrorPath() {
		return "/error" ;
	} 

//	/*Generic Exception Handler for input intervals */
	@ExceptionHandler({NullPointerException.class, IndexOutOfBoundsException.class})
	public String handleException(Model model, Exception ex){
		Logger logger = Logger.getLogger(IntervalSplitterController.class);
		logger.error("Null pointer exception occured in the input.The error message is :"+ ex.getMessage());
		//model.addAttribute("input exception", ex);
		return "error";	
	}		

}
