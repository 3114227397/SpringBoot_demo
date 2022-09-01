package com.itheima.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.dao.WorkerDao;
import com.itheima.domain.worker;
import com.itheima.service.WorkerService;
import org.springframework.stereotype.Service;

@Service
public class WorkerServiceImpl extends ServiceImpl<WorkerDao, worker> implements WorkerService {


}
