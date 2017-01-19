package com.pms.dbview.model;


/**
 * Created by sunshine on 16/7/20.
 */
public class Columns {

    /**
     * 字段名
     */
    String columnName;

    /**
     * 字段长度
     */
    String columnLength;

    /**
     * 字段类型
     */
    String columnType;

    /**
     * 备注
     */
    String columnMark;

    /**
     * 此字段暂忽略
     */
    String columneSize;

    /**
     * 保留小数点位数
     */
    String columnScale;

    /**
     * 不允许空 Y - YES ， N - NOT
     */
    String notNull;

    public String getColumnMark() {
        return columnMark;
    }

    public void setColumnMark(String columnMark) {
        this.columnMark = columnMark;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnLength() {
        return columnLength;
    }

    public void setColumnLength(String columnLength) {
        this.columnLength = columnLength;
    }

    public String getColumnType() {
        return columnType;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }

    public String getColumneSize() {
        return columneSize;
    }

    public void setColumneSize(String columneSize) {
        this.columneSize = columneSize;
    }

    public String getColumnScale() {
        return columnScale;
    }

    public void setColumnScale(String columnScale) {
        this.columnScale = columnScale;
    }

    public String getNotNull() {
        return notNull;
    }

    public void setNotNull(String notNull) {
        this.notNull = notNull;
    }

}
