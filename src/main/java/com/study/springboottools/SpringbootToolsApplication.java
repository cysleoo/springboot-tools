package com.study.springboottools;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SpringbootToolsApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringbootToolsApplication.class, args);
  }

}
