package com.jeffrey.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author Jeffrey.Liu
 * @version V1.0
 * @Description JDBC工具类：
 * 1：获取Connection
 * 2：释放资源
 * @date 2018-6-3 21:00
 */
public class JDBCUtil {
    /**
     * 获取Connection
     *
     * @return 所获得到的JDBC的Connection
     */
    public static Connection getConnection() throws ClassNotFoundException, SQLException, IOException {
        InputStream inputStream = JDBCUtil.class.getClassLoader().getResourceAsStream("db.properties");
        Properties properties = new Properties();
        properties.load(inputStream);

        Class.forName(properties.getProperty("jdbc.driverClass"));
        Connection connection = DriverManager.getConnection(properties.getProperty("jdbc.url"), properties.getProperty("jdbc.user"), properties.getProperty("jdbc.password"));
        return connection;
    }

    /**
     * 释放资源
     * @param resultSet
     * @param statement
     * @param connection
     */
    public static void release(ResultSet resultSet, Statement statement,Connection connection){
        if (resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (statement != null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
