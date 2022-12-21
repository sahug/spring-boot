package org.example.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    /* With this value we would be able to access the home page with any of the below link
    * http://localhost:8081/springboot
    * http://localhost:8081/springboot/
    * http://localhost:8081/springboot/home.html */
    @RequestMapping(value = {"", "/","/home"})
    public String displayHomePage() {
        return "home.html";
    }

}
