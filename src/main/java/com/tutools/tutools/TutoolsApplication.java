package com.tutools.tutools;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class TutoolsApplication {

    public static void main(String[] args) {
        SpringApplication.run(TutoolsApplication.class, args);
    }

    @GetMapping(value = "")
    public String index(){
        return "index";
    }

}
