package cn.tedu;

import java.sql.*;

/**
 * @author Freg
 * @time 2022/9/5  15:22
 */
public class Demo03 {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:10086/empdb?characterEncoding=utf8&serverTimezone=Asia/Shanghai&useSSL=false","root","root"
        );
        Statement statement = connection.createStatement();
//        int row = executeUpdate();   执行增删改相关的SQL语句.  row代表生效的行数
//        ResultSet rs = executeQuery();    执行查询相关的SQL语句 rs是结果集对象
//        statement.executeUpdate("INSERT INTO emp(name) VALUES('TOM')");
//        statement.executeUpdate("UPDATE emp SET name='Jerry' WHERE name='Tom'");
//        statement.executeUpdate("DELETE from emp WHERE name='Jerry'");
        ResultSet resultSet = statement.executeQuery("SELECT * FROM emp");
        while (resultSet.next()){
            String name = resultSet.getString("name");
            double sal = resultSet.getDouble("sal");
            System.out.println(name+": "+sal);
        }
        connection.close();
    }
}
