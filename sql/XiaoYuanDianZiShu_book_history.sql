create table book_history
(
    id         int auto_increment
        primary key,
    user_id    varchar(32) not null,
    book_id    int         not null,
    section_id int         not null
)
    charset = utf8mb4;

