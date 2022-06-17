package com.disquera.disquera.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class IndexController {

    @GetMapping(path={"/","","/index","home"})
    public String index(){
        return "index";
    }
}
