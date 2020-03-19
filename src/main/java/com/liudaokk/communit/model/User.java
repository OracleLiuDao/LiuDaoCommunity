package com.liudaokk.communit.model;

import lombok.Data;


/**
 * @author:liudao
 * @company:null
 * @date: 2020/3/18 - 13:52
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;
    private String avatarUrl;

}
