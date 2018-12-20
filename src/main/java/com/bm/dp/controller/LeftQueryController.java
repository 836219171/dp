package com.bm.dp.controller;

import com.bm.dp.pojo.UserReg;
import com.bm.dp.service.LeftQueryService;
import com.bm.dp.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


/**
 * @author LITAO
 * @version V1.0
 * @Package com.bm.dp.controller
 * @Title:
 * @Description:
 * @date 2018/9/27 21:21
 */
@RestController
public class LeftQueryController extends BaseController{

    @Autowired
    private LeftQueryService leftQueryService;

    @GetMapping("leftQuery")
    public Object leftQuery(){
        start();
        try{

           List<BaseDataVO> tjcglList = leftQueryService.mdxcqkLv();
           List<BaseDataVO> mdjflxList = leftQueryService.mdjflxSelect();

           List<Map<String,Object>> mjflyList = leftQueryService.mjflySelect();

           List<BaseDataVO> mjflyLvList = leftQueryService.mdjflyAll();
            ResultTypeTwoVO resultTypeOne  = new ResultTypeTwoVO();
            resultTypeOne.setResultOne(tjcglList.get(0));

            resultTypeOne.setResultTwo(tjcglList.get(1));

            ResultTypeOneVO resultTypeTwo  = new ResultTypeOneVO();
            resultTypeTwo.setResultOne(mdjflxList);



            ResultTypeTwoVO resultTypeThree = new ResultTypeTwoVO();
            resultTypeThree.setResultOne(mjflyList);
            resultTypeThree.setResultTwo(mjflyLvList);

            List<BaseDataVO> topTen = leftQueryService.zytjTopTen();
            for (BaseDataVO baseDataVO : topTen) {
                if(baseDataVO.getMc()==null){
                    baseDataVO.setMc("无名氏");
                }
            }

            ResultTypeOneVO resultTypeFour = new ResultTypeOneVO();
            resultTypeFour.setResultOne(topTen);


            PartOneVO partOne = new PartOneVO();
            partOne.setBlockOne(resultTypeOne);
            partOne.setBlockTwo(resultTypeTwo);
            partOne.setBlockThree(resultTypeThree);
            partOne.setBlockFour(resultTypeFour);


           data(partOne);
            return  success();
        }catch(Exception e){
            e.printStackTrace();
            return fail();
        }

    }




}


    