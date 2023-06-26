package com.xiaoyuandianzishu.pojo;

import lombok.Data;

@Data
public class ResultUser {

    private Integer code;
    private User user;

    public ResultUser(Integer code, User user) {
        this.code = code;
        this.user = user;
    }
}
