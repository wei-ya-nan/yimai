package com.easybuy.service;

import com.easybuy.entity.Page;
import com.easybuy.entity.Product;

import java.util.List;

/**
 * @author wei-ya-nan
 * @version 1.0
 * @date 2022/2/21
 */
public interface GoodsService {
    //
    public void addGoods(Product product);

    public void deleteGoodsById(Integer id);

    public void updateGoods(Product product);

    //根据id查询商品
    public Product queryById(Integer ProId);

    //查询所有的商品
    public List<Product> queryAllGoods();

    //分页的业务逻辑
    Page<Product> page(Integer childId,Integer epcId,int pageNo, int pageSize);
}
