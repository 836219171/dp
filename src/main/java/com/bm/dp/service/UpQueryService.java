package com.bm.dp.service;

import com.bm.dp.vo.BaseDataVO;

import java.util.List;
import java.util.Map;

/**
 * @author LITAO
 * @version V1.0
 * @Package com.bm.dp.service
 * @Title: 地图上半区
 * @Description:
 * @date 2018/9/28 14:17
 */
public interface UpQueryService {

    /**
     * 全国调解案件量
     */
    BaseDataVO sumCaseNum();


    /**
     * 近12个月的调解案件数 调解成功率
     */

    List<Map<String,Object>> allTwelevMonths();

    /**
     * 各省柱状图
     */

    List<Map<String,Object>> everyHistogram();
    /**
     * 各省折线图
     * 1.收案
     * 2.结案
     */
    List<Map<String,Object>> zxPicture();


    List<Map<String,Object>> jaPicture();
}
