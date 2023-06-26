package com.xiaoyuandianzishu.mapper;

import com.xiaoyuandianzishu.pojo.Sort;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SortMapper {

    @Select("SELECT id, name FROM sort")
    List<Sort> listAllSort();

}
