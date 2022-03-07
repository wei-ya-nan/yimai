package com.easybuy.dao;

import com.easybuy.entity.ProductCategory;

import java.util.List;

/**
 * @author wei-ya-nan
 * @version 1.0
 * @date 2022/2/22
 */
public interface CategoryDao {
    //增加
    public int addCategory(ProductCategory productCategory);

    //修改
    public int updateCategory(ProductCategory productCategory);

    //删除
    public int deleteCategory(Integer id);

    //根据id查询分类信息
    public ProductCategory queryCategoryById(Integer id);

    //查询所有
    public List<ProductCategory> queryAllCategory();

    //根据父类的id查询分类的商品信息
    public List<ProductCategory> queryListCategoryById(Integer id);

    //查询单个的父类
    public List<ProductCategory> queryListCategoryParentId();

    public List<ProductCategory> queryCategoryParentAll();

}
