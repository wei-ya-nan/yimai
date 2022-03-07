package com.easybuy.test;

import com.easybuy.dao.GoodsDao;
import com.easybuy.dao.impl.GoodsDaoImpl;
import com.easybuy.entity.Cart;
import com.easybuy.entity.CartItems;
import com.easybuy.entity.Product;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wei-ya-nan
 * @version 1.0
 * @date 2022/2/24
 */
public class CartTest {
    private GoodsDao goodsDao = new GoodsDaoImpl();

//    @Test
//    public void addCartItem() {
//        Product product = goodsDao.queryGoodsById(591);
//        Cart cart = new Cart();
//        cart.addCartItem(new CartItems(product.getId(), product.getName(), 1, product.getPrice(),
//                product.getPrice()));
//        cart.addCartItem(new CartItems(12, product.getName(), 1, product.getPrice(),
//                product.getPrice()));
//        System.out.println(cart);
//    }
//
//    @Test
//    public void deleteCart() {
//        Product product = goodsDao.queryGoodsById(591);
//        Cart cart = new Cart();
//        cart.addCartItem(new CartItems(product.getId(), product.getName(), 1, product.getPrice(),
//                product.getPrice()));
//        cart.addCartItem(new CartItems(12, product.getName(), 1, product.getPrice(),
//                product.getPrice()));
//        cart.deleteCart(12);
//        System.out.println(cart);
//    }
//
//    @Test
//    public void clearCart() {
//        Product product = goodsDao.queryGoodsById(591);
//        Cart cart = new Cart();
//        cart.addCartItem(new CartItems(product.getId(), product.getName(), 1, product.getPrice(),
//                product.getPrice()));
//        cart.addCartItem(new CartItems(12, product.getName(), 1, product.getPrice(),
//                product.getPrice()));
//        cart.clearCart();
//        System.out.println(cart);
//    }
//
//    @Test
//    public void updateCount() {
//        Product product = goodsDao.queryGoodsById(591);
//        Cart cart = new Cart();
//        cart.addCartItem(new CartItems(product.getId(), product.getName(), 1, product.getPrice(),
//                product.getPrice()));
//        cart.addCartItem(new CartItems(12, product.getName(), 1, product.getPrice(),
//                product.getPrice()));
//       cart.updateCount(12,100);
//        System.out.println(cart);
//    }

    @Test
    public void getCartTotalCount() {

    }

    @Test
    public void getCartTotalPrice() {
    }

    @Test
    public void getItemsMap() {
    }

    @Test
    public void setItemsMap() {
    }

    @Test
    public void testToString() {
    }
}