package com.example.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {
    // @GetMapping ensures that HTTP GET Requests to /helloworld is mapped to
    // helloworld()
    @GetMapping("/helloworld")
    public String helloWorld(@RequestParam(name = "name", required = false, defaultValue = "User") String name,
            Model model, View view) {
        model.addAttribute("name", name);
        view.setViewName("helloworld");
        return "helloWorld";
    }
}
