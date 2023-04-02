drop table if exists SiteUser;

create table if not exists SiteUser(
    id varchar(10),
    username varchar(50),
    email varchar(50),
    password varchar(30),
    type varchar(2)
);

