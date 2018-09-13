package com.example.aop;

import com.example.enums.DataSources;
import com.example.util.DataSourceTypeManager;

/**
 * Created by lvxiao on 2018/9/13.
 */
public class DataSourceInterceptor {
    public void setDataSourceMaster() {
        DataSourceTypeManager.set(DataSources.MASTER);
    }

    public void setDataSourceSLAVE() {
        DataSourceTypeManager.set(DataSources.SLAVE);
    }
}
