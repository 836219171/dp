package com.bm.dp.controller;

import com.bm.dp.enums.ResultEnum;
import com.bm.dp.pojo.Result;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiao liang
 * @version V1.0
 * @Package com.bm.dp.controller
 * @Title: BaseController
 * @Description: TODO
 * @date 2018/9/27 13:13
 */
@RestController
public class BaseController<T> {

    private ThreadLocal<Result> results = new ThreadLocal<Result>();

    protected void start() {
        results.set(new Result());
    }


    protected Object  success() {
        Result result = results.get();
        result.setEnum(ResultEnum.SUCCESS);
        return result;
    }

    protected void data(T... t ){
        Result result = results.get();
        result.setData(t);
    }


    protected Object fail() {
        Result result = results.get();
        result.setEnum(ResultEnum.ERROR);
        return result;
    }


}
