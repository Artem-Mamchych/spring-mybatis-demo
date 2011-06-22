create database spring_mybatis_demo;
use spring_mybatis_demo;
CREATE TABLE messages (
	id          BIGINT(20) unsigned NOT NULL AUTO_INCREMENT,
	messageContent      text NULL,
	datePosted          DATE NULL,
	PRIMARY KEY (id)
);

insert into messages (messageContent, datePosted) values ('Message 1', CURRENT_DATE);
insert into messages (messageContent, datePosted) values ('Message 2', CURRENT_DATE);
select * from messages;
