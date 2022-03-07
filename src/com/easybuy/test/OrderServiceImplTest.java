package com.easybuy.test;

import com.easybuy.entity.Order;
import com.easybuy.service.OrderService;
import com.easybuy.service.impl.OrderServiceImpl;
import com.easybuy.utils.WebUtils;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author wei-ya-nan
 * @version 1.0
 * @date 2022/3/1
 */
public class OrderServiceImplTest {
    private OrderService orderService = new OrderServiceImpl();
    @Test
    public void addOrder() {
        Order order = new Order(null,121,"jack","地球村", WebUtils.getDate(),new BigDecimal(100.22),2,00);
        orderService.addOrder(order);
    }

    @Test
    public void updateOrder() {
        Order order = new Order(65,121,"jack","sfd球村", WebUtils.getDate(),new BigDecimal(1120.22),2,00);
        orderService.updateOrder(order);
    }

    @Test
    public void deleteOrder() {
        orderService.deleteOrder(66);
    }

    @Test
    public void queryAllOrder() {
        List<Order> orders = orderService.queryAllOrder();
        System.out.println(Arrays.asList(orders));
    }

    @Test
    public void queryOneOrder() {
        System.out.println(orderService.queryOneOrder(66));
    }
}