package com.example.model;

import javax.persistence.*;

/**
 * Created by lylllcc on 2016/12/13.
 */

@Entity
@Table(name = "blog_article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String title;

    private String body;

    private long createTime;

    private long updataTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getUpdataTime() {
        return updataTime;
    }

    public void setUpdataTime(long updataTime) {
        this.updataTime = updataTime;
    }
}
