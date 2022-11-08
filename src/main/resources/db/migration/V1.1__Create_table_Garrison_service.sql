create table garrison_service (
id bigint primary key auto_increment,
file_name varchar(100) not null,
file_id bigint not null,
foreign key (file_id) references file(id)
);


