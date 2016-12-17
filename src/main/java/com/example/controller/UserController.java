package com.example.controller;

import com.example.dao.ArticleDao;
import com.example.dao.UserDao;
import com.example.model.Article;
import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by lylllcc on 2016/12/13.
 */
@Controller
public class UserController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private HttpSession httpSession;

    @Autowired
    private ArticleDao articleDao;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/dologin",method = RequestMethod.POST)
    public String doLogin(String username,String password,Model model){
        User user = userDao.findFirstByUsername(username);
        if(user==null || !user.getPassword().equals(password)){
            model.addAttribute("msg","用户名或者密码错误!");
            return "fail";
        }
        httpSession.setAttribute("admin",user);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/admin",method = RequestMethod.GET)
    public String admin(Model model){
        User user = (User) httpSession.getAttribute("admin");
        if(user==null)
            return "redirect:/login";
        Iterable<Article> articles = articleDao.findAll();
        model.addAttribute("articles",articles);
        return "admin";
    }

}
