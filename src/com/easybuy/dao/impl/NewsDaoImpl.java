package com.easybuy.dao.impl;

import com.easybuy.dao.NewDao;
import com.easybuy.entity.News;

import java.util.List;

/**
 * @author wei-ya-nan
 * @version 1.0
 * @date 2022/3/1
 */
public class NewsDaoImpl extends BaseDao implements NewDao {
    @Override
    public int addNew(News news) {
        String sql = "insert into EASYBUY_NEWS (EN_ID, EN_TITLE, EN_CONTENT, EN_CREATE_TIME)" +
                "values (?, ?, ?, ?)";
        return update(sql, news.getId(), news.getTitle(), news.getContent(),news.getCreateDate());
    }

    @Override
    public int deleteNew(Integer id) {
        String sql = "delete from EASYBUY_NEWS where EN_ID = ?";
        return update(sql,id);
    }

    @Override
    public int updateNew(News news) {
        String sql ="update EASYBUY_NEWS set EN_TITLE=?,EN_CONTENT=?,EN_CREATE_TIME=? where EN_ID =?";
        return update(sql, news.getTitle(),news.getContent(),news.getCreateDate(),news.getId());
    }

    @Override
    public List<News> queryNewsAll() {
        String sql = "select EN_ID id, EN_TITLE title, EN_CONTENT content, EN_CREATE_TIME createDate from " +
                "EASYBUY_NEWS";
        return queryForList(News.class , sql);
    }

    @Override
    public News queryOne(Integer id) {
        String sql ="select EN_ID id, EN_TITLE title, EN_CONTENT content, EN_CREATE_TIME createDate from " +
                "EASYBUY_NEWS where " +
                "EN_ID=?";
        return queryOne(sql, News.class, id);
    }

    @Override
    public Integer queryForPageTotalCount() {
        String sql = "select count(*) from EASYBUY_NEWS";
        Number count =(Number) queryForSingleValue(sql);
        return count.intValue();
    }

    @Override
    public List<News> queryForPageItems(int begin, int pageSize) {
        String sql =  "select EN_ID id, EN_TITLE title, EN_CONTENT content, EN_CREATE_TIME createDate from " +
                "easybuy_news order by createDate desc limit ?,?";
        return queryForList(News.class, sql, begin, pageSize);
    }
}
