package com.bm.dp.service.impl;


import com.bm.dp.dao.UpQueryDao;
import com.bm.dp.service.UpQueryService;
import com.bm.dp.vo.BaseDataObjectVO;
import com.bm.dp.vo.BaseDataSzVO;
import com.bm.dp.vo.BaseDataVO;
import com.bm.dp.vo.Histogram;
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
 * @Title:
 * @Description:
 * @date 2018/9/28 14:22
 */
@Service
public class UpQueryServiceImpl implements UpQueryService {



    @Autowired
    private UpQueryDao upQueryDao;



    /**
     * 全国调解案件量
     */
    @Override
    public BaseDataVO sumCaseNum() {
        Integer sum = upQueryDao.qgajAll();
        BaseDataVO baseDataVO = new BaseDataVO();
        baseDataVO.setSz(sum.toString());
        baseDataVO.setMc("全国调解案件量");
        return baseDataVO;
    }


    /**
     * 各个省的案件数，和调解成功率
     */
    @Override
    public List<Map<String,Object>> allTwelevMonths() {

        List<BaseDataVO> sumList = upQueryDao.allTwelevMonths();
        List<BaseDataVO> sucList = upQueryDao.allSucTwelevMonths();
        Map<String,Object> map1 = new HashMap<>();
        Map<String,Object> map2 = new HashMap<>();

        DecimalFormat df = new DecimalFormat("0.00");

        List<Map<String,Object>> list = new ArrayList<>();
        for(int i=0 ;i < sucList.size() ;i++){
            Integer sum =Integer.parseInt( sumList.get(i).getSz());
            String name = sumList.get(i).getMc();
            if(name != null && (name.equals("北京市") || name.equals("云南省") || name.equals("浙江省"))){
                BaseDataVO baseDataVO = new BaseDataVO();
                baseDataVO.setSz(sum.toString());
                baseDataVO.setMc("调解案件量");
                map1.put(name,baseDataVO);
                Integer sucNum = Integer.parseInt(sucList.get(i).getSz());
                String s = null;
                try {
                    s = df.format((float) sucNum / sum * 100);
                    BaseDataVO baseDataOne1 = new BaseDataVO();
                    baseDataOne1.setMc("调解成功率");
                    baseDataOne1.setSz(s);
                    map2.put(name,baseDataOne1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        list.add(map1);
        list.add(map2);
        return list;
    }


    @Override
    public List<Map<String, Object>> everyHistogram() {

        List<Histogram> list = upQueryDao.ajnumSelect();
        List<BaseDataSzVO> list1 = upQueryDao.pgzcLQuery();
        Map<String,Object> map = new HashMap<>();

        List<Map<String, Object>> mapList = new ArrayList<>();

        for(int i = 0;i<list.size();i++){
            for(int j = 0; j<list1.size();j++){
                String mcname = list.get(i).getMc();
                if (list.get(i).getMc()!=null &&
                        list1.get(j)!= null &&
                        list.get(i).getMc().equals(list1.get(j).getMc()) &&
                        (mcname.equals("云南省") || mcname.equals("浙江省") || mcname.equals("北京市"))
 ){
                    List<String> listNum = new ArrayList<>();
                    listNum.add(list.get(i).getOne());
                    listNum.add(list.get(i).getTwo());
                    listNum.add(list.get(i).getThree());
                    listNum.add(list.get(i).getFour());
                    listNum.add(list1.get(j).getSz());
                    listNum.add("128");

                    List<String> listMc = new ArrayList<>();
                    listMc.add("调解成功案件量");
                    listMc.add("调解失败案件量");
                    listMc.add("诉讼案件量");
                    listMc.add("司法确认案件量");
                    listMc.add("评估案件量");
                    listMc.add("仲裁案件量");



                    BaseDataObjectVO baseDataObjectVO  = new BaseDataObjectVO();
                    baseDataObjectVO.setMc(listMc);
                    baseDataObjectVO.setSz(listNum);
                    String name = list.get(i).getMc();
                    if(name != null){
                        map.put(name,baseDataObjectVO);
                    }
                }
            }

        }
        mapList.add(map);
        return mapList;
    }

    @Override
    public List<Map<String, Object>> zxPicture() {

        List<String> name = upQueryDao.sNameSelect();
        Map<String,Object> map = new HashMap<>();
        List<Map<String, Object>> res = new ArrayList<>();
        for (String s : name) {
            if(s != null &&(s.equals("北京市") || s.equals("云南省") || s.equals("浙江省"))){
                List<BaseDataVO> list = upQueryDao.saTwelevMonths(s);
                List<String> list1 = new ArrayList<>();
                List<String> list2 = new ArrayList<>();
                for (BaseDataVO baseDataVO : list) {
                    String month = baseDataVO.getMc().substring(4,6);
                    Integer monthNum = Integer.parseInt(month);
                    String num = baseDataVO.getSz();
                    BaseDataObjectVO baseDataObjectVO = new BaseDataObjectVO();
                    list1.add(monthNum+"月");
                    list2.add(num);
                    baseDataObjectVO.setSz(list2);
                    baseDataObjectVO.setMc(list1);
                    map.put(s,baseDataObjectVO);
                }
            }

        }
        res.add(map);
        return res;
    }

    @Override
    public List<Map<String, Object>> jaPicture() {
        List<String> name = upQueryDao.sNameSelect();
        Map<String,Object> map = new HashMap<>();
        List<Map<String, Object>> res = new ArrayList<>();

        for (String s : name) {
            if(s != null && (s.equals("北京市") || s.equals("云南省") || s.equals("浙江省"))){
                List<BaseDataVO> list = upQueryDao.jaTwelevMonths(s);
                List<String> list1 = new ArrayList<>();
                List<String> list2 = new ArrayList<>();
                for (BaseDataVO baseDataVO : list) {
                    String month = baseDataVO.getMc().substring(4,6);
                    Integer monthNum = Integer.parseInt(month);
                    String num = baseDataVO.getSz();
                    BaseDataObjectVO baseDataObjectVO = new BaseDataObjectVO();
                    list1.add(monthNum+"月");
                    list2.add(num);
                    baseDataObjectVO.setSz(list2);
                    baseDataObjectVO.setMc(list1);
                    map.put(s,baseDataObjectVO);
                }
            }

        }
        res.add(map);
        return res;
    }
}


    