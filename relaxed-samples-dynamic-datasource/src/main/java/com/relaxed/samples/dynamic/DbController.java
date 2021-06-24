package com.relaxed.samples.dynamic;

import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import com.relaxed.common.core.result.R;
import com.relaxed.common.datasource.provider.PropertyProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Yakir
 * @Topic DbController
 * @Description
 * @date 2021/6/24 9:19
 * @Version 1.0
 */
@RequiredArgsConstructor
@RequestMapping("/db")
@RestController
public class DbController {

    private final PropertyProvider propertyProvider;

    @GetMapping("prop")
    public R produceProperty(String dbName,String url,String username,String pasaword){
        DataSourceProperty dataSourceProperty = propertyProvider.prodDataSourceProperty(dbName, url, username, pasaword);
        return R.ok(dataSourceProperty);
    }

}
