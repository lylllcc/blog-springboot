package com.jaxlying.www.controller;

import com.jaxlying.www.model.Article;
import com.jaxlying.www.repository.ArticleRepository;
import com.jaxlying.www.util.LinkPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by jaxlying on 2016/9/24.
 */
@Controller
public class HomeController {

    @Autowired
    private ArticleRepository articleRepository;

    @RequestMapping({"/index","/home","index.html","/"})
    public String showIndex(){
        return "redirect:/articles/";
    }



}
