package com.example.dao;

import com.example.model.Article;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by lylllcc on 2016/12/13.
 */
public interface ArticleDao extends CrudRepository<Article,Integer>{
}
