package com.jaxlying.www.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jaxlying on 2016/9/25.
 */
@Controller
@RequestMapping("/admin")
public class AdminHomeController {

    @RequestMapping("/home")
    public String showIndex(){
        return "home";
    }
}
