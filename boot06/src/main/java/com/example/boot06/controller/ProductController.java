package com.example.boot06.controller;

import com.example.boot06.entity.Product;
import com.example.boot06.mapper.ProductMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Freg
 * @time 2022/9/9  10:42
 */
@RestController
public class ProductController {
    @Autowired
    ProductMapper mapper;

    @RequestMapping("/insert")
    public void insert(@RequestBody Product product){
        mapper.insert(product);
    }
}
