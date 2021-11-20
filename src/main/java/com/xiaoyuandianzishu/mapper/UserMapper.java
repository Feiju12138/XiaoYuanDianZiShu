package com.xiaoyuandianzishu.mapper;

import com.xiaoyuandianzishu.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT COUNT(*) FROM user WHERE id=#{id}")
    Integer existUser(String id);

    @Select("SELECT user.id AS id, username, sex, img_url, time_stamp FROM user WHERE user.id=#{id}")
    User getUserInfo(String id);

    @Insert("INSERT INTO user VALUES (#{id}, #{username}, #{sex}, #{img_url}, #{time})")
    Integer insertUser(String id, String time, String img_url, Integer sex, String username);

    @Update("UPDATE user SET time_stamp=#{time_stamp} WHERE id=#{id}")
    Integer updateTimeStamp(String id, String time_stamp);

    @Select("SELECT book_id FROM book_like WHERE user_id=#{user_id}")
    List<Integer> getUserLike(String user_id);

    @Select("SELECT book_id FROM book_history WHERE user_id=#{user_id}")
    List<Integer> getUserHistory(String user_id);

    @Select("SELECT section_id FROM book_history WHERE user_id=#{user_id} AND book_id=#{book_id}")
    Integer getUserHistorySectionByBookId(String user_id, Integer book_id);
}
