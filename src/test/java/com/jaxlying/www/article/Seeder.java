package com.jaxlying.www.article;

import com.jaxlying.www.model.Article;
import com.jaxlying.www.model.Comment;
import com.jaxlying.www.model.User;
import com.jaxlying.www.repository.ArticleRepository;
import com.jaxlying.www.repository.CommentRepository;
import com.jaxlying.www.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by jaxlying on 2016/9/24.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Seeder {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    ArticleRepository articleRepository;

    @Test
    public void seeder(){
        for (int i = 0;i<10;i++){
            User user = new User();
            userRepository.save(user);
            long time = System.currentTimeMillis();
            Article article = new Article("til","body",time,time,user);
            Article article1 = new Article("til","body",time,time,user);
            articleRepository.save(article);
            articleRepository.save(article1);
            Comment comment = new Comment("body","email","nickname",time,time,article);
            Comment comment1 = new Comment("body","email","nickname",time,time,article);
            Comment comment2 = new Comment("body","email","nickname",time,time,article1);
            Comment comment3 = new Comment("body","email","nickname",time,time,article1);
            commentRepository.save(comment);
            commentRepository.save(comment1);
            commentRepository.save(comment2);
            commentRepository.save(comment3);
        }

    }
}
