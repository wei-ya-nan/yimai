package com.easybuy.dao;

import com.easybuy.entity.Comment;

import java.awt.print.Book;
import java.util.List;

/**
 * @author wei-ya-nan
 * @version 1.0
 * @date 2022/3/1
 */
public interface CommentDao {
    public int updateComment(Comment comment);

    public int insertComment(Comment comment);

    public int deleteComment(Integer id);

    public List<Comment> queryAll();

    public Integer queryForPageTotalCount();

    public Comment queryById(Integer id);

    List<Comment> queryForPageItems(int begin, Integer pageSize);
}
