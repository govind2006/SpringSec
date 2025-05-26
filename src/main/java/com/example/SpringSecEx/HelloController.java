package com.example.SpringSecEx;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

@RestController
public class HelloController {

    @GetMapping("/")
    public String greet(HttpServletRequest request) {
        return "Hello, World! " + request.getSession().getId();
    }
}