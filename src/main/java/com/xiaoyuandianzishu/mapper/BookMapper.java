package com.xiaoyuandianzishu.mapper;

import com.xiaoyuandianzishu.pojo.BookInfo;
import com.xiaoyuandianzishu.pojo.BookContext;
import com.xiaoyuandianzishu.pojo.Section;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface BookMapper {

    @Select("SELECT book_info.id, sort_id, title, author, details, img_url, see FROM book_info WHERE sort_id=#{sortId} LIMIT ${index},10")
    List<BookInfo> listBookForSort(Integer sortId, Integer index);

    // 浏览量自增
    @Update("UPDATE book_info SET see=see+1 WHERE id=#{id}")
    Integer addSee(Integer id);

    // 查询电子书基本信息
    @Select("SELECT book_info.id, sort_id, sort.name AS sort_name, title, author, details, img_url, see FROM book_info, sort WHERE book_info.sort_id=sort.id AND book_info.id=#{id}")
    BookInfo listBookInfo(Integer id);

    // 检查收藏状态
    @Select("SELECT COUNT(*) FROM book_like WHERE user_id=#{id} AND book_id=#{book_id}")
    Integer checkLike(String id, Integer book_id);

    // 获取当前电子书的所有章节信息
    @Select("SELECT section_id, title FROM book_section WHERE book_id=#{id}")
    List<Section> listSectionsByBookId(Integer id);

    @Select("SELECT book_id, section_id, book_section.title, text FROM book_info, book_section WHERE book_info.id=book_section.book_id AND book_info.id=#{id} AND book_section.section_id=#{section_id}")
    BookContext listBookContext(Integer id, Integer section_id);

    @Insert("INSERT INTO book_like VALUES (null, #{user_id}, #{book_id})")
    Integer addLike(String user_id, Integer book_id);

    @Delete("DELETE FROM book_like WHERE user_id=#{id} AND book_id=#{book_id}")
    Integer removeLike(String id, Integer book_id);

    @Select("SELECT COUNT(*) FROM book_history WHERE user_id=#{user_id} AND book_id=#{book_id}")
    Integer existHistoryByBookId(String user_id, Integer book_id);

    @Insert("INSERT INTO book_history VALUES (null, #{user_id}, #{book_id}, #{section_id})")
    Integer addHistory(String user_id, Integer book_id, Integer section_id);

    @Update("UPDATE book_info SET section_id=#{section_id} WHERE user_id=#{user_id} AND book_id=#{book_id}")
    Integer updateHistory(String user_id, Integer book_id, Integer section_id);

    @Select("SELECT book_info.id, sort_id, sort.name AS sort_name, title, author, details, img_url, see FROM book_info, sort WHERE book_info.sort_id=sort.id AND book_info.title LIKE '%${keyword}%'")
    List<BookInfo> search(String keyword);
}
