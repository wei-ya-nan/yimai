package com.easybuy.entity;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author wei-ya-nan
 * @version 1.0
 * @date 2022/2/24
 */
public class Cart {
    private Map<Integer,CartItems> itemsMap = new LinkedHashMap<Integer, CartItems>();
    //添加商品的方法
    public void addCartItem(CartItems cartItems){
        //获取购物车Map集合中的一个购物车商品项
        CartItems item = itemsMap.get(cartItems.getId());
        if(item == null){
            //如果没有的话就添加一个购物车商品项
            itemsMap.put(cartItems.getId(), cartItems);
        }else{
            //如果存在的话就购物车商品项中的数量加一.,然后算出总金额
            item.setCount(item.getCount()+1);
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));
        }
    }

    //删除购物车
    public void deleteCart(Integer id){
        itemsMap.remove(id);
    }

    //清空购物车
    public void clearCart(){
        itemsMap.clear();
    }

    //修改购物车中的商品数量
    public void updateCount(Integer id,Integer count){
        CartItems cartItems = itemsMap.get(id);
        if(cartItems != null){
            cartItems.setCount(count);
            cartItems.setTotalPrice(cartItems.getPrice().multiply(new BigDecimal(cartItems.getCount())));
        }
    }
    public Integer getCartTotalCount(){
        Integer count = 0;
        for (Map.Entry<Integer, CartItems> integerCartItemsEntry : itemsMap.entrySet()) {
            count += integerCartItemsEntry.getValue().getCount();
        }
        return count;
    }

    public BigDecimal getCartTotalPrice(){
        BigDecimal price = new BigDecimal(0);
        for (Map.Entry<Integer, CartItems> entry : itemsMap.entrySet()) {
            price = price.add(entry.getValue().getTotalPrice());
        }
        return price;
    }

    public Map<Integer, CartItems> getItemsMap() {
        return itemsMap;
    }

    public void setItemsMap(Map<Integer, CartItems> itemsMap) {
        this.itemsMap = itemsMap;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "itemsMap=" + itemsMap +
                '}';
    }
}
