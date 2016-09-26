package com.jaxlying.www.controller;

import com.jaxlying.www.model.Article;
import com.jaxlying.www.model.Comment;
import com.jaxlying.www.repository.ArticleRepository;
import com.jaxlying.www.repository.CommentRepository;
import com.jaxlying.www.util.LinkPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


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

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String index(Model model,
                        @RequestParam(value = "page", defaultValue = "0") Integer page,
                        @RequestParam(value = "size", defaultValue = "8") Integer size){
        Pageable pageable = new PageRequest(page,size);
        Page<Article> pages = articleRepository.findByDeleteAtOrderByIdDesc(0,pageable);
        model.addAttribute("page", new LinkPage<>(pages,"/articles"));
        return "home";
    }


    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public String show(@PathVariable int id,Model model){
        Article article = articleRepository.findOne(id);
        Iterable<Comment> comments = commentRepository.findByArticleAndDeleteAtOrderByIdDesc(article,0);
        model.addAttribute("article",article);
        model.addAttribute("comments",comments);
        return "detail";
    }
}
