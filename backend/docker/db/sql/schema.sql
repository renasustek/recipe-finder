CREATE DATABASE IF NOT EXISTS `roadmap_project` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `roadmap_project`;

-- Schema DDL

CREATE TABLE IF NOT EXISTS users
(
    uuid     VARCHAR(36) NOT NULL,
    username VARCHAR(50) NOT NULL PRIMARY KEY,
    password VARCHAR(50) NOT NULL,
    enabled  BOOLEAN     NOT NULL
);
CREATE TABLE IF NOT EXISTS  authorities
(
    username  VARCHAR(50) NOT NULL,
    authority VARCHAR(50) NOT NULL,
    CONSTRAINT fk_authorities_users FOREIGN KEY (username) REFERENCES users (username),
    UNIQUE INDEX ix_auth_username (username, authority)
);

CREATE TABLE IF NOT EXISTS roadmap
(
    id       VARCHAR(36) NOT NULL PRIMARY KEY,
    username VARCHAR(50)   NOT NULL
);
CREATE TABLE IF NOT EXISTS roadmap_resources
(
    id                   VARCHAR(36) NOT NULL PRIMARY KEY,
    roadmap_id           VARCHAR(36) NOT NULL,
    revision_resource_id VARCHAR(36) NOT NULL
);
CREATE TABLE IF NOT EXISTS revision_resource
(
    id              VARCHAR(36) NOT NULL PRIMARY KEY,
    topic           VARCHAR(20)   NOT NULL,
    resource_name   VARCHAR(20)   NOT NULL,
    description     VARCHAR(100)  NOT NULL,
    where_to_access VARCHAR(100)  NOT NULL,
    difficulty_level varchar(12)   NOT NULL
);

CREATE TABLE IF NOT EXISTS topics
(
    id               VARCHAR(36) NOT NULL PRIMARY KEY,
    subject          VARCHAR(20),
    topic            VARCHAR(20) NOT NULL

);

CREATE TABLE IF NOT EXISTS user_topics
(
    id                  VARCHAR(36) NOT NULL PRIMARY KEY,
    topic_id            VARCHAR(36) NOT NULL,
    confidence_in_topic VARCHAR(12) NOT NULL
);

INSERT INTO users (uuid, username, password, enabled)
VALUES ('774c5dee-e6af-4184-aae5-400f94ea9822', 'renas', 'renas', true),
       ('5b918af2-5507-407f-bfb9-1fe0781582d0', 'admin', 'admin', true);

INSERT INTO authorities (username, authority)
VALUES ('renas', 'ROLE_USER'),
       ('admin', 'ROLE_USER'),
       ('admin', 'ROLE_ADMIN');

INSERT INTO roadmap (id, username)
VALUES ('8894517b-539a-4b89-b0a0-849e84329181', 'renas');

INSERT INTO revision_resource (id, topic, resource_name, description, where_to_access, difficulty_level)
VALUES ('4c059778-5c0e-40f0-ae0b-85bf0ce8b6cc', 'algebra', 'book',
        'read this book and become good at algebra :)', 'MathsBook101 page 10', 'novice'),
       ('2d927d0a-d2a1-46d7-826d-e6783da22169', 'addition', 'website',
        'complete the tasks on this website and you will be an expert adder', 'https://www.coolmathgames.com/','expert');

INSERT INTO roadmap_resources (id, roadmap_id, revision_resource_id)
VALUES ('0dbabf29-a60f-459c-8419-3628a56c2e68', '8894517b-539a-4b89-b0a0-849e84329181',
        '4c059778-5c0e-40f0-ae0b-85bf0ce8b6cc'),
       ('6033160c-c5f5-4459-96c5-5c21f4d34048','8894517b-539a-4b89-b0a0-849e84329181',
        '2d927d0a-d2a1-46d7-826d-e6783da22169');


