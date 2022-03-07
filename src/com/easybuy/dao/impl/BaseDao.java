package com.easybuy.dao.impl;

import com.easybuy.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author wei-ya-nan
 * @version 1.0
 * @date 2022/2/19
 */
public class BaseDao {
    private QueryRunner queryRunner = new QueryRunner();

    /**
     * 执行update insert delete 语句
     *
     * @param sql
     * @param params
     * @return int
     */
    public int update(String sql, Object... params) {
        Connection conn = JdbcUtils.getConn();
        try {
            return queryRunner.update(conn, sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.ConnClose(conn);
        }
        return -1;
    }

    /**
     * 执行查询一条数据
     *
     * @param sql    数据库语句
     * @param type   返回的对象的类型
     * @param params sql 对应的参数值
     * @param <T>    返回的类型的泛型
     * @return
     */
    public <T> T queryOne(String sql, Class<T> type, Object... params) {
        Connection conn = JdbcUtils.getConn();
        try {
            return queryRunner.query(conn, sql, new BeanHandler<T>(type), params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.ConnClose(conn);
        }
        return null;
    }
    /**
     * 查询多个Javabean 的sql语句
     *
     * @param type 返回的对象类型
     * @param sql  数据库语句
     * @param params sql对应的数值
     * @param <T>  返回的类型的泛型
     * @return
     */
    public <T> List<T> queryForList(Class<T> type , String sql, Object ... params){
        Connection conn = JdbcUtils.getConn();
        try {
            return queryRunner.query(conn, sql, new BeanListHandler<T>(type), params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.ConnClose(conn);
        }
        return null;
    }
    /**
     * 执行返回一行一列的sql语句,输出特殊值如最大值
     * @param sql
     * @param params
     * @return
     */
    public Object queryForSingleValue(String sql, Object... params) {
        Connection conn = JdbcUtils.getConn();
        try {
            return queryRunner.query(conn, sql, new ScalarHandler(), params);
        } catch (SQLException e) {
            e.printStackTrace();

        }finally {
            JdbcUtils.ConnClose(conn);
        }
        return null;
    }

}
