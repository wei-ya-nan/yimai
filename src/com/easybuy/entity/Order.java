package com.easybuy.entity;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * @author wei-ya-nan
 * @version 1.0
 * @date 2022/3/1
 */
public class Order {
    private Integer id;
    private Integer userId;
    private String userName;
    private String address;
    private Date createTime;
    private BigDecimal cost;//总价
    private Integer status;
    private Integer type;

    public Order() {
    }

    public Order(Integer id, Integer userId, String userName, String address, Date createTime, BigDecimal cost,
                 Integer status, Integer type) {
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.address = address;
        this.createTime = createTime;
        this.cost = cost;
        this.status = status;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", address='" + address + '\'' +
                ", createTime=" + createTime +
                ", cost=" + cost +
                ", status=" + status +
                ", type=" + type +
                '}';
    }
}
