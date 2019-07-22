package com.bx.springvue.Mapper;

import com.bx.springvue.Entity.UserEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface DataMapper {
    //User Method
    @Select("select password from user where name=#{name}")
    String getUserpswbyname(@Param("name") String name);

    @Insert("insert into user (name, password) values (#{name},#{password})")
    void addUser(@Param("name") String name, @Param("password") String password);

    @Delete("delete from user where name=#{name}")
    void deleteUserbyname(@Param("name") String name);

    @Select("select * from user order by ${key} limit #{pageNum},#{pageSize}")
    List<UserEntity> findpart(@Param("key") String k, @Param("pageNum") int pn, @Param("pageSize") int ps);

    @Select({"select tablerows from tableInfo where tablename='user'"})
    Integer getUserNum();

    @Update("update tableInfo set tablerows=tablerows+1 where tablename='user'")
    void increaseUserNum();

    @Update("update tableInfo set tablerows=tablerows-1 where tablename='user'")
    void decreaseUserNum();

    //Device Method
}
