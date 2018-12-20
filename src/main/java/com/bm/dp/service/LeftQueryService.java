package com.bm.dp.service;

import com.bm.dp.vo.BaseDataVO;

import java.util.List;
import java.util.Map;

/**
 * @author LITAO
 * @version V1.0
 * @Package com.bm.dp.service
 * @Title:
 * @Description:
 * @date 2018/9/27 17:56
 */
public interface LeftQueryService {
//    List<BaseDataPercentVO>


    /**
     * 1.调解成功率
     * 2.及时响应率
     */
    List<BaseDataVO> mdxcqkLv();


    /**
     * 矛盾纠纷类型前五名
     */
    List<BaseDataVO> mdjflxSelect();


    /**
     * 矛盾纠纷来源
     */

    List<Map<String,Object>> mjflySelect();

    /**
     * 矛盾纠纷来源总数
     *
     */
    List<BaseDataVO> mdjflyAll();

    /**
     * 最优调解top10
     */

    List<BaseDataVO> zytjTopTen();



}
