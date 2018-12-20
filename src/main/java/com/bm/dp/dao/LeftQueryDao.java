package com.bm.dp.dao;

import com.bm.dp.vo.BaseDataVO;

import java.util.List;

/**
 * @author LITAO
 * @version V1.0
 * @Package com.bm.dp.dao
 * @Title:  矛盾纠纷左侧图形
 * @Description:
 * @date 2018/9/27 16:56
 */
public interface LeftQueryDao {


    /**
     * 成功调解率
     * 1.案件总数
     * 2.成功案件数
     * @return Integer
     */
    Integer ajsAllSelect();

    Integer sucajsSelect();


    /**
     * 及时响应率
     * 0为及时响应案件
     * @return Integer
     */

    Integer jsxyajSelect();

    Integer syajAll();


    /**
     * 矛盾纠纷类型前五名
     * @return list
     */

    List<BaseDataVO> mdjflxSelect();

    /**
     * 矛盾纠纷来源
     * @return list
     */

    List<BaseDataVO> mdjflySelect();

    /**
     * 最优调解top10
     * @return list
     */
    List<BaseDataVO> zytjTopTen();

    /**
     * 矛盾纠纷来源总数
     * @return integer
     */

    Integer mdjflyAll();




}
