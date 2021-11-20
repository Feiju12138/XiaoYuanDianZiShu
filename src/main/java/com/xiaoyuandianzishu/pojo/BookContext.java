package com.xiaoyuandianzishu.pojo;

import lombok.Data;

@Data
public class BookContext {

    private Integer book_id;
    private Integer section_id;
    private String title;
    private String text;

}
