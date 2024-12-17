package com.example.demo11;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HelloWorldController {

	@GetMapping("/hello")
	public String start(){
		System.out.println("From controller..");
		return "Hello, this is a message from the API!";
	}
//	public ModelAndView showMessage(
//			@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
//		System.out.println("From controller..");
//		ModelAndView mv = new ModelAndView("hello");
//		mv.addObject("hello", "Hello");
//		mv.addObject("name", name);
//		return mv;
//	}
}