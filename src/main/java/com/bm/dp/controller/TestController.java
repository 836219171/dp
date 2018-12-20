package com.bm.dp.controller;

import com.bm.dp.pojo.UserReg;
import com.bm.dp.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author xiao liang
 * @version V1.0
 * @Package com.bm.dp.controller
 * @Title: TestController
 * @Description: TODO
 * @date 2018/9/25 9:32
 */
@RestController
public class TestController  extends BaseController{

    @Autowired
    private TestService testService;

/*    @RequestMapping("test")
    public Object test(){
        start();
        try{
            List<UserReg> test = testService.test();
            System.out.println("2222");
            return  success(test);
        }catch(Exception e){
            e.printStackTrace();
            return fail();
        }

    }*/
}
