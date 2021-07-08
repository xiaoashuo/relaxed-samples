package com.relaxed.samples.swagger.provider;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Yakir
 * @Topic TestObj
 * @Description
 * @date 2021/7/8 14:45
 * @Version 1.0
 */
@ApiModel("测试对象")
@AllArgsConstructor
@Data
public class TestObj {
    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    private String userName;
    /**
     * 年龄
     */
    @ApiModelProperty("年龄")
    private Integer age;

    private Boolean open;
}
