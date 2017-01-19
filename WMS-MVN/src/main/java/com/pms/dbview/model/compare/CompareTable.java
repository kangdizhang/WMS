package com.pms.dbview.model.compare;


import org.springframework.util.StringUtils;

import java.sql.*;
import java.util.*;

/**
 * Created by 23626 on 2016/11/8.
 */
public class CompareTable {
//    public static StringBuffer[] sb = {new StringBuffer(), new StringBuffer(), new StringBuffer(), new StringBuffer(), new StringBuffer(), new StringBuffer()};

    public static Statement stmt = null;
    public static ResultSet rs = null;

    public static Connection getConnectionP46() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.222:1521:orcl", "p46", "p46");
        if (conn != null) System.out.println("数据库加载成功！");
        return conn;
    }

    public static Connection getConnectionP461() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.222:1521:orcl", "p461", "p461");
        if (conn != null) System.out.println("数据库加载成功！");
        return conn;
    }

    public static void main(String[] args) throws Exception {
         //比较数据库
        List<Infornation> list = compareTables();
        System.out.println(list.size());
//        writeFile(); //写入文件
    }

    /**
     * @author YUJIYU090
     * 比较P46库和P461库的数据表，包括表名、字段名、字段类型、字段长度
     */
    public static List<Infornation> compareTables() throws Exception {

        //1、P46存在，P461不存在的表--跳过
        //2、P46不存在，P461存在的表--需要人工判断脚本
        //3、P46存在，P461不存在的字段--需人工判断如何处理
        //4、P46不存在，P461存在的字段--需要人工判断脚本
        //5、表和字段都相同，但字段类型不同的内容--需要人工判断脚本
        //6、表和字段、字段类型都相同，但字段长度不同的内容--需要人工判断脚本

        //P46连接
        Connection connP46 = getConnectionP46();
        Map<String, Table> map_product = getTables(connP46);

        //P461连接
        Connection connP461 = getConnectionP461();
        Map<String, Table> map_develop = getTables(connP461);
        List<Infornation> list = new ArrayList<Infornation>();
        //遍历P461库Map
        for (Iterator<String> iter_table = map_develop.keySet().iterator(); iter_table.hasNext(); ) {
            String key_table = (String) iter_table.next();
            Table table_develop = map_develop.get(key_table);//获得P461库中的表
            Table table_product = map_product.get(key_table);//尝试从P46库中获得同名表
            if (table_product == null) { //如果获得表为空，说明P461存在，P46不存在
                list.add(append(table_develop, null, 2));
            } else { //表相同，判断字段、字段类型、字段长度
                for (Iterator<String> iter_column = table_develop.columns.keySet().iterator(); iter_column.hasNext(); ) {
                    String key_column = (String) iter_column.next();
                    Column column_develop = table_develop.columns.get(key_column);//获得P461库中的列
                    Column column_product = table_product.columns.get(key_column);//尝试从P46库中获得同名列
                    if (column_product == null) {//如果列名为空，说明P461存在，P46不存在
                        list.add(append(table_develop, column_develop, 4));
                    } else {//说明两者都存在
                        if (!column_develop.dataType.equals(column_product.dataType))//字段类型不一致
                            list.add(append(table_develop, column_develop, 5));
                        if (column_develop.length != column_product.length)//字段长度不一致
                            list.add(append(table_develop, column_develop, 6));
                    }
                }
            }
        }

        //遍历P46库Map
        for (Iterator<String> iter_table = map_product.keySet().iterator(); iter_table.hasNext(); ) {
            String key_table = (String) iter_table.next();
            Table table_product = map_product.get(key_table);//尝试从P46库中获得同名表
            Table table_develop = map_develop.get(key_table);//获得P461库中的表
            if (table_develop == null) { //如果获得表为空，说明P461存在，P46不存在
                list.add(append(table_product, null, 1));
            } else { //表相同，判断字段、字段类型、字段长度
                for (Iterator<String> iter_column = table_product.columns.keySet().iterator(); iter_column.hasNext(); ) {
                    String key_column = (String) iter_column.next();
                    Column column_product = table_product.columns.get(key_column);//获得P46库中的列
                    Column column_develop = table_develop.columns.get(key_column);//尝试从P461库中获得同名列
                    if (column_develop == null) {//如果列名为空，说明P46存在，P461不存在
                        list.add(append(table_product, column_product, 3));
                    }
                }
            }
        }
        return list;
    }

    /**
     * @author YUJIYU090
     * 传入数据库连接，返回数据库中所有TABLE对象的MAP
     */
    public static Map<String, Table> getTables(Connection conn) throws Exception {

        String sSql = " select table_name,Column_Name,Data_Type," +
                " DECODE(DATA_TYPE,'NUMBER',DATA_PRECISION,'VARCHAR2',DATA_LENGTH,'VARCHAR',DATA_LENGTH,'CHAR',DATA_LENGTH,0) Length," +
                " NVL(DATA_SCALE, 0) SCALE,DECODE(NULLABLE, 'N', '1', '0') NULLABLE " +
                " from user_tab_columns where 1=1 And table_name Not Like 'BIN$%' Order By table_name,column_name";

        Map<String, Table> map = new HashMap<String, Table>();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sSql);//执行查询,(ruby)为表名
            String tableName = "";
            Table table = null;
            while (rs.next()) {
                if (!tableName.equals(rs.getString("table_name"))) {//一张新表
                    tableName = rs.getString("table_name");
                    table = new Table(tableName);
                    Column column = new Column(rs.getString("Column_Name"), rs.getString("Data_Type"), rs.getInt("Length"));
                    table.columns.put(column.columnName, column);
                    map.put(rs.getString("table_name"), table);
                } else {//已存在的表，增加字段
                    Column column = new Column(rs.getString("Column_Name"), rs.getString("Data_Type"), rs.getInt("Length"));
                    table.columns.put(column.columnName, column);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rs.close();
            stmt.close();
            conn.close();
        }
        return map;
    }

    /**
     * @author YUJIYU090
     * 根据标示位，追加到满足条件的StringBuffer
     */
    public static Infornation append(Table table, Column column, int flag) throws Exception {
        Infornation infornation = new Infornation();
        infornation.setNum(flag);
        switch (flag) {
            case 1:
                System.out.println("1、P46存在，P461不存在的表：" + table.getTableName());// 跳过
                infornation.setStr("P46存在，P461不存在的表：" + table.getTableName());
//                sb[0].append(table.getTableName() + "\n");
                break;
            case 2:
                System.out.println("2、P46不存在，P461存在的表：" + table.getTableName());// 需要人工判断脚本
                infornation.setStr("P46不存在，P461存在的表：" + table.getTableName());
//                sb[1].append(table.getTableName() + "\n");
                break;
            case 3:
                System.out.println("3、P46存在，P461不存在的字段：" + table.getTableName() + " | " + column.getColumnName());//需人工判断如何处理
                infornation.setStr("P46存在，P461不存在的字段：" + table.getTableName() + " | " + column.getColumnName());
//                sb[2].append(table.getTableName() + " | " + column.getColumnName() + "\n");
                break;
            case 4:
                System.out.println("4、P46不存在，P461存在的字段：" + table.getTableName() + " | " + column.getColumnName());//需要人工判断脚本
                infornation.setStr("P46不存在，P461存在的字段：" + table.getTableName() + " | " + column.getColumnName());
//                sb[3].append(table.getTableName() + " | " + column.getColumnName() + "\n");
                break;
            case 5:
                System.out.println("5、表和字段都相同，但字段类型不同的内容：" + table.getTableName() + " | " + column.getColumnName() + " | " + column.getDataType());//需要人工判断脚本
                infornation.setStr("表和字段都相同，但字段类型不同的内容：" + table.getTableName() + " | " + column.getColumnName() + " | " + column.getDataType());
//                sb[4].append(table.getTableName() + " | " + column.getColumnName() + " | " + column.getDataType() + "\n");
                break;
            case 6:
                System.out.println("6、表和字段、字段类型都相同，但字段长度不同的内容：" + table.getTableName() + " | " + column.getColumnName() + " | " + column.getLength());//需要人工判断脚本
                infornation.setStr("表和字段、字段类型都相同，但字段长度不同的内容：" + table.getTableName() + " | " + column.getColumnName() + " | " + column.getLength());
//                sb[5].append(table.getTableName() + " | " + column.getColumnName() + " | " + column.getLength() + "\n");
                break;
        }
        return infornation;
    }

    /**
     * @author YUJIYU090
     * 将StringBuffer中的值写入文件中
     */
//    public static void writeFile() throws Exception {
//        String[] fileName = {
//                "D://table//P46存在，P461不存在的表.txt",
//                "D://table//P46不存在，P461存在的表.txt",
//                "D://table//P46存在，P461不存在的字段.txt",
//                "D://table//P46不存在，P461存在的字段.txt",
//                "D://table//表和字段都相同，但字段类型不同的内容.txt",
//                "D://table//表和字段、字段类型都相同，但字段长度不同的内容.txt"};
//
//        for (int i = 0; i < fileName.length; i++) {
//            File file = new File(fileName[i]);
//            OutputStream os = new FileOutputStream(file);
//            os.write(sb[i].toString().getBytes());
//            os.flush();
//            os.close();
//        }
//    }
}