drop table if exists roles cascade;
    drop table if exists users  cascade;
    drop table if exists recipes cascade;
	drop table if exists reviews cascade;
	
create table roles( id VARCHAR primary key, name VARCHAR );
insert into roles( 1, "USER");



#create table recipes( id varchar 100 primary key );

create table recipes( id varchar(255) primary key, title varchar, cusine varchar, calories int, url varchar );


insert into recipes(id, title, cusine, calories, url) values ('782585', 'Cannellini Bean and Asparagus Salad with Mushrooms', 'salad', 269, 'https://spoonacular.com/recipeImages/782585-556x370.jpg' );

insert into recipes(id, title, cusine, calories, url) values ('664147', 'Tuscan White Bean Soup with Olive Oil and Rosemary', 'soup', 101, 'https://spoonacular.com/recipeImages/664147-312x231.jpg' );

insert into recipes(id, title, cusine, calories, url) values ('716627', 'Easy Homemade Rice and Beans', 'rice', '445', 'https://spoonacular.com/recipeImages/716627-312x231.jpg' );