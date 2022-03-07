package com.easybuy.entity;

import java.util.Date;

/**
 * @author wei-ya-nan
 * @version 1.0
 * @date 2022/2/19
 */
public class User {
    private Integer userId;
    private String password;
    private String userName;
    private String sex;
    private Date birthDay;
    private Long identityCode;
    private String email;
    private String mobile;
    private String address;
    private Integer status;

    public User() {
    }

    public User(String userName, String password) {
        this.password = password;
        this.userName = userName;
    }

    public User(Integer userId, String password, String userName, String sex, Date birthDay, Long identityCode,
                String email, String mobile, String address, Integer status) {
        this.userId = userId;
        this.password = password;
        this.userName = userName;
        this.sex = sex;
        this.birthDay = birthDay;
        this.identityCode = identityCode;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public Long getIdentityCode() {
        return identityCode;
    }

    public void setIdentityCode(Long identityCode) {
        this.identityCode = identityCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                ", sex='" + sex + '\'' +
                ", birthDay=" + birthDay +
                ", identityCode='" + identityCode + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", address='" + address + '\'' +
                ", status=" + status +
                '}';
    }
}
