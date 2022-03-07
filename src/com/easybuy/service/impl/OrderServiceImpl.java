package com.easybuy.service.impl;

import com.easybuy.dao.OrderDao;
import com.easybuy.dao.impl.OrderDaoImpl;
import com.easybuy.entity.Order;
import com.easybuy.entity.Page;
import com.easybuy.service.OrderService;

import java.util.List;

/**
 * @author wei-ya-nan
 * @version 1.0
 * @date 2022/3/1
 */
public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = new OrderDaoImpl();
    @Override
    public void addOrder(Order order) {
        orderDao.addOrder(order);
    }

    @Override
    public void updateOrder(Order order) {
        orderDao.updateOrder(order);
    }

    @Override
    public void deleteOrder(Integer id) {
        orderDao.deleteOrder(id);
    }

    @Override
    public List<Order> queryAllOrder() {
        return orderDao.queryAll();
    }

    @Override
    public Order queryOneOrder(Integer id) {
        return orderDao.queryOne(id);
    }

    @Override
    public Page<Order> page(int pageNo, int pageSize) {
        Page<Order> page = new Page<Order>();

        // 设置每页显示的数量
        page.setPageSize(pageSize);
        // 求总记录数
        Integer pageTotalCount = orderDao.queryForPageTotalCount();
        // 设置总记录数
        page.setPageTotalCount(pageTotalCount);
        // 求总页码
        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pageTotal+=1;
        }
        // 设置总页码
        page.setPageTotal(pageTotal);

        // 设置当前页码
        page.setPageNo(pageNo);

        // 求当前页数据的开始索引
        int begin = (page.getPageNo() - 1) * pageSize;
        // 求当前页数据
        List<Order> items = orderDao.queryForPageItems(begin,pageSize);
        // 设置当前页数据
        page.setItems(items);

        return page;
    }
}
