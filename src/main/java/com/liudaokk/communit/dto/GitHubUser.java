package com.liudaokk.communit.dto;

import lombok.Data;

/**
 * @author:liudao
 * @company:null
 * @date: 2020/3/17 - 21:00
 */
@Data
public class GitHubUser {
    private String name;
    private Long id;
    private String bio;
    private String avatarUrl;
}
