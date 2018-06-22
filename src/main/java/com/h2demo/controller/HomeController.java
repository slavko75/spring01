package com.h2demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.h2demo.service.PostService;

@Controller
public class HomeController {
	
	private PostService postService;
	
	
	@Autowired
	public HomeController(PostService postService) {
		this.postService = postService;
	}
	


}
