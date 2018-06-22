package com.h2demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.h2demo.domain.Post;
import com.h2demo.service.PostService;

@RestController
@RequestMapping("/posts")
public class PostController {
	
	
	private PostService postService;
	
	@Autowired
	public PostController(PostService postService) {
		this.postService = postService;
	}
	
	@RequestMapping(value="/list", method = RequestMethod.GET)	
	public Iterable<Post> listPosts() {
		
		return postService.list();
	}
	
	
/*	@RequestMapping("/view/{slug}")
	public String view(@PathVariable(value="slug") String slug, Model model) {
		
		model.addAttribute("post", postService.getBySlug(slug));
		
		return "post/view";
	}*/
	
	@RequestMapping(value="/byAuthor/{first}", method = RequestMethod.GET)	
	public List<Post> byAuthor(@PathVariable(value="first") String first){
		
		return postService.byAuthor(first);
	}
	
	@RequestMapping(value="/byKeyword/{keyword}" , method = RequestMethod.GET)	
	public List<Post> byKeyword(@PathVariable(value="keyword") String keyword){
		
		return postService.byKeywords(keyword);
	}
	
	@RequestMapping(value="/active", method = RequestMethod.GET)	
	public List<Post> active(){
		
		return postService.active();
	}
	
	@RequestMapping(value="/bySlug/{slug}", method = RequestMethod.GET)	
	public List<Post> bySlug(@PathVariable(value="slug") String slug){
		
		return postService.bySlug(slug);
	}

}
