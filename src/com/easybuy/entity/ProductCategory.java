package com.easybuy.entity;

import java.util.List;

/**
 * @author wei-ya-nan
 * @version 1.0
 * @date 2022/2/22
 */
public class ProductCategory{
    //商品分类的id
    private Integer epcID;
    //商品的类别的名字
    private String epcName;
    //商品分类的父类id
    private Integer parentId;


    public ProductCategory() {
    }

    public ProductCategory(Integer epcID, String epcName, Integer parentId) {
        this.epcID = epcID;
        this.epcName = epcName;
        this.parentId = parentId;
    }

    public Integer getEpcID() {
        return epcID;
    }

    public void setEpcID(Integer epcID) {
        this.epcID = epcID;
    }

    public String getEpcName() {
        return epcName;
    }

    public void setEpcName(String epcName) {
        this.epcName = epcName;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "\n商品分类{" +
                "epcID=" + epcID +
                ", epcName='" + epcName + '\'' +
                ", parentId=" + parentId +
                '}';
    }
}
