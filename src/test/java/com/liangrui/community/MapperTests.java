package com.liangrui.community;

import com.liangrui.community.dao.DiscussPostMapper;
import com.liangrui.community.dao.UserMapper;
import com.liangrui.community.entity.DiscussPost;
import com.liangrui.community.entity.User;
import com.liangrui.community.util.HostHolder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.Date;
import java.util.List;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MapperTests {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DiscussPostMapper discussPostMapper;
    @Autowired
    private HostHolder hostHolder;

    @Test
    public void testSelectUser(){
        User user = userMapper.selectById(101);
        System.out.println(user);
    }

    @Test
    public void testselectDiscussPosts(){
        List<DiscussPost> discussPosts = discussPostMapper.selectDiscussPosts(149, 0, 10,0);
        for (DiscussPost d:discussPosts) {
            System.out.println(d);
        }

        int rows=discussPostMapper.selectDiscussPostRows(149);
        System.out.println(rows);
    }


    @Test
    public void test(){
        DiscussPost post = new DiscussPost();
        post.setUserId(138);
        post.setTitle("xuxuxuuuuuuuu");
        post.setContent("lrlrllrrlrlrlrl");
        post.setCreateTime(new Date());
        discussPostMapper.insertDiscussPost(post);
        System.out.println(discussPostMapper.selectDiscussPostRows(138));
    }
}
