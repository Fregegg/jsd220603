package cn.tedu.boot03.mapper;

import cn.tedu.boot03.entity.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Freg
 * @time 2022/9/7  16:54
 */

@Mapper
public interface ProductMapper {
//    #{变量名} 会自动找到方法中参数列表里面的同名参数,若没有同名参数则会调用参数列表中对象的get方法
    @Insert("INSERT INTO product VALUES(NULL,#{title},#{price},#{num})")
    void insert(Product product);

//    Select注解执行查询相关的sql语句,数据会自动封装到product对象中并添加到list集合中
    @Select("SELECT * FROM product")
    List<Product> select();

    @Delete("DELETE FROM product WHERE id=#{id}")
    void deleteById(int id);

    @Update("UPDATE product SET title=#{title},price=#{price},num=#{num} WHERE id=#{id}")
    void update(Product product);
}
