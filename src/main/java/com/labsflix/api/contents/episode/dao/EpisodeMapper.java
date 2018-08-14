package com.labsflix.api.contents.episode.dao;

import com.labsflix.api.contents.episode.vo.Episode;
import com.labsflix.api.contents.vo.Content;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EpisodeMapper {

    @Select("select * from contents where title like concat('%',#{title},'%')")
    @Results({
            @Result(property = "hasEpisodes", column = "has_episodes"),
            @Result(property = "regDate", column = "reg_date")
    })
    public List<Content> findByTitle(String title);

    @Select("select * from contents where id=#{id}")
    @Results({
            @Result(property = "hasEpisodes", column = "has_episodes"),
            @Result(property = "regDate", column = "reg_date")
    })
    public Content findById(String id);

    @Select("select * from episodes where content=#{content}")
    public List<Episode> findByContent(String content);

    @Select("select distinct season from episodes where content=#{content}")
    public List<Integer> findSeasonsByContent(String content);

    @Select("select * from episodes where content=#{content} and season=#{season}")
    public List<Episode> findByContentAndSeason(@Param("content") String content, @Param("season") int season);

    @Select("select * from episodes where content=#{content} and season=#{season} and episode=#{episode}")
    public Episode findOne(@Param("content") String content, @Param("season") int season, @Param("episode") int episode);

}