package com.jaxlying.www.model;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jaxlying on 2016/9/24.
 */
@Entity
@Table(name = "user")
public class User  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String nickname;
    private String password;
    private String email;

    @OneToMany(mappedBy = "user",cascade={CascadeType.PERSIST})
    private List<Article> articleList;

    public void addArticle(Article article){
        if(article!=null)
            articleList.add(article);
    }

    public User(){
        articleList = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }
}
