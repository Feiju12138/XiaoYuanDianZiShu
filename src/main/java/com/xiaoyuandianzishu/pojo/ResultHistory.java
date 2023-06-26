package com.xiaoyuandianzishu.pojo;

import lombok.Data;

import java.util.List;

@Data
public class ResultHistory {

    private Integer code;
    private List<History> histories;

    public ResultHistory(Integer code, List<History> histories) {
        this.code = code;
        this.histories = histories;
    }
}
