package com.study.springboottools.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author ssliu
 * @date 2020-08-06
 */
@Component
public class LogScheduler{
  private static  final Logger log = LoggerFactory.getLogger(LogScheduler.class);
  @Scheduled(cron = "0/2 * * * * *")
  public void testLog(){
    log.info("test log ...");
    log.info("test log ...");

  }
}
