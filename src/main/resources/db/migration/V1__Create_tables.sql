create table file (
id bigint primary key auto_increment,
file_path varchar(200) not null
);

create table RD (
id int primary key auto_increment,
name varchar(100) not null,
doc_date date not null,
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