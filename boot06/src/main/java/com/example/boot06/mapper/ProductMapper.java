package com.example.boot06.mapper;

import com.example.boot06.entity.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Freg
 * @time 2022/9/9  10:43
 */
@Mapper
public interface ProductMapper {
    @Insert("INSERT INTO product values(null,#{title},#{price},#{num})")
    void insert(Product product);
}
