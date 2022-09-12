package com.example.boot06.mapper;

import com.example.boot06.entity.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Freg
 * @time 2022/9/9  10:43
 */
@Mapper
public interface ProductMapper {
    @Insert("INSERT INTO product values(null,#{title},#{price},#{num})")
    void insert(Product product);

    @Select("SELECT * FROM product")
    List<Product> select();

    @Delete("DELETE FROM product WHERE id=#{id}")
    void deleteById(int id);

    @Select("SELECT * FROM product WHERE id=#{id}")
    Product selectById(int id);

    @Update("UPDATE product SET title=#{title},price=#{price},num=#{num} WHERE id=#{id}")
    void update(Product product);
}
