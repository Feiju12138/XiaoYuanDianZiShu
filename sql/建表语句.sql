
CREATE DATABASE XiaoYuanDianZiShu;

USE XiaoYuanDianZiShu;

# 用户表
CREATE TABLE user(
    id varchar(32) NOT NULL PRIMARY KEY,
    username varchar(32) NOT NULL,
    sex tinyint(1) NOT NULL, # 1男 0女
    img_url text NOT NULL, # 头像图
    time_stamp varchar(16) NULL
);

# 书的基本信息
CREATE TABLE book_info(
    id int NOT NULL PRIMARY KEY AUTO_INCREMENT, # 书的编号
    sort_id int NOT NULL, # 分类编号
    title varchar(32) NOT NULL, # 书名
    author varchar(32) NOT NULL, # 作者
    details text NOT NULL, # 简介
    img_url text NOT NULL, # 图片编号（封面图）
    see int NOT NULL DEFAULT 0 # 浏览量
);

# 书的章节
CREATE TABLE book_section(
    id int NOT NULL PRIMARY KEY AUTO_INCREMENT, # 书的编号
    book_id int NOT NULL, # 书的编号
    section_id int NOT NULL, # 章节编号
    title varchar(32) NOT NULL, # 章节的标题
    text text NOT NULL
);

# 收藏记录
CREATE TABLE book_like(
    id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
    user_id varchar(32) NOT NULL,
    book_id int NOT NULL
);

# 历史记录
CREATE TABLE book_history(
    id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
    user_id varchar(32) NOT NULL,
    book_id int NOT NULL,
    section_id int NOT NULL # 章节编号
);

# 分类表
CREATE TABLE sort(
    id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name varchar(32) NOT NULL
);

ALTER TABLE user CONVERT TO CHARACTER SET utf8mb4;
ALTER TABLE book_info CONVERT TO CHARACTER SET utf8mb4;
ALTER TABLE book_section CONVERT TO CHARACTER SET utf8mb4;
ALTER TABLE book_like CONVERT TO CHARACTER SET utf8mb4;
ALTER TABLE book_history CONVERT TO CHARACTER SET utf8mb4;
ALTER TABLE sort CONVERT TO CHARACTER SET utf8mb4;
