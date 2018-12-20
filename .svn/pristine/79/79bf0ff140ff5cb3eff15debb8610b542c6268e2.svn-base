package com.bm.dp.service.impl;

import com.bm.dp.dao.BottomQueryDao;
import com.bm.dp.service.BottomQueryService;
import com.bm.dp.vo.BaseDataVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BottomQueryServiceImpl implements BottomQueryService {
    @Autowired
    private BottomQueryDao bottomQueryDao;

    @Override
    public List<BaseDataVO> queryFwl() {
        return bottomQueryDao.fwlSelcet();
    }
}
