package com.jaxlying.www.model;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    private int create_at;
    private int updata_at;
    private int delete_at;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "article",cascade = CascadeType.PERSIST)
    private List<Comment> commentList;

    public Article(){
        commentList = new ArrayList<>();
    }

    public void addComment(Comment comment){
        if(comment!=null){
            commentList.add(comment);
        }
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }
}
