package com.museum.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.museum.entity.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer>{

}
