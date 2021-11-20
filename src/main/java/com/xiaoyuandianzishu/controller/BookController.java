package com.xiaoyuandianzishu.controller;

import com.xiaoyuandianzishu.pojo.BookInfo;
import com.xiaoyuandianzishu.pojo.BookSection;
import com.xiaoyuandianzishu.pojo.BookContext;
import com.xiaoyuandianzishu.pojo.ResultObj;
import com.xiaoyuandianzishu.pojo.ResultSearch;
import com.xiaoyuandianzishu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    /**
     * 根据分类，返回1页（10本）书的详情
     */
    @RequestMapping("/listBookForSort")
    public List<BookInfo> listBookForSort(Integer sortId, Integer page) {
        return bookService.listBookForSort(sortId, page);
    }

    /**
     * 根据电子书编号，返回电子书的基本信息
     */
    @RequestMapping("/listBookInfo")
    public BookInfo listBookInfo(Integer id) {
        return bookService.listBookInfo(id);
    }

    /**
     * 根据电子书的编号返回电子书的信息
     * 根据用户编号返回用户的收藏状态
     */
    @RequestMapping("/listBookSection")
    public BookSection listBookSection(Integer id, String user_id) {
        return bookService.listBookSection(id, user_id);
    }

    /**
     * 根据电子书的编号和章节编号，返回电子书的内容
     */
    @RequestMapping("/listBookContext")
    public BookContext listBookContext(String openid, Integer id, Integer section_id) {
        return bookService.listBookContext(openid, id, section_id);
    }

    /**
     * 改变收藏状态
     */
    @RequestMapping("/changeLike")
    public ResultObj changeLike(String openid, Integer book_id) {
        return bookService.changeLike(openid, book_id);
    }

    /**
     * 根据关键字搜索电子书名
     */
    @RequestMapping("/search")
    public ResultSearch search(String keyword) {
        return bookService.search(keyword);
    }

}
