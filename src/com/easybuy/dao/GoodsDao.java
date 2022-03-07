package com.easybuy.dao;

import com.easybuy.entity.Product;

import java.util.List;

/**
 * @author wei-ya-nan
 * @version 1.0
 * @date 2022/2/21
 */
//处理商品
public interface GoodsDao {

    public int addGoods(Product product);

    public int deleteGoodsById(Integer id);

    public int updateGoods(Product product);

    public Product queryGoodsById(Integer id);

    public List<Product> queryGoods();

    Integer queryForPageTotalCount();

    List<Product> queryForPageItems(int begin,int pageSize);

    List<Product> queryCatePage(Integer id,int begin,int pageSize);
    //查询分类之后的id的总记录数
    Integer queryForPageCategoryTotalCount(Integer cateEpcId);

    //查询子类的id的总记录
    List<Product> queryCatePageByChild(Integer childId,int begin,int pageSize);

    //查询子类的id的总记录数
    Integer queryForPageCategoryChildTotalCount(Integer childId);




}
