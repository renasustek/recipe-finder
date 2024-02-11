CREATE DATABASE IF NOT EXISTS `roadmap_project` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `roadmap_project`;

-- Schema DDL

CREATE TABLE users
(
    uuid     VARCHAR(36) NOT NULL,
    username VARCHAR(50) NOT NULL PRIMARY KEY,
    password VARCHAR(50) NOT NULL,
    enabled  BOOLEAN     NOT NULL
);
CREATE TABLE authorities
(
    username  VARCHAR(50) NOT NULL,
    authority VARCHAR(50) NOT NULL,
    CONSTRAINT fk_authorities_users FOREIGN KEY (username) REFERENCES users (username),
    UNIQUE INDEX ix_auth_username (username, authority)
);

CREATE TABLE roadmap
(
    id       VARCHAR(36) NOT NULL PRIMARY KEY,
    username VARCHAR(50)   NOT NULL
);
CREATE TABLE revision_resource
(
    id              VARCHAR(36) NOT NULL PRIMARY KEY,
    topic           VARCHAR(20)   NOT NULL,
    resource_name   VARCHAR(20)   NOT NULL,
    description     VARCHAR(100)  NOT NULL,
    where_to_access VARCHAR(100)  NOT NULL
);
CREATE TABLE roadmap_resources
(
    id                   VARCHAR(36) NOT NULL PRIMARY KEY,
    roadmap_id           VARCHAR(36) NOT NULL,
    revision_resource_id VARCHAR(36) NOT NULL
);
