DROP TABLE IF EXISTS `chat`;
DROP TABLE IF EXISTS `like`;
DROP TABLE IF EXISTS `comment`;
DROP TABLE IF EXISTS `post`;
DROP TABLE IF EXISTS `user`;

-- Create User Table
CREATE TABLE IF NOT EXISTS `user`
(
    `username`                       VARCHAR(255) NOT NULL,
    `password`                       VARCHAR(255) NOT NULL,
    `firstname`                      VARCHAR(255) NOT NULL,
    `lastname`                       VARCHAR(255) NOT NULL,
    `department`                     VARCHAR(255),
    `email`                          VARCHAR(255) NOT NULL,
    `phone_number`                   VARCHAR(255),
    `university_registration_number` VARCHAR(255),
    `is_active`                      BOOLEAN      NOT NULL DEFAULT TRUE,
    `role`                           VARCHAR(50)  NOT NULL, -- Changed from ENUM to VARCHAR
    PRIMARY KEY (`username`)
);

-- Create Post Table
CREATE TABLE IF NOT EXISTS `post`
(
    `id`            BIGINT       NOT NULL AUTO_INCREMENT,
    `content`       TEXT         NOT NULL,
    `created_at`    TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `user_username` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`user_username`) REFERENCES `user` (`username`)
);

-- Create Comment Table
CREATE TABLE IF NOT EXISTS `comment`
(
    `id`            BIGINT       NOT NULL AUTO_INCREMENT,
    `content`       TEXT         NOT NULL,
    `created_at`    TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `user_username` VARCHAR(255) NOT NULL,
    `post_id`       BIGINT       NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`user_username`) REFERENCES `user` (`username`),
    FOREIGN KEY (`post_id`) REFERENCES `post` (`id`)
);

-- Create Like Table
CREATE TABLE IF NOT EXISTS `like`
(
    `id`            BIGINT       NOT NULL AUTO_INCREMENT,
    `user_username` VARCHAR(255) NOT NULL,
    `post_id`       BIGINT       NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`user_username`) REFERENCES `user` (`username`),
    FOREIGN KEY (`post_id`) REFERENCES `post` (`id`)
);

-- Create Chat Table
CREATE TABLE IF NOT EXISTS `chat`
(
    `id`                BIGINT       NOT NULL AUTO_INCREMENT,
    `message`           TEXT         NOT NULL,
    `sent_at`           TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `sender_username`   VARCHAR(255) NOT NULL,
    `receiver_username` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`sender_username`) REFERENCES `user` (`username`),
    FOREIGN KEY (`receiver_username`) REFERENCES `user` (`username`)
);

-- Insert Sample Users
INSERT INTO `user` (`username`, `password`, `firstname`, `lastname`, `email`, `role`, `is_active`)
VALUES
('john_doe', 'password123', 'John', 'Doe', 'john.doe@example.com', 'student', TRUE),
('jane_doe', 'password123', 'Jane', 'Doe', 'jane.doe@example.com', 'staff', TRUE);

-- Insert Sample Posts
INSERT INTO `post` (`content`, `user_username`)
VALUES
('Hello, this is my first post!', 'john_doe'),
('Another post by John.', 'john_doe');

-- Insert Sample Comments
INSERT INTO `comment` (`content`, `user_username`, `post_id`)
VALUES
('Great post!', 'jane_doe', 1),
('Nice work!', 'john_doe', 2);

-- Insert Sample Likes
INSERT INTO `like` (`user_username`, `post_id`)
VALUES
('jane_doe', 1),
('john_doe', 2);

-- Insert Sample Chats
INSERT INTO `chat` (`message`, `sender_username`, `receiver_username`)
VALUES
('Hi John!', 'jane_doe', 'john_doe'),
('Hello Jane!', 'john_doe', 'jane_doe');