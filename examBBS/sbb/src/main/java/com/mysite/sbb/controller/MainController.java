package com.mysite.sbb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    
    @RequestMapping("/")
    public String root(){
        // Redirect to the SBB homepage
        return "redirect:/question/list";
    }

    @RequestMapping("/sbb")
    @ResponseBody
    public String index(){
        // Redirect to the SBB homepage
        return "HI sbb welcome";
    }

}
