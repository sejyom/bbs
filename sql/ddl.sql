drop table if exists bbs CASCADE;
create table bbs (
    id int NOT NULL AUTO_INCREMENT,
    title varchar(45) not null,
    content text not null,
    primary key(id)
)

# DELIMITER $$
#
# CREATE PROCEDURE testDataInsert()
# BEGIN
#     DECLARE i INT DEFAULT 1;
#
#     WHILE i <= 120 DO
#             INSERT INTO bbs(title, content)
#             VALUES(concat('제목',i), concat('내용',i));
#             SET i = i + 1;
#         END WHILE;
#     END$$
# DELIMITER $$