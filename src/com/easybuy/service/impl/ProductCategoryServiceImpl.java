package com.easybuy.service.impl;

import com.easybuy.dao.CategoryDao;
import com.easybuy.dao.impl.CategoryDaoImpl;
import com.easybuy.entity.ProductCategory;
import com.easybuy.service.ProductCategoryService;

import java.util.List;

/**
 * @author wei-ya-nan
 * @version 1.0
 * @date 2022/2/22
 */
public class ProductCategoryServiceImpl implements ProductCategoryService {
    private CategoryDao categoryDao = new CategoryDaoImpl();
    @Override
    public void addProductCategory(ProductCategory productCategory) {
        categoryDao.addCategory(productCategory);
    }

    @Override
    public void deleteProductCategory(Integer id) {
        categoryDao.deleteCategory(id);
    }

    @Override
    public void updateProductCategory(ProductCategory productCategory) {
        categoryDao.updateCategory(productCategory);
    }

    /**
     * 根据id查询单个的信息
     * @param id
     * @return
     */
    @Override
    public ProductCategory queryProductCategoryById(Integer id) {
        return categoryDao.queryCategoryById(id);
    }

    /**
     * 查询所有的商品信息
     * @return
     */
    @Override
    public List<ProductCategory> queryAllProductCategory() {
        return categoryDao.queryAllCategory();
    }

    /**
     * 查询父类下的子类的商品信息
     * [[
     * 商品分类{epcID=658, epcName='医护', parentId=555},
     * 商品分类{epcID=659, epcName='奢品', parentId=555}]]
     * @param id
     * @return
     */
    @Override
    public List<ProductCategory> queryCategoryIdAndNotParentId(Integer id) {
        return categoryDao.queryListCategoryById(id);
    }
    /**
     * 查询父类的几个大的分类
     * 商品分类{epcID=542, epcName='图书音像', parentId=542},
     * 商品分类{epcID=545, epcName='生活用品', parentId=545},
     * 商品分类{epcID=555, epcName='其他', parentId=555}]]
     *
     * @return
     */
    @Override
    public List<ProductCategory> queryListCategoryByParentId() {
        return categoryDao.queryListCategoryParentId();
    }

    @Override
    public List<ProductCategory> queryCategoryParentAll() {
        return categoryDao.queryCategoryParentAll();
    }
}
