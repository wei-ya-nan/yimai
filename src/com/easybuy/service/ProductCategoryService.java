package com.easybuy.service;

import com.easybuy.entity.ProductCategory;

import java.util.List;

/**
 * @author wei-ya-nan
 * @version 1.0
 * @date 2022/2/22
 */
public interface ProductCategoryService {
    public void addProductCategory(ProductCategory productCategory);

    public void deleteProductCategory(Integer id);

    public void updateProductCategory(ProductCategory productCategory);

    //查询单个的分类商品信息记录
    public ProductCategory queryProductCategoryById(Integer id);

    //查询所有的分类信息
    public List<ProductCategory> queryAllProductCategory();

    //根据id查询不包括父类的信息
    public List<ProductCategory> queryCategoryIdAndNotParentId(Integer id);

    //根据商品的父类id查询分类信息
    public List<ProductCategory> queryListCategoryByParentId();

    public List<ProductCategory> queryCategoryParentAll();


}
