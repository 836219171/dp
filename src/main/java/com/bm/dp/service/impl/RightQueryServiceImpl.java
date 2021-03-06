package com.bm.dp.service.impl;

import com.bm.dp.dao.RightQueryDao;
import com.bm.dp.service.RightQueryService;
import com.bm.dp.vo.BaseDataVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

/**
 * @author Wang Yongxin
 * @version V1.0
 * @Package com.bm.dp.service.impl
 * @Title: RightQueryServiceImpl
 * @Description: TODO
 * @date 2018/9/28 09:05
 */
@Service
public class RightQueryServiceImpl implements RightQueryService {
    private final int MOD = 5;

    /**
     * Dao层对象注入
     */
    @Autowired
    private RightQueryDao rightQueryDao;

    /**
     * 注册用户总数查询
     *
     * @return BaseDataVO
     */
    @Override
    public BaseDataVO queryUserNum() {
        return rightQueryDao.loginUserCount();
    }

    /**
     * 查询性别比例
     *
     * @return List<BaseDataVO>
     */
    @Override
    public List<BaseDataVO> querySexNum() {
        BaseDataVO db = this.queryUserNum();
        List<BaseDataVO> sexNum = rightQueryDao.StastSex();
        List<BaseDataVO> result = new ArrayList<>();
            for (BaseDataVO bd : sexNum) {
                //将非法数值过滤
                if(bd.getMc().equals("男") || bd.getMc().equals("女")) {
                    float bfb = Float.parseFloat(bd.getSz()) / Float.parseFloat(db.getSz()) * 100;
                    bd.setSz(String.format("%.0f", bfb));
                    result.add(bd);
                }
         }
         //如果数据库中没有查出性别数据、只有男或者只有女则都显示0
         if(result.size() != 2){
             BaseDataVO manNum = new BaseDataVO();
             BaseDataVO womenNum = new BaseDataVO();
             manNum.setMc("男");
             manNum.setSz("0");
             womenNum.setMc("女");
             womenNum.setSz("0");
             List<BaseDataVO> virList = new ArrayList<>();
             virList.add(manNum);
             virList.add(womenNum);
             return virList;
         }
        return result;
     }

    /**
     * 查询用户地域分布
     *
     * @return List<BaseDataVO>
     */
    @Override
    public List<BaseDataVO> queryUserArea() {
        List<BaseDataVO> userArea = rightQueryDao.UserAreaQuery();
        for(BaseDataVO bd : userArea){
            if(bd.getMc() == null || bd.getMc() == "") {
                bd.setMc("浙江");
            }
        }
        return userArea;
    }

    /**
     * 服务机构数量统计
     *
     * @return BaseDataVO
     */
    @Override
    public BaseDataVO querySrvOrg() {
        return rightQueryDao.SrvOrgQeury();
    }

    /**
     * 调解员数量统计
     *
     * @return BaseDataVO
     */
    @Override
    public BaseDataVO queryMediNum() {
        return rightQueryDao.mediNumQeury();
    }

    /**
     * 两种Top5查询
     *
     * @return List<BaseDataVO>
     */
    @Override
    public List<BaseDataVO> queryTwoTop() {
        List<BaseDataVO> orgCaseNum = rightQueryDao.mediaCaseNumQuery();
        List<BaseDataVO> orgSucNum = rightQueryDao.mediaSucNumQuery();
        List<BaseDataVO> resultList = new ArrayList<>();
        float sucRate = 0;
        for (int i = 0; i < orgCaseNum.size(); i++) {
            BaseDataVO orgCase = orgCaseNum.get(i);
            BaseDataVO orgSuc = orgSucNum.get(i);
            if(Float.parseFloat(orgCase.getSz()) ==0 ) {
                sucRate = 0;
            }
            else {
                try {
                    sucRate = Float.parseFloat(orgSuc.getSz()) / Float.parseFloat(orgCase.getSz()) * 100;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            BaseDataVO result = new BaseDataVO();
            result.setMc(orgCase.getMc());
            result.setSz(String.format("%.0f", sucRate));
            resultList.add(result);
        }
        //按照调解成功率为各机构排序
        Collections.sort(resultList, new Comparator<BaseDataVO>() {
            @Override
            public int compare(BaseDataVO o1, BaseDataVO o2) {
                return Integer.parseInt(o2.getSz()) - Integer.parseInt(o1.getSz());
            }
        });
        if (resultList.size() > 5) {
            resultList = resultList.subList(0, 5);
        }
        for (BaseDataVO bdv : resultList) {
            bdv.setSz(bdv.getSz() );
        }
        List<BaseDataVO> list = this.queryTopMedia();
        for(BaseDataVO bdv: list){
            resultList.add(bdv);
        }
        return resultList;
    }

    /**
     * 法官数量查询
     * @return
     */
    @Override
    public BaseDataVO queryLawerNum() {
        return rightQueryDao.lawerNumQuery();
    }

    /**
     * 咨询师数量查询
     * @return
     */
    @Override
    public BaseDataVO queryZxsNum() {
        return rightQueryDao.zxsNumQuery();
    }

    /**
     * 各地法官咨询师分布
     * @return
     */
    @Override
    public List<BaseDataVO> areaMediDist() {
        List<BaseDataVO> gdfg = rightQueryDao.areaLawerNumQuery();
        List<BaseDataVO> gdxl = rightQueryDao.areaXlNumQuery();
        List<BaseDataVO> gdfl = rightQueryDao.areaflNumQuery();
        List<BaseDataVO> resultList = new ArrayList<>();
        for (int i = 0; i < gdfg.size(); i++) {

            BaseDataVO bdv = new BaseDataVO();
            bdv.setMc(gdfg.get(i).getMc());
            bdv.setSz(gdxl.get(i).getSz()+","+gdfg.get(i).getSz()+","+gdfl.get(i).getSz());
            resultList.add(bdv);
        }
        List<BaseDataVO> returnList = new ArrayList<>();
        for(BaseDataVO bdv : resultList){
            if(bdv.getMc().equals("云南") || bdv.getMc().equals("北京市") || bdv.getMc().equals("浙江省")){
                returnList.add(bdv);
            }
        }
        return returnList;
    }

    @Override
    public BaseDataVO queryRgzxs() {
        return rightQueryDao.rgzxNumQuery();
    }

    /**
     * 自选量变化趋势
     * @return mlxt12#D
     */
    @Override
    public List<BaseDataVO> zxlQs() {
        List<BaseDataVO> resultList = new ArrayList<>();
        BaseDataVO hzb = new BaseDataVO();
        BaseDataVO rgData = new BaseDataVO();
        BaseDataVO znData = new BaseDataVO();
        String[] month={"一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"};
        Calendar cale = null;
        cale = Calendar.getInstance();
        int curMonth = cale.get(Calendar.MONTH);
        int startMonth;
        if(curMonth - MOD >0) {
            startMonth = curMonth - MOD;
        }else {
            startMonth = 7 + curMonth;
        }
        String resultMonth="";
        for(int i = startMonth;i < startMonth + (MOD + 1) ; i++) {
            resultMonth += month[i % 12] ;
            if(i!=startMonth+5)
            {resultMonth+=",";}
        }
        hzb.setMc("横坐标");
        hzb.setSz(resultMonth);
        List<BaseDataVO> rsList = this.querySixMonthData();
        String rgValue="";
        for(int i=0;i<rsList.size();i++)
        {
            rgValue+=rsList.get(i).getSz();
            if(i!=rsList.size()-1) {
                rgValue += ",";
            }
        }
        rgData.setMc("人工咨询量数据");
        rgData.setSz(rgValue);
        rsList = this.querySixMonthZNData();
        String znValue = "";
        for(int i=0;i<rsList.size();i++)
        {
            znValue+=rsList.get(i).getSz();
            if(i!=rsList.size()-1) {
                znValue += ",";
            }
        }
        znData.setMc("智能咨询量数据");
        znData.setSz(znValue);
        resultList.add(hzb);
        resultList.add(rgData);
        resultList.add(znData);
        return resultList;
    }

    /**
     * 申请司法确认率
     * @return BaseDataVO
     */
    @Override
    public BaseDataVO judCaseNumRate() {
        BaseDataVO sumNum = this.queryCaseNum();
        BaseDataVO judNum = rightQueryDao.judCaseNumQuery();
        BaseDataVO result = new BaseDataVO();
        float judRate = 0;
        if(judNum.getSz() != null) {
            judRate = Float.parseFloat(judNum.getSz()) / Float.parseFloat(sumNum.getSz()) * 100;
        }
        else{
            judRate = 0 ;
        }

        result.setMc("申请司法确认率");
        result.setSz(String.format("%.2f",judRate));
        return result;
    }


    /**
     * 申请诉讼确认率
     * @return BaseDataVO
     */
    @Override
    public BaseDataVO lowCaseRate() {
        BaseDataVO sumNum = this.queryCaseNum();
        BaseDataVO lowCaseNum = rightQueryDao.lawNumQuery();
        BaseDataVO result = new BaseDataVO();
        float judRate = 0;
        if(lowCaseNum.getSz() != null) {
            judRate = Float.parseFloat(lowCaseNum.getSz()) / Float.parseFloat(sumNum.getSz()) * 100;
        }else{
            judRate = 0;
        }
        result.setMc("申请诉讼确认率");
        result.setSz(String.format("%.2f",judRate));
        return result;
    }

    /**
     * 总案件数
     * @return
     */
    @Override
    public BaseDataVO queryCaseNum() {
        return rightQueryDao.caseNumQuery();
    }

    /**
     * 成功案件数
     * @return
     */
    @Override
    public List<BaseDataVO> querySucNum() {
        return rightQueryDao.sucNumQuery();
    }

    /**
     * 失败案件数
     * @return
     */
    @Override
    public List<BaseDataVO> queryFailNum() {
        return rightQueryDao.failNumQuery();
    }

    /**
     * 各地区司法确认数
     * @return
     */
    @Override
    public List<BaseDataVO> queryAreaJudCaseNum() {
        float sumCaseNum = Float.parseFloat(this.queryCaseNum().getSz());
        List<BaseDataVO> resultList = rightQueryDao.areaJudCaseNumQuery();
        for(BaseDataVO bdv : resultList)
        {
            float rate =(Float.parseFloat(bdv.getSz())/sumCaseNum)*100;
            String result = String.format("%.2f",rate);
            bdv.setSz(result);
        }
        return resultList;
    }

    /**
     * 各地区诉讼确认数
     * @return
     */
    @Override
    public List<BaseDataVO> queryAreaLawNum() {
        float sumCaseNum = Float.parseFloat(this.queryCaseNum().getSz());
        List<BaseDataVO> resultList = rightQueryDao.areaLawNumQuery();
        for(BaseDataVO bdv : resultList)
        {
            if (bdv != null && bdv.getSz() != null){
                float rate =(Float.parseFloat(bdv.getSz())/sumCaseNum)*100;
                String result = String.format("%.2f",rate);
                bdv.setSz(result);
            }
        }
        return resultList;
    }

    /**
     *
     * @return
     */
    @Override
    public List<BaseDataVO> hxclSitu() {
        List<BaseDataVO> sucNum = rightQueryDao.sucNumQuery();
        List<BaseDataVO> failNum = rightQueryDao.failNumQuery();
        List<BaseDataVO> judNum = this.queryAreaJudCaseNum();
        List<BaseDataVO> lawNum =this.queryAreaLawNum();
        List<BaseDataVO> resultList = new ArrayList<>();
        for(int i=0;i<sucNum.size();i++){
            BaseDataVO result = new BaseDataVO();
            if(sucNum.get(i).getMc() == null || sucNum.get(i).getMc() == ""){
                result.setMc("舟山市");
            }
            else{
            result.setMc(sucNum.get(i).getMc());}
            result.setSz(sucNum.get(i).getSz()+","+failNum.get(i).getSz()+","+judNum.get(i).getSz()+","+lawNum.get(i).getSz());
            resultList.add(result);
        }
        Collections.sort(resultList, new Comparator<BaseDataVO>() {
            @Override
            public int compare(BaseDataVO o1, BaseDataVO o2) {
                String[] valueO1 = o1.getSz().split(",");
                String[] valueO2 = o2.getSz().split(",");
                return -(Integer.parseInt(valueO1[0])+Integer.parseInt(valueO1[1])-Integer.parseInt(valueO2[0])-Integer.parseInt(valueO2[1]));
            }
        });
        if (resultList.size() > 5) {
            resultList = resultList.subList(0, 5);
        }
        return resultList;
    }

    /**
     * 各地区总案件数
     * @return BaseDataVO
     */
    @Override
    public List<BaseDataVO> queryAreaSumCase() {
        return rightQueryDao.areaSumCaseQuery();
    }

    /**
     * 近六个月数据查询
     * @return BaseDataVO
     */
    @Override
    public List<BaseDataVO> querySixMonthData() {
                return rightQueryDao.sixMonDataQuery();
    }

    /**
     * 近六个月智能咨询量
     * @return
     */
    @Override
    public List<BaseDataVO> querySixMonthZNData() {
        return rightQueryDao.sixMonZNDataQuery();
    }

    /**
     * 金牌调解员
     * @return BaseDataVO
     */
    @Override
    public List<BaseDataVO> queryTopMedia() {
        return rightQueryDao.bestMediaQuery();
    }


    @Override
    public BaseDataVO queryZnzxl() {
        return rightQueryDao.znzxlQuery();
    }
}
