package com.xiaoyuandianzishu.pojo;

import lombok.Data;

@Data
public class BookInfo {

    private Integer id;
    private Integer sort_id;
    private String sort_name;
    private String title;
    private String author;
    private String details;
    private String img_url;
    private Long see;

}
