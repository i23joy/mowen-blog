CREATE TABLE T_USER (
	uid VARCHAR ( 100 ) NOT NULL COMMENT 'uuid of user',
	email VARCHAR ( 50 ) COMMENT 'email of user',
	username VARCHAR ( 20 ) NOT NULL COMMENT 'username',
	upassword VARCHAR ( 20 ) NOT NULL COMMENT 'password',
	avatar VARCHAR(1000) COMMENT 'avatar url',
	cdate DATETIME NOT NULL COMMENT 'time of create',
	edate DATETIME NOT NULL COMMENT 'time of edit' 
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT = 'table to store user info';

show INDEX FROM db_mowen_blog.t_user
DROP INDEX idx_username on db_mowen_blog.t_user;
ALTER TABLE db_mowen_blog.t_user DROP PRIMARY KEY

CREATE UNIQUE INDEX uk_username on db_mowen_blog.t_user(username)
ALTER TABLE db_mowen_blog.t_user ADD CONSTRAINT pk_uid PRIMARY KEY(uid)