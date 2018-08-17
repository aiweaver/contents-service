package com.labsflix.api.category.mapper;

import com.labsflix.api.domain.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CategoryMapper {

    @Select("select * from categories")
    List<Category> findAll();

    @Select("select * from categories where id=#{id}")
    Category findById(String id);

}