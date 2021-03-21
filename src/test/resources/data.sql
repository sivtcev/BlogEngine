INSERT INTO users(id, is_moderator, reg_time, name, email, password, code, photo)
VALUES (1, FALSE, '2005-12-31 23:59:59', 'User one', 'user1@mail.com', '1111', '1111', '1111');
INSERT INTO users(id, is_moderator, reg_time, name, email, password, code, photo)
VALUES (2, FALSE, '2005-12-30 23:59:59', 'User two', 'user2@mail.com', '1111', '1111', '1111');
INSERT INTO users(id, is_moderator, reg_time, name, email, password, code, photo)
VALUES (3, TRUE, '2005-12-29 23:59:59', 'User three', 'user3@mail.com', '1111', '1111', '1111');

INSERT INTO posts(id, is_active, moderation_status, moderator_id, user_id, time, title, text, view_count)
VALUES (1, TRUE, 'NEW', 1, 2, '2005-12-29 23:59:59', 'title1', 'text1', 1);
INSERT INTO posts(id, is_active, moderation_status, moderator_id, user_id, time, title, text, view_count)
VALUES (2, FALSE, 'NEW', 2, 1, '2005-12-30 23:59:59', 'title2', 'text2', 2);
INSERT INTO posts(id, is_active, moderation_status, moderator_id, user_id, time, title, text, view_count)
VALUES (3, FALSE, 'NEW', 3, 3, '2005-12-31 23:59:59', 'title3', 'text3', 3);

INSERT INTO post_votes(id, user_id, post_id, time, value)
VALUES (1, 1, 1, '2005-12-29 23:59:59', 1);
INSERT INTO post_votes(id, user_id, post_id, time, value)
VALUES (2, 2, 2, '2005-12-29 23:59:59', 2);
INSERT INTO post_votes(id, user_id, post_id, time, value)
VALUES (3, 3, 3, '2005-12-29 23:59:59', 3);

INSERT INTO tags(id, name)
VALUES (1, 'tag1');
INSERT INTO tags(id, name)
VALUES (2, 'tag2');
INSERT INTO tags(id, name)
VALUES (3, 'tag3');

INSERT INTO post_comments(id, parent_id, post_id, user_id, time, text)
VALUES (1, 1, 1, 1, '2005-12-29 23:59:59', 'comment1');
INSERT INTO post_comments(id, parent_id, post_id, user_id, time, text)
VALUES (2, 2, 2, 2, '2005-12-31 23:59:59', 'comment2');
INSERT INTO post_comments(id, parent_id, post_id, user_id, time, text)
VALUES (3, 3, 3, 3, '2005-12-30 23:59:59', 'comment3');

INSERT INTO captcha_codes(id, time, code, secret_code)
VALUES (1, '2005-12-30 23:59:59', 1, 1);
INSERT INTO captcha_codes(id, time, code, secret_code)
VALUES (2, '2005-12-30 23:59:59', 2, 2);
INSERT INTO captcha_codes(id, time, code, secret_code)
VALUES (3, '2005-12-30 23:59:59', 3, 3);

INSERT INTO global_settings(id, code, name, value)
VALUES (1, 'MULTIUSER_MODE', 'yes', 'no');
INSERT INTO global_settings(id, code, name, value)
VALUES (2, 'MULTIUSER_MODE', 'no', 'yes');
INSERT INTO global_settings(id, code, name, value)
VALUES (3, 'MULTIUSER_MODE', 'yes', 'yes');



