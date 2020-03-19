package com.liudaokk.communit.dto;

import lombok.Data;

/**
 * @author:liudao
 * @company:null
 * @date: 2020/3/17 - 19:03
 */
//封装令牌的参数
@Data
public class AccessTokenDto {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;

}
