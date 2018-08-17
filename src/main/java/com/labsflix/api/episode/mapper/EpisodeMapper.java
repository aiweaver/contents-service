package com.labsflix.api.episode.mapper;

import com.labsflix.api.domain.Episode;
import com.labsflix.api.domain.Content;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EpisodeMapper {

    @Select("select * from contents where title like concat('%',#{title},'%')")
    @Results({
            @Result(property = "hasEpisodes", column = "has_episodes"),
            @Result(property = "regDate", column = "reg_date")
    })
    List<Content> findByTitle(String title);

    @Select("select * from contents where id=#{id}")
    @Results({
            @Result(property = "hasEpisodes", column = "has_episodes"),
            @Result(property = "regDate", column = "reg_date")
    })
    Content findById(String id);

    @Select("select * from episodes where content=#{content}")
    List<Episode> findByContent(String content);

    @Select("select distinct season from episodes where content=#{content}")
    List<Integer> findSeasonsByContent(String content);

    @Select("select * from episodes where content=#{content} and season=#{season}")
    List<Episode> findByContentAndSeason(@Param("content") String content, @Param("season") int season);

    @Select("select * from episodes where content=#{content} and season=#{season} and episode=#{episode}")
    Episode findOne(@Param("content") String content, @Param("season") int season, @Param("episode") int episode);

}