package com.example.restservicecors.controller;

import com.example.restservicecors.model.Greeting;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    public static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    /**
     * method CORS
     * only allow http://localhost:9000 to send cross origin requests.
     * @param name
     * @return
     */
    @CrossOrigin("http://localhost:9000")
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(required = false, defaultValue = "World") String name) {
        System.out.println("==================== in greeting ====================");
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    /**
     * Global CORS
     * @param name
     * @return
     */
    @GetMapping("/greeting-javaconfig")
    public Greeting greetingJavaconfig(@RequestParam(required = false, defaultValue = "World") String name) {
        System.out.println("==================== in greeting javaconfig ==============");
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
