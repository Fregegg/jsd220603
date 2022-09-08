package cn.tedu;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Freg
 * @time 2022/9/5  16:59
 */
public class Demo05 {
    private static DruidDataSource dds;
    static{
//        创建数据库连接池
        dds = new DruidDataSource();
//        设置连接数据库的信息
        dds.setUrl("jdbc:mysql://localhost:10086/empdb?characterEncoding=utf8&serverTimezone=Asia/Shanghai&useSSL=false");
        dds.setUsername("root");
        dds.setPassword("root");
//        设置初始连接数量
        dds.setInitialSize(3);
//        设置最大连接数量
        dds.setMaxActive(5);
    }

    public static Connection getConnection() throws SQLException {
//        获取连接对象 异常抛出
        Connection connection = dds.getConnection();
        System.out.println(connection);
        return connection;
    }
}
