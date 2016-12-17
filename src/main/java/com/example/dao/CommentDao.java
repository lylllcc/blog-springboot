package com.example.dao;

import com.example.model.Comment;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by lylllcc on 2016/12/13.
 */
public interface CommentDao extends CrudRepository<Comment,Integer>{
    Iterable<Comment> findByArticleId(int articleid);
}
