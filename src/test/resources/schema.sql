CREATE TABLE users(
     id BIGINT PRIMARY KEY AUTO_INCREMENT,
     is_moderator BOOLEAN NOT NULL,
     reg_time TIMESTAMP NOT NULL,
     name VARCHAR(255) NOT NULL,
     email VARCHAR(255) NOT NULL,
     password VARCHAR(255) NOT NULL,
     code VARCHAR(255),
     photo VARCHAR(255)
);

CREATE TABLE posts (
     id BIGINT PRIMARY KEY AUTO_INCREMENT,
     is_active BOOLEAN NOT NULL,
     moderation_status VARCHAR(255) NOT NULL,
     moderator_id BIGINT,
     user_id BIGINT,
     time TIMESTAMP NOT NULL,
     title VARCHAR(255) NOT NULL,
     text VARCHAR(255) NOT NULL,
     view_count INT NOT NULL
);

CREATE TABLE post_votes (
     id BIGINT PRIMARY KEY AUTO_INCREMENT,
     user_id INT NOT NULL,
     post_id INT NOT NULL,
     time TIMESTAMP NOT NULL,
     value SMALLINT NOT NULL
);

CREATE TABLE tags(
     id BIGINT PRIMARY KEY AUTO_INCREMENT,
     name VARCHAR(255) NOT NULL
);

CREATE TABLE tag2post (
     id BIGINT PRIMARY KEY AUTO_INCREMENT,
     post_id INT NOT NULL,
     tag_id INT NOT NULL
);

CREATE TABLE post_comments(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    parent_id INT,
    post_id INT NOT NULL,
    user_id INT NOT NULL,
    time TIMESTAMP NOT NULL,
    text VARCHAR(255) NOT NULL
);

CREATE TABLE captcha_codes(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    time TIMESTAMP NOT NULL,
    code SMALLINT NOT NULL,
    secret_code SMALLINT NOT NULL
);

CREATE TABLE global_settings(
     id BIGINT PRIMARY KEY AUTO_INCREMENT,
     code VARCHAR(255) NOT NULL,
     name VARCHAR(255) NOT NULL,
     value BOOLEAN NOT NULL
);
