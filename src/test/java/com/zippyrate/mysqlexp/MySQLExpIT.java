package com.zippyrate.mysqlexp;

import com.jcabi.jdbc.JdbcSession;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLExpIT {

  private static final String PORT = System.getProperty("mysql.port");

  @Test
  public void worksWithMysqlServer() throws SQLException
  {
    Connection conn = DriverManager
        .getConnection(String.format("jdbc:mysql://localhost:%s/root?user=root&password=root", MySQLExpIT.PORT));
    new JdbcSession(conn)
      .sql("CREATE TABLE foo (id INT PRIMARY KEY)")
      .execute();
  }
}
