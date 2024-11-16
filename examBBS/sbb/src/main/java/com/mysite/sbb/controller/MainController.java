package com.mysite.sbb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    
    @RequestMapping("/")
    @ResponseBody
    public String root(){
        // Redirect to the SBB homepage
        return "Web root";
    }

    @RequestMapping("/sbb")
    @ResponseBody
    public String index(){
        // Redirect to the SBB homepage
        return "HI sbb welcome";
    }

}
