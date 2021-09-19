package org.apache.skywalking.apm.plugin.lymysql.define;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @description: ConnMySql
 * @author: LiYuan liyuan@agree.com.cn
 * @version: 1.0
 * @ create: 2019-02-12 21:30
 **/

public class ConnMySql {
    private static transient Logger logger = LoggerFactory.getLogger(mysql.ConnMySql.class);
    public static void main(String[] args) throws Exception {
       ConnMySql connMySql = new ConnMySql();
       connMySql.createAndSelect();

    }

    public void createAndSelect() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://10.8.4.50:3306/select_test" ,
                "root", "bestADA50#");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select s.*, teacher_name from student_table s, " +
                "teacher_table t where t.teacher_id = s.java_teacher");

        while (rs.next()) {
            logger.info(rs.getInt(1) + "\t"
                    + rs.getString(2) + "\t"
                    + rs.getString(3) + "\t"
                    + rs.getString(4));
        }
        if (rs != null) {
            rs.close();
        }
        if (stmt != null) {
            stmt.close();
        }

        if (conn != null) {
            conn.close();
        }
    }
}

