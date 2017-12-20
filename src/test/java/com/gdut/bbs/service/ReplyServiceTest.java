package com.gdut.bbs.service;

import com.gdut.bbs.JUnit4ClassRunner;
import com.gdut.bbs.domain.Reply;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

@RunWith(JUnit4ClassRunner.class)
@ContextConfiguration("classpath:config/spring/application-context.xml")
public class ReplyServiceTest {

    @Autowired
    public ReplyService replyService;

    @Test
    public void selectList(){
        List<Reply> replyList = replyService.selectList(30,1);
        for (Reply reply : replyList) {
            System.out.println(reply.getContent());
        }
    }
}
