package cn.solr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/solr")
public class ViewController {
    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

}
