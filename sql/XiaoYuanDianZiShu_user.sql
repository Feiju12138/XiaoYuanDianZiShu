create table user
(
    id         varchar(32) not null
        primary key,
    username   varchar(32) not null,
    sex        tinyint(1)  not null,
    img_url    text        not null,
    time_stamp varchar(16) null
)
    charset = utf8mb4;

INSERT INTO XiaoYuanDianZiShu.user (id, username, sex, img_url, time_stamp) VALUES ('oJ-dd41PY9_xk4Tm8-KYauxnMwq8', 'SevenOne', 1, 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83epuaeBZNzNPqmJJiaEGaou6e9cT0v7vwsmic8UX5tFUfdicmWu6kRImb1QXP5U8vDib5nwW2BanSOXG6A/132', '1637399277394');