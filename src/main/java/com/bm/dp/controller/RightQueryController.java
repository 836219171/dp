package com.bm.dp.controller;

import com.bm.dp.service.RightQueryService;
import com.bm.dp.vo.BaseDataVO;
import com.bm.dp.vo.PartFourVO;
import com.bm.dp.vo.ResultTypeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wang Yongxin
 * @version V1.0
 * @Package com.bm.dp.controller
 * @Title: RightQueryController
 * @Description:右侧查询
 * @date 2018/9/28 09:02
 */



@RestController
public class RightQueryController extends BaseController {

    @Autowired
    private RightQueryService rightQueryService;
    @Autowired
    private PartFourVO partFour;

    @RequestMapping("rightQuery")
    public Object rightQuery(){
        start();
        try {
            //初始化数组
            ResultTypeVO[] resultType = new ResultTypeVO[5];
            for(int i=0;i<resultType.length;i++){
                resultType[i]=new ResultTypeVO();
            }
            //第四部分第一块数据的查询
            resultType[0].setResultOne(rightQueryService.queryUserNum());
            resultType[0].setResultTwo(rightQueryService.querySexNum());
            resultType[0].setResultThree(rightQueryService.queryUserArea());
            partFour.setBlockOne(resultType[0]);
            //第四部分第二块数据的查询
            resultType[1].setResultOne(rightQueryService.querySrvOrg());
            resultType[1].setResultTwo(rightQueryService.queryMediNum());
            //造的假数据
            List<BaseDataVO> twoTop = new ArrayList<>();

            resultType[1].setResultThree(rightQueryService.queryTwoTop());
            partFour.setBlockTwo(resultType[1]);
            // 第四部分第三块数据的查询
            resultType[2].setResultOne(rightQueryService.queryLawerNum());
            resultType[2].setResultTwo(rightQueryService.queryZxsNum());
            resultType[2].setResultThree(rightQueryService.areaMediDist());
            partFour.setBlockThree(resultType[2]);
            //第四部分第四块数据的查询
            resultType[3].setResultOne(rightQueryService.queryZnzxl());
            //只能咨询量假数据
//            BaseDataVO baseDataVO = new BaseDataVO();
//            baseDataVO.setMc("智能咨询量");
//            baseDataVO.setSz("11260");

           // resultType[3].setResultOne(baseDataVO);
            //----------------------------
            resultType[3].setResultTwo(rightQueryService.queryRgzxs());
            resultType[3].setResultThree(rightQueryService.zxlQs());
            partFour.setBlockFour(resultType[3]);
            //第四部分第五块数据的查询
            resultType[4].setResultOne(rightQueryService.judCaseNumRate());
            resultType[4].setResultTwo(rightQueryService.lowCaseRate());
            resultType[4].setResultThree(rightQueryService.hxclSitu());
            partFour.setBlockFive(resultType[4]);
            data(partFour);
            return success();
        }catch(Exception e){
               e.printStackTrace();
               return fail();
        }
    }

}
