package com.itheima.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.domain.book;
import com.itheima.domain.qq;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BookDao extends BaseMapper<qq> {
    @Select("select password from qq where username=#{username}")
    public qq getByUsername(String username);
}
