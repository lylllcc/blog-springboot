package com.jaxlying.www.repository;

import com.jaxlying.www.model.Article;
import com.jaxlying.www.model.Comment;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by jaxlying on 2016/9/24.
 */
public interface CommentRepository extends PagingAndSortingRepository<Comment,Integer>{

    Iterable<Comment> findByArticleAndDeleteAtOrderById(Article article,long deletAt);
}
