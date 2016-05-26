package cn.yyljj.myblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by yyljj on 2016/5/26.
 */
@Controller
public class CreatController {

    @RequestMapping("/creat")
    public String showCreatPage(Model model, HttpSession httpSession) {
        if (httpSession.getAttribute("admin") == null) {
            return "redirect:/login";
        }
        else {
            return "creat";
        }
    }

}
