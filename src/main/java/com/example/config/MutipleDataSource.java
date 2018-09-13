package com.example.config;

import com.example.util.DataSourceTypeManager;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Created by lvxiao on 2018/9/12.
 */
public class MutipleDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceTypeManager.get();
    }
}
