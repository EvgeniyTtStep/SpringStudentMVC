package com.itstep.controller;

import com.itstep.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class MyFirstController {


    @GetMapping("/hello")
    @ResponseBody//выводит ответ на страницу
    public String hello() {
        return "hello from controller";
    }

    @GetMapping({"/show", "/show/{first}", "/show/{first}/{second}"})
    public String show(@PathVariable(value = "first", required = false) String first,//Принимает данные из пути
                       @PathVariable(value = "second", required = false) String second,
                       @RequestParam(value = "name", required = false, defaultValue = "Noname") String name,
                       @RequestParam(value = "surname", required = false, defaultValue = "Noname") String surname,
                       Model model) {//@RequestParam() - аналог getParametr() принимает данные из формы
        model.addAttribute("name", "Controller name " + name);
        model.addAttribute("surname", "Controller surname " + surname);
        return "show";
    }

}
