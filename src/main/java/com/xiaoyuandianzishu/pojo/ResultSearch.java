package com.xiaoyuandianzishu.pojo;

import lombok.Data;

import java.util.List;

@Data
public class ResultSearch {

    private Integer code;
    private List<BookInfo> books;

    public ResultSearch(Integer code, List<BookInfo> books) {
        this.code = code;
        this.books = books;
    }

}
