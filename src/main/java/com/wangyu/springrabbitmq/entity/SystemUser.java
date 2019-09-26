package com.wangyu.springrabbitmq.entity;

import com.wangyu.springrabbitmq.common.base.BaseEntity;

/**
 * 用户实体
 *
 * @Author wangyu
 * @Date 2019/9/26 10:35
 * @Version 1.0
 */
public class SystemUser extends BaseEntity {

  private String nickName;

  private String username;

  private String password;

  private Integer age;

  private String sex;

  private String email;

  private String address;

  private String idCard;

  private String phone;

  public String getNickName() {
    return nickName;
  }

  public void setNickName(String nickName) {
    this.nickName = nickName;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getIdCard() {
    return idCard;
  }

  public void setIdCard(String idCard) {
    this.idCard = idCard;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }
}
