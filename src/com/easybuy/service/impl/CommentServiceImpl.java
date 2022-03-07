package com.easybuy.service.impl;

import com.easybuy.dao.CommentDao;
import com.easybuy.dao.impl.CommentDaoImpl;
import com.easybuy.entity.Comment;
import com.easybuy.entity.Page;
import com.easybuy.service.CommentService;

import java.awt.print.Book;
import java.util.List;

/**
 * @author wei-ya-nan
 * @version 1.0
 * @date 2022/3/1
 */
public class CommentServiceImpl implements CommentService {
    private CommentDao commentDao = new CommentDaoImpl();
    @Override
    public void addComment(Comment comment) {
        commentDao.insertComment(comment);
    }

    @Override
    public void updateComment(Comment comment) {
        commentDao.updateComment(comment);
    }

    @Override
    public void deleteCommById(Integer id) {
            commentDao.deleteComment(id);
    }

    @Override
    public List<Comment> queryAll() {

        return commentDao.queryAll();
    }

    @Override
    public Comment queryOne(Integer id) {
        return commentDao.queryById(id);
    }

    @Override
    public Page<Comment> page(Integer pageNo, Integer pageSize) {
        Page<Comment> page = new Page<Comment>();

        // 设置每页显示的数量
        page.setPageSize(pageSize);
        // 求总记录数
        Integer pageTotalCount = commentDao.queryForPageTotalCount();
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
        List<Comment> items = commentDao.queryForPageItems(begin,pageSize);
        // 设置当前页数据
        page.setItems(items);

        return page;
    }

}
