package com.h2demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h2demo.domain.Post;
import com.h2demo.domain.PostRepository;

@Service
public class PostService {
	
	private PostRepository postRepository;
	
	@Autowired
	public PostService(PostRepository postRepository) {
		this.postRepository = postRepository;
	}
		


	public Iterable<Post> list() {

		return postRepository.findAll();
	}



	public List<Post> byAuthor(String first) {

		return postRepository.findAllByAuthorFirstNameIgnoreCaseOrderByPostedOnDesc(first);
	}
	
	public List<Post> byKeywords(String keyword){
		
		return postRepository.findAllByKeywordsLikeIgnoreCase('%'+keyword+'%');
		
	}



	public List<Post> active() {
		// TODO Auto-generated method stub
		return postRepository.findAllByActiveTrue();
	}



	public List<Post> bySlug(String slug) {
		// TODO Auto-generated method stub
		return postRepository.findPostBySlugByNative(slug);
	}



}
	