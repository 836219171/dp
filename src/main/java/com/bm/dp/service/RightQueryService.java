package com.bm.dp.service;

import com.bm.dp.vo.BaseDataVO;
import java.util.List;

/**
 * @author Wang Yongxin
 * @version V1.0
 * @Package com.bm.dp.service
 * @Title: RightQueryService
 * @Description: TODO
 * @date 2018/9/28 09:05
 */
public interface RightQueryService {
    /**
     * 注册用户总数查询
     * @return
     */
    BaseDataVO queryUserNum();

    /**
     *查询性别比例
     * @return
     */
    List<BaseDataVO> querySexNum();

    /**
     * 查询用户地域分布
     * @return
     */
    List<BaseDataVO> queryUserArea();

    /**
     *服务机构数量统计
     * @return
     */
    BaseDataVO querySrvOrg();

    /**
     * 调解员数量统计
     * @return BaseDataVO
     */
    BaseDataVO queryMediNum();

    /**
     * 各调解机构调解成功率
     * @return
     */
    List<BaseDataVO> queryTwoTop();

    /**
     * 法官总数查询
     * @return
     */
    BaseDataVO queryLawerNum();

    /**
     * 咨询师总数查询
     * @return
     */
    BaseDataVO queryZxsNum();

    /**
     * 各地法官咨询师分布查询
     * @return
     */
    List<BaseDataVO> areaMediDist();

    /**
     *
     */
    BaseDataVO queryRgzxs();

    /**
     * 咨询量变化趋势
     */
    List<BaseDataVO> zxlQs();

    /**
     * 司法确认率查询
     */
    BaseDataVO judCaseNumRate();

    /**
     * 总案件数查询
     * @return
     */
    BaseDataVO queryCaseNum();

    /**
     * 诉讼案件率
     */
    BaseDataVO lowCaseRate();

    /**
     * 成功诉讼案件数
     */
    List<BaseDataVO> querySucNum();

    /**
     * 各地区失败诉讼案件数
     */
    List<BaseDataVO> queryFailNum();

    /**
     * 各地流程后续处理情况
     */
    List<BaseDataVO> hxclSitu();

    /**
     * 各地区司法确认数查询
     */
    List<BaseDataVO> queryAreaJudCaseNum();


    /**
     * 各地区诉讼确认数查询
     * @return
     */
    List<BaseDataVO> queryAreaLawNum();

    /**
     * 各地区总案件数查询
     */
    List<BaseDataVO> queryAreaSumCase();


    /**
     *近六个月人工咨询量
     */
    List<BaseDataVO> querySixMonthData();

    /**
     *近六个月人工咨询量
     */
    List<BaseDataVO> querySixMonthZNData();

    /**
     *
     * @return
     */
    List<BaseDataVO> queryTopMedia();

    /**
     * 智能咨询量查询
     */
    BaseDataVO queryZnzxl();



}
