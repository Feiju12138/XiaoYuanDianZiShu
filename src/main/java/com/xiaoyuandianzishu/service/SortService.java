package com.xiaoyuandianzishu.service;

import com.xiaoyuandianzishu.mapper.SortMapper;
import com.xiaoyuandianzishu.pojo.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SortService {

    @Autowired
    private SortMapper sortMapper;

    public List<Sort> listAllSort() {
        return sortMapper.listAllSort();
    }
}
