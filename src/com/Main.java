package com;

import java.sql.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
  public static final String URL = "jdbc:mysql://123.56.96.224:3310/data?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&useSSL=false";
  public static final String USER = "root";
  public static final String PASSWORD = "4833666";

  public static void main(String[] args) throws Exception {
    String sql = "INSERT INTO mydata(equipName,POSITION,DATA,TYPE ) VALUES(?,?,?,?)";
    //1.加载驱动程序
    Class.forName("com.mysql.jdbc.Driver");
    //2. 获得数据库连接
    Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
    //3.操作数据库，实现增删改查
    PreparedStatement ptmt = conn.prepareStatement(sql);
    int idx = 1;
    DecimalFormat df = new DecimalFormat("#0.000");
    DecimalFormat df1 = new DecimalFormat("#0.00");

    double start = 1.0;
    String data = "";
    ptmt.setString(1, "QC010101");
    ptmt.setString(2, "27.12");
    ptmt.setString(3, "0.010");
    ptmt.setString(4, "1");
    long s = System.currentTimeMillis();

    while (idx <= 5000) {
      ptmt.addBatch();
//            System.out.println(idx);
      Thread.sleep(20);
      start += 0.07;
//            if (idx%5==0){
      // 执行该batch的插入操作
      ptmt.executeBatch();

      // 清空已执行的batch
      ptmt.clearBatch();
//            }
      idx++;

    }

    long end = System.currentTimeMillis();
    System.out.println(end - s);
    ptmt.close();
    conn.close();
       /* Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM mydata");
        //如果有数据，rs.next()返回true
        while(rs.next()){
            System.out.println(rs.getString("equipId")+"   "+rs.getString("equipName")+"   "+rs.getString("data")+"   "+rs.getString("time"));
        }*/
  }
}
