package com.bm.dp.enums;

/**
 * @author xiao liang
 * @version V1.0
 * @Package com.bm.dp.enums
 * @Title: ResultEnum
 * @Description: TODO
 * @date 2018/9/27 13:14
 */
public enum ResultEnum {

    /**
     * 成功
     */
    SUCCESS(200,"ok"),
    /**
     * 失败
     */
    ERROR(500,"error");

    private Integer code;
    private String msg;

    ResultEnum(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
