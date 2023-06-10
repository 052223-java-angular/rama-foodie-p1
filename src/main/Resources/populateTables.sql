drop table if exists roles cascade;
    drop table if exists users  cascade;
    drop table if exists recipes cascade;
	drop table if exists reviews cascade;
	
create table roles( id VARCHAR primary key, name VARCHAR );
insert into roles( 1, "USER");



#create table recipes( id varchar 100 primary key );

create table recipes( id varchar(255) primary key );
insert into recipes(id) values('23');

insert into recipes(id) values ('782585');

