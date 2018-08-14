package com.labsflix.api.category.dao;

import com.labsflix.api.category.vo.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CategoryMapper {

    @Select("select * from categories")
    List<Category> findAll();

    @Select("select * from categories where id=#{id}")
    Category findById(String id);

}