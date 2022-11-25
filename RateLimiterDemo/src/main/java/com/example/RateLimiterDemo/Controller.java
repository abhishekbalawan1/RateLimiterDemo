package com.example.RateLimiterDemo;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Controller {

    @Autowired
    RestTemplate template;

    @GetMapping("/message")
    @RateLimiter(name = "HelloService", fallbackMethod = "rateLimiterFallback")
    public String getMessage(){
        String response = template.getForObject("http://localhost:8082/hello", String.class);
        return response;
    }

    public String rateLimiterFallback(Exception e){
        return "Rate limiter can not serve your request";
    }
}
