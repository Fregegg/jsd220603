package cn.tedu.boot05.mapper;

import cn.tedu.boot05.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author Freg
 * @time 2022/9/8  17:25
 */
@Mapper
public interface UserMapper {

    @Select("SELECT password FROM user WHERE username=#{username}")
    User selectByUsername(String username);

    @Insert("INSERT INTO user VALUES(NULL,#{username},#{password},#{nick})")
    void insert(User user);
}
