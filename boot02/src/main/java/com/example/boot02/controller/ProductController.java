package com.example.boot02.controller;

import com.example.boot02.Utils.DBUtils;
import com.example.boot02.entity.Product;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Freg
 * @time 2022/9/7  10:41
 */
@RestController
public class ProductController {

    @RequestMapping("/insert")
    public String insert(Product product){
        try (Connection connection = DBUtils.getConn()) {
            String sql = "INSERT INTO product VALUES(null,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, product.getTitle());
            statement.setDouble(2, product.getPrice());
            statement.setInt(3, product.getNum());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("product = " + product);
        return "添加成功~<a href='/'>返回首页</a>";
    }

    @RequestMapping("/delete")
    public String delete(Product product){
        try (Connection connection = DBUtils.getConn()) {
            String sql = "DELETE FROM product WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,product.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "删除成功<a href='/'>返回首页</a>";
    }

    @RequestMapping("/update")
    public String update(Product product){
        try (Connection connection = DBUtils.getConn()) {
            String sql = "UPDATE product SET title=?,price=?,num=? WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,product.getTitle());
            preparedStatement.setDouble(2,product.getPrice());
            preparedStatement.setInt(3,product.getNum());
            preparedStatement.setInt(4,product.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        System.out.println("product = " + product);
        return "修改成功~<a href='/select'>返回列表</a>";
    }

    @RequestMapping("/select")
    public String select(){
        //创建一个用来装查询到的数据的集合
        ArrayList<Product> list = new ArrayList<>();
        try (Connection connection = DBUtils.getConn()) {
            String sql = "SELECT * FROM product";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt(1);
                String title = resultSet.getString(2);
                double price = resultSet.getDouble(3);
                int num = resultSet.getInt(4);
                //将查询到的数据封装进对象并将对象封装进list
                list.add(new Product(id,title,price,num));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String html = "<table border=\"1\">\n" +
                "    <caption>商品列表</caption>\n" +
                "    <tr>\n" +
                "        <th>id</th>\n" +
                "        <th>商品标题</th>\n" +
                "        <th>价格</th>\n" +
                "        <th>库存</th>\n" +
                "        <th>操作</th>\n" +
                "    </tr>\n";
        for (Product p:list) {
            html+="<tr>";
            html+="<td>"+p.getId()+"</td>";
            html+="<td>"+p.getTitle()+"</td>";
            html+="<td>"+p.getPrice()+"</td>";
            html+="<td>"+p.getNum()+"</td>";
            html+="<td><a href='/delete?id="+p.getId()+"'>删除</a></td>";
            html+="</tr>";
        }
        html+="</table>";
        return html;
    }
}
