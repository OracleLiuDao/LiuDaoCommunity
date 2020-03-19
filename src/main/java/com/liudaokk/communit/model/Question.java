package com.liudaokk.communit.model;

import lombok.Data;

/**
 * @author:liudao
 * @company:null
 * @date: 2020/3/19 - 11:37
 */
@Data
public class Question {
    private Integer id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;

}
