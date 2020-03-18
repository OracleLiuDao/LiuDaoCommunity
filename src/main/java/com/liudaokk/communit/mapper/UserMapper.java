package com.liudaokk.communit.mapper;
import com.liudaokk.communit.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;


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
    @Insert("insert into user(name,account_id,token,gmt_create,gmt_modified) values(#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified})")
    public void  insert(User user);
}
