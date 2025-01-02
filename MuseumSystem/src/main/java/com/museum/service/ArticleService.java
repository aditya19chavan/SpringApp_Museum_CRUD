package com.museum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.museum.dao.ArticleRepository;
import com.museum.entity.Article;

@Service
public class ArticleService {

	@Autowired
	private ArticleRepository articleRepo;
	public Article addArticle(Article article)
	{
		Article savedArticle=articleRepo.save(article);
		return savedArticle;
	}
}
