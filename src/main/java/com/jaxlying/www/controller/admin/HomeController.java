package com.jaxlying.www.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jaxlying on 2016/9/24.
 */
@Controller
@RequestMapping("/admin")
public class HomeController {

    public String home(){
        return "admin/home";
    }
}
