create table book_like
(
    id      int auto_increment
        primary key,
    user_id varchar(32) not null,
    book_id int         not null
)
    charset = utf8mb4;

INSERT INTO XiaoYuanDianZiShu.book_like (id, user_id, book_id) VALUES (12, 'oJ-dd41PY9_xk4Tm8-KYauxnMwq8', 1);
INSERT INTO XiaoYuanDianZiShu.book_like (id, user_id, book_id) VALUES (13, 'oJ-dd41PY9_xk4Tm8-KYauxnMwq8', 9);