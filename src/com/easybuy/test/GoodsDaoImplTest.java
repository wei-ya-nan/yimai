package com.easybuy.test;

import com.easybuy.dao.GoodsDao;
import com.easybuy.dao.impl.GoodsDaoImpl;
import com.easybuy.entity.Product;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author wei-ya-nan
 * @version 1.0
 * @date 2022/2/21
 */
public class GoodsDaoImplTest {
    private GoodsDao goodsDao = new GoodsDaoImpl();

    @Test
    public void addGoods() {
        int i = 776;
        int childId = 750;
        int fileName = 12;
        Product product = null;
        for (int x = 96; x <= 109; x++) {

            product = new Product(i, "爱马仕" + "II" + x, "爱马仕 好用实惠", new BigDecimal(99999.00),
                    20000,
                    659,
                    childId, "12 (" + x + ")" +
                    ".jpg");
            i++;
            childId++;
            goodsDao.addGoods(product);
        }

    }

    @Test
    public void deleteGoodsById() {
    }

    @Test
    public void updateGoods() {
    }

    @Test
    public void queryGoodsById() {
        Product product = goodsDao.queryGoodsById(591);
        System.out.println(product);
    }

    @Test
    public void queryGoods() {
        List<Product> products = goodsDao.queryGoods();
        System.out.println(products);
    }

    @Test
    public void queryForPageTotalCount() {
        Integer integer = goodsDao.queryForPageTotalCount();
        System.out.println(integer);
    }

    @Test
    public void queryForPageItems() {
        List<Product> products = goodsDao.queryForPageItems(0, 6);
        System.out.println(products);
    }

    @Test
    public void queryCount() {
        Integer integer = goodsDao.queryForPageCategoryTotalCount(545);
        System.out.println(integer);
    }
}