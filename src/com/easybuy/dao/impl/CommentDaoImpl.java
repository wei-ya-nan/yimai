package com.easybuy.dao.impl;

import com.easybuy.dao.CommentDao;
import com.easybuy.entity.Comment;

import java.util.List;

/**
 * @author wei-ya-nan
 * @version 1.0
 * @date 2022/3/1
 */
public class CommentDaoImpl extends BaseDao implements CommentDao {
    @Override
    public int updateComment(Comment comment) {
        String sql = "update easybuy_comment set EC_REPLY=?, " +
                "EC_REPLY_TIME=?, EC_NICK_NAME=?  where EC_ID = ?";
        return update(sql, comment.getReplay(), comment.getReplayDate(), comment.getName(), comment.getEcId());
    }

    @Override
    public int insertComment(Comment comment) {
        String sql = "insert into EASYBUY_COMMENT (EC_ID, EC_CONTENT, EC_CREATE_TIME, EC_REPLY, EC_REPLY_TIME, " +
                "EC_NICK_NAME) values (?, ? ,?, ?, ?,?)";
        return update(sql, comment.getEcId(), comment.getContent(), comment.getCreateDate(),
                comment.getReplay(), comment.getReplayDate(), comment.getName());
    }

    @Override
    public int deleteComment(Integer id) {
        String sql = "delete from EASYBUY_COMMENT where EC_ID = ?";
        return update(sql, id);
    }

    @Override
    public List<Comment> queryAll() {
        String sql = "select EC_ID ecId, EC_CONTENT content, EC_CREATE_TIME createDate, EC_REPLY replay, " +
                "EC_REPLY_TIME replayDate, EC_NICK_NAME name from easybuy_comment";
        return queryForList(Comment.class, sql);
    }

    @Override
    public Integer queryForPageTotalCount() {
        String sql = " select count(*) from easybuy_comment ";
        Number count = (Number) queryForSingleValue(sql);
        return count.intValue();
    }

    @Override
    public Comment queryById(Integer id) {
        String sql = "select EC_ID ecId, EC_CONTENT content, EC_CREATE_TIME createDate, EC_REPLY replay," +
                "EC_REPLY_TIME replayDate, EC_NICK_NAME name  from easybuy_comment where EC_ID = ?";
        return queryOne(sql, Comment.class, id);
    }

    @Override
    public List<Comment> queryForPageItems(int begin, Integer pageSize) {
        String sql = " select EC_ID ecId, EC_CONTENT content, EC_CREATE_TIME createDate, EC_REPLY replay, " +
                "EC_REPLY_TIME replayDate, EC_NICK_NAME name from easybuy_comment order by EC_CREATE_TIME desc " +
                "limit ?,?";
        return queryForList(Comment.class, sql, begin, pageSize);
    }
}
