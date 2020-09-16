package com.charon.database;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
@Slf4j
public class DruidTest {

    @Autowired
    DataSource dataSource;
    @Test
    public void test() throws SQLException {
        System.out.println(dataSource.getClass());
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        log.trace("I am trace log.");
        log.debug("I am debug log.");
        log.warn("I am warn log.");
        log.error("I am error log.");
        log.error("写入文件");
    }
}
