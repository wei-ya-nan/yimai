package com.easybuy.service.impl;

import com.easybuy.dao.NewDao;
import com.easybuy.dao.impl.NewsDaoImpl;
import com.easybuy.entity.News;
import com.easybuy.entity.Page;
import com.easybuy.service.NewService;

import java.util.List;

/**
 * @author wei-ya-nan
 * @version 1.0
 * @date 2022/3/1
 */
public class NewsServiceImpl implements NewService {
    private NewDao newsDao = new NewsDaoImpl();

    @Override
    public void addNews(News news) {
        newsDao.addNew(news);
    }

    @Override
    public void updateNews(News news) {
        newsDao.updateNew(news);
    }

    @Override
    public void deleteNews(Integer id) {
            newsDao.deleteNew(id);
    }

    @Override
    public List<News> queryAllNew() {
        return newsDao.queryNewsAll();
    }

    @Override
    public News queryOneNews(Integer id) {
        return newsDao.queryOne(id);
    }

    @Override
    public Page<News> page(int pageNo, int pageSize) {
        Page<News> page = new Page<News>();

        // 设置每页显示的数量
        page.setPageSize(pageSize);
        // 求总记录数
        Integer pageTotalCount = newsDao.queryForPageTotalCount();
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
        List<News> items = newsDao.queryForPageItems(begin,pageSize);
        // 设置当前页数据
        page.setItems(items);

        return page;
    }
}
