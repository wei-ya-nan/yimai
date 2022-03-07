package com.easybuy.dao;

import com.easybuy.entity.Order;

import java.util.List;

/**
 * @author wei-ya-nan
 * @version 1.0
 * @date 2022/3/1
 */
public interface OrderDao {
    public Integer queryForPageTotalCount();
    

    public int addOrder(Order order);

    public int deleteOrder(Integer id);

    public int updateOrder(Order order);

    public List<Order> queryAll();

    public Order queryOne(Integer id);

    List<Order> queryForPageItems(int begin, int pageSize);

    public Order queryOneByIdAndUserName(Integer id,String userName);
}
