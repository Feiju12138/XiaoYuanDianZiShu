package com.xiaoyuandianzishu.pojo;

import lombok.Data;

@Data
public class History {

    private BookInfo books;
    private Integer section_id;

    public History(BookInfo books, Integer section_id) {
        this.books = books;
        this.section_id = section_id;
    }
}
