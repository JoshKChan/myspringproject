package com.joshkchan.myspringproject.restservice;

import java.util.concurrent.atomic.AtomicLong;

import com.joshkchan.myspringproject.GreetingConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

  @Autowired
  private GreetingConfig greetingConfig;

  private static final String template = "Hello, %s!";
  private final AtomicLong counter = new AtomicLong();

  @GetMapping("/greeting")
  public Greeting greeting() {
    System.out.println(greetingConfig.getName());
    return new Greeting(counter.incrementAndGet(), greetingConfig.getGreeting());
  }
}
