package com.easybuy.test;

import com.easybuy.entity.News;
import com.easybuy.service.NewService;
import com.easybuy.service.impl.NewsServiceImpl;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author wei-ya-nan
 * @version 1.0
 * @date 2022/3/1
 */
public class NewsServiceImplTest {
private NewService newsService = new NewsServiceImpl();
    @Test
    public void addNews() {
//        6	新年不夜天，通宵也是开张了	新年不夜天，通宵也是开张了	2010-11-12
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = dateFormat.format(date);
        News news = new News(7,"新年不夜天，通宵也是开张了","新年不夜天，通宵也是开张了", java.sql.Date.valueOf(format));
        newsService.addNews(news);
    }

    @Test
    public void updateNews() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = dateFormat.format(date);
        News news = new News(6,"新年不夜天，通宵也是开张了","新年不夜天，通宵也是开张了", java.sql.Date.valueOf(format));
        newsService.updateNews(news);
    }

    @Test
    public void deleteNews() {
        newsService.deleteNews(6);
    }

    @Test
    public void queryAllNew() {
        List<News> news = newsService.queryAllNew();
        System.out.println(Arrays.asList(news));
    }

    @Test
    public void queryOneNews() {
        News news = newsService.queryOneNews(2);
        System.out.println(news);
    }
}