use `roadmapProject`;

create table users(username varchar(50) not null primary key,password varchar(500) not null,enabled boolean not null);
create table authorities (username varchar(36) not null,authority varchar(50) not null,constraint fk_authorities_users foreign key(username) references users(username));
create unique index ix_auth_username on authorities (username,authority);

insert into users values ('renas','renas', true);
insert into authorities values ('renas','ROLE_USER');


insert into users values ('admin','admin', true);
insert into authorities values ('admin','ROLE_USER');
insert into authorities values  ('admin','ROLE_ADMIN');