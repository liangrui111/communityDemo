package com.liangrui.community.dao;

import com.liangrui.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {
    //有时会用都userId(某个用户个人主页) 有时用不到 所以时动态sql
    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit,int orderMode);//offset是每页起始行号 limit是每页数据量

    // @Param注解用于给参数取别名, 例如有的名字比较长写起来比较费事
    // 如果只有一个参数,并且在<if>里使用,则必须加别名.    动态的拼条件 并且只有一个参数时 一定要起别名
    int selectDiscussPostRows(@Param("userId") int userId);//查询总帖子的数量 后续分页的计算会用到

    int insertDiscussPost(DiscussPost discussPost);

    DiscussPost selectDiscussPostById(int id);

    int updateCommentCount(int id, int commentCount);

    int updateType(int id, int type);

    int updateStatus(int id, int status);

    int updateScore(int id, double score);

}
