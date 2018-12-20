package com.bm.dp.controller;

import com.bm.dp.service.UpQueryService;
import com.bm.dp.vo.BaseDataVO;
import com.bm.dp.vo.PartThreeVO;
import com.bm.dp.vo.ResultTypeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author LITAO
 * @version V1.0
 * @Package com.bm.dp.controller
 * @Title:
 * @Description:
 * @date 2018/9/28 14:22
 */
@RestController
public class UpQueryController extends BaseController{

    @Autowired
    private UpQueryService upQueryService;


    @GetMapping("upQuery")
    public Object upQuery(){
        start();
        try{

            BaseDataVO baseDataVO = upQueryService.sumCaseNum();
            ResultTypeVO resultTypeVO = new ResultTypeVO();
            resultTypeVO.setResultOne(baseDataVO);
            PartThreeVO partThreeVO = new PartThreeVO();
            partThreeVO.setBlockOne(baseDataVO);

            /**
             * 近12个月的调解案件数 调解成功率
             */
            List<Map<String,Object>> list  = upQueryService.allTwelevMonths();
            partThreeVO.setBlockTwo(list);

            /**
             * 近12个月的调解案件数 柱状图
             */

            List<Map<String,Object>> list1 = upQueryService.everyHistogram();
            partThreeVO.setBlockThree(list1);


//            折线图
            List<Map<String,Object>> list2 = upQueryService.zxPicture();
            partThreeVO.setBlockFour(list2);

            List<Map<String,Object>> list3 = upQueryService.jaPicture();
            partThreeVO.setBlockFive(list3);

            data(partThreeVO);
            return  success();
        }catch(Exception e){
            e.printStackTrace();
            return fail();
        }

    }

}


    