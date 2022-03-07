package com.easybuy.dao;

import com.easybuy.entity.News;

import java.util.List;

/**
 * @author wei-ya-nan
 * @version 1.0
 * @date 2022/3/1
 */
public interface NewDao {
    public int addNew(News news);

    public int deleteNew(Integer id);

    public int updateNew(News news);

    public List<News> queryNewsAll();

    public News queryOne(Integer id);

    Integer queryForPageTotalCount();

    List<News> queryForPageItems(int begin, int pageSize);
}
