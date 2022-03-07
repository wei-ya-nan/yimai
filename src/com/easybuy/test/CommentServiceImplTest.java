package com.easybuy.test;

import com.easybuy.entity.Comment;
import com.easybuy.service.CommentService;
import com.easybuy.service.impl.CommentServiceImpl;
import org.junit.Test;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

/**
 * @author wei-ya-nan
 * @version 1.0
 * @date 2022/3/1
 */
public class CommentServiceImplTest {
private CommentService coService = new CommentServiceImpl();
    @Test
    public void addComment() {
        Comment comment = new Comment(2, "垃圾网站", Date.valueOf( "2012-12-2"), "你来写，zz",
                Date.valueOf( "2012-12-2"), "jack");
        coService.addComment(comment);
    }

    @Test
    public void updateComment() {
        Comment comment = new Comment(2, "垃圾网站", Date.valueOf( "2012-12-2"), "你来写，wez",
                Date.valueOf( "2012-12-2"), "jack");
        coService.updateComment(comment);
    }

    @Test
    public void deleteCommById() {
        coService.deleteCommById(2);
    }

    @Test
    public void queryAll() {
        List<Comment> comments = coService.queryAll();
        System.out.println(Arrays.asList(comments));
    }

    @Test
    public void queryOne() {
        Comment comment = coService.queryOne(2);
        System.out.println(comment);

    }

    @Test
    public void page() {

        java.util.Date date =  new java.util.Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String stringDate = simpleDateFormat.format(date);
        System.out.println(stringDate);
    }
}