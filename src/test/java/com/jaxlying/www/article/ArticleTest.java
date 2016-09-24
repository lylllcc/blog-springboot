package com.jaxlying.www.article;

import com.jaxlying.www.model.Article;
import com.jaxlying.www.model.Comment;
import com.jaxlying.www.model.User;
import com.jaxlying.www.repository.ArticleRepository;
import com.jaxlying.www.repository.CommentRepository;
import com.jaxlying.www.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.PortableInterceptor.Interceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest

/**
 * Created by jaxlying on 2016/9/24.
 */
public class ArticleTest {

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CommentRepository commentRepository;

    @Test
    public void testMantToone(){


        User user = userRepository.findOne(1);
       Iterable<Article> li = articleRepository.findByUser(user);
       Iterator<Article> ll = li.iterator();
        while(ll.hasNext()){
            Article ar = ll.next();
            System.out.println(ar.getBody());
        }
    }

    @Test
    public void testModel(){
        Article article = new Article();
        User user = new User();
        Comment comment = new Comment();
        article.setUser(user);
        comment.setArticle(article);
        article.setBody("2333");
        user.addArticle(article);
        article.addComment(comment);
        userRepository.save(user);
    }
}
