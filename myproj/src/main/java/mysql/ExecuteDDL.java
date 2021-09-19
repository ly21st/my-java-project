package mysql;


import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

/**
 * @description: ExecuteDDL
 * @author: LiYuan liyuan@agree.com.cn
 * @version: 1.0
 * @ create: 2019-02-12 23:03
 **/
public class ExecuteDDL {
    private String driver;
    private String url;
    private String user;
    private String pass;
    Connection conn;
    Statement stmt;

    public void initParam(String jparamFile) throws Exception {
        Properties props = new Properties();
        props.load(new FileInputStream(jparamFile));
        driver = props.getProperty("driver");
        url = props.getProperty("url");
        user = props.getProperty("user");
        pass = props.getProperty("pass");
    }

    public void createTable(String sql) throws Exception {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, pass);
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        ExecuteDDL ed = new ExecuteDDL();
        ed.initParam("mysql.ini");
        ed.createTable("create table jdbc_test "
            + "(jdbc_id int auto_increment primary key, "
            + "jdbc_name varchar(255),"
            + "jdbc_desc text);");
        System.out.println("------建表成功------");
    }
}
























