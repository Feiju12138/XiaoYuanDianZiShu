package com.xiaoyuandianzishu.service;

import com.xiaoyuandianzishu.mapper.BookMapper;
import com.xiaoyuandianzishu.pojo.BookInfo;
import com.xiaoyuandianzishu.pojo.BookSection;
import com.xiaoyuandianzishu.pojo.BookContext;
import com.xiaoyuandianzishu.pojo.ResultObj;
import com.xiaoyuandianzishu.pojo.ResultSearch;
import com.xiaoyuandianzishu.pojo.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookMapper bookMapper;

    public List<BookInfo> listBookForSort(Integer sortId, Integer page) {
        // 通过页数计算当前页第一个数据的位置
        int index = (page-1)*10;
        return bookMapper.listBookForSort(sortId, index);
    }

    public BookInfo listBookInfo(Integer id) {
        int rows = bookMapper.addSee(id);
        return bookMapper.listBookInfo(id);
    }

    public BookSection listBookSection(Integer id, String user_id) {

        BookSection bookSection = new BookSection();

        // 查询当前用户的收藏状态
        int like_status = bookMapper.checkLike(user_id, id);
        bookSection.setLike_status(like_status);

        // 查询当前电子书的所有分类
        List<Section> sections = bookMapper.listSectionsByBookId(id);
        bookSection.setSections(sections);

        return bookSection;
    }

    public BookContext listBookContext(String user_id, Integer book_id, Integer section_id) {
        // 为当前用户写入浏览记录
        addHistory(user_id, book_id, section_id);
        // 返回书的内容
        return bookMapper.listBookContext(book_id, section_id);
    }

    public ResultObj changeLike(String user_id, Integer book_id) {
        try {
            // 检查收藏状态
            int checkResult = bookMapper.checkLike(user_id, book_id);
            // 没收藏时
            if (checkResult==0) {
                int rows = bookMapper.addLike(user_id, book_id);
                return new ResultObj(201, "已添加收藏!");
            }
            // 已收藏时
            else {
                int rows = bookMapper.removeLike(user_id, book_id);
                return new ResultObj(202, "已取消收藏!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultObj(500, "收藏操作失败!");
        }
    }

    public ResultObj addHistory(String user_id, Integer book_id, Integer section_id) {

        int res = bookMapper.existHistoryByBookId(user_id, book_id);
        if (res==0) {
            int rows = bookMapper.addHistory(user_id, book_id, section_id);
            if (rows==0) {
                return new ResultObj(500, "插入历史记录失败");
            } else {
                return new ResultObj(200, "插入历史记录成功");
            }
        } else {
            int rows = bookMapper.updateHistory(user_id, book_id, section_id);
            if (rows==0) {
                return new ResultObj(500, "修改历史记录失败");
            } else {
                return new ResultObj(200, "修改历史记录成功");
            }
        }

    }

    public ResultSearch search(String keyword) {

        try {
            // 获取关键字查找相似书名的电子书对象
            List<BookInfo> bookInfos = bookMapper.search(keyword);
            if (bookInfos.size()==0) {
                return new ResultSearch(201, null);
            }
            return new ResultSearch(200, bookInfos);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultSearch(500, null);
        }

    }
}
