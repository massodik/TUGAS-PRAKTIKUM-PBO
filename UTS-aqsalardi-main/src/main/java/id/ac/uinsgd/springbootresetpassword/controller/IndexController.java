package id.ac.uinsgd.springbootresetpassword.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/login")
    public String index() {
        return "index";
    }

}