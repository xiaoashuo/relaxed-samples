package com.relaxed.samples.swagger.provider;

import com.relaxed.common.core.result.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @author Yakir
 * @Topic SwaggerProviderController
 * @Description
 * @date 2021/7/8 14:41
 * @Version 1.0
 */
@Api(tags = "接口文档提供者")
@RestController
@RequestMapping("/provider")
public class SwaggerProviderController {

    /**
     * 测试保存
     * @param testObj
     * @return
     */
    @ApiOperation(value = "测试保存" )
    @PostMapping
    public R save(TestObj testObj){
       return R.ok(new TestObj("测试",10,true));
    }

    /**
     * 更新测试
     * @param testObj
     * @return
     */
    @ApiOperation("更新测试")
    @PutMapping
    public R update(@RequestBody TestObj testObj){
        return R.ok(new TestObj("更新测试",10,true));
    }
}
