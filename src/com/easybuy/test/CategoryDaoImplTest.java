package com.easybuy.test;

import com.easybuy.dao.CategoryDao;
import com.easybuy.dao.impl.CategoryDaoImpl;
import com.easybuy.entity.ProductCategory;
import org.junit.Test;

import javax.swing.plaf.synth.SynthSpinnerUI;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author wei-ya-nan
 * @version 1.0
 * @date 2022/2/22
 */
public class CategoryDaoImplTest {
    private CategoryDao categoryDao = new CategoryDaoImpl();
    @Test
    public void addCategory() {
    }

    @Test
    public void updateCategory() {
    }

    @Test
    public void deleteCategory() {
    }

    @Test
    public void queryCategoryById() {

    }

    @Test
    public void queryAllCategory() {
        List<ProductCategory> productCategories = categoryDao.queryAllCategory();
        System.out.println(Arrays.asList(productCategories));
    }
    @Test
    public void queryAllCategoryByIdAndList(){
        List<ProductCategory> productCategories = categoryDao.queryListCategoryById(545);
        System.out.println(Arrays.asList(productCategories));
    }

    @Test
    public void queryListCategoryParentId(){
        List<ProductCategory> productCategories = categoryDao.queryListCategoryParentId();
        System.out.println(Arrays.asList(productCategories));
    }
}