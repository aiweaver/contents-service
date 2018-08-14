package com.labsflix.api.contents.dao;

import com.labsflix.api.contents.vo.Content;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ContentsMapper {

    @Select("select * from contents where category=#{category}")
    @Results({
            @Result(property = "hasEpisodes", column = "has_episodes"),
            @Result(property = "regDate", column = "reg_date")
    })
    List<Content> findByCategory(String category);

    @Insert("insert into contents(category, title, grade, poster, stillcut, rate, year, summary, video, runtime, has_episodes, view, reg_date) values (#{category}, #{title}, #{grade}, #{poster}, #{stillcut}, #{rate}, #{year}, #{summary}, #{video}, #{runtime}, #{hasEpisodes}, #{view}, #{regDate})")
    int insertContent(Content content);

}
