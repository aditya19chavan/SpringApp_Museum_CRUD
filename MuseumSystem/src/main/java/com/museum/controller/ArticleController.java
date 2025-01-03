package com.museum.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.museum.entity.Article;
import com.museum.service.ArticleService;

@RestController
@RequestMapping("/article")
public class ArticleController {
	
	@Autowired
	private ArticleService articleService;

	//http://localhost:8085/article/add
	@PostMapping("/add")
	public ResponseEntity<?> addArtcle(@RequestBody Article article){
		try {
			Article savedArticle = articleService.addArticle(article);
			return new ResponseEntity<>(savedArticle, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//http://localhost:8085/article/all
	@GetMapping("/all")
	public ResponseEntity<?>allArticles(){
		try {
			Collection<Article>articles=articleService.getAllArticle();
			return new ResponseEntity<>(articles,HttpStatus.OK);
		}catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	//http://localhost:8085/article/oneArticle/4
	@GetMapping("/oneArticle/{id}")
	public ResponseEntity<?>getArticle(@PathVariable Integer id){
		try {
			
			Article foundArticle = articleService.getArticleById(id);
			return new ResponseEntity<>(foundArticle,HttpStatus.OK);
		}catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	//http://localhost:8085/article/delete/4
		@DeleteMapping("/delete/{id}")
		public ResponseEntity<?>deleteArticle(@PathVariable Integer id){
			try {
				String result = articleService.deleteArticleById(id);
				
				return new ResponseEntity<>(result,HttpStatus.OK);
			}catch (Exception e) {
				
				return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		
		//http://localhost:8085/article/update/4
				@PutMapping("/update/{id}")
				public ResponseEntity<?>updateArticle(@PathVariable Integer id,
						@RequestBody Article updatedArticle){
					try {
						Article updated = articleService.updateArticleById(id,updatedArticle);
						
						return new ResponseEntity<>(updated,HttpStatus.OK);
					}catch (Exception e) {
						
						return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
					}
				}
}
