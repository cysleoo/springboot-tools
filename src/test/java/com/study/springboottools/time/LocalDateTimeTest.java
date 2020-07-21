package com.study.springboottools.time;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import org.apache.tomcat.jni.Local;
import org.apache.tomcat.util.net.openssl.OpenSSLUtil;
import org.junit.jupiter.api.Test;

/**
 * @author ssliu
 * @date 2020-07-20
 */
public class LocalDateTimeTest {

  @Test
  void testTime() {
    LocalDateTime dateTime = LocalDateTime.now();
    LocalDateTime ctt = LocalDateTime.now(ZoneId.of("UTC+8"));
    System.out.println(dateTime);
    System.out.println(dateTime.toLocalDate());
    System.out.println(dateTime.toLocalTime());
    System.out.println(ctt);
  }

  @Test
  void convertString(){
  //  to string
  //   LocalDateTime now = LocalDateTime.now(); 本地时区
    LocalDateTime now = LocalDateTime.now(ZoneId.of("UTC"));
    String timeStr = now.toString();
    System.out.println(timeStr);

  //  from string
    LocalDateTime parse = LocalDateTime.parse(timeStr);


    System.out.println(parse);

    assertThat(parse.toString()).isEqualTo(timeStr);
  }

  @Test
  void formatterTest(){
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter dtf =
        DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    // 方式1
    String format = dtf.format(now);
    System.out.println(format);
  //  方式2
    String format1 = now.format(dtf);
    System.out.println(format1);
  }

  @Test
  void calculateTest(){
    LocalDateTime now = LocalDateTime.parse("2019-07-31T10:53:19.874");
    LocalDateTime dateTime = now.minusYears(1).minusMonths(1);
    System.out.println(dateTime);
  }

  @Test
  void modifyTest(){
    LocalDateTime now = LocalDateTime.parse("2019-07-31T10:53:19.874");
    LocalDateTime newDate = now.withMonth(6);

    System.out.println(now);
    System.out.println(newDate);

  }


  @Test
  void compareTest() throws InterruptedException {
    LocalDateTime time1 = LocalDateTime.now();
    Thread.sleep(100);
    LocalDateTime time2 = LocalDateTime.now();
    System.out.println(time1.isBefore(time2));
    System.out.println(time1.isAfter(time2));
  }

  @Test
  void timestampTest(){
    // to timestamp
    LocalDateTime now = LocalDateTime.parse("2019-07-31T10:53:19.874");
    long l = now.toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
    System.out.println(l);

  //  from timestamp
    long timeMillis = System.currentTimeMillis();
    LocalDateTime dateTime =
        Instant.ofEpochMilli(timeMillis).atZone(ZoneOffset.ofHours(8)).toLocalDateTime();
    System.out.println(dateTime);

  }

}
