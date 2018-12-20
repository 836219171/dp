package com.bm.dp.pojo;

import lombok.Data;

/**
 * @author xiao liang
 * @version V1.0
 * @Package com.bm.dp.pojo
 * @Title: LawCase
 * @Description: TODO
 * @date 2018/9/27 13:59
 */
@Data
public class LawCase {

    private String yearId;
    private String monthId;
    private String dateId;
    private String provinceName;
    private String areaName;
    private String caseType;
    private String mediatorsId;
    private String origin;
    private Integer caseNum;
    private Integer sucNum;
    private Integer failNum;
    private Integer lawNum;
    private Integer judNum;

}
