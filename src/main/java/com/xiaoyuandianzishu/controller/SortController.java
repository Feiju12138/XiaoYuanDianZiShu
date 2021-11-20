package com.xiaoyuandianzishu.controller;

import com.xiaoyuandianzishu.pojo.Sort;
import com.xiaoyuandianzishu.service.SortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sort")
public class SortController {

    @Autowired
    private SortService service;

    /**
     * 返回所有分类数据
     * @return
     */
    @RequestMapping("/listAllSort")
    public List<Sort> listAllSort() {
        return service.listAllSort();
    }

}
