use `roadmapProject`;

create table users(uuid varchar(36) not null, username varchar(50) not null primary key,password varchar(50) not null,enabled boolean not null);
create table authorities (username varchar(50) not null,authority varchar(50) not null,constraint fk_authorities_users foreign key(username) references users(username));
create unique index ix_auth_username on authorities (username,authority);

insert into users values ('774c5dee-e6af-4184-aae5-400f94ea9822','renas','renas',true);
insert into authorities values ('renas','ROLE_USER');


insert into users values ('774c5dee-e6af-4184-aae5-400f94ea9823','admin','admin',true);
insert into authorities values ('admin','ROLE_USER');
insert into authorities values  ('admin','ROLE_ADMIN');

create table roadmap(id varchar(36) not null primary key, username varchar(50) not null, foreign key (username) references users(username));
create table revisionRecource(id varchar(36) not null primary key, topic varchar(20) not null, recourceName varchar(20) not null, description varchar(100) not null, whereToAcces varchar(100) not null);
create table roadmapRecources(id varchar(36) not null primary key, roadmapId varchar(36) not null, revisionRecourceId varchar(36) not null, foreign key (roadmapId) references roadmap(id),foreign key (revisionRecourceId) references revisionRecource(id));

insert into roadmap values ('774c5dee-e6af-4184-aae5-400f94ea9823','renas');

insert into revisionRecource values ('774c5dee-e6af-4284-aae5-400f94ea9823','algebra','book','read this book and become good at algebra :)', 'MathsBook101 page 10');
insert into revisionRecource values ('214c5dee-e6af-4184-aae5-400f94ea9823','addition','website','complete the tasks on this website and you will be an expert adder', 'https://www.coolmathgames.com/');

insert into roadmapRecources values ('2asc5dee-e6af-4184-aae5-400f94ea9823','774c5dee-e6af-4184-aae5-400f94ea9823', '774c5dee-e6af-4284-aae5-400f94ea9823');
insert into roadmapRecources values ('2wdc5dee-e6af-4184-aae5-400f94ea9823','774c5dee-e6af-4184-aae5-400f94ea9823', '214c5dee-e6af-4184-aae5-400f94ea9823');
