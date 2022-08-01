package org.example.db;

import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;

public enum  DataSourceProvider {
    INSTANCE;

    private PGSimpleDataSource ds;

    public DataSource getDataSource () {
        if(ds == null) {
            ds = new PGSimpleDataSource();
            ds.setServerNames(new String[] {"localhost"});
            ds.setPortNumbers(new int[] {5432});
            ds.setDatabaseName("keeper");
            ds.setUser("postgres");
            ds.setPassword("123");
        }
        return ds;
    }

//    private static DataSourceProvider INSTANCE;
//
//    private DataSourceProvider() {
//
//    }
//
//    public static DataSourceProvider getInstance() {
//        if(INSTANCE == null) {
//            INSTANCE = new DataSourceProvider();
//        }
//        return INSTANCE;
//    }
//    Раньше синглтоны писали так, через класс и ленивую инициализацию, для многопоточки нужно еще
//    синхронизировать

}
