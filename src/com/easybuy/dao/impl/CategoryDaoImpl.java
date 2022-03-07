package com.easybuy.dao.impl;

import com.easybuy.dao.CategoryDao;
import com.easybuy.entity.ProductCategory;

import java.util.List;

/**
 * @author wei-ya-nan
 * @version 1.0
 * @date 2022/2/22
 */
public class CategoryDaoImpl extends BaseDao implements CategoryDao {
    @Override
    public int addCategory(ProductCategory productCategory) {
        String sql = "insert into easybuy_product_category values (?,?,?)";
        return update(sql, productCategory.getEpcID(),productCategory.getEpcName(),
                productCategory.getParentId());
    }

    @Override
    public int updateCategory(ProductCategory productCategory) {
        String sql = "update easybuy_product_category set EPC_NAME=? where EPC_ID=?";
        return update(sql, productCategory.getEpcName(), productCategory.getEpcID());
    }

    @Override
    public int deleteCategory(Integer id) {
        String sql = "delete from easybuy_product_category where EPC_ID=?";
        return update(sql, id);
    }

    @Override
    public ProductCategory queryCategoryById(Integer id) {
        String sql = "select EPC_ID epcId,EPC_NAME epcName,EPC_PARENT_ID parentId from easybuy_product_category " +
                "where EPC_ID=?";
        return queryOne(sql, ProductCategory.class, id);
    }

    @Override
    public List<ProductCategory> queryAllCategory() {
        String sql = "select EPC_ID epcId,EPC_NAME epcName,EPC_PARENT_ID parentId from easybuy_product_category";
        return queryForList(ProductCategory.class, sql);
    }

    @Override
    public List<ProductCategory> queryListCategoryById(Integer id) {
        String sql = "select EPC_ID epcId,EPC_NAME epcName,EPC_PARENT_ID parentId from easybuy_product_category " +
                "where EPC_PARENT_ID = ? and  not EPC_ID  =?";
        return queryForList(ProductCategory.class, sql, id, id);
    }

    @Override
    public List<ProductCategory> queryListCategoryParentId() {
        String sql = "select  EPC_ID epcId,EPC_NAME epcName,EPC_PARENT_ID parentId from easybuy_product_category" +
                " where EPC_ID = EPC_PARENT_ID";
        return queryForList(ProductCategory.class, sql);
    }

    @Override
    public List<ProductCategory> queryCategoryParentAll() {
        String sql = "select EPC_ID epcId,EPC_NAME epcName,EPC_PARENT_ID parentId  from easybuy_product_category" +
                " where EPC_ID = EPC_PARENT_ID";
        return queryForList(ProductCategory.class, sql);
    }
}
