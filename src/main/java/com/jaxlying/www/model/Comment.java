package com.jaxlying.www.model;

import javax.persistence.*;

/**
 * Created by jaxlying on 2016/9/24.
 */
@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String body;
    private String email;
    private String nickname;

    private long createAt;
    private long updataAt;
    private long deleteAt = 0;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

    /**
     *
     * @param body
     * @param email
     * @param nickname
     * @param createAt
     * @param updataAt
     * @param article
     */
    public Comment(String body, String email, String nickname, long createAt, long updataAt, Article article) {
        this.body = body;
        this.email = email;
        this.nickname = nickname;
        this.createAt = createAt;
        this.updataAt = updataAt;
        this.article = article;
    }

    public Comment(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(int createAt) {
        this.createAt = createAt;
    }

    public long getUpdataAt() {
        return updataAt;
    }

    public void setUpdataAt(int updataAt) {
        this.updataAt = updataAt;
    }

    public long getDeleteAt() {
        return deleteAt;
    }

    public void setDeleteAt(int deleteAt) {
        this.deleteAt = deleteAt;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
