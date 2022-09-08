package com.example.boot04.mapper;

import com.example.boot04.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author Freg
 * @time 2022/9/8  10:58
 */
@Mapper
public interface UserMapper {

//    通过User对象接收查询回来的password 若查不到则方法返回null
    @Select("SELECT password FROM user WHERE username=#{username}")
    User selectByUsername(String username);

    @Insert("INSERT INTO user values(null,#{username},#{password},#{nick})")
    void insert(User user);

}
