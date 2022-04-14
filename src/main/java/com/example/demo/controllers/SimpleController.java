package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SimpleController {
@GetMapping("/simple") //localhost:8080/simple

public String simpleFunc() {
		System.out.println("simple funkcija nostrādāja");
		return "home";
	}
@GetMapping("/msg") //localhost:8080/msg
	public String msgFunc(Model model) {
		model.addAttribute("package", "ziņa no backend");
		System.out.println("msg funkcijas nostrādāja");
		return "msg-page";
	}
}
