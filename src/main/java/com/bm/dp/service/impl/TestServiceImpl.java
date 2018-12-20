package com.bm.dp.service.impl;

import com.bm.dp.dao.TestDao;
import com.bm.dp.pojo.UserReg;
import com.bm.dp.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xiao liang
 * @version V1.0
 * @Package com.bm.dp.service.impl
 * @Title: TestServiceImpl
 * @Description: TODO
 * @date 2018/9/25 9:34
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestDao testDao;

    @Override
    public List<UserReg> test() {
        return testDao.test();
    }
}
