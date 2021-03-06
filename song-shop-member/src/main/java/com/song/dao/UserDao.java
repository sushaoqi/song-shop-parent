package com.song.dao;

import com.song.common.mybatis.BaseDao;
import com.song.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * created on 2019/3/8 13:52
 *
 * @author nfboy_liusong@163.com
 * @version 1.0.0
 */
@Mapper
public interface UserDao extends BaseDao {

    @Select("select id,userName,password,phone,email,created,updated from mb_user where phone = #{phone} and password=#{password}")
    public UserEntity getUserPhoneAndPwd(@Param("phone") String phone, @Param("password") String password);

    @Select("select id,userName,password,phone,email, created,updated from mb_user where id = #{id}")
    public UserEntity getUserInfo(@Param("id") Long id);

    @Select("select id,userName,password,phone,email, created,updated from mb_user where phone = #{phone} or email=#{email}")
    public UserEntity getUser(@Param("phone") String phone, @Param("email") String email);

    @Select("select id,userName,password,phone,email,openId,created,updated from mb_user where openId = #{openId}")
    public UserEntity findOpenId(@Param("openId") String openId);

}
