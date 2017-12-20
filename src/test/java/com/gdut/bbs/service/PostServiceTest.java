package com.gdut.bbs.service;

import com.gdut.bbs.JUnit4ClassRunner;
import com.gdut.bbs.domain.Post;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@RunWith(JUnit4ClassRunner.class)
@ContextConfiguration("classpath:config/spring/application-context.xml")
public class PostServiceTest{

    @Autowired
    private PostService postService;

    @Test
    public void addWatchCountTest(){
        Post post = new Post();
        post.setPid(1);
        postService.addWatchCount(post);
    }
}
