package com.relaxed.samples.dynamic;

import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.hikari.HikariCpConfig;
import com.relaxed.common.datasource.provider.PropertyProvider;
import com.zaxxer.hikari.HikariConfig;
import org.springframework.stereotype.Component;

/**
 * @author Yakir
 * @Topic DbPropertyProvider
 * @Description
 * @date 2021/6/24 9:09
 * @Version 1.0
 */
public class DbPropertyProvider implements PropertyProvider {
    @Override
    public DataSourceProperty prodDataSourceProperty(String dsName, String url, String username, String password) {
        DataSourceProperty dataSourceProperty = new DataSourceProperty();
        dataSourceProperty.setPoolName(dsName);
        dataSourceProperty.setUrl(url);
        dataSourceProperty.setUsername(username);
        dataSourceProperty.setPassword(password);
        HikariCpConfig hikariCpConfig = new HikariCpConfig();
        hikariCpConfig.setMaxPoolSize(1);
        dataSourceProperty.setHikari(hikariCpConfig);
        return dataSourceProperty;
    }
}
