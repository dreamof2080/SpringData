package com.jeffrey.util;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Jeffrey.Liu
 * @version V1.0
 * @Description
 * @date 2018-6-3 21:04
 */
public class JDBCUtilTest {
    @Test
    public void testGetConnection() throws SQLException, ClassNotFoundException, IOException {
        Connection connection = JDBCUtil.getConnection();
        Assert.assertNotNull(connection);
    }
}
