package com.bm.dp.dao;

import com.bm.dp.vo.BaseDataSzVO;
import com.bm.dp.vo.BaseDataVO;
import com.bm.dp.vo.Histogram;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author LITAO
 * @version V1.0
 * @Package com.bm.dp.dao
 * @Title:
 * @Description:
 * @date 2018/9/28 14:21
 */
public interface UpQueryDao {


    /**
     * 全国案件来源
     */
    Integer qgajAll();


    /**
     * 各个省近12个月的案件数
     */
    List<BaseDataVO> allTwelevMonths();

    /**
     * 各个省近12个月的调解成功案件数
     */
    List<BaseDataVO> allSucTwelevMonths();

    /**
     * 各个省近12个月的调解各案件数  柱状图
     */

    List<Histogram> ajnumSelect();

    /**
     * 各个省近12个月的调解各案件数 评估量 仲裁量
     */
    List<BaseDataSzVO> pgzcLQuery();

    /**
     * 近12个月结案 收案 折线图
     */
    List<String> sNameSelect();

    List<BaseDataVO> saTwelevMonths(@Param("name") String name);

    List<BaseDataVO> jaTwelevMonths(@Param("name") String name);
}
