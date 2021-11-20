package com.xiaoyuandianzishu.service;

import com.xiaoyuandianzishu.mapper.BookMapper;
import com.xiaoyuandianzishu.mapper.UserMapper;
import com.xiaoyuandianzishu.pojo.BookInfo;
import com.xiaoyuandianzishu.pojo.History;
import com.xiaoyuandianzishu.pojo.ResultHistory;
import com.xiaoyuandianzishu.pojo.ResultLike;
import com.xiaoyuandianzishu.pojo.ResultObj;
import com.xiaoyuandianzishu.pojo.ResultUser;
import com.xiaoyuandianzishu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BookMapper bookMapper;

    public ResultUser getUserInfo(String id) {

        int rows = userMapper.existUser(id);
        if (rows == 0) {
            return new ResultUser(500, null);
        } else {
            User userInfo = userMapper.getUserInfo(id);
            return new ResultUser(200, userInfo);
        }


    }

    public ResultObj login(String id, String time_stamp, String img_url, Integer sex, String username) {

        int rows = userMapper.existUser(id);
        if (rows == 0) {
            int res = userMapper.insertUser(id, time_stamp, img_url, sex, username);
            return new ResultObj(201, "用户不存在，已经新增用户信息");
        } else {
            int res = userMapper.updateTimeStamp(id, time_stamp);
            return new ResultObj(202, "用户已存在，已经修改时间戳哦");
        }

    }

    public ResultLike getUserLike(String user_id) {
        try {
            // 创建一个存放很多书对象的集合
            List<BookInfo> bookInfos = new ArrayList<>();
            // 获取指定用户所有收藏的book_id
            List<Integer> book_ids = userMapper.getUserLike(user_id);
            // 如果没有收藏直接返回
            if (book_ids.size()==0) {
                return new ResultLike(201, null);
            }
            // 遍历book_id集合
            for (Integer book_id : book_ids) {
                // 根据bookId获取书对象
                // 并添加到集合中
                bookInfos.add(bookMapper.listBookInfo(book_id));
            }
            return new ResultLike(200, bookInfos);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultLike(500, null);
        }
    }

    public ResultHistory getUserHistory(String user_id) {
        try {
            // 创建一个存放历史记录（同时存储历史的电子书和章节）的集合
            List<History> histories = new ArrayList<>();
            // 获取指定用户所有收藏的book_id
            List<Integer> book_ids = userMapper.getUserHistory(user_id);
            // 如果没有历史记录直接返回
            if (book_ids.size()==0) {
                return new ResultHistory(201, null);
            }

            // 遍历book_id集合
            for (Integer book_id : book_ids) {
                // 根据book_id获取对应的书的信息
                BookInfo bookInfo = bookMapper.listBookInfo(book_id);
                // 根据user_id和book_id获取对应的section_id
                Integer sectionId = userMapper.getUserHistorySectionByBookId(user_id, book_id);
                // 放到所有历史记录列表
                histories.add(new History(bookInfo, sectionId));
            }
            return new ResultHistory(200, histories);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultHistory(500, null);
        }
    }

}
