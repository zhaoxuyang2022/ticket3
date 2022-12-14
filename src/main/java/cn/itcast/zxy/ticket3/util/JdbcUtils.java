package cn.itcast.zxy.ticket3.util;


import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * JDBC工具类，使用druid连接池
 */
public class JdbcUtils {
    private static DataSource ds;

    static {
        try {
            //1.加载配置文件
            Properties pro = new Properties();
            InputStream is = JdbcUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(is);
            //2.初始化连接池对象
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取连接池对象
     */
    public static DataSource getDataSource() {
        return ds;
    }

    /**
     * 获取链接connection对象
     */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }


    /**
     * 释放资源
     */
    public static void close(Statement stmt, Connection conn) {

        close(null, stmt, conn);
    }

    public static void close(ResultSet rs, Statement stmt, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();//归还连接
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

