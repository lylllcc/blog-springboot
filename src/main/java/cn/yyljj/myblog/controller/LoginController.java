package cn.yyljj.myblog.controller;

import cn.yyljj.myblog.config.DevConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;


/**
 * Created by yyljj on 2016/5/26.
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private HttpSession httpSession = null;

    @RequestMapping(method = RequestMethod.GET)
    public String showLogin() {
        return "login";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
        if (username.equals(DevConfig.username)&& password.equals(DevConfig.password)) {
            httpSession.setAttribute("admin", true);
            return "redirect:creat";
        } else {
            return "redirect:login";
        }
    }
}
