package com.mysite.sbb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class QuestionController {
    
    @RequestMapping("/question/list")
    @ResponseBody
    public String requestMethodName() {
        return "question list";
    }
    
}
