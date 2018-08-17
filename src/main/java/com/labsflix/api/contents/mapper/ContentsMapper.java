package com.labsflix.api.contents.mapper;

import com.labsflix.api.domain.Content;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
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
