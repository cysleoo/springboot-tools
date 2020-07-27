package com.study.springboottools.gson;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.study.springboottools.domain.Dog;

/**
 * gson 测试
 */
class GsonTest {

  private Dog dog1;
  private Dog dog2;
  private List<Dog> dogList = new ArrayList<>();
  private Gson gson;
  private String str1 = "{\"age\":1,\"color\":\"yellow\",\"type\":\"husky\"}";
  private String str2 =
      "[{\"age\":1,\"color\":\"yellow\",\"type\":\"husky\"},{\"age\":2,\"color\":\"black\",\"type\":\"husky\"}]";

  @BeforeEach
  void setUp() {
    gson = new Gson();
    dog1 = new Dog(1, "yellow", "husky");
    dog2 = new Dog(2, "black", "husky");
    dogList.add(dog1);
    dogList.add(dog2);
  }

  @Test
  void obj2String() {
    System.out.println(gson.toJson(dog1));
    System.out.println(gson.toJson(dogList));
  }

  @Test
  void string2Obj() {
    Dog dog = gson.fromJson(str1, Dog.class);
    assertThat(dog).isEqualToComparingFieldByField(dog1);
  }

  @Test
  void obj2JsonElement() {
    JsonObject obj = gson.toJsonTree(dog1).getAsJsonObject();
    JsonArray array = gson.toJsonTree(dogList).getAsJsonArray();
  }

  @Test
  void jsonObjectTest() {
    JsonObject obj = new JsonObject();
    // 增
    obj.addProperty("data", "value");
    System.out.println(obj.toString());
    //  查
    System.out.println(obj.get("data"));
    // 删
    obj.remove("data");
    System.out.println(obj.toString());
  }

  @Test
  void jsonArrayTest() {
    JsonArray array = new JsonArray();
    //  1.增删改查
    array.add(1);
    array.add("test");
    System.out.println(array.toString());
    array.remove(0);
    System.out.println(array.toString());
    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("taa", "test-new");
    array.set(0, jsonObject);
    System.out.println(array.toString());
    System.out.println(array.get(0));

    //  2.size、包含
    System.out.println(array.size());
    System.out.println(array.contains(jsonObject));

  }

  /**
   * 字符串 to List
   */
  @Test
  void testArray() {
    // string
    String strArr = "['张三','李四','王五']";
    String[] strings = gson.fromJson(strArr, String[].class);
    System.out.println(strings);
    List<String> stringList = Arrays.asList(strings);
    System.out.println(gson.toJson(stringList));

    // integer
    String intArr = "[1,2,3,4,5]";
    Integer[] ints = gson.fromJson(intArr, Integer[].class);
    List<Integer> intList = Arrays.asList(ints);
    System.out.println(gson.toJson(intList));
  }

}
