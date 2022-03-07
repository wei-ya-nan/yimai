package com.easybuy.dao.impl;

import com.easybuy.dao.GoodsDao;
import com.easybuy.entity.Product;

import java.util.List;

/**
 * @author wei-ya-nan
 * @version 1.0
 * @date 2022/2/21
 */
public class GoodsDaoImpl extends BaseDao implements GoodsDao {
    /**
     * 添加商品
     *
     * @param product
     * @return
     */
    @Override
    public int addGoods(Product product) {
        String sql =
                "insert into EASYBUY_PRODUCT (EP_ID, EP_NAME, EP_DESCRIPTION, EP_PRICE, EP_STOCK, EPC_ID, " +
                        "EPC_CHILD_ID, EP_FILE_NAME)" +
                        "values (?, ?, ?, ?, ?, ?, ?, ?)";
        return update(sql, product.getId(), product.getName(), product.getDescription(), product.getPrice(),
                product.getStock(), product.getPcId(), product.getChildId(), product.getFileName());

    }

    /**
     * 删除商品根据id
     *
     * @param id
     * @return
     */
    @Override
    public int deleteGoodsById(Integer id) {
        String sql = "delete from easybuy_product where EP_ID = ?";
        return update(sql , id);
    }

    /**
     * 更新商品
     *
     * @param product
     * @return
     */
    @Override
    public int updateGoods(Product product) {
        String sql = "update easybuy_product set EP_NAME =?, EP_DESCRIPTION =?, EP_PRICE =?," +
                " EP_STOCK =?, EPC_ID = ?, EPC_CHILD_ID = ?, EP_FILE_NAME = ? where EP_ID =?";
        return update(sql , product.getName(),product.getDescription(),product.getPrice(),product.getStock(),
                product.getPcId(),product.getChildId(),product.getFileName(),product.getId());
    }

    /**
     * 查询商品
     *
     * @param id
     * @return
     */
    @Override
    public Product queryGoodsById(Integer id) {
        String sql = "select EP_ID id, EP_NAME `name`, EP_DESCRIPTION description, EP_PRICE price, EP_STOCK " +
                "stock, EPC_ID pcID, EPC_CHILD_ID childId, EP_FILE_NAME fileName from easybuy_product where " +
                "EP_ID=?";
        return queryOne(sql, Product.class, id);
    }

    /**
     * 查询所有的商品信息
     *
     * @return
     */
    @Override
    public List<Product> queryGoods() {
        String sql = "select EP_ID id, EP_NAME `name`, EP_DESCRIPTION description, EP_PRICE price, EP_STOCK " +
                "stock, EPC_ID pcID, EPC_CHILD_ID childId, EP_FILE_NAME fileName from easybuy_product ";
        return queryForList(Product.class, sql);
    }

    /**
     * 查询出所有的商品数量
     *
     * @return
     */
    @Override
    public Integer queryForPageTotalCount() {
        String sql = "select count(*) from easybuy_product";
        Number count = (Number) queryForSingleValue(sql);
        return count.intValue();
    }

    /**
     * 分页查询
     *
     * @param begin
     * @param pageSize
     * @return
     */
    @Override
    public List<Product> queryForPageItems(int begin, int pageSize) {
        String sql = "\n" +
                "select EP_ID id, EP_NAME `name`, EP_DESCRIPTION description, EP_PRICE price, EP_STOCK stock, " +
                "EPC_ID pcID, EPC_CHILD_ID childId, EP_FILE_NAME fileName from easybuy_product limit ?,?";
        return queryForList(Product.class, sql, begin, pageSize);
    }

    public List<Product> queryCatePage(Integer id, int begin, int pageSize) {
        String sql = "select EP_ID id, EP_NAME `name`, EP_DESCRIPTION description, EP_PRICE price, EP_STOCK " +
                "stock," +
                "EPC_ID pcID, EPC_CHILD_ID childId, EP_FILE_NAME fileName from easybuy_product " +
                "where EPC_ID=? limit ?,?";
        return queryForList(Product.class, sql, id, begin, pageSize);
    }

    @Override
    public Integer queryForPageCategoryTotalCount(Integer cateEpcId) {
        String sql = "select count(*) from easybuy_product where epc_id=?";
        Number count = (Number) queryForSingleValue(sql, cateEpcId);
        return count.intValue();
    }

    @Override
    public List<Product> queryCatePageByChild(Integer childId, int begin, int pageSize) {
        String sql = "select EP_ID id, EP_NAME `name`, EP_DESCRIPTION description, EP_PRICE price, EP_STOCK " +
                "stock, EPC_ID pcID, EPC_CHILD_ID childId, EP_FILE_NAME fileName from easybuy_product where  " +
                "EPC_CHILD_ID=? limit ?,?";
        return queryForList(Product.class, sql, childId, begin, pageSize);
    }

    @Override
    public Integer queryForPageCategoryChildTotalCount(Integer childId) {
        String sql = "select count(*) from easybuy_product where EPC_CHILD_ID=?";
        Number count = (Number) queryForSingleValue(sql, childId);
        return count.intValue();
    }
}
