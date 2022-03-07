package com.easybuy.entity;

import java.math.BigDecimal;

/**
 * @author wei-ya-nan
 * @version 1.0
 * @date 2022/2/21
 */
//商品
public class Product {
    private Integer id;//商品id
    private String name;//商品名字
    private String  description;//描述
    private BigDecimal price;//价格
    private Integer stock;//库存
    private Integer pcId;//商品分类id
    private Integer childId;//商品分类子id
    private String fileName;//图片文件名

    public Product() {
    }

    public Product(Integer id, String name, String description, BigDecimal price, Integer stock, Integer pcId,
                   Integer childId, String fileName) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.pcId = pcId;
        this.childId = childId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getPcId() {
        return pcId;
    }

    public void setPcId(Integer pcId) {
        this.pcId = pcId;
    }

    public Integer getChildId() {
        return childId;
    }

    public void setChildId(Integer childId) {
        this.childId = childId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return "\nProduct{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", pcId=" + pcId +
                ", childId=" + childId +
                ", fileName='" + fileName + '\'' +
                '}';
    }
}
