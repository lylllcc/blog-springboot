package com.jaxlying.www.controller;

import com.jaxlying.www.model.Article;
import com.jaxlying.www.model.Comment;
import com.jaxlying.www.repository.ArticleRepository;
import com.jaxlying.www.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by jaxlying on 2016/9/25.
 */
@Controller
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private CommentRepository commentRepository;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public String show(@PathVariable int id,Model model){
        Article article = articleRepository.findOne(id);
        Iterable<Comment> comments = commentRepository.findByArticleAndDeleteAtOrderById(article,0);
        model.addAttribute("article",article);
        model.addAttribute("comments",comments);
        return "detail";
    }
}
