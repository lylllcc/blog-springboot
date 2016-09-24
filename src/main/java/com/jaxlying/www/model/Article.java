package com.jaxlying.www.model;


import javax.persistence.*;

/**
 * Created by jaxlying on 2016/9/24.
 */
@Entity
@Table(name = "article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String title;
    private String body;

    private long createAt;
    private long updataAt;
    private long deleteAt = 0;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    /**
     *
     * @param title
     * @param body
     * @param createAt
     * @param updataAt
     * @param user
     */
    public Article(String title, String body, long createAt, long updataAt, User user) {
        this.title = title;
        this.body = body;
        this.createAt = createAt;
        this.updataAt = updataAt;
        this.user = user;
    }

    public Article(){

    }


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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
