package com.example.boot06.controller;

import com.example.boot06.entity.Product;
import com.example.boot06.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @RequestMapping("/select")
    public List<Product> select(){
//        调用mapper中的查询方法，把查询到的list集合直接相应给客户端
        return mapper.select();
    }

    @RequestMapping("/delete")
    public void delete(int id){
        mapper.deleteById(id);
    }
    @RequestMapping("/selectById")
    public Product selectById(int id){
        return  mapper.selectById(id);
    }

    @RequestMapping("/update")
    public void update(@RequestBody Product product){
        mapper.update(product);
    }
}
