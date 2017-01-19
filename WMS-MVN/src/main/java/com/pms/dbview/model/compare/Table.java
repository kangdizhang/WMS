package com.pms.dbview.model.compare;

import java.util.HashMap;

/**
 * Created by 23626 on 2016/11/8.
 */
public class Table {

    public String tableName;
    public HashMap<String, Column> columns = new HashMap<String, Column>();

    public Table(String tableName) {
        this.tableName = tableName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public HashMap<String, Column> getColumns() {
        return columns;
    }

    public void setColumns(HashMap<String, Column> columns) {
        this.columns = columns;
    }

}
