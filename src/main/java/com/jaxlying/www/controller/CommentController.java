package com.jaxlying.www.controller;

import com.jaxlying.www.model.Article;
import com.jaxlying.www.model.Comment;
import com.jaxlying.www.repository.ArticleRepository;
import com.jaxlying.www.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Jaxlying on 2016/9/26.
 */
@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @RequestMapping(value = "",method = RequestMethod.POST)
    @ResponseBody
    public void store(int articleid,String nickname,String email,String body){
        Article article = articleRepository.findOne(articleid);
        Comment comment = new Comment(article,nickname,email,body);
        commentRepository.save(comment);
        System.out.println("评论成功！");
    }

}
