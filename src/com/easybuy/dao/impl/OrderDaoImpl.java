package com.easybuy.dao.impl;

import com.easybuy.dao.OrderDao;
import com.easybuy.entity.Order;

import java.util.List;

/**
 * @author wei-ya-nan
 * @version 1.0
 * @date 2022/3/1
 */
public class OrderDaoImpl extends BaseDao implements OrderDao {

    @Override
    public Integer queryForPageTotalCount() {
        String sql ="select count(*) from EASYBUY_ORDER";
        Number count = (Number) queryForSingleValue(sql);
        return count.intValue();
    }

    @Override
    public int addOrder(Order order) {
        String sql = "insert into EASYBUY_ORDER (EO_ID, EO_USER_ID, EO_USER_NAME, EO_USER_ADDRESS, " +
                "EO_CREATE_TIME, EO_COST, EO_STATUS, EO_TYPE) values (?, ?, ?, ?, " +
                "?, ?, ?, ?)";
        return update(sql, order.getId(), order.getUserId(), order.getUserName(), order.getAddress(),
                order.getCreateTime(), order.getCost(), order.getStatus(), order.getStatus());
    }

    @Override
    public int deleteOrder(Integer id) {
        String sql = "delete from EASYBUY_ORDER where EO_ID=?";
        return update(sql, id);
    }

    @Override
    public int updateOrder(Order order) {
        String sql = "update EASYBUY_ORDER set EO_USER_NAME=?,EO_USER_ADDRESS=?,EO_STATUS=? where EO_ID=?";
        return update(sql, order.getUserName(), order.getAddress(), order.getStatus(),order.getId());
    }

    @Override
    public List<Order> queryAll() {
        String sql = "select EO_ID id, EO_USER_ID userId, EO_USER_NAME userName, " +
                "EO_USER_ADDRESS address, EO_CREATE_TIME createTime, EO_COST cost, EO_STATUS status, EO_TYPE " +
                "type from EASYBUY_ORDER";
        return queryForList(Order.class, sql);
    }

    @Override
    public Order queryOne(Integer id) {
        String sql = "select  EO_ID id, EO_USER_ID userId, EO_USER_NAME userName, " +
                "EO_USER_ADDRESS address, EO_CREATE_TIME createTime, EO_COST cost, EO_STATUS status, EO_TYPE " +
                "type from EASYBUY_ORDER where EO_ID = ?";
        return queryOne(sql, Order.class, id);
    }

    @Override
    public List<Order> queryForPageItems(int begin, int pageSize) {
        String sql = "select  EO_ID id, EO_USER_ID userId, EO_USER_NAME userName, " +
                "EO_USER_ADDRESS address, EO_CREATE_TIME createTime, EO_COST cost, EO_STATUS status, EO_TYPE " +
                "type from EASYBUY_ORDER order by  EO_CREATE_TIME desc limit ?,?";
        return queryForList(Order.class, sql, begin,pageSize);
    }

    @Override
    public Order queryOneByIdAndUserName(Integer id, String userName) {
        String sql = "select  EO_ID id, EO_USER_ID userId, EO_USER_NAME userName, " +
                "EO_USER_ADDRESS address, EO_CREATE_TIME createTime, EO_COST cost, EO_STATUS status, EO_TYPE " +
                "type from EASYBUY_ORDER where EO_ID = ? and EO_USER_NAME  like ?";
        return queryOne(sql, Order.class, id,userName);
    }
}
