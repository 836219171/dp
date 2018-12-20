package com.bm.dp.controller;

import com.bm.dp.service.BottomQueryService;
import com.bm.dp.vo.BaseDataVO;
import com.bm.dp.vo.PartTwoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wang Yongxin
 * @version V1.0
 * @Package com.bm.dp.controller
 * @Title:BottomQueryController
 * @Description:近一年平台访问量变化
 * @date 2018/9/28 21:21
 */
    @RestController
    public class BottomQueryController extends BaseController{
        @Autowired
        private BottomQueryService bottomQueryService;
        @RequestMapping("downQuery")
        public Object dwonQuery(){
            start();
            try{
                List<BaseDataVO> list = bottomQueryService.queryFwl();
                List<BaseDataVO> listOne = new ArrayList<>();
                for (BaseDataVO baseDataVO : list) {
                    String ym = baseDataVO.getMc();
                    String m = ym.substring(4,6);
                    BaseDataVO baseDataVO1 = new BaseDataVO();
                    baseDataVO1.setMc(m);
                    baseDataVO1.setSz(baseDataVO.getSz());
                    listOne.add(baseDataVO1);
                }
                PartTwoVO partTwoVO = new PartTwoVO();
                partTwoVO.setBlockOne(listOne);
                data(partTwoVO);
                return  success();
            }catch(Exception e){
                e.printStackTrace();
                return fail();
            }
        }
    }
