create table file (
id bigint primary key auto_increment,
file_path varchar(200) not null
);

create table RD (
id int primary key auto_increment,
name varchar(100) not null,
doc_date date,
file_id bigint not null ,
foreign key (file_id) references file(id)
);

create table schedule (
id int primary key auto_increment,
year varchar(5) not null,
file_id bigint not null,
foreign key (file_id) references file(id)
);

create table map_hydrant (
id int primary key auto_increment,
city varchar(30) not null,
path varchar(200) not null
);

create table responsibilities (
id int primary key auto_increment,
position varchar(50) not null,
file_id bigint not null,
foreign key (file_id) references file(id)
);

create table characteristics (
id int primary key auto_increment,
file_name varchar(100) not null,
file_id bigint not null,
foreign key (file_id) references file(id)
);

create table statistics (
id bigint primary key auto_increment,
user_name varchar(100) not null,
click_count_RD bigint default 0,
click_count_schedule bigint default 0,
click_count_map_hydrant bigint default 0,
click_count_responsibility bigint default 0,
click_count_developer bigint default 0,
click_characteristics bigint default 0,
recent_activities datetime not null
);