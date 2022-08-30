package com.itheima.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.domain.book;
import com.itheima.domain.music;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookDao extends BaseMapper<book> {
//    @Select("select * from music where id=#{id}")
//    public Book getById(Integer id);
}
