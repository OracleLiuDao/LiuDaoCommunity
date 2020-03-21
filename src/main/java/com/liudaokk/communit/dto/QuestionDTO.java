package com.liudaokk.communit.dto;

import com.liudaokk.communit.model.User;
import lombok.Data;

/**
 * @author:liudao
 * @company:null
 * @date: 2020/3/19 - 16:39
 */
//传输层的提问对象,
@Data
public class QuestionDTO {
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
    private User user;
}
