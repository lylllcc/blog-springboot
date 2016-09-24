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

    private int create_at;
    private int updata_at;
    private int delete_at;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;


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

    public int getCreate_at() {
        return create_at;
    }

    public void setCreate_at(int create_at) {
        this.create_at = create_at;
    }

    public int getUpdata_at() {
        return updata_at;
    }

    public void setUpdata_at(int updata_at) {
        this.updata_at = updata_at;
    }

    public int getDelete_at() {
        return delete_at;
    }

    public void setDelete_at(int delete_at) {
        this.delete_at = delete_at;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
