import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Freg
 * @time 2022/9/5  19:05
 */
public class Demo01 {
    public static void main(String[] args) {
        try (Connection connection = DBUtils.getConnection();
        ){
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE car(id int PRIMARY KEY AUTO_INCREMENT,title VARCHAR(20),type VARCHAR(20),price DOUBLE(9,2))");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
class Demo2{
    public static void main(String[] args) {
        try (Connection connection = DBUtils.getConnection();
        ){
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO car VALUES(NULL,'五菱宏光','燃油',50000.00),(NULL,'比亚迪','新能源',180000.00),(NULL,'宝马','油电混动',260000.00)");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
class Demo3{
    public static void main(String[] args) {
        try (Connection connection = DBUtils.getConnection();
        ){
            Statement statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM car WHERE id=(SELECT max(id) FROM car)");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
class Demo4{
    public static void main(String[] args) {
        try (Connection connection = DBUtils.getConnection();
        ){
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE car SET title='奔驰S500',type='轿车',price=9.9 WHERE ID=2");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
class Demo5{
    public static void main(String[] args) {
        try (Connection connection = DBUtils.getConnection();
        ){
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM car");
            while(rs.next()){
                String title = rs.getString("title");
                System.out.println(title+rs.getString("type")+rs.getDouble("price"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
