package com.liangrui.community.controller;

import com.liangrui.community.dao.DiscussPostMapper;
import com.liangrui.community.dao.UserMapper;
import com.liangrui.community.entity.DiscussPost;
import com.liangrui.community.entity.Page;
import com.liangrui.community.entity.User;
import com.liangrui.community.service.DiscussPostService;
import com.liangrui.community.service.LikeService;
import com.liangrui.community.service.UserService;
import com.liangrui.community.util.CommunityConstant;
import org.apache.ibatis.annotations.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController implements CommunityConstant {
    @Autowired
    private DiscussPostService discussPostService;

    @Autowired
    private UserService userService;

    @Autowired
    private LikeService likeService;

    @RequestMapping(path = "/index",method = RequestMethod.GET)
    public String getIndexPage(Model model, Page page){
        //Model和Page都是dispathseverlet帮我们初始化的 它还会自动把page装到model中

        page.setRows(discussPostService.findDiscussPostRows(0));
        page.setPath("/index");//复用路径


        List<DiscussPost> list = discussPostService.findDiscussPost(0, page.getOffset(), page.getLimit());
        List<Map<String,Object>> discussPosts=new ArrayList<>();//重新组合一个帖子包含用户名 map存放用户和帖子对象
        if(list!=null){
            for(DiscussPost post:list){
                Map<String,Object> map=new HashMap<>();
                map.put("post",post);
                User user = userService.findUserById(post.getUserId());
                map.put("user",user);
                long likeCount = likeService.findEntityLikeCount(ENTITY_TYPE_POST, post.getId());
                map.put("likeCount",likeCount);
                discussPosts.add(map);
            }
        }
        model.addAttribute("discussPosts",discussPosts);

        return "/index";
    }


    @RequestMapping(path = "/error", method = RequestMethod.GET)
    public String getErrorPage() {
        return "/error/500";
    }
}
