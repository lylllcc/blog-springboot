package cn.yyljj.myblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yyljj on 2016/5/26.
 */
@Controller
public class IndexContoller {
    @RequestMapping("/")
    public String showIndex(){
        return "index";
    }

}
