package com.study.springboottools.domain;

import java.util.StringJoiner;

/**
 * @author ssliu
 * @date 2020-07-20
 */
public class Dog {
  private Integer age;



  private String color;
  private String type;

  public Dog(Integer age, String color, String type) {
    this.age = age;
    this.color = color;
    this.type = type;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }
  @Override
  public String toString() {
    return new StringJoiner(", ", Dog.class.getSimpleName() + "[", "]")
        .add("age=" + age)
        .add("color='" + color + "'")
        .add("type='" + type + "'")
        .toString();
  }

}
