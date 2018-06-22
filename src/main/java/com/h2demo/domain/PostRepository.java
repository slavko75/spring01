package com.h2demo.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;



public interface PostRepository extends CrudRepository<Post, Long> {
	
	
	List<Post> findAllByAuthorFirstName(String firstName);

	List<Post> findAllByAuthorFirstNameIgnoreCase(String firstName);
	
	List<Post> findAllByAuthorFirstNameIgnoreCaseOrderByPostedOnDesc(String firstName);
	
	List<Post> findAllByAuthorFirstNameIgnoreCaseAndAuthorLastNameIgnoreCase(String firstName, String lastName);
	
	List<Post> findAllByKeywordsLikeIgnoreCase(String keyword);
	
	List<Post> findAllByActiveTrue();
	
	@Query("select p from Post p where p.slug = ?1")
	List<Post> findPostBySlug(String slug);
	
	@Query(value="select p.* from Post p where p.slug = :slug", nativeQuery = true)
	List<Post> findPostBySlugByNative(@Param("slug") String slug);

}
