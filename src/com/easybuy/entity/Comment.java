package com.easybuy.entity;

import java.sql.Date;

/**
 * @author wei-ya-nan
 * @version 1.0
 * @date 2022/3/1
 */
public class Comment {
    private Integer ecId;
    private String content;
    private Date createDate;
    private String replay;
    private Date replayDate;
    private String name;

    public Comment() {
    }

    public Comment(Integer ecId, String content, Date createDate, String replay, Date replayDate, String name) {
        this.ecId = ecId;
        this.content = content;
        this.createDate = createDate;
        this.replay = replay;
        this.replayDate = replayDate;
        this.name = name;
    }

    public Integer getEcId() {
        return ecId;
    }

    public void setEcId(Integer ecId) {
        this.ecId = ecId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getReplay() {
        return replay;
    }

    public void setReplay(String replay) {
        this.replay = replay;
    }

    public Date getReplayDate() {
        return replayDate;
    }

    public void setReplayDate(Date replayDate) {
        this.replayDate = replayDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "ecId=" + ecId +
                ", content='" + content + '\'' +
                ", createDate=" + createDate +
                ", replay='" + replay + '\'' +
                ", replyDate=" + replayDate +
                ", name='" + name + '\'' +
                '}';
    }
}
