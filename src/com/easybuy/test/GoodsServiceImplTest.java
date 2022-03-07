package com.easybuy.test;

import com.easybuy.entity.Page;
import com.easybuy.entity.Product;
import com.easybuy.service.GoodsService;
import com.easybuy.service.impl.GoodsServiceImpl;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author wei-ya-nan
 * @version 1.0
 * @date 2022/2/21
 */
public class GoodsServiceImplTest {
    private GoodsService goodsService = new GoodsServiceImpl();


    @Test
    public void addGoods() {
    }

    @Test
    public void deleteGoodsById() {
    }

    @Test
    public void updateGoods() {
    }

    @Test
    public void queryById() {
        Product product = goodsService.queryById(686);
        System.out.println(product);
    }

    @Test
    public void queryAllGoods() {
        List<Product> products = goodsService.queryAllGoods();
        System.out.println(products);
    }

    @Test
    public void page() {
        Page<Product> page = goodsService.page(null,null, 0,6);
        System.out.println(Arrays.asList(page));
    }
}