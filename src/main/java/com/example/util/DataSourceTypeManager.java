package com.example.util;

import com.example.enums.DataSources;

/**
 * Created by lvxiao on 2018/9/12.
 */
public class DataSourceTypeManager {
    private static final ThreadLocal<DataSources> dataSourceTypes = new ThreadLocal<DataSources>(){
        @Override
        protected DataSources initialValue() {
            return DataSources.MASTER;
        }
    };
    public static DataSources get(){
        return dataSourceTypes.get();
    }

    public static void set(DataSources dataSourceType){
        dataSourceTypes.set(dataSourceType);
    }

    public static void reset(){
        dataSourceTypes.set(DataSources.MASTER);
    }
}
