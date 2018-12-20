package com.bm.dp.pojo;

import com.bm.dp.enums.ResultEnum;

/**
 * @author xiao liang
 * @version V1.0
 * @Package com.bm.dp.pojo
 * @Title: Result
 * @Description: TODO
 * @date 2018/9/27 13:17
 */
public class Result<T> {

    private Integer code;

    private String msg;

    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    public void setEnum(ResultEnum resultEnum){
        this.msg = resultEnum.getMsg();
        this.code = resultEnum.getCode();
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
