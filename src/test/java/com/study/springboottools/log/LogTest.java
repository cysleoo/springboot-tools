package com.study.springboottools.log;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.log4j.Log4j2;

/**
 * @author ssliu
 * @date 2020-08-06
 */
@SpringBootTest
public class LogTest {

  private static final Logger log = LoggerFactory.getLogger(LogTest.class);


 @Test
 void testLog(){
   if(log.isDebugEnabled()){
     log.debug("debug for test: ");

   }
   log.info("test something");
 }
}
