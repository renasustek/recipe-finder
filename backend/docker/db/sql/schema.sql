use `roadmapProject`;

create table users(id varchar(36) not null primary key, username varchar(50) not null,password varchar(500) not null,enabled boolean not null);
create table authorities (id varchar(36) not null,authority varchar(50) not null,constraint fk_authorities_users foreign key(id) references users(id));
create unique index ix_auth_username on authorities (id,authority);

insert into users values ('774c5dee-e6af-4184-aae5-400f94ea9822','renas','renas', true);
insert into authorities values ('774c5dee-e6af-4184-aae5-400f94ea9822','ROLE_USER');


insert into users values ('114c5dee-e6af-4184-aae5-400f94ea9823','admin','admin', true);
insert into authorities values ('114c5dee-e6af-4184-aae5-400f94ea9823','ROLE_USER');
insert into authorities values  ('114c5dee-e6af-4184-aae5-400f94ea9823','ROLE_ADMIN');