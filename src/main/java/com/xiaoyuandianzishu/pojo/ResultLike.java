package com.xiaoyuandianzishu.pojo;

import lombok.Data;

import java.util.List;

@Data
public class ResultLike {

    private Integer code;
    private List<BookInfo> books;

    public ResultLike(Integer code, List<BookInfo> books) {
        this.code = code;
        this.books = books;
    }
}
