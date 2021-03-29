create table product(

    id int primary key auto_increment,
    name varchar(30) not null,
    description varchar(100) not null
);

create table category(
    id int  primary key auto_increment,
    category_name varchar(30) not null,
    description varchar(100) not null
);

alter table category add column product_id int null;

alter table category add
foreign key (product_id) references product (id);
