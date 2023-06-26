package com.xiaoyuandianzishu.pojo;

import lombok.Data;

@Data
public class ResultObj {

    private Integer code;
    private String message;

    public ResultObj(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
