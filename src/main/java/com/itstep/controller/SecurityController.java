package com.itstep.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SecurityController {

    @RequestMapping(value = "/login")
    public String login(@RequestParam(name = "error", required = false)Boolean error, Model model){
        if(Boolean.TRUE.equals(error)){
            model.addAttribute("error", true);
        }
        return "login_student";
    }
}
