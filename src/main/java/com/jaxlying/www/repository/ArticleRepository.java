package com.jaxlying.www.repository;


import com.jaxlying.www.model.Article;
import com.jaxlying.www.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by jaxlying on 2016/9/24.
 */
public interface ArticleRepository extends PagingAndSortingRepository<Article,Integer> {
    Iterable <Article> findByUser(User user);
}
