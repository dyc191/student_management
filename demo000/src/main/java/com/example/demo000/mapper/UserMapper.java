package com.example.demo000.mapper;

import com.example.demo000.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * from user where uname=#{uname} and upassword=#{upassword}")
    User Login(User user);
}
