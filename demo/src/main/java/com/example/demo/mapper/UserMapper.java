package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.pojo.user.User;


@Mapper
public interface UserMapper {
    @Select("select * from tb_userlogin")
    public List<User> userlist();

    @Insert("insert into tb_userlogin(username,password,register_time) values(#{username},#{password},#{registerTime})")
    public void insert(User newUser);

    @Update("update tb_userlogin set password = #{password} where username = #{username}")
    public void update(User oneUser);

    @Update("update tb_userlogin set login_time = #{loginTime} where username = #{username}")
    public void updateLoginTime(User oneUser);

    @Results({
        @Result(column="user_id",property="userId")
    })
    @Select("select * from tb_userlogin where username = #{username} and password = #{password}")
    public User getByUsernameAndPassword(User oneUser);

    @Select("select * from tb_userlogin where user_id = #{id}")
    public User getByUserId(Integer id);

}
