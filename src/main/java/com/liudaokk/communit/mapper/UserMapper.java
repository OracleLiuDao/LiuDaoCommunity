package com.liudaokk.communit.mapper;
import com.liudaokk.communit.model.User;
import org.apache.ibatis.annotations.*;


/**
 * @author:liudao
 * @company:null
 * @date: 2020/3/18 - 13:48
 *     private Integer id;
 *     private String name;
 *     private String accountId;
 *     private String token;
 *     private Long gmtCreate;
 *     private Long gmtModified;
 */
@Mapper
public interface UserMapper {
    @Insert("insert into user(name,account_id,token,gmt_create,gmt_modified,avatar_url) values(#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified},#{avatarUrl})")
    public void  insert(User user);

    @Select("select * from user where token = #{token}")
    User findByTocken(@Param("token") String token);
    @Select("select * from user where id = #{id}")
    User findById(@Param("id") Integer id);

    @Select("select * from user where account_id = #{accountId}")
    User findByAccountId(@Param("accountId") String accountId);

    @Update("update user set name = #{name}, token = #{token}, gmt_modified = #{gmtModified},avatar_url = #{avatarUrl} where id = #{id}")
    void update(User user);
}
