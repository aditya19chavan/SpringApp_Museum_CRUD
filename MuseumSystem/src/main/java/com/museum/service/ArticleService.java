package com.museum.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.museum.dao.ArticleRepository;
import com.museum.entity.Article;
import com.museum.exception.ArticleNotFoundException;

@Service
public class ArticleService {
	
	@Autowired
	private ArticleRepository articleRepo;

	public Article addArticle(Article article) {
		Article savedArticle = articleRepo.save(article);
		return savedArticle;
	}
	
	//getAll method
	
	public Collection<Article>getAllArticle(){
		List<Article>articles=articleRepo.findAll();
		return articles;
	}
	
	//getbyId method
	
	public Article getArticleById(Integer id) {
		Article foundArticle = articleRepo.findById(id)
		.orElseThrow(()-> new ArticleNotFoundException("Article not found of give id:"+id));
		return foundArticle;
					
	}
	//delete by id method
	
	public String deleteArticleById(Integer id) {
		Article foundArticle = articleRepo.findById(id)
				.orElseThrow(()-> new ArticleNotFoundException("Article not found of give id:"+id));
	articleRepo.delete(foundArticle);
		return"Article of id:"+id+" deleted";
	}
	
	//update the article method
	
	public Article updateArticleById(Integer id,Article updatedArticle) {    //create the updatedArticle 
		Article foundArticle = articleRepo.findById(id)
		
				.orElseThrow(()-> new ArticleNotFoundException("Article not found of give id:"+id));
		foundArticle.setName(updatedArticle.getName());               //these methods update the already existed data
		foundArticle.setCategory(updatedArticle.getCategory());
		foundArticle.setCreatedDate(updatedArticle.getCreatedDate());
		foundArticle.setCreatedName(updatedArticle.getCreatedName());
		//saves the updated data
		Article article=articleRepo.save(foundArticle);
		return foundArticle;
					
	}
}

