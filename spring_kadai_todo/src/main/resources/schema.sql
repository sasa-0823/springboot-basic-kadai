CREATE table if not exists todos (
id int not null auto_increment,
title varchar(50) not null,
priority ENUM('高', '中', '低') not null default '中',
status ENUM('未着手', '着手中', '完了') NOT NULL DEFAULT '未着手',

primary key (id)
);