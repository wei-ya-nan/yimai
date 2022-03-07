package com.easybuy.test;

import com.easybuy.dao.CategoryDao;
import com.easybuy.entity.ProductCategory;
import com.easybuy.service.ProductCategoryService;
import com.easybuy.service.impl.ProductCategoryServiceImpl;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author wei-ya-nan
 * @version 1.0
 * @date 2022/2/22
 */
public class ProductCategoryServiceImplTest {
    private ProductCategoryService productCategoryService = new ProductCategoryServiceImpl();
    @Test
    public void addProductCategory() {
    }

    @Test
    public void deleteProductCategory() {
    }

    @Test
    public void updateProductCategory() {
    }

    @Test
    public void queryProductCategoryById() {
        ProductCategory productCategory = productCategoryService.queryProductCategoryById(542);
        System.out.println(productCategory);
    }

    @Test
    public void queryAllProductCategory() {
        List<ProductCategory> productCategories = productCategoryService.queryAllProductCategory();
        System.out.println(Arrays.asList(productCategories));
    }

    @Test
    public void queryCategoryIdAndNotParentId() {
        List<ProductCategory> productCategories = productCategoryService.queryCategoryIdAndNotParentId(555);
        System.out.println(Arrays.asList(productCategories));
    }

    @Test
    public void queryListCategoryByParentId() {
        List<ProductCategory> productCategories = productCategoryService.queryListCategoryByParentId();
        System.out.println(Arrays.asList(productCategories));
    }

    @Test
    public void test99(){
        List<ProductCategory> productCategories = productCategoryService.queryCategoryParentAll();
        System.out.println(Arrays.asList(productCategories));
    }
}