package com.itheima.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.dao.PersonDao;
import com.itheima.domain.person;
import com.itheima.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl extends ServiceImpl<PersonDao, person> implements PersonService {
    @Autowired
    PersonDao pd;

    @Override
    public person checkByName(String name) {
        return pd.checkByName(name);
    }

    @Override
    public Boolean deleteByName(String name) {
        return pd.dropByName(name);
    }

    @Override
    public Boolean modifyById(Integer id,String name, String msg) {
        return pd.modifyById(id,name,msg);
    }
}
