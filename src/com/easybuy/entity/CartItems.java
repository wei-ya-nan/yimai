package com.easybuy.entity;

import java.math.BigDecimal;

/**
 * @author wei-ya-nan
 * @version 1.0
 * @date 2022/2/24
 */

/**
 * 购物车的商品项对象
 *
 */
public class CartItems {
    private Integer id;//商品id
    private String name;//商品的名字
    private Integer count;//购物车里面的商品数量
    private BigDecimal price;//商品的价格
    private BigDecimal totalPrice;//购物车内的商品总价
    private String fileName;

    public CartItems() {
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public CartItems(Integer id, String name, Integer count, BigDecimal price, BigDecimal totalPrice,
                     String fileName) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.price = price;
        this.totalPrice = totalPrice;
        this.fileName = fileName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "CartItems{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", price=" + price +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
