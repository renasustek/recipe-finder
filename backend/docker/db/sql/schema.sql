use `roadmap_project`;

create table users(uuid varchar(36) not null, username varchar(50) not null primary key,password varchar(50) not null,enabled boolean not null);
create table authorities (username varchar(50) not null,authority varchar(50) not null,constraint fk_authorities_users foreign key(username) references users(username));
create unique index ix_auth_username on authorities (username,authority);

insert into users values ('774c5dee-e6af-4184-aae5-400f94ea9822','renas','renas',true);
insert into authorities values ('renas','ROLE_USER');


insert into users values ('5b918af2-5507-407f-bfb9-1fe0781582d0','admin','admin',true);
insert into authorities values ('admin','ROLE_USER');
insert into authorities values  ('admin','ROLE_ADMIN');

create table roadmap(id VARBINARY(36) not null primary key, username varchar(50) not null);
create table revision_resource(id VARBINARY(36) not null primary key, topic varchar(20) not null, resource_name varchar(20) not null, description varchar(100) not null, where_to_access varchar(100) not null);
create table roadmap_resources(id VARBINARY(36) not null primary key, roadmap_id VARBINARY(36) not null, revision_resource_id VARBINARY(36) not null);

insert into roadmap values (UUID_TO_BIN('8894517b-539a-4b89-b0a0-849e84329181'),'renas');

insert into revision_resource values (UUID_TO_BIN('4c059778-5c0e-40f0-ae0b-85bf0ce8b6cc'),'algebra','book','read this book and become good at algebra :)', 'MathsBook101 page 10');
insert into revision_resource values (UUID_TO_BIN('2d927d0a-d2a1-46d7-826d-e6783da22169'),'addition','website','complete the tasks on this website and you will be an expert adder', 'https://www.coolmathgames.com/');

insert into roadmap_resources values (UUID_TO_BIN('0dbabf29-a60f-459c-8419-3628a56c2e68'),UUID_TO_BIN('8894517b-539a-4b89-b0a0-849e84329181'), UUID_TO_BIN('4c059778-5c0e-40f0-ae0b-85bf0ce8b6cc'));
insert into roadmap_resources values (UUID_TO_BIN('6033160c-c5f5-4459-96c5-5c21f4d34048'),UUID_TO_BIN('8894517b-539a-4b89-b0a0-849e84329181'), UUID_TO_BIN('2d927d0a-d2a1-46d7-826d-e6783da22169'));
