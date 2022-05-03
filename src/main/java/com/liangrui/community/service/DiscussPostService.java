package com.liangrui.community.service;

import com.liangrui.community.dao.DiscussPostMapper;
import com.liangrui.community.entity.DiscussPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussPostService {
    @Autowired
    private DiscussPostMapper discussPostMapper;

    public List<DiscussPost> findDiscussPost(int userId,int offset,int limit){
        return discussPostMapper.selectDiscussPosts(userId,offset,limit);
    }

    public int findDiscussPostRows(int userId){
        return discussPostMapper.selectDiscussPostRows(userId);
    }

    //帖子页面上面显示的是用户名 而不是userId
    //解决方案一：在sql语句时写一个关联查询
    //解决方案二：针对每个帖子discussPost单独的查询用户名
    //方案二有利于将来redis缓存数据
    //当然写在这里不合适 卸载UserMapper中

}
