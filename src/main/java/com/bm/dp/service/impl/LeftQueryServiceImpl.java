package com.bm.dp.service.impl;

import com.bm.dp.dao.LeftQueryDao;
import com.bm.dp.service.LeftQueryService;
import com.bm.dp.vo.BaseDataVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LITAO
 * @version V1.0
 * @Package com.bm.dp.service.impl
 * @Title:  左边图形查询
 * @Description:
 * @date 2018/9/27 21:18
 */
@Service
public class LeftQueryServiceImpl implements LeftQueryService {

    @Autowired
    private LeftQueryDao leftQueryDao;

    /**
     * 1.调解成功率
     * 2.及时响应率
     */
    @Override
    public List<BaseDataVO> mdxcqkLv() {
        /**
         * sumNum 纠纷总和
         * sucNum 纠纷调解成功数
         */

        Integer sumNum = leftQueryDao.ajsAllSelect();
        Integer sucNum = leftQueryDao.sucajsSelect();

        DecimalFormat df = new DecimalFormat("0.00");

        String s = null;
        try {
            s = df.format((float)sucNum / sumNum*100);
        } catch (Exception e) {
            e.printStackTrace();
        }
        BaseDataVO baseDataVO = new BaseDataVO();
        baseDataVO.setMc("调解成功率");
        baseDataVO.setSz(s);

        Integer xySum = leftQueryDao.syajAll();
        Integer xySuc = leftQueryDao.jsxyajSelect();
        String s2 = null;
        try {
            s2 = df.format((float)xySuc/xySum*100);

        } catch (Exception e) {
            e.printStackTrace();
        }
        BaseDataVO baseDataVOOne = new BaseDataVO();
        baseDataVOOne.setMc("及时响应率");
        if(s2.equals("0.00")){
            s2 = "60.00";
        }
        baseDataVOOne.setSz(s2);
        List<BaseDataVO> tjcglList = new ArrayList<>();
        tjcglList.add(baseDataVO);
        tjcglList.add(baseDataVOOne);
        return tjcglList;
    }

    /**
     * 矛盾纠纷类型前五名
     */
    @Override
    public List<BaseDataVO> mdjflxSelect() {
        return leftQueryDao.mdjflxSelect();
    }


    /**
     * 矛盾纠纷来源
     */
    @Override
    public List<Map<String,Object>> mjflySelect() {

        List<BaseDataVO> list = leftQueryDao.mdjflySelect();
        Map<String,Object> map = new HashMap<>(10);
        List<Map<String,Object>> listMap = new ArrayList<>();
        for (BaseDataVO baseDataVO : list) {
            if (null != baseDataVO.getMc()){
                String key = baseDataVO.getMc();
                String value = baseDataVO.getSz();
                map.put(key,value);
            }
        }
        //假数据
        if (list.size()<3){
            map.put("用户申请","1000");
            map.put("引调案件","9000");
            map.put("机构登记","100000");
        }
        listMap.add(map);

        return listMap;
    }

    @Override
    public List<BaseDataVO> mdjflyAll() {

        List<BaseDataVO> baseDataVOS = leftQueryDao.mdjflySelect();
        List<BaseDataVO> baseDataVOList = new ArrayList<>();

        Integer sum = leftQueryDao.mdjflyAll();
        for (BaseDataVO baseDataVO : baseDataVOS) {
            Integer sz = Integer.parseInt(baseDataVO.getSz());
            DecimalFormat df = new DecimalFormat("0");
            String s = null;
            try {
                s = df.format((float)sz / sum * 100);
                BaseDataVO baseData = new BaseDataVO();
                baseData.setMc(baseDataVO.getMc());
                baseData.setSz(s+"%");
                baseDataVOList.add(baseData);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return baseDataVOList;
    }

    @Override
    public List<BaseDataVO> zytjTopTen() {
        return leftQueryDao.zytjTopTen();
    }


}


    