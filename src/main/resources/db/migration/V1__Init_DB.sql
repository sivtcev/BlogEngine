CREATE TABLE users(
    id BIGINT NOT NULL PRIMARY KEY ,
    is_moderator BOOLEAN NOT NULL,
    reg_time TIMESTAMP NOT NULL,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    code VARCHAR(255),
    photo TEXT
);

CREATE TABLE posts (
    id BIGINT NOT NULL PRIMARY KEY ,
    is_active BOOLEAN NOT NULL,
    moderation_status VARCHAR(255) NOT NULL,
    moderator_id INT,
    user_id INT,
    time TIMESTAMP NOT NULL,
    title VARCHAR(255) NOT NULL,
    text TEXT NOT NULL,
    view_count INT NOT NULL
);

CREATE TABLE post_votes (
    id BIGINT NOT NULL PRIMARY KEY,
    user_id INT NOT NULL,
    post_id INT NOT NULL,
    time TIMESTAMP NOT NULL,
    value SMALLINT NOT NULL
);

CREATE TABLE tags(
    id BIGINT NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE tags2post (
    id BIGINT NOT NULL PRIMARY KEY,
    post_id INT NOT NULL,
    tag_id INT NOT NULL
);

CREATE TABLE post_comments(
    id BIGINT NOT NULL PRIMARY KEY,
    parent_id INT,
    post_id INT NOT NULL,
    user_id INT NOT NULL,
    time TIMESTAMP NOT NULL,
    text TEXT NOT NULL
);

CREATE TABLE captcha_codes(
    id BIGINT NOT NULL PRIMARY KEY,
    time TIMESTAMP NOT NULL,
    code SMALLINT NOT NULL,
    secret_code SMALLINT NOT NULL
);

CREATE TABLE global_settings(
    id BIGINT NOT NULL PRIMARY KEY,
    code VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    value VARCHAR(255) NOT NULL
);

ALTER TABLE posts
    ADD CONSTRAINT posts_user_foreign_key
    FOREIGN KEY (user_id) REFERENCES users(id)
    ON DELETE CASCADE;

ALTER TABLE posts
    ADD CONSTRAINT posts_author_foreign_key
    FOREIGN KEY (user_id) REFERENCES users(id)
    ON DELETE CASCADE;

ALTER TABLE post_votes
    ADD CONSTRAINT post_votes_user_foreign_key
    FOREIGN KEY (user_id) REFERENCES users(id)
    ON DELETE CASCADE;

ALTER TABLE post_votes
    ADD CONSTRAINT post_votes_post_foreign_key
    FOREIGN KEY (post_id) REFERENCES posts(id)
    ON DELETE CASCADE;

ALTER TABLE tags2post
    ADD CONSTRAINT tag2post_post_foreign_key
    FOREIGN KEY (post_id) REFERENCES posts(id)
    ON DELETE CASCADE;

ALTER TABLE tags2post
    ADD CONSTRAINT tag2post_tag_foreign_key
    FOREIGN KEY (tag_id) REFERENCES tags(id)
    ON DELETE CASCADE;

ALTER TABLE post_comments
    ADD CONSTRAINT post_comments_parent_foreign_key
    FOREIGN KEY (parent_id) REFERENCES post_comments(id)
    ON DELETE CASCADE;

ALTER TABLE post_comments
    ADD CONSTRAINT post_comments_post_foreign_key
    FOREIGN KEY (post_id) REFERENCES posts(id)
    ON DELETE CASCADE;

ALTER TABLE post_comments
    ADD CONSTRAINT post_comments_user_foreign_key
    FOREIGN KEY (user_id) REFERENCES users(id)
    ON DELETE CASCADE;
