package com.example.controller;

import com.example.dao.ArticleDao;
import com.example.dao.CommentDao;
import com.example.model.Article;
import com.example.model.Comment;
import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by lylllcc on 2016/12/17.
 */
@Controller
public class ArticleController {

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private HttpSession httpSession;

    @Autowired
    private CommentDao commentDao;

    @RequestMapping("/")
    public String index(Model model){
        Iterable<Article> articles = articleDao.findAll();
        model.addAttribute("articles",articles);
        return "index";
    }

    @RequestMapping(value = "/addarticle",method = RequestMethod.GET)
    public String add(){
        User user = (User) httpSession.getAttribute("admin");
        if(user==null)
            return "redirect:/login";
        return "pub";
    }

    @RequestMapping(value = "/addarticle",method = RequestMethod.POST)
    public String add(String title,String body){
        User user = (User) httpSession.getAttribute("admin");
        if(user==null)
            return "redirect:/login";
        Article article = new Article();
        article.setBody(body);
        article.setTitle(title);
        article.setCreateTime(System.currentTimeMillis());
        articleDao.save(article);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/updarticle",method = RequestMethod.GET)
    public String upd(Model model,int id){
        User user = (User) httpSession.getAttribute("admin");
        if(user==null)
            return "redirect:/login";
        Article article = articleDao.findOne(id);
        model.addAttribute("article",article);
        return "upd";
    }

    @RequestMapping(value = "/updarticle",method = RequestMethod.POST)
    public String upd(int id,String title,String body){
        User user = (User) httpSession.getAttribute("admin");
        if(user==null)
            return "redirect:/login";
        Article article = articleDao.findOne(id);
        article.setTitle(title);
        article.setBody(body);
        articleDao.save(article);
        return "redirect:/admin";
    }


    @RequestMapping("/delarticle")
    public String delete(int id){
        User user = (User) httpSession.getAttribute("admin");
        if(user==null)
            return "redirect:/login";
        articleDao.delete(id);
        return "redirect:/admin";
    }

    @RequestMapping("/article")
    public String article(Model model,int id){
        Article article  = articleDao.findOne(id);
        model.addAttribute("article",article);
        Iterable<Comment> comments = commentDao.findByArticleId(id);
        model.addAttribute("comments",comments);
        return "article";
    }
}
