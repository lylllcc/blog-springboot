package com.example.controller;

import com.example.dao.CommentDao;
import com.example.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lylllcc on 2016/12/17.
 */
@Controller
public class CommentController {


    @Autowired
    private CommentDao commentDao;

    @RequestMapping("/comment")
    public String comment(String username,String email,int id,String body){
        Comment comment = new Comment();
        comment.setBody(body);
        comment.setUsername(username);
        comment.setEmail(email);
        comment.setArticleId(id);
        commentDao.save(comment);
        return "redirect:/article?id=" + id;
    }
}
