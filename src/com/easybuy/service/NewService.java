package com.easybuy.service;

import com.easybuy.entity.News;
import com.easybuy.entity.Page;

import java.util.List;

/**
 * @author wei-ya-nan
 * @version 1.0
 * @date 2022/3/1
 */
public interface NewService {
    public void addNews(News news);

    public void updateNews(News news);

    public void deleteNews(Integer id);

    public List<News> queryAllNew();

    public News queryOneNews(Integer id);

    public Page<News> page(int pageNo,int pageSize );
}
