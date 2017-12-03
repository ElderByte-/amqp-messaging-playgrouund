package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoController {

    @Autowired
    public Producer producer;

    @RequestMapping("/test")
    public void test(){
        System.out.println("Invoking message ...");

        try {
            producer.send();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
