package com.itheima.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.domain.person;

public interface PersonService extends IService<person> {
    public person checkByName(String name);
    public Boolean deleteByName(String name);
    public Boolean modifyById(Integer id,String name,String msg);
}
