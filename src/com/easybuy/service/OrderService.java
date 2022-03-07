package com.easybuy.service;

import com.easybuy.entity.Order;
import com.easybuy.entity.Page;

import java.util.List;

/**
 * @author wei-ya-nan
 * @version 1.0
 * @date 2022/3/1
 */
public interface OrderService {
    public void addOrder(Order order);

    public void updateOrder(Order order);

    public void deleteOrder(Integer id);

    public List<Order> queryAllOrder();

    public Order queryOneOrder(Integer id);

    Page<Order> page(int pageNo, int pageSize);

}
