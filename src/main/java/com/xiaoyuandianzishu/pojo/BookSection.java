package com.xiaoyuandianzishu.pojo;

import lombok.Data;

import java.util.List;

@Data
public class BookSection {

    // 收藏状态 1-已收藏 0-未收藏
    private Integer like_status;
    // 所有章节
    private List<Section> sections;

}
