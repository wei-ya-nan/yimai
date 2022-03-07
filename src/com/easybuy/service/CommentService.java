package com.easybuy.service;

import com.easybuy.entity.Comment;
import com.easybuy.entity.Page;

import java.util.List;

/**
 * @author wei-ya-nan
 * @version 1.0
 * @date 2022/3/1
 */
public interface CommentService {
    public void addComment(Comment comment);

    public void updateComment(Comment comment);

    public void deleteCommById(Integer id);

    public List<Comment> queryAll();

    public Comment queryOne(Integer id);

    public Page<Comment> page(Integer pageNo, Integer pageSize);
}
