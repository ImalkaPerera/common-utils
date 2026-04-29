package com.learn.userservice;

import com.learn.commonutils.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return StringUtils.greet("Intern");
    }
}